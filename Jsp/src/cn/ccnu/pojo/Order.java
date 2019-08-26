package cn.ccnu.pojo;

public class Order {
	//订单编号,自主主键,
	private int orderId;
	//商品编号
	private int goodsId;
	//用户名
	private int customerId;
	//快递单号
	private int shopId;
	//收货人姓名
	private String customerName;
	//收货地址
	private String customerAddress;
	//支付方式
	private int payWay;
	//订单金额
	private float orderMoney;
	//下单时间
	private String orderTime;
	//发货时间
	private String sendTime;
	//支付时间
	private String payTime;
	//订单状态
	private int orderStatus;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public int getPayWay() {
		return payWay;
	}
	public void setPayWay(int payWay) {
		this.payWay = payWay;
	}
	public float getOrderMoney() {
		return orderMoney;
	}
	public void setOrderMoney(float orderMoney) {
		this.orderMoney = orderMoney;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Order(int orderId, int goodsId, int customerId, int shopId, String customerName, String customerAddress,
			int payWay, float orderMoney, String orderTime, String sendTime, String payTime, int orderStatus) {
		super();
		this.orderId = orderId;
		this.goodsId = goodsId;
		this.customerId = customerId;
		this.shopId = shopId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.payWay = payWay;
		this.orderMoney = orderMoney;
		this.orderTime = orderTime;
		this.sendTime = sendTime;
		this.payTime = payTime;
		this.orderStatus = orderStatus;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int orderId, int goodsId, int customerId, int shopId, String customerName, String customerAddress,
			float orderMoney) {
		super();
		this.orderId = orderId;
		this.goodsId = goodsId;
		this.customerId = customerId;
		this.shopId = shopId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.orderMoney = orderMoney;
	}
		
	
}
