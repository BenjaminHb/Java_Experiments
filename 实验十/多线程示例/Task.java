package com.flueky.thread.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * 待处理业务
 * 
 * @author flueky zkf@yitong.com.cn
 * @date 2016年10月8日 下午2:14:41
 */
public abstract class Task {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	protected String number;// 取号
	private int costTime;// 业务需要消耗的时间
	private Calendar birthTime;// 业务生成时间
	private Calendar startTime;// 业务开始时间
	private Calendar endTime;// 业务结束时间

	private Window window;// 处理该业务的窗口

	public Task(int number, Calendar time) {
		birthTime = time;
		costTime = (new Random().nextInt(10) + 1) * 1000;// 每个任务需要消耗的时间，是1到10s范围内
	}

	public int getCostTime() {
		return costTime;
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

	public void setWindow(Window window) {
		this.window = window;
	}

	public String getId(){
		return number;
	}
	
	@Override
	public String toString() {
		if (window == null) {
			return "任务：" + number + " 生成于：" + dateFormat.format(birthTime.getTime()) + " 耗时：" + costTime;
		}
		return "任务：" + number + " 生成于：" + dateFormat.format(birthTime.getTime()) + " 耗时：" + costTime + " "
				+ window.getName() + "处理时间：" + dateFormat.format(startTime.getTime()) + "~"
				+ dateFormat.format(endTime.getTime());

	}
}
