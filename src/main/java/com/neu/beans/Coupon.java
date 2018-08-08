package com.neu.beans;

import java.util.Date;

public class Coupon {
    private int cid;//coupon id
    private int qid;//company id
    private String category;//coupon category
    private float money;//coupon price
    private int total;//coupon total
    private int get;//coupon get money
    private Date deadline;//coupon expired time
    private int score;//integration per coupon

    private int full;
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    
    

    public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	

	public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getGet() {
        return get;
    }

    public void setGet(int get) {
        this.get = get;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getFull() {
		return full;
	}

	public void setFull(int full) {
		this.full = full;
	}
}
