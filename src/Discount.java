
public class Discount {

	private Discount_items items;
	private Discount_categories categories;
	private Discount_cartCoupon cartCoupon;
	private Discount_deals deals;

	public Discount_items getItems() {
		return items;
	}

	public void setItems(Discount_items items) {
		this.items = items;
	}

	public Discount_categories getCategories() {
		return categories;
	}

	public void setCategories(Discount_categories categories) {
		this.categories = categories;
	}

	public Discount_cartCoupon getCartCoupon() {
		return cartCoupon;
	}

	public void setCartCoupon(Discount_cartCoupon cartCoupon) {
		this.cartCoupon = cartCoupon;
	}

	public Discount_deals getDeals() {
		return deals;
	}

	public void setDeals(Discount_deals deals) {
		this.deals = deals;
	}

	@Override
	public String toString() {
		return "Discount [items=" + items + ", categories=" + categories + ", cartCoupon=" + cartCoupon + ", deals="
				+ deals + "]";
	}

	public Discount(Discount_items items, Discount_categories categories, Discount_cartCoupon cartCoupon,
			Discount_deals deals) {
		super();
		this.items = items;
		this.categories = categories;
		this.cartCoupon = cartCoupon;
		this.deals = deals;
	}

	public Discount() {
		super();
	}

}

class Discount_items {
	private int id;
	private double discount;

	@Override
	public String toString() {
		return "Discount_items [id=" + id + ", discount=" + discount + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Discount_items(int id, double discount) {
		super();
		this.id = id;
		this.discount = discount;
	}

	public Discount_items() {
		super();
	}

}

class Discount_categories {
	private String category;
	private double discount;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Discount_categories [category=" + category + ", discount=" + discount + "]";
	}

	public Discount_categories(String category, double discount) {
		super();
		this.category = category;
		this.discount = discount;
	}

	public Discount_categories() {
		super();
	}

}

class Discount_cartCoupon {
	private int minAmount;
	private double discount;

	public int getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(int minAmount) {
		this.minAmount = minAmount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Discount_cartCoupon [minAmount=" + minAmount + ", discount=" + discount + "]";
	}

	public Discount_cartCoupon(int minAmount, double discount) {
		super();
		this.minAmount = minAmount;
		this.discount = discount;
	}

	public Discount_cartCoupon() {
		super();
	}

}

class Discount_deals {
	private String category;
	private int buyx;
	private int gety;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getBuyx() {
		return buyx;
	}

	public void setBuyx(int buyx) {
		this.buyx = buyx;
	}

	public int getGety() {
		return gety;
	}

	public void setGety(int gety) {
		this.gety = gety;
	}

	@Override
	public String toString() {
		return "Discount_Deals [category=" + category + ", buyx=" + buyx + ", gety=" + gety + "]";
	}

	public Discount_deals(String category, int buyx, int gety) {
		super();
		this.category = category;
		this.buyx = buyx;
		this.gety = gety;
	}

	public Discount_deals() {
		super();
	}

}
