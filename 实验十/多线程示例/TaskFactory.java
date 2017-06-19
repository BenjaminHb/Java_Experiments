package com.flueky.thread.demo;

import java.util.Calendar;
import java.util.Random;

/**
 * 生成任务工厂
 * 
 * @author flueky zkf@yitong.com.cn
 * @date 2016年10月8日 下午2:16:05
 */
public class TaskFactory {

	private static int normalNo = 0;// 普通业务取号计数器
	private static int vipNo = 0;// vip业务取号计数器
	private static int quickNo = 0;// 快速业务取号计数器

	private static Random random = new Random();

	private static final int NORMAL_PROPORTION = 6;
	private static final int VIP_PROPORTION = 1;
	private static final int QUICK_PROPORTION = 3;

	/**
	 * 生成一个业务
	 * 
	 * @author flueky zkf@yitong.com.cn
	 * @date 2016年10月8日 下午3:34:17
	 * @return
	 */
	public static Task generateTask() {
		Task task = null;
		int type = random.nextInt(NORMAL_PROPORTION + VIP_PROPORTION + QUICK_PROPORTION);
		if (type < VIP_PROPORTION)
			task = new VIPTask(++vipNo, Calendar.getInstance());
		else if (type < VIP_PROPORTION + QUICK_PROPORTION)
			task = new QuickTask(++quickNo, Calendar.getInstance());
		else
			task = new NormalTask(++normalNo, Calendar.getInstance());
		return task;
	}

}
