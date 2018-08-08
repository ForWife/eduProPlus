package com.neu.controller;

import com.neu.beans.Address;
import com.neu.beans.Message;
import com.neu.beans.MessageImg;
import com.neu.beans.User;
import com.neu.service.BackGetAllMessageService;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.neu.util.FastDFSFile;
import com.neu.util.FileManager;
import org.csource.common.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BackCircleOfFriendShowHandler {
	@Autowired
	private BackGetAllMessageService backGetAllMessageService;
	@RequestMapping(value = "/back/back_getAllMessage")
	@ResponseBody
	public List<Message> getAllMessage(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
	    User user = (User) session.getAttribute("user");
		List<Message> result = backGetAllMessageService.getAllMessage(user.getQid());
		for(Message r : result) {
			for(MessageImg m : ((Message) r).getMessageImg()) {
				String img = m.getImgurl();
				m.setFlag(Integer.parseInt(img.substring(img.length()-1, img.length())));
			}
		}
		System.out.println(result);
		System.out.println("测试");
		return result;
	}
	@RequestMapping(value = "/back/back_circleOfFriend_getPart")
	@ResponseBody
	public List<Address> getPart(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
	    User user = (User) session.getAttribute("user");
		return backGetAllMessageService.getPart(user.getQid());
	}
	
	@RequestMapping(value = "/back/back_circleOfFriend_setMessage")
	@ResponseBody
	public void  setMessage(String partChoose, 
							 String areaJs,
							 @RequestParam(value = "files", required = false) MultipartFile [] files,
							 HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
	    User user = (User) session.getAttribute("user");
		partChoose = URLDecoder.decode(partChoose,"utf-8");
		areaJs = URLDecoder.decode(areaJs,"utf-8");
		String pathOfService = request.getServletContext().getRealPath("/");
		String path;
		List<String> pathOfPicture = new ArrayList<>();
		for(MultipartFile file : files) {
			String filename = System.currentTimeMillis() + file.getOriginalFilename();
			InputStream in = file.getInputStream();
			BufferedImage bufferedImg = javax.imageio.ImageIO.read(in);
			int imgWidth = bufferedImg.getWidth();
			int imgHeight = bufferedImg.getHeight();
			if(imgWidth > imgHeight) {
				filename = filename + "0";
			}else {
				filename = filename + "1";
			}
			System.out.println("文件名"+filename);
			FastDFSFile fastDFSFile = new FastDFSFile(file.getBytes(), filename.substring(filename.lastIndexOf(".")+1));
			NameValuePair[] meta_list = new NameValuePair[4];
			meta_list[0] = new NameValuePair("fileName", filename);
			meta_list[1] = new NameValuePair("fileLength", String.valueOf(file.getSize()));
			meta_list[2] = new NameValuePair("fileExt", filename.substring(filename.lastIndexOf(".")+1));
			meta_list[3] = new NameValuePair("fileAuthor", "EduPro");
			String filePath = FileManager.upload(fastDFSFile,meta_list);
			pathOfPicture.add(filePath);
		}
		backGetAllMessageService.setMessage(user.getQid(), partChoose, areaJs, pathOfPicture);
	}
}
 