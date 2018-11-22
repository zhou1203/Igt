package Deck;

import java.util.Scanner;

import User.User;

/* igt_scheme user_id count card_type isWin bonus_or_penalty money decision_time
 * user_scheme user_id gender group_id
 *  borrow_scheme test_id user_id borrow_mony borrow_total
 */

public class ViewControl {
	private User user;
	private Scanner in;
	private TestControl testCtl;
	
	public ViewControl() {
		in = new Scanner(System.in);
	}
	
	public void game() {
		int count = 1;
		int limit = 100;
		int index;
		welcome();
		System.out.println("*******测试开始*******");
		long startTime, endTime, decisionTime;
		
		while (count <= limit) {
			System.out.println("=======================\n第" + count + "次抽牌");
			startTime = System.currentTimeMillis();
			index = in.nextInt();
			endTime = System.currentTimeMillis();
			decisionTime = endTime - startTime;
			testCtl.gameHandler(user, index, count, decisionTime);
			
			if (user.getMoney() < 0) {
				System.out.println("你的账户透支，现在你可以向终端贷款，请输入贷款金额：\n");
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
		System.out.println("欢迎你来到IGT赌博小游戏，游戏规则是：现有1234四种牌各100张。请你从这400张牌中按照你觉得利益最大化的原则抽100次，以保证最后您所收获的金额更多。每次抽有四种结果，抽中1234结果分别如下:\r\n" + 
				"①抽到1牌，你有1/2的概率获得100奖金，1/2的概率扣除35~150不等的罚金\r\n" + 
				"②抽到2牌，你有9/10的概率获得100奖金，1/10的概率扣除1250罚金\r\n" + 
				"③抽到3牌，你有1/2的概率获得50奖金，1/2的概率扣除25~75不等的罚金\r\n" + 
				"④抽到4牌，你有9/10的概率获得50奖金，1/10的概率扣除250罚金\r\n" + 
				"为了能让您有更好的游戏体验，我们将免费为您提供2000元的游戏基础基金。\r\n" + 
				"如果您在赌博过程中出现负资产状况，系统会提示您借款业务，您可以自行决定借款金额，以确保有充足的现金继续游戏。\r\n" + 
				"确认理解后您可以点击开始进行游戏练习，当您确保理解后可点击结束练习、开始游戏， 那么现在让我们先来练习一下，随后正式开启你的赌博游戏之旅吧");
		System.out.println("请输入您的编号");
		userId = in.next();
		System.out.println("请输入您的性别");
		gender = in.next();
		this.user = testCtl.register(userId, gender);
	}
	
}
