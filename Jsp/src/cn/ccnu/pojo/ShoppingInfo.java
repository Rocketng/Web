package cn.ccnu.pojo;

import java.util.Date;

public class ShoppingInfo {
	private int shopId;
	private String shopName;
	private String shopContact;
	private String telephone;
	private float price;
	private Date modifiedTime;
	
	public ShoppingInfo(int shopId, String shopName, String shopContact, String telephone, float price) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
		this.shopContact = shopContact;
		this.telephone = telephone;
		this.price = price;
	}
	public ShoppingInfo(String shopName, String shopContact, String telephone, float price) {
		super();
		this.shopName = shopName;
		this.shopContact = shopContact;
		this.telephone = telephone;
		this.price = price;
	}
	public ShoppingInfo(int shopId, String shopName, String shopContact, String telephone, float price,
			Date modifiedTime) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
		this.shopContact = shopContact;
		this.telephone = telephone;
		this.price = price;
		this.modifiedTime = modifiedTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopContact() {
		return shopContact;
	}
	public void setShopContact(String shopContact) {
		this.shopContact = shopContact;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public ShoppingInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
