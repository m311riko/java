package cn.exit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Exit extends JDialog implements ActionListener {//定义一个exit类，继承JDialog类，实现ActionListener接口
	JFrame mainFrame;//定义一个JFrame变量
	JPanel panelS, panelN;//定义两个JPanel变量
	JButton yes, no;//定义两个JButton变量
	JLabel lab;//定义一个JLabel变量
	public Exit(JFrame mainFrame) {
		super(mainFrame, "南京邮电大学学生成绩信息管理系统", true);
		// true 代表为有模式对话框
		this.mainFrame = mainFrame;
		panelN = new JPanel();//创建Panel对象
		panelS = new JPanel();//创建Panel对象
		lab = new JLabel("确认要退出学生成绩管理系统吗?");//创建JLabel对象“确认要退出学生成绩管理系统？”
		lab.setForeground(Color.black);//设置字体为黑色
		lab.setFont(new Font("华文行楷", Font.PLAIN, 20));//设置字体为华文行楷，大小为20
		panelN.add(lab);//将标签添加入面板panelN
		yes = new JButton("退出");//创建JButton对象
		yes.setForeground(Color.black);//设置按钮字体为黑色
		yes.setFont(new Font("华文行楷", Font.PLAIN, 20));//设置按钮字体为华文行楷，大小为20
		yes.addActionListener(this);//加入事件监听
		no = new JButton("取消");//创建JButton对象“取消”
		no.setFont(new Font("华文行楷", Font.PLAIN, 20));//设置按钮字体为华文行楷，大小为20
		no.setForeground(Color.black);//设置按钮字体颜色为黑色
		no.addActionListener(this);//加入事件监听
		panelS.add(yes);//将按钮加入面板panelS
		panelS.add(no);//将按钮加入面板panelS
		getContentPane().add(panelS, BorderLayout.SOUTH);//设置面板为BorderLayout
		getContentPane().add(panelN, BorderLayout.NORTH);//设置面板为BorderLayout
		this.setBackground(Color.yellow);//设置背景色为黄色
		this.setResizable(false); // 设置对话框为不可改变大小
	}
	public void actionPerformed(ActionEvent e) {//事件监听方法
		if (e.getSource() == yes) {//如果事件是“yes”
			System.exit(0);
		}
		if (e.getSource() == no) {//如果事件是“no”
			this.setVisible(false);//界面不可见
		}
	}
}
