package Deck;

import java.util.Scanner;

import User.User;

/* igt_scheme user_id count card_type isWin bonus_or_penalty money decision_time
 * user_scheme user_id gender group_id
 *  borrow_scheme test_id user_id borrow_mony borrow_total
 */

public class ViewControl {
	private int count;
	private User user;
	private Scanner in;
	private TestControl testCtl;
	
	public ViewControl() {
		in = new Scanner(System.in);
	}
	
	public void game() {
		count = 1;
		int limit = 100;
		int index;
		welcome();
		System.out.println("*******���Կ�ʼ��*******");
		count = 1;
		Long startTime, endTime, decisionTime;
		
		while (count <= limit) {
			System.out.println("=======================\n��" + count + "�γ���:");
			startTime = System.currentTimeMillis();
			index = in.nextInt();
			endTime = System.currentTimeMillis();
			decisionTime = endTime - startTime;
			testCtl.gameHandler(user, index, count, decisionTime);
			
			if (user.getMoney() < 0) {
				System.out.println("�����ʲ��Ѿ��ľ�����������Ҫ�������Լ�������\n�������������Ľ�");
				int borrowMoney;
				borrowMoney = in.nextInt();
				testCtl.borrow(borrowMoney);
			}
			count ++;
		}
		
		testCtl.close();
	}
		
	public void welcome() {
		String userId, gender;
		System.out.println("��ӭ������IGT�Ĳ�С��Ϸ����Ϸ�����ǣ�����1234�����Ƹ�100�š��������400�����а��������������󻯵�ԭ���100�Σ��Ա�֤��������ջ�Ľ����ࡣÿ�γ������ֽ��������1234����ֱ�����:\r\n" + 
				"�ٳ鵽A�ƣ�����1/2�ĸ��ʻ��100����1/2�ĸ��ʿ۳�35~150���ȵķ���\r\n" + 
				"�ڳ鵽B�ƣ�����9/10�ĸ��ʻ��100����1/10�ĸ��ʿ۳�1250����\r\n" + 
				"�۳鵽C�ƣ�����1/2�ĸ��ʻ��50����1/2�ĸ��ʿ۳�25~75���ȵķ���\r\n" + 
				"�ܳ鵽D�ƣ�����9/10�ĸ��ʻ��50����1/10�ĸ��ʿ۳�250����\r\n" + 
				"Ϊ���������и��õ���Ϸ���飬���ǽ�Ϊ���ṩ2000Ԫ����Ϸ��������\r\n" + 
				"������ڶĲ������г��ָ��ʲ�״����ϵͳ����ʾ�����ҵ�����������о���������ȷ���г�����ֽ������Ϸ��\r\n" + 
				"ȷ�����������Ե����ʼ������Ϸ��ϰ������ȷ������ɵ��������ϰ����ʼ��Ϸ�� ��ô����������������ϰһ�£������ʽ������ĶĲ���Ϸ֮�ð�");
		System.out.println("��������Ա��");
		userId = in.next();
		System.out.println("�������Ա�");
		gender = in.next();
		this.user = testCtl.register(userId, gender);
	}
	
}
