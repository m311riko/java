package cn.add;

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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class AddStudent extends Panel implements ActionListener{//定义一个addStudent类继承Panel类，实现ActionListener接口
	Connection con;//定义一个Connection类型变量
	Statement sql;//定义一个Statement类型变量
	Panel pNorth, pCenter;//定义两个Panel类型变量
	JButton done, readd;//定义两个JButton类型变量
	Box box, box0, box1, box2, box3, box4, box5, box6, box7,box8,box9,box10;//定义多个Box类型变量
	JTextField num, name, courseId, courseName, card, regularGrade,experimentalGrade,finalGrade;//定义多个JTextField类型变量
	public AddStudent() {
		setLayout(new BorderLayout());//设置BorderLayout类型布局管理器
		Font font = new Font("华文中宋", Font.BOLD, 30);//设置字体为华文中宋，字体大小为22
		UIManager.put("Label.font", font);//将标签加入面板
		num = new JTextField(26);//创建JTextField对象num，文本框大小设置为26
		name = new JTextField(20);//创建JTextField对象name，文本框大小设置为20
		courseId = new JTextField(20);//创建JTextField对象courseId,文本框大小设置为20
		courseName=new JTextField(20);//创建JTextField对象courseName，文本框大小设置为20
		card=new JTextField(20);//创建JTextField对象card，文本框大小设置为20
		regularGrade=new JTextField(20);//regularGrade文本框大小设置为20
		experimentalGrade=new JTextField(20);//experimentalGrade文本框大小设置为20
		finalGrade=new JTextField(20);//finalGrade文本框大小设置为20
		
		box0 = Box.createHorizontalBox();//Box对象调用creatHorizontalBox()方法
		JLabel jl = new JLabel("            录入学生基本信息            ");//创建一个标签j1，添加信息“录入学生基本信息”
		jl.setForeground(Color.BLACK);//设置字体颜色为黑色
		jl.setFont(new Font("华文行楷", Font.BOLD, 35));//设置字体为华文行楷，大小为34
		box0.add(jl);//将标签加入box0面板中
		
		box1 = Box.createHorizontalBox();
		box1.add(new JLabel("学号:    "));//将名为“学号”的标签加入box1面板中
		box1.add(Box.createHorizontalStrut(8));
		box1.add(num);//将名为num的文本框加入box1面板中
		box2 = Box.createHorizontalBox();
		box2.add(new JLabel("姓名:    "));//将名为“姓名”的标签加入box2面板中
		box2.add(Box.createHorizontalStrut(8));
		box2.add(name);//将名为name的文本框加入box2面板中
		box3 = Box.createHorizontalBox();
		box3.add(new JLabel("课程号: "));//将名为“课程号”的标签加入box3面板中
		box3.add(Box.createHorizontalStrut(8));
		box3.add(courseId);//将courseId文本框加入box3面板
		box4 = Box.createHorizontalBox();
		box4.add(new JLabel("课程名  "));//将“课程名”标签加入box4面板
		box4.add(Box.createHorizontalStrut(8));
		box4.add(courseName);//将courseName文本框加入box4面板中
		box5 = Box.createHorizontalBox();
		box5.add(new JLabel("学分     "));//将“学分”标签加入box5面板
		box5.add(Box.createHorizontalStrut(8));
		box5.add(card);//将card文本框加入box5
		box6 = Box.createHorizontalBox();
		box6.add(new JLabel("平时成绩"));//将“平时成绩”标签加入box6
		box6.add(Box.createHorizontalStrut(8));
		box6.add(regularGrade);//将regularGrade文本框加入box6
		
		box7 = Box.createHorizontalBox();
		box7.add(new JLabel("实验成绩"));//将“实验成绩”标签加入box7
		box7.add(Box.createHorizontalStrut(8));
		box7.add(experimentalGrade);//将experimentalGrade文本框加入box7
		
		box8 = Box.createHorizontalBox();
		box8.add(new JLabel("期末成绩"));//将“期末成绩”标签加入box8
		box8.add(Box.createHorizontalStrut(8));
		box8.add(finalGrade);//将finalGrade文本框加入box8
		
		
		done = new JButton("录入");//创建“录入”按钮done
		done.setFont(new Font("华文行楷", Font.BOLD, 30));//设置字体为华文行楷，大小为22
		done.setForeground(Color.black);//设置字体色为黑色
		done.setBackground(Color.white);//设置背景色为白色
		done.addActionListener(this);//将按钮加入事件监听
		box9 = Box.createHorizontalBox();
		box9.add(done);//将按钮加入box9面板
		box9.add(Box.createHorizontalStrut(8));
		readd = new JButton("重置");//创建“重置”按钮
		readd.setFont(new Font("华文行楷", Font.BOLD, 30));//设置字体为华文行楷，大小为22
		readd.setForeground(Color.black);//设置字体颜色为红色
		readd.setBackground(Color.white);//设置背景颜色为白色
		readd.addActionListener(this);//将按钮加入事件监听
		box10 = Box.createHorizontalBox();
		box10.add(readd);//将按钮加入box10
		
		box = Box.createVerticalBox();
		box.add(box0);//将box0面板加入box面板
		box.add(Box.createVerticalStrut(12));//间隙设置为12
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
		box.add(box10);
		
		
		pCenter = new Panel();//创建一个pCenter面板
		pCenter.add(box);//将box面板加入pCenter面板中
		add(pCenter, "Center");//将pCenter加入并放置在面板中间
		setBackground(Color.pink);//设置背景色为粉红色
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {//设置事件监听方法
		String num0, num1, name1, courseId1, courseName1;//定义四个字符串变量
		String card1;//定义一个字符串变量
		String regularGrade1;//定义一个字符串变量
		String experimentalGrade1;//定义一个字符串变量
		String finalGrade1;//定义一个字符串变量
		int out = 1;//定义一个整型变量
		if (e.getSource() == done) {//使用事件的getSource()方法检查事件源，确定触发事件的按钮，如果触发“录入”按钮
			name1 = name.getText();//为姓名框输入文本
			if (name1.equals("")) {
				JOptionPane.showMessageDialog(this, "对不起,姓名不能为空!");
			}
			else {
				try {
					Class.forName("com.mysql.jdbc.Driver");//加载数据库驱动程序
				} catch (java.lang.ClassNotFoundException ee) {
				}
				try {
					con = DriverManager.getConnection("jdbc:mysql:///users-info", "root", "wang18121996");//建立连接
					sql = con.createStatement();//创建执行sql语句的语句
					ResultSet rs = null;//结果为空
					boolean Abook;//定义一个boolean类型的变量
					rs = sql.executeQuery("select * from stud");//处理数据库中的语句，查询数据库中的字段
					while (rs.next()) {//依次显示信息
						num1 = rs.getString("学号");//将数据库中的学号赋值给num1
						if (num1.equals(num.getText().trim())) {
							num.setText("");
							JOptionPane.showMessageDialog(this, "对不起,该学							号已存在!", "学籍管理系统",
							JOptionPane.ERROR_MESSAGE);//设置不能重复设置学号
							out = 0;
							break;
						}
					}
					con.close();
					sql.close();
				} catch (SQLException r) {
				}
				try{
					Class.forName("com.mysql.jdbc.Driver");//加载驱动程序
				} catch (java.lang.ClassNotFoundException ee) {
				}
				try {
					con = DriverManager.getConnection("jdbc:mysql:///users-info", "root", "wang18121996");//建立连接
					sql = con.createStatement();//创建执行sql语句的语句
					num1 = "'" + num.getText().trim() + "'";
					name1 = name.getText().trim();
					card1="'" +card.getText().trim()+ "'";
					courseId1 ="'"+courseId.getText().trim()+"'";
					courseName1 = "'" + courseName.getText().trim() + "'";
					regularGrade1 = "'"+regularGrade.getText().trim()+"'";
					experimentalGrade1 = "'" + experimentalGrade.getText().trim() + "'";
					finalGrade1="'" +finalGrade.getText().trim() + "'";
					String temp = "insert into stud values (" + num1 + ","
							+ "'" + name1 + "'" + "," + courseId1 + ","
							+ courseName1 + "," + card1 + "," + regularGrade1 +"," + experimentalGrade1+","+finalGrade1+")";
					System.out.println(temp);
					sql.executeUpdate(temp);//处理数据库中的语句
					sql.close();
					con.close();
				} catch (SQLException err) {
					JOptionPane.showMessageDialog(this, "信息录入错误,请重新录入!", "学籍管理系统",
					JOptionPane.ERROR_MESSAGE);//显示信息错误是的处理方式
					out = 0;
				}
				if (out == 1) {
					JOptionPane.showMessageDialog(this, "录入成功!", 
					"学籍管理系统",
							JOptionPane.INFORMATION_MESSAGE);//显示信息正确时的处理方式
					num.setText("");//在num框输入文本信息
					name.setText(" ");//在name框输入文本信息
					courseId.setText("");
					courseName.setText(" ");
					card.setText(" ");
					regularGrade.setText(" ");
					experimentalGrade.setText(" ");
					
					finalGrade.setText(" ");
					
				}
			}
		}
		if (e.getSource() == readd) {//如果触发“重置”按钮
			num.setText("");//重新输入num值
			name.setText(" ");//重新输入name值
			courseId.setText("");//重新输入courseId值
			courseName.setText(" ");
			card.setText(" ");
			regularGrade.setText(" ");
			experimentalGrade.setText(" ");
		
			finalGrade.setText(" ");
			
		}
	}
	

}
