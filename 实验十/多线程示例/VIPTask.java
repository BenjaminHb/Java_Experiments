package com.flueky.thread.demo;

import java.util.Calendar;

/**
 * VIP业务
 * @author flueky zkf@yitong.com.cn
 * @date 2016年10月8日 下午2:17:43
 */
public class VIPTask extends Task {

	public VIPTask(int number, Calendar time) {
		super(number, time);
		String no = new StringBuffer(number+"").reverse().append("000").insert(3, 'V').substring(0, 4);
		this.number = new StringBuffer(no).reverse().toString();
	}

}
