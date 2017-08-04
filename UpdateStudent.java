package cn.update;

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

public class UpdateStudent extends Panel implements ActionListener {//定义一个updateStudent类，继承panel类，实现ActionListener接口
	Connection con;
	Statement sql;
	JButton b1, b2, b3;
	Box box, box0, box1, box2, box3, box4, box5, box6;
	JTextField num, regularGrade, experimentalGrade, finalGrade;
	public UpdateStudent() {
		setLayout(new BorderLayout());//建立一个BorderLayout布局管理器
		Font font = new Font("华文中宋", Font.BOLD, 30);//设置字体为华文中宋，大小为30
		UIManager.put("Label.font", font);//加入界面管理器
		b1 = new JButton("开始修改");//创建按钮“开始修改”
		b1.setFont(new Font("华文行楷", Font.BOLD, 30));//设置字体为华文行楷，大小30
		b1.setBackground(Color.white);//按钮背景色为白色
		b1.setForeground(Color.black);//按钮字体颜色为黑色
		b2 = new JButton("录入修改");//创建按钮“录入修改”
		b2.setFont(new Font("华文行楷", Font.BOLD, 30));//字体为华文行楷，大小为30
		b2.setBackground(Color.white);//背景白色
		b2.setForeground(Color.black);//字体黑色
		b3 = new JButton("重置");//创建按钮“重置”
		b3.setFont(new Font("华文行楷", Font.BOLD, 30));//字体为华文行楷，大小为30
		b3.setForeground(Color.black);//字体黑色
		b3.setBackground(Color.white);//背景白色
		b1.addActionListener(this);//加入事件监听
		b2.addActionListener(this);//加入事件监听
		b3.addActionListener(this);//加入事件监听
		num = new JTextField(18);//创建文本框，大小18
		regularGrade= new JTextField(20);//创建文本框，大小20
		experimentalGrade = new JTextField(20);//创建文本框，大小20
		finalGrade = new JTextField(20);//创建文本框，大小20
		
		Panel pNorth = new Panel();//创建面板
		JLabel jl = new JLabel("修改学生成绩信息 ");//创建标签“修改学生信息”
		jl.setForeground(Color.black);//设置字体为黑色
		jl.setFont(new Font("华文行楷", Font.BOLD, 35));//设置字体为华文行楷，大小35
		pNorth.add(jl);//将标签加入面板
		add(pNorth, "North");//将面板加入主面板，设置在北方
		/*以下代码为将标签加入不同子面板，将不同子面板加入主面板*/
		box0 = Box.createHorizontalBox();
		box0.add(new JLabel("输入要修改信息的学号:"));
		box0.add(Box.createHorizontalStrut(8));
		box0.add(num);
		box0.add(Box.createHorizontalStrut(8));
		box0.add(b1);
		
		
		box1 = Box.createHorizontalBox();
		box1.add(new JLabel("(新)平时成绩:"));
		box1.add(Box.createHorizontalStrut(8));
		box1.add(regularGrade);
		box2 = Box.createHorizontalBox();
		box2.add(new JLabel("(新)实验成绩:"));
		box2.add(Box.createHorizontalStrut(8));
		box2.add(experimentalGrade);
		box3 = Box.createHorizontalBox();
		box3.add(new JLabel("(新)期末成绩:"));
		box3.add(Box.createHorizontalStrut(8));
		box3.add(finalGrade);
		
		box4 = Box.createHorizontalBox();
		box4.add(b2);
		box4.add(Box.createHorizontalStrut(8));
		box4.add(b3);
		
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
	
		
		Panel pCenter = new Panel();//创建一个面板
		pCenter.add(box);//将box面板加入主面板
		add(pCenter, "Center");//加入框架，放置在中间
		setBackground(Color.pink);//设置面板颜色为pink
	}
	public void actionPerformed(ActionEvent e) {//事件监听方法
		String num1,regularGrade1, experimentalGrade1, finalGrade1;
		int flag = 0;
		if (e.getSource() == b1) {//如果点击“开始修改”
			try {
				Class.forName("com.mysql.jdbc.Driver");//加载驱动
			} catch (ClassNotFoundException ce) {
				System.out.println("SQLException:" + ce.getMessage());
			}
			try {
				con = DriverManager.getConnection("jdbc:mysql:///users-info", "root", "wang18121996");//建立连接
				sql = con.createStatement();//创建书写sql语句的语句
				String sql2="select* from stud";//查询字段
				System.out.println(sql2);
				ResultSet rs = sql.executeQuery(sql2);
				while (rs.next()) {//依次显示以下内容
					num1 = rs.getString("学号");
					regularGrade1 = rs.getString("平时成绩");
					experimentalGrade1= rs.getString("实验成绩");
					finalGrade1 = rs.getString("期末成绩");
					
					if (num1.equals(num.getText().trim())) {
						
						regularGrade.setText(regularGrade1);
						experimentalGrade.setText(experimentalGrade1);
						finalGrade.setText(finalGrade1);
						
						flag = 1;
						break;
					}
				}
				sql.close();
				rs.close();
				con.close();
			} catch (SQLException ee) {
			}
			if (flag == 0) {//如果没有相应学生
				JOptionPane.showMessageDialog(null, "没有该学生相关信息!请重新输入！","学籍管理系统", JOptionPane.ERROR_MESSAGE);//输出没有此学生的信息
				regularGrade.setText("");
				
				experimentalGrade.setText("");
				finalGrade.setText("");
				/*以上代码表示文本框为空*/
				
			}
		}
		if (e.getSource() == b2) {//如果点击“录入修改”，则进行相应修改
			num1 = num.getText().trim();
			regularGrade1 = "'" + regularGrade.getText().trim() + "'";
			experimentalGrade1 = "'" + experimentalGrade.getText().trim() + "'";
			
			finalGrade1 = "'" + finalGrade.getText().trim() + "'";
			
			try {
				Class.forName("com.mysql.jdbc.Driver");//加载驱动
			} catch (ClassNotFoundException ee) {
			}
			try {
				con = DriverManager.getConnection("jdbc:mysql:///users-info", "root", "wang18121996");//建立连接
				sql = con.createStatement();//创建书写sql语句的语句
				String temp = "update stud set 平时成绩=" +regularGrade1  + ","
						+ "实验成绩=" + experimentalGrade1 + ","
						+ "卷面成绩=" + finalGrade1 + " where 学号="+ "'" + num1 + "'";
				System.out.println(temp);
				sql.executeUpdate(temp);
				sql.close();
				con.close();
				JOptionPane.showMessageDialog(this, "修改成功!", "学籍管理系统", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException ex) {
				System.out.println(ex);
			}
		}
		if (e.getSource() == b3) {//如果点击重置，则进行重置
			num.setText("");
			regularGrade.setText(" ");
			experimentalGrade.setText("");
			finalGrade.setText(" ");
		
		}
	}
}

