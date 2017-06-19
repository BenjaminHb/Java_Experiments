package Exercise10_9;

/**
 * Created by benjaminzhang on 19/06/2017.
 * Copyright © benjaminzhang 2017.
 */
public class Customer extends Thread{
    private Bank bank = null;
    private int id = -1;
    private boolean running = false;
    private int type = -1;
    public Customer(int _id, Bank _bank, int _type){
        bank=_bank;
        id=_id;
        type=_type;
        start();
    }

    public void start(){
        running = true;
        super.start();
    }

    public void halt(){
        running = false;
    }

    public void run(){
        while(running){		//顾客有两种行为，type==0为顾客之间转账，type==1为顾客购买商品
            if(type==0){
                int into = (int)(Bank.NUM_ACCOUNTS*Math.random());	//目标账户
                int amount = (int)(1000*Math.random());				//转账金额
                bank.action(id, into, amount,1);
                yield();
            }
            else if(type==1){
                int into = (int)(Bank.NUM_DESKS*Math.random());		//目标收银台
                int desk = (int)(1000*Math.random());				//消费金额
                bank.action(id, into, desk,3);
                yield();
            }
        }
    }
}