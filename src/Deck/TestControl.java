package Deck;

import java.util.ArrayList;
import java.util.Map;
import User.User;
import Card.Card;
import DButil.*;

public class TestControl {
	private Deck deck;
	private Card card;
	private int count;
	private DbControl db;
	private String sql;
	private User user;
	private ArrayList<String> params;
	
	public TestControl() {
		db = new DbControl();
		db.connect();
	}
	
	public User register(String userId, String gender) {
		user = new User(userId, gender, 2000);
		ArrayList<String> params = new ArrayList<>();
		params.add(userId);
		params.add(gender);
		sql = DbTool.sqlInsertBuilder(Common.TableUser, Common.UserColumns);
		db.insert(sql, params);
		return user;
	}
	
	public void gameHandler(User user, int index, int count, long decisionTime) {
		deck = new Deck();
		this.count = count;
		int result;
		int money = user.getMoney();
		String userId = user.getUserId(); 
		card = deck.getCard(index);
		String cardType = card.getType();
		boolean isWin = card.isWin;
		if (isWin) {
			result = card.getBouns();
			money += result;
		} else {
			result = card.getPenalty();
			money -= result;
		}
		user.setMoney(money);
		// insert into database
		sql = DbTool.sqlInsertBuilder(Common.TableIGT, Common.IgtColumns);
		params = DbTool.paramsBuilder(userId, count, cardType, isWin, result, money, decisionTime);
		db.insert(sql, params);
	}
	
	public void borrow(int borrowMoney) {
		String userId = user.getUserId();
		int total = 0;
		user.setMoney(user.getMoney() + borrowMoney);
		String countStr = String.valueOf(count);
		//select testId
		sql = "select * from igt_scheme where user_id = " + userId + "and" + "count=" + countStr;
		params = DbTool.paramsBuilder(userId, count);
		Map<String, Object> setmap = db.findSimpleResult(sql, params);
		Object testId = setmap.get(Common.ColumnTestId);
		
		total = user.getBorrow() + borrowMoney;
		user.setBorrow(total);
		
		params = DbTool.paramsBuilder(testId, userId, borrowMoney, total);
		sql = DbTool.sqlInsertBuilder(Common.TableBorrow, Common.BorrowColumns);
		db.insert(sql, params);
	}

	
	public void close() {
		db.close();
	}
	
	
	
	
}
