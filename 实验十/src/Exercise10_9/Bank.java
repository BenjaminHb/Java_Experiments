package Exercise10_9;

import java.awt.*;
import java.awt.event.*;

/**
 * Created by benjaminzhang on 19/06/2017.
 * Copyright © benjaminzhang 2017.
 */
public class Bank extends Frame implements ActionListener{
    protected final static int NUM_ACCOUNTS=8;		//顾客人数
    protected final static int NUM_DESKS=4;			//收银台个数
    private final static int WASTE_TIME=1;			//每一个行为的延迟时间
    private int accounts[]=new int[NUM_ACCOUNTS];
    private int desks[]=new int[NUM_DESKS];
    private Customer customer[]=new Customer[NUM_ACCOUNTS];	//八为客人
    private Market market[]=new Market[NUM_DESKS];		//四张收银台
    private int totalmarketmoney=0;						//商店存在银行的总金额
    private int counter=0;		//顾客间转账次数
    private int counter1=0;		//商店将收银台的钱存到银行
    private int counter2=0;		//顾客到商店消费
    private int choose=0;		//顾客的两种行为不能同时进行，故用choose分开

    private Label status = new Label("Transfers Completed:0");	//界面设计
    private TextArea display = new TextArea();
    private Button show = new Button("Show Accounts");
    private Button start = new Button("Restart");
    private Button stop = new Button("Stop");

    public Bank(){
        super("Mystery Money");			//界面以及时间监听器部分
        Panel buttons = new Panel();
        buttons.setLayout(new FlowLayout());
        buttons.add(show);		show.addActionListener(this);
        buttons.add(start);		start.addActionListener(this);
        buttons.add(stop);		stop.addActionListener(this);
        setLayout(new BorderLayout());
        add("North",status);  add("South",buttons);  add("Center",display);
        validate();setSize(500,500);setVisible(true);

        for(int i=0;i<accounts.length;i++)		//每个客户初始金额为100000，一共8个客户，故总金额为800000
            accounts[i]=100000;
        for(int i=0;i<desks.length;i++)
            desks[i]=0;
        start();

        addWindowListener(new WindowAdapter(){	//x可以关闭窗口
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
    }

    public synchronized void action(int from,int into,int amount,int type){
        if(type==1){		//顾客之间转账
            if((accounts[from]>=amount)&&(from!=into)){
                int newAmountFrom = accounts[from]-amount;
                int newAmountTo = accounts[into]+amount;
                wasteSomeTime();
                accounts[from]=newAmountFrom;
                accounts[into]=newAmountTo;
                status.setText("Transfers:"+(counter++)+" Save:"+(counter1)+" Buy:"+(counter2));
            }
        }
        else if(type==2){	//收银台存到银行
            if((desks[from]>0)){
                int newAmountTo = totalmarketmoney+desks[from];
                int newAmountFrom = 0;
                wasteSomeTime();
                desks[from]=newAmountFrom;
                totalmarketmoney=newAmountTo;
                status.setText("Transfers:"+(counter)+" Save:"+(counter1++)+" Buy:"+(counter2));
            }
        }
        else if(type==3){	//顾客消费
            if((accounts[from]>=amount)){
                int newAmountFrom = accounts[from]-amount;
                int newAmountTo = desks[into]+amount;
                wasteSomeTime();
                accounts[from]=newAmountFrom;
                desks[into]=newAmountTo;
                status.setText("Transfers:"+(counter)+" Save:"+(counter1)+" Buy:"+(counter2++));
            }
        }

    }

    private void start(){
        stop();
        if(choose%2==0){	//顾客的行为不能同时进行，故设置choose，stop之后重新开始时交换
            for(int i=0;i<accounts.length;i++)
                customer[i]= new Customer(i,this,0);

            for(int i=0;i<desks.length;i++)
                market[i]= new Market(i,this);
        }
        else{
            for(int i=0;i<accounts.length;i++)
                customer[i]= new Customer(i,this,1);

            for(int i=0;i<desks.length;i++)
                market[i]= new Market(i,this);
        }
        choose=choose+1;

    }

    private void stop(){	//暂停当前线程
        for(int i=0;i<desks.length;i++)
            if(market[i]!=null)
                market[i].halt();
        for(int i=0;i<accounts.length;i++)
            if(customer[i]!=null)
                customer[i].halt();
    }

    private void wasteSomeTime(){	//模拟实际操作时间的延迟
        try{
            Thread.sleep(WASTE_TIME);
        }catch(InterruptedException ie){
            System.err.println("Error: "+ie);
        }
    }

    private void showAccounts(){	//界面输出
        int sum=0;
        int sum1=0;
        for(int i=0;i<accounts.length;i++){
            sum+=accounts[i];
            display.append("\nCustomer "+i+" :$ "+accounts[i]);		//分别输出顾客账号金额
        }
        display.append("\nTotal Amount of Customers:     $ "+sum);	//8名顾客所剩总金额

        for(int i=0;i<desks.length;i++){
            sum1+=desks[i];
            display.append("\nDesk "+i+" :$ "+desks[i]);		//分别输出收银台目前存放金额
        }
        display.append("\nTotal Amount of Desks:     $ "+sum1);//4张收银台总金额

        display.append("\nTotal Amount of Market in Bank:     $ "+totalmarketmoney);//存到商店账号的金额
        display.append("\nTotal money:"+(sum+sum1+totalmarketmoney));//顾客总金额，收银台总金额，商店账号总金额的和不变
    }

    public void actionPerformed(ActionEvent ae){	//时间响应
        if(ae.getSource()==show)
            showAccounts();
        else if(ae.getSource()==start)
            start();
        else if(ae.getSource()==stop)
            stop();

    }

    public static void main(String args[]){
        Bank bank = new Bank();
    }
}
