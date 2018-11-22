package User;

public class User {
	private String userId;
	private String gender;
	private int money;
	private int borrow;
	
	public User(String userId, String gender, int money) {
		this.userId = userId;
		this.gender = gender;
		this.money = 2000;
		this.borrow = 0;
	}
	public String getUserId() {
		return userId;
	}
	
	public String getGender() {
		return gender;
	}
	
	public int getBorrow() {
		return borrow;
	}
	
	public void setBorrow(int borrow) {
		this.borrow = borrow;
	}
	
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	
	
}
