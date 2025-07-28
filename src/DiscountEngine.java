import java.util.ArrayList;
import java.util.List;

public class DiscountEngine {

	public static void calculateCart(Cart cart, Discount discount) {
		List<AfterBreakDown> breakdown = new ArrayList<AfterBreakDown>();
		CartSummary cartSummary = new CartSummary();
		cart.getItems().forEach(item -> {
			AfterBreakDown afterBreakDown = new AfterBreakDown(item.getName(), item.getPrice() * item.getQuantity());

			if (discount.getItems().getId() == item.getId()) {
				afterBreakDown.setDiscount(item.getPrice() * item.getQuantity() * discount.getItems().getDiscount());
				cartSummary.setItemDiscount(cartSummary.getItemDiscount()
						+ item.getPrice() * item.getQuantity() * discount.getItems().getDiscount());
			}
//			System.out.println(afterBreakDown);

			if (discount.getCategories().getCategory().equals(item.getCategory())
					&& afterBreakDown.getDiscount() != 0) {

				if (item.getPrice() * item.getQuantity() * discount.getItems().getDiscount() < item.getPrice()
						* item.getQuantity() * discount.getCategories().getDiscount()) {
					afterBreakDown
							.setDiscount(item.getPrice() * item.getQuantity() * discount.getCategories().getDiscount());
					cartSummary.setItemDiscount(cartSummary.getItemDiscount()
							+ item.getPrice() * item.getQuantity() * discount.getCategories().getDiscount());
				}

			}
			if (discount.getCategories().getCategory().equals(item.getCategory())
					&& afterBreakDown.getDiscount() == 0) {

				afterBreakDown
						.setDiscount(item.getPrice() * item.getQuantity() * discount.getCategories().getDiscount());
				cartSummary.setItemDiscount(cartSummary.getItemDiscount()
						+ item.getPrice() * item.getQuantity() * discount.getCategories().getDiscount());

			}

			if (item.getCategory().equals(discount.getDeals().getCategory())) {
				List<Integer> prices = cart.getItems().stream().filter(a -> a.getCategory().equals(item.getCategory()))
						.map(Item::getPrice).toList();

//
				afterBreakDown.setDiscount(item.getPrice()
						* (item.getQuantity() / discount.getDeals().getBuyx() - discount.getDeals().getGety()));
//				

			}

			afterBreakDown.setFinalPrice(afterBreakDown.getOriginal() - afterBreakDown.getDiscount());
			cartSummary.setSubtotal(cartSummary.getSubtotal() + item.getPrice() * item.getQuantity());
			cartSummary.setFinalTotal(cartSummary.getFinalTotal() + afterBreakDown.getFinalPrice());
//			System.out.println(afterBreakDown);
			breakdown.add(afterBreakDown);
		});
		cartSummary.setAfterBreakDown(breakdown);

		if (cartSummary.getSubtotal() > discount.getCartCoupon().getMinAmount()) {
			cartSummary.setCouponDiscount(discount.getCartCoupon().getDiscount());
			cartSummary.setFinalTotal(cartSummary.getFinalTotal() - cartSummary.getCouponDiscount());
		}
		System.out.println(cartSummary);

	}

	public static void main(String[] args) {

		Cart cart = new Cart(List.of(new Item(1, "Laptop", "electronics", 1000, 1),
				new Item(2, "Mouse", "electronics", 50, 3), new Item(3, "Notebook", "stationery", 10, 6)));
		Discount discount = new Discount(new Discount_items(2, 0.20), new Discount_categories("electronics", 0.15),
				new Discount_cartCoupon(50, 10), new Discount_deals("stationery", 2, 1));
		calculateCart(cart, discount);
	}
}

class AfterBreakDown {
	private String item;
	private int original;
	private double discount;
	private double finalPrice;

	@Override
	public String toString() {
		return "AfterBreakDown [item=" + item + ", original=" + original + ", discount=" + discount + ", finalPrice="
				+ finalPrice + "]";
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getOriginal() {
		return original;
	}

	public void setOriginal(int original) {
		this.original = original;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public AfterBreakDown(String item, int original, double discount, double finalPrice) {
		super();
		this.item = item;
		this.original = original;
		this.discount = discount;
		this.finalPrice = finalPrice;
	}

	public AfterBreakDown() {
		super();
	}

	public AfterBreakDown(String item) {
		super();
		this.item = item;
	}

	public AfterBreakDown(String item, int original) {
		super();
		this.item = item;
		this.original = original;
	}

}

class CartSummary {
	private double subtotal;
	private double itemDiscount;
	private double dealDiscounts;
	private double couponDiscount;
	private double finalTotal;
	List<AfterBreakDown> afterBreakDown;

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getItemDiscount() {
		return itemDiscount;
	}

	public void setItemDiscount(double itemDiscount) {
		this.itemDiscount = itemDiscount;
	}

	public double getDealDiscounts() {
		return dealDiscounts;
	}

	public void setDealDiscounts(double dealDiscounts) {
		this.dealDiscounts = dealDiscounts;
	}

	public double getCouponDiscount() {
		return couponDiscount;
	}

	public void setCouponDiscount(double couponDiscount) {
		this.couponDiscount = couponDiscount;
	}

	public double getFinalTotal() {
		return finalTotal;
	}

	public void setFinalTotal(double finalTotal) {
		this.finalTotal = finalTotal;
	}

	public List<AfterBreakDown> getAfterBreakDown() {
		return afterBreakDown;
	}

	public void setAfterBreakDown(List<AfterBreakDown> afterBreakDown) {
		this.afterBreakDown = afterBreakDown;
	}

	@Override
	public String toString() {
		return "CartSummary [subtotal=" + subtotal + ", itemDiscount=" + itemDiscount + ", dealDiscounts="
				+ dealDiscounts + ", couponDiscount=" + couponDiscount + ", finalTotal=" + finalTotal
				+ ", afterBreakDown=" + afterBreakDown + "]";
	}

	public CartSummary(double subtotal, double itemDiscount, double dealDiscounts, double couponDiscount,
			double finalTotal, List<AfterBreakDown> afterBreakDown) {
		super();
		this.subtotal = subtotal;
		this.itemDiscount = itemDiscount;
		this.dealDiscounts = dealDiscounts;
		this.couponDiscount = couponDiscount;
		this.finalTotal = finalTotal;
		this.afterBreakDown = afterBreakDown;
	}

	public CartSummary() {
		super();
	}

}
