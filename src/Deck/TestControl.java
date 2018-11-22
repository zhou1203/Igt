package Deck;

import java.util.ArrayList;
import java.util.Map;
import User.User;
import Card.Card;
import DButil.Common;
import DButil.DbControl;;

public class TestControl {
	private Deck deck;
	private Card card;
	private int count;
	private DbControl db;
	private String sql;
	private User user;
	
	public TestControl() {
		db = new DbControl();
		db.connect();
	}
	
	public User register(String userId, String gender) {
		user = new User(userId, gender, 2000);
		ArrayList<String> params = new ArrayList<>();
		params.add(userId);
		params.add(gender);
		sql = db.sqlInsertBuilder(Common.TableUser, Common.UserColumns);
		db.insert(sql, params);
		return user;
	}
	
	public void gameHandler(User user, int index, int count, Long decisionTime) {
		deck = new Deck();
		this.count = count;
		int result;
		int money = user.getMoney();
		String userId = user.getUserId(); 
		ArrayList<String> params = new ArrayList<>();
		card = deck.getCard(index - 1);
		String cardType = card.getType();
		if (card.isWin) {
			result = card.getBouns();
			money += result;
		} else {
			result = card.getPenalty();
			money -= result;
		}
		
		sql = db.sqlInsertBuilder(Common.TableIGT, Common.IgtColumns);
		params.add(userId);
		params.add(((Integer)count).toString());
		params.add(cardType);
		params.add(((Boolean)card.isWin).toString());
		params.add(((Integer)result).toString());
		params.add(((Integer)money).toString());
		params.add(decisionTime.toString());
		db.insert(sql, params);
	}
	
	
	public void borrow(int borrowMoney) {
		String userId = user.getUserId();
		int total = 0;
		ArrayList<String> params = new ArrayList<>();
		user.setMoney(user.getMoney() + borrowMoney);
		String countStr = ((Integer)count).toString();
		sql = "select * from igt_scheme where user_id = " + userId + "and" + "count=" + countStr;
		params.add(userId);
		params.add(countStr);
		Map<String, Object> setmap = db.findSimpleResult(sql, params);
		Object testId = setmap.get(Common.ColumnTestId);
		total = user.getBorrow() + borrowMoney;
		user.setBorrow(total);
		params = new ArrayList<>();
		params.add(testId.toString());
		params.add(userId);
		params.add(((Integer)borrowMoney).toString());
		params.add(((Integer)total).toString());
		
		sql = db.sqlInsertBuilder(Common.TableBorrow, Common.BorrowColumns);
		db.insert(sql, params);
	}
	
	public void close() {
		db.close();
	}
	
	
}
