package com.neu.beans;

import java.util.Date;

public class Coupon {
    private int cid;//coupon id
    private int qid;//company id
    private String category;//coupon category
    private double money;//coupon price
    private int total;//coupon total
    private int get;//coupon get money
    private Date deadline;//coupon expired time
    private int integration;//integration per coupon

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

    
    

    public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public int getIntegration() {
		return integration;
	}

	public void setIntegration(int integration) {
		this.integration = integration;
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
}
