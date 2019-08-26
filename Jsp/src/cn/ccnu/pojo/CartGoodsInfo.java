package cn.ccnu.pojo;

public class CartGoodsInfo {
	private int goodsId;
	private int cartId;
	private int goodsAccount;
	private float price;
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getGoodsAccount() {
		return goodsAccount;
	}
	public void setGoodsAccount(int goodsAccount) {
		this.goodsAccount = goodsAccount;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public CartGoodsInfo(int goodsId, int cartId, int goodsAccount, float price) {
		super();
		this.goodsId = goodsId;
		this.cartId = cartId;
		this.goodsAccount = goodsAccount;
		this.price = price;
	}
	public CartGoodsInfo(int goodsId, int cartId) {
		super();
		this.goodsId = goodsId;
		this.cartId = cartId;
	}
	public CartGoodsInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
