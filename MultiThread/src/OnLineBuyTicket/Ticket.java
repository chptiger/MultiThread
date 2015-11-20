/* (程序头部注释开始)
* 程序的版权和版本声明部分
* Copyright (c) 2011, 烟台大学计算机学院学生 
* All rights reserved.
* 文件名称：    《多线程练习—买票小程序——Java第十四周》                          
* 作    者：       刘江波                       
* 完成日期：    2012     年   12    月     2   日
* 版 本 号：    v2.2     

* 对任务及求解方法的描述部分 
* 问题描述：

2.仿照例题9.14，模拟3个人排除买票，张某、李某和赵某买电影票，售票员只有3张五元的钱，电影票5元一张。
张某拿20元一张的RMB排在李某的前面，李某排在赵某的前面拿一张10元的RMB买票，赵某拿一张5元的RMB买票。（选做题）  
* 程序头部的注释结束
*/
package OnLineBuyTicket;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class Ticket {
	public static void main(String[] args) {
		new MyFrame();
	}
}

class MyFrame extends JFrame implements Runnable, ActionListener {
	TicketSeller seller;
	Thread buyer1, buyer2, buyer3;
	static JTextArea text;
	JButton start = new JButton("排队买票");

	MyFrame() {
		seller = new TicketSeller();
		buyer1 = new Thread(this);
		buyer2 = new Thread(this);
		buyer3 = new Thread(this);
		text = new JTextArea(10, 30);
		start.addActionListener(this);
		add(text, BorderLayout.CENTER);
		add(start, BorderLayout.NORTH);
		setVisible(true);
		setSize(360, 300);
		validate();
	}

	public void actionPerformed(ActionEvent e) {
		try {
			buyer1.start();
			buyer2.start();
			buyer3.start();
		} catch (Exception exp) {
		}
	}

	public void run() {
		if (Thread.currentThread() == buyer1) {
			seller.rule(20);
		} else if (Thread.currentThread() == buyer2) {
			seller.rule(10);
		} else if (Thread.currentThread() == buyer3) {
			seller.rule(5);
		}
	}
}

class TicketSeller {
	int money5 = 3, money10 = 0, money20 = 0;
	String s = null;

	public synchronized void rule(int money) {
		if (money == 5)// 不用等待
		{
			money5++;
			s = "给你入场券，你的钱正好。";
			MyFrame.text.append("\n" + s);
		} else if (money == 20) {
			while (money5 < 3) {
				try {
					wait();// 没有零钱，等待
				} catch (InterruptedException e) {
				}
			}
			money5 = money5 - 3;
			money20++;
			s = "给你入场券，你给我20元，找你15元。";
			MyFrame.text.append("\n" + s);
		} else if (money == 10) {
			while (money5 < 1) {
				try {
					wait();// 没有零钱，等待
				} catch (InterruptedException e) {
				}
			}
			money5 = money5 - 1;
			money10++;
			s = "给你入场券，你给我10元，找你5元。";
			MyFrame.text.append("\n" + s);
		}
		notifyAll();
	}

}
