package cn.query;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class QueryStudent extends Panel implements ActionListener {//定义一个QueryStudent类，继承Panel类，实现ActionListener接口
	Connection con;//定义一个Connection变量
	Statement sql;//定义一个Sql对象
	ButtonGroup bg;//定义一个ButtonGroup对象
	JRadioButton male, female;//定义两个JRadioButton对象
	JTextField num, name, courseId, courseName, card,regularGrade,experimentalGrade,finalGrade,totalGrade,totalCard;//定义多个JTextField变量
	JButton jb;//定义一个JButton变量
	Box box, box0, box1, box2, box3, box4, box5, box6,box7,box8,box9;//定义多个Box对象
	int flag = 0;//定义一个整型变量
	public QueryStudent() {
		Font font = new Font("华文中宋", Font.BOLD, 30);//设置面板字体为华文中宋，大小为30
		UIManager.put("Label.font", font);//将面板加入主面板中
		setLayout(new BorderLayout());//建立一个BorderLayout布局管理器
		jb = new JButton("查询");//建立一个“查询”按钮
		jb.setBackground(Color.white);//设置按钮背景色为白色
		jb.setFont(new Font("华文行楷", Font.BOLD, 22));//设置按钮字体为华文行楷，大小为22
		jb.setForeground(Color.black);//设置字体颜色为黑色
		jb.addActionListener(this);//加入事件监听
		num = new JTextField(26);//创建文本框对象，大小为26
		name = new JTextField(20);//创建文本框对象，大小为20
		courseId = new JTextField(20);//创建文本框对象，大小为20
		courseName=new JTextField(20);//创建文本框对象，大小为20
		card=new JTextField(20);//创建文本框对象，大小为20
		regularGrade=new JTextField(20);//创建文本框对象，大小为20
		
		finalGrade=new JTextField(20);//创建文本框对象，大小为20
		totalGrade=new JTextField(20);//创建文本框对象，大小为20
		totalCard=new JTextField(20);//创建文本框对象，大小为20
		experimentalGrade=new JTextField(20);//创建文本框对象，大小为20
		
		/* 设置以下属性值不可编辑 */
		name.setEditable(false);
		courseId.setEditable(false);
		courseName.setEditable(false);
		card.setEditable(false);
		regularGrade.setEditable(false);
		
		finalGrade.setEditable(false);
		totalGrade.setEditable(false);
		totalCard.setEditable(false);
		experimentalGrade.setEditable(false);
		Panel p1 = new Panel();//创建一个面板
		JLabel jl = new JLabel("查询学生基本信息 ");//创建一个标签“查询学生基本信息”
		jl.setForeground(Color.black);//字体设置为黑色
		jl.setFont(new Font("华文行楷", Font.BOLD, 35));//字体设置为华文行楷，大小为35
		p1.add(jl);//将j1标签加入到p1面板中
		add(p1, "North");//将p1面板加入主面板，设置在北面
		box0 = Box.createHorizontalBox();
		box0.add(new JLabel("输入要查询的学号:"));//创建一个标签
		box0.add(Box.createHorizontalStrut(8));
		box0.add(num);//将文本框加入到box0中
		box0.add(Box.createHorizontalStrut(8));
		box0.add(jb);//将按钮加入到box0中
		box1 = Box.createHorizontalBox();
		box1.add(new JLabel("姓名:     "));//将标签加入到box1中
		box1.add(Box.createHorizontalStrut(8));
		box1.add(name);//将文本框加入box1中
		box2 = Box.createHorizontalBox();
		box2.add(new JLabel("课程号:  "));
		box2.add(Box.createHorizontalStrut(8));
		box2.add(courseId);
		box3 = Box.createHorizontalBox();
		box3.add(new JLabel("课程名     "));
		box3.add(Box.createHorizontalStrut(8));
		box3.add(courseName);
		box4 = Box.createHorizontalBox();
		box4.add(new JLabel("学分     "));
		box4.add(Box.createHorizontalStrut(8));
		box4.add(card);
		box5 = Box.createHorizontalBox();
		box5.add(new JLabel("平时成绩  "));
		box5.add(Box.createHorizontalStrut(8));
		box5.add(regularGrade);
		box6 = Box.createHorizontalBox();
		box6.add(new JLabel("实验成绩  "));
		box6.add(Box.createHorizontalStrut(8));
		box6.add(experimentalGrade);
		box7 = Box.createHorizontalBox();
		box7.add(new JLabel("期末成绩  "));
		box7.add(Box.createHorizontalStrut(8));
		box7.add(finalGrade);
		box8 = Box.createHorizontalBox();
		box8.add(new JLabel("总评成绩  "));
		box8.add(Box.createHorizontalStrut(8));
		box8.add(totalGrade);
		box9 = Box.createHorizontalBox();
		box9.add(new JLabel("实得学分"));
		box9.add(Box.createHorizontalStrut(8));
		box9.add(totalCard);
		/*以上是将组件加入到面板中的操作*/
		

		/*以下是将子面板加入到主面板中的操作*/
		box = Box.createVerticalBox();
		box.add(box0);
		box.add(Box.createVerticalStrut(12));
		box.add(box1);
		box.add(Box.createVerticalStrut(12));
		box.add(box2);
		box.add(Box.createVerticalStrut(12));
		box.add(box3);
		box.add(Box.createVerticalStrut(12));
		box.add(box4);
		box.add(Box.createVerticalStrut(12));
		box.add(box5);
		box.add(Box.createVerticalStrut(12));
		box.add(box6);
		box.add(Box.createVerticalStrut(12));
		box.add(box7);
		box.add(Box.createVerticalStrut(12));
		box.add(box8);
		box.add(Box.createVerticalStrut(12));
		box.add(box9);
		box.add(Box.createVerticalStrut(12));
		Panel pCenter = new Panel();//创建一个面板
		pCenter.add(box);//将box加入到面板中
		add(pCenter, "Center");//设置在主屏幕中间
		setSize(300, 250);//长为300，宽为250
		setBackground(Color.pink);//设置背景色为pink
	}
	public void actionPerformed(ActionEvent e) {//事件监听方法
		int flag = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");//加载驱动器
		} catch (ClassNotFoundException ee) {
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql:///users-info", "root", "wang18121996");//建立与我的数据库的连接
			sql = con.createStatement();//创建书写sql语句的语句
			String num1, name1, courseId1, courseName1; 
			int card1;
			double regularGrade1,experimentalGrade1,finalGrade1,totalGrade1,totalCard1;
			ResultSet rs = sql.executeQuery("SELECT * FROM stud");//查询数据库中的字段
			while (rs.next()) {//依次输出下列内容
				num1 = rs.getString("学号");
				name1 = rs.getString("姓名");
				 courseId1 = rs.getString("课程号");
				 courseName1 = rs.getString("课程名");
				 card1= rs.getInt("学分");
				 regularGrade1 = rs.getDouble("平时成绩");
				 experimentalGrade1 = rs.getDouble("实验成绩");
				 finalGrade1 = rs.getDouble("期末成绩");
				 /*以上程序为使各变量获得数据库中字段的值*/
				 
				 
				 totalGrade1= getTotalGrade(regularGrade1,experimentalGrade1,finalGrade1);//获得三个值
				 totalCard1 = getTotalCard(totalGrade1,card1);//获得两个值
				
				if (num1.equals(num.getText().trim())) {
					name.setText(name1);//将name1的值写入文本框
					courseId.setText(courseId1);
					courseName.setText(courseName1);
					card.setText(String.valueOf(card1));
					regularGrade.setText(String.valueOf(regularGrade1));
					experimentalGrade.setText(String.valueOf(experimentalGrade1));
					finalGrade.setText(String.valueOf(finalGrade1));
					totalGrade.setText(String.valueOf(totalGrade1));
					totalCard.setText(String.valueOf(totalCard1));
					/*以上代码为为各变量写入相应的值*/
					flag = 1;
					break;
				}
			}
			sql.close();
			con.close();
		} catch (SQLException ex) {
		}
		if (flag == 0) {//如果没有对应的值
			JOptionPane.showMessageDialog(null, "没有该学生相关信息!请重新输入！", "学籍管理系统", JOptionPane.ERROR_MESSAGE);//显示相应的信息
			num.setText("");
			name.setText(" ");
			courseId.setText("");
			courseName.setText(" ");
			card.setText(" ");
			regularGrade.setText(" ");
			experimentalGrade.setText(" ");
			totalGrade.setText(" ");
			finalGrade.setText(" ");
			totalCard.setText(" ");
			/*以上代码表示没有相应值时文本框为空*/
		}
	}
	private double getTotalCard(double totalGrade1, int  card2) {//计算综合成绩
		double totalCard1=0;
		if(totalGrade1>=90&&totalGrade1<=100){
			totalCard1=card2*1;
		}else if(totalGrade1>=80&&totalGrade1<90){
			totalCard1=card2*0.8;
		}else if(totalGrade1>=70&&totalGrade1<80){
			totalCard1=card2*0.75;
		}else if(totalGrade1>=60&&totalGrade1<70){
			totalCard1=card2*0.6;
		}else totalCard1=0;
		
		return totalCard1;
	}
	private double getTotalGrade(double regularGrade1, double experimentalGrade1, double finalGrade1){//计算实得学分
		double totalGrade1=0;
		if(experimentalGrade1==-1){
			totalGrade1=regularGrade1*0.3+finalGrade1*0.7;
		}else 
			totalGrade1=regularGrade1*0.15+experimentalGrade1*0.15+finalGrade1*0.7;
		return totalGrade1;
	}

}
