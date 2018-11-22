package DButil;

public class Common {
	public static String TableIGT = "igt_scheme";
	public static String TableBorrow = "borrow_scheme";
	public static String TableUser = "user_scheme";
	
	public static String[] UserColumns = {"user_id", "gender"};
	public static String[] IgtColumns = {"test_id", "user_id", "count", "card_type", "isWin", "bo_or_pe", "money", "decition_time"};
	public static String[] BorrowColumns = {"test_id", "user_id", "money", "total"};
	
	public static String ColumnUserId = "user_id";
	public static String ColumnMoney = "money";
	public static String ColumnTestId = "test_id";
	public static String ColumnCount = "count";
}
