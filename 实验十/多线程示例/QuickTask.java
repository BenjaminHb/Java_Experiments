package com.flueky.thread.demo;

import java.util.Calendar;

/**
 * 快速业务
 * @author flueky zkf@yitong.com.cn
 * @date 2016年10月8日 下午2:18:27
 */
public class QuickTask extends Task {

	public QuickTask(int number, Calendar time) {
		super(number, time);
		String no = new StringBuffer(number+"").reverse().append("000").insert(3, 'Q').substring(0, 4);
		this.number = new StringBuffer(no).reverse().toString();
	}

}
