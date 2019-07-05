package vo;

public class MemberVo {
	private int no;
	private String id;
	private String pwd;
	private String address;
	private String phoneNumber;
	private String age;
	
	public MemberVo() {}
	public MemberVo(String id, String pwd, String address, String phoneNumber, String age) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.age = age;
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "[No=" + no + ",/t ID=" + id + ",/t 주소=" + address + ",/t 핸드폰="
				+ phoneNumber + ",/t 나이=" + age + "]";
	}
	
	
	
	
}
