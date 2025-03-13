package kr.basic.vo;

public class Reservation {
	
	
	private int reserveSeq; // 차량 예약 정보
	private int num; // 렌트카 고유 번호
	private String userid; // 고객 id
	private int qty; // 렌트한 수량
	private int dday; // 대여 기간
	private String rday; // 대여일
	private int usein; // 운전자 보험여부
	private int usewifi; // 인터넷 여부
	private int usenavi; // 네비게이션 대여 여부
	private int useseat; // 베이비시트 적용
	
	
	
	public Reservation(int num, String userid, int qty, int dday, String rday, int usein, int usewifi, int usenavi,
			int useseat) {
		super();
		this.num = num;
		this.userid = userid;
		this.qty = qty;
		this.dday = dday;
		this.rday = rday;
		this.usein = usein;
		this.usewifi = usewifi;
		this.usenavi = usenavi;
		this.useseat = useseat;
	}
	@Override
	public String toString() {
		return "Reservation [reserveSeq=" + reserveSeq + ", num=" + num + ", userid=" + userid + ", qty=" + qty
				+ ", dday=" + dday + ", rday=" + rday + ", usein=" + usein + ", usewifi=" + usewifi + ", usenavi="
				+ usenavi + ", useseat=" + useseat + "]";
	}
	public int getReserve_seq() {
		return reserveSeq;
	}
	public void setReserve_seq(int reserveSeq) {
		this.reserveSeq = reserveSeq;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public int getUsein() {
		return usein;
	}
	public void setUsein(int usein) {
		this.usein = usein;
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