package Exercise10_9;

/**
 * Created by benjaminzhang on 19/06/2017.
 * Copyright © benjaminzhang 2017.
 */
public class Market extends Thread{
    private Bank bank = null;
    private int id = -1;
    private boolean running = false;
    public Market(int _id, Bank _bank){
        bank=_bank;
        id=_id;
        start();
    }

    public void start(){
        running = true;
        super.start();
    }

    public void halt(){
        running = false;
    }

    public void run(){				//商店可以将各个收银台的钱存到银行
        while(running){
            bank.action(id,0,0,2);
            yield();
        }
    }
}