package com.flueky.thread.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Bank implements TaskCompeleteListener {

	public static void main(String[] args) {

		new Bank().excute();
	}

	public void excute() {

		/**
		 * 普通任务队列
		 */
		BlockingQueue<Task> normalTasks = new ArrayBlockingQueue<Task>(100);
		/**
		 * vip任务队列
		 */
		BlockingQueue<Task> vipTasks = new ArrayBlockingQueue<Task>(100);
		/**
		 * 快速业务队列
		 */
		BlockingQueue<Task> quickTasks = new ArrayBlockingQueue<Task>(100);

		NormalWindow normalWindow1 = new NormalWindow("普通窗口1", this);
		NormalWindow normalWindow2 = new NormalWindow("普通窗口2", this);
		NormalWindow normalWindow3 = new NormalWindow("普通窗口3", this);
		NormalWindow normalWindow4 = new NormalWindow("普通窗口4", this);
		VIPWindow vipWindow = new VIPWindow("VIP窗口", this);
		QuickWindow quickWindow = new QuickWindow("快速窗口", this);

		/**
		 * 添加处于本窗口管理的任务队列
		 */
		normalWindow1.addTaskQueque(normalTasks);
		normalWindow2.addTaskQueque(normalTasks);
		normalWindow3.addTaskQueque(normalTasks);
		normalWindow4.addTaskQueque(normalTasks);
		vipWindow.addTaskQueque(vipTasks);
		quickWindow.addTaskQueque(quickTasks);

		/**
		 * 给vip窗口和快速窗口添加普通窗口的任务队列
		 */
		vipWindow.addTaskQueque(normalTasks);
		quickWindow.addTaskQueque(normalTasks);

		/**
		 * 启动所有窗口的线程
		 */
		normalWindow1.start();
		normalWindow2.start();
		normalWindow3.start();
		normalWindow4.start();
		vipWindow.start();
		quickWindow.start();

		while (true) {
			try {
				Task task = TaskFactory.generateTask();
				System.out.println(task);
				if (task instanceof NormalTask)
					normalTasks.add(task);
				else if (task instanceof VIPTask)
					vipTasks.add(task);
				else
					quickTasks.add(task);
				
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTaskCompelete(Task task) {
		System.out.println(task);
	}

}
