import java.util.List;

public class Cart {

	private List<Item> items;

	@Override
	public String toString() {
		return "Cart [items=" + items + "]";
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Cart(List<Item> items) {
		super();
		this.items = items;
	}

	public Cart() {
		super();
	}

}
