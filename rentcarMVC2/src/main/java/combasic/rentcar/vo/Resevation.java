package combasic.rentcar.vo;

public class Resevation {
	private int reserveSeq;
	private int no;
	private String id;
	private int qty;
	private int dday;
	private String rday;
	private int userin;
	private int usewifi;
	private int usenavi;
	private int useseat;
	
	public Resevation(int reserveSeq, int no, String id, int qty, int dday, String rday, int userin, int usewifi,
			int usenavi, int useseat) {
		super();
		this.reserveSeq = reserveSeq;
		this.no = no;
		this.id = id;
		this.qty = qty;
		this.dday = dday;
		this.rday = rday;
		this.userin = userin;
		this.usewifi = usewifi;
		this.usenavi = usenavi;
		this.useseat = useseat;
	}

	public int getReserveSeq() {
		return reserveSeq;
	}

	public void setReserveSeq(int reserveSeq) {
		this.reserveSeq = reserveSeq;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getDday() {
		return dday;
	}

	public void setDday(int dday) {
		this.dday = dday;
	}

	public String getRday() {
		return rday;
	}

	public void setRday(String rday) {
		this.rday = rday;
	}

	public int getUserin() {
		return userin;
	}

	public void setUserin(int userin) {
		this.userin = userin;
	}

	public int getUsewifi() {
		return usewifi;
	}

	public void setUsewifi(int usewifi) {
		this.usewifi = usewifi;
	}

	public int getUsenavi() {
		return usenavi;
	}

	public void setUsenavi(int usenavi) {
		this.usenavi = usenavi;
	}

	public int getUseseat() {
		return useseat;
	}

	public void setUseseat(int useseat) {
		this.useseat = useseat;
	}
	
	
	
}
