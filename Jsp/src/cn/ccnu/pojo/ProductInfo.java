package cn.ccnu.pojo;

public class ProductInfo {
	private int product_id;
	private String product_name;
	private String product_img;
	private float price;
	private String descript;
	public ProductInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductInfo(int product_id, String product_name, String product_img, float price, String descript) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_img = product_img;
		this.price = price;
		this.descript = descript;
	}
	public ProductInfo(String product_name, String product_img, float price, String descript) {
		super();
		this.product_name = product_name;
		this.product_img = product_img;
		this.price = price;
		this.descript = descript;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_img() {
		return product_img;
	}
	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	
}
