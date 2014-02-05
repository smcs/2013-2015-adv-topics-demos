public class Bond {

	private int id;
	private int Order = 1;
	private int B;
	private int E;

	public String toString() {
		return id + " " + Order;
	}
	
	public void setOrder(Integer newOrder) {
		if (newOrder != null && newOrder > 0) {
			Order = newOrder;
		}
	}

}
