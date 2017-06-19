package com.flueky.thread.demo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.BlockingQueue;

/**
 * 窗口
 * 
 * @author flueky zkf@yitong.com.cn
 * @date 2016年10月8日 下午2:02:09
 */
public abstract class Window extends Thread {

	private TaskCompeleteListener listener;

	protected ArrayList<BlockingQueue<Task>> taskQueue = null;// 任务队列容器，每个窗口至少有一个任务队列

	public Window(String name, TaskCompeleteListener listener) {
		super(name);
		this.listener = listener;
	}

	/**
	 * 添加任务队列。VIP和快速窗口，优先处理属于本窗口的业务。当普通窗口业务繁忙时，配合处理普通窗口的业务。
	 * 
	 * @author flueky zkf@yitong.com.cn
	 * @date 2016年10月9日 下午6:45:24
	 * @param tasks
	 */
	public void addTaskQueque(BlockingQueue<Task> tasks) {
		if (taskQueue == null)
			taskQueue = new ArrayList<BlockingQueue<Task>>();
		taskQueue.add(tasks);
	}

	/**
	 * 从队列中取出任务
	 * 
	 * @author flueky zkf@yitong.com.cn
	 * @date 2016年10月9日 下午6:47:12
	 * @return 可能返回空，等待一段时间查询
	 * @throws InterruptedException
	 */
	protected Task getTask() throws InterruptedException {
		if (taskQueue == null) {
			return null;
		}
		// if (taskQueue.get(0).isEmpty()) {// 当属于自己的任务队列空
		// if (taskQueue.size() > 1) {// 存在其他的任务队列
		//
		// } else {// 不存在其他的任务队列
		//
		// }
		// } else {// 属于自己的任务队列非空
		// return taskQueue.get(0).take();
		// }
		if (taskQueue.get(0).isEmpty() || taskQueue.size() == 1) {// 当自己的任务队列空，或者本本窗口只有属于自己的任务
			return taskQueue.get(0).take();// 从对头取出任务，如果任务队列空，则阻塞线程
		}
		for (int i = 1; i < taskQueue.size(); i++) {
			if (!taskQueue.get(i).isEmpty()) {// 存在非空的任务队列，取出任务处理
				System.err.println("处理其他窗口业务");
				return taskQueue.get(i).remove();
			}
		}
		return null;

	}

	@Override
	public void run() {
		super.run();
		while(true){
			Task task = null;
			try {
				while ((task = getTask()) == null) {
					Thread.sleep(1000);
				}
				task.setWindow(this);
				System.out.println(getName() + "处理" + task.getId());
				task.setStartTime(Calendar.getInstance());
				Thread.sleep(task.getCostTime());
				task.setEndTime(Calendar.getInstance());
				listener.onTaskCompelete(task);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
