package cn.ccnu.pojo;

public class CartUser {
	private int cart_id;
	private int user_id;
	public CartUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CartUser(int cart_id, int user_id) {
		super();
		this.cart_id = cart_id;
		this.user_id = user_id;
	}

	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
}
