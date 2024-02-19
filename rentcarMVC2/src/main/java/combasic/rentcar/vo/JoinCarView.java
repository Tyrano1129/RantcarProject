package combasic.rentcar.vo;

public class JoinCarView {
	private int reserveSeq;
	private int no;
	private String img;
	private String name;
	private String rday;
	private int dday;
	private int price;
	private int qty;
	private int usein;
	private int usewifi;
	private int useseat;
	private int usenavi;
	
	public JoinCarView(int reserveSeq,int no,String img, String name,String rday, int dday, int price, int qty, int usein, int usewifi, int useseat,
			int usenavi) {
		this.reserveSeq = reserveSeq;
		this.no = no;
		this.img = img;
		this.name = name;
		this.rday = rday;
		this.dday = dday;
		this.price = price;
		this.qty = qty;
		this.usein = usein;
		this.usewifi = usewifi;
		this.useseat = useseat;
		this.usenavi = usenavi;
	}
	
	public int getReserveSeq() {
		return reserveSeq;
	}

	public int getNo() {
		return no;
	}
	public String getImg() {
		return img;
	}
	public String getName() {
		return name;
	}
	public int getDday() {
		return dday;
	}
	public int getPrice() {
		return price;
	}
	public int getQty() {
		return qty;
	}
	public int getUsein() {
		return usein;
	}
	public int getUsewifi() {
		return usewifi;
	}
	public int getUseseat() {
		return useseat;
	}
	public int getUsenavi() {
		return usenavi;
	}
	public String getRday() {
		return rday;
	}
	
	
	
}
