package com.spring.dto;


import java.util.Date;

import javax.validation.constraints.NotNull;

public class AddItem {
    private int id;
    private @NotNull int productId;
    private  double price;
private int userId;
private Date creaedDate;
    


    public AddItem(Integer id, @NotNull Integer productId, double price, int userId) {
	super();
	this.id = id;
	this.productId = productId;
	this.price = price;
	this.userId = userId;
	
}



	public AddItem() {
		// TODO Auto-generated constructor stub
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public Date getCreaedDate() {
		return creaedDate;
	}



	public void setCreaedDate(Date creaedDate) {
		this.creaedDate = creaedDate;
	}



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}

   
}
