package cn.delete;

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

public class DeleteStudent  extends Panel implements ActionListener{//定义一个DeleteStudent继承Panel,实现ActionListener接口
	Connection con;//定义一个Connection类型变量
	Statement sql;//定义一个Statement类型对象
	JTextField num;//定义一个JTextField类型对象
	JButton  b1;//定义一个JButton类型对象
	Box box, box0;//定义两个Box类型变量
	ButtonGroup bg;//定义一个ButtonGroup类型变量
	
	public DeleteStudent() {
		setLayout(new BorderLayout());
		Font font = new Font("华文中宋", Font.BOLD, 30);//设置字体为华文中宋，大小为30
		UIManager.put("Label.font", font);//将标签放入面板
		b1 = new JButton("确定删除");//创建JButton对象“确定删除”
		b1.setForeground(Color.black);//设置按钮字体颜色为黑色
		b1.setFont(new Font("华文行楷", Font.BOLD, 30));//设置按钮字体为华文行楷，大小为30
		b1.setBackground(Color.white);//设置按钮背景色为白色
		b1.addActionListener(this);//加入事件监听
		
		num = new JTextField(24);//建立文本框大小为24
		
		
		Panel pNorth = new Panel();//定义一个面板pNorth
		JLabel jl = new JLabel("删除学生基本信息 ");//定义一个标签“删除学生信息”
		jl.setForeground(Color.black);//字体为黑色
		jl.setFont(new Font("华文行楷", Font.BOLD, 35));//设置字体为华文行楷，大小为35
		pNorth.add(jl);//将j1加入pNorth面板
		add(pNorth, "North");//将pNorth加入面板
		
		box0 = Box.createHorizontalBox();
		box0.add(new JLabel("输入要删除的学号:"));//将标签“输入要删除的学号”加入box0面板中
		box0.add(Box.createHorizontalStrut(8));
		box0.add(num);//将文本框加入面板
		box0.add(Box.createHorizontalStrut(8));
		box0.add(b1);//将按钮加入面板

		
		
		box = Box.createVerticalBox();
		box.add(box0);//将box0子面板加入box面板中
		box.add(Box.createVerticalStrut(12));
		
		
		Panel pCenter = new Panel();//创建一个pCenter面板
		pCenter.add(box);//将box面板加入到pCenter面板中
		add(pCenter, "Center");//将pCenter面板加入总面板
		setBackground(Color.pink);//将面板背景色设置为pink
	}
	public void actionPerformed(ActionEvent e) {//定义事件监听方法
		String num1;//定义一个字符串变量
		int flag = 0;//定义一个整型变量
		if (e.getSource() == b1) {//如果事件源是“确定删除”
			try {
				Class.forName("com.mysql.jdbc.Driver");//设置驱动程序
			} catch (ClassNotFoundException ee) {
				System.out.println("SQLException:" + ee.getMessage());
			}
			try {
				con = DriverManager.getConnection("jdbc:mysql:///users-info", "root", "wang18121996");//建立连接
				sql = con.createStatement();//创建执行sql语句的语句
				ResultSet rs = sql.executeQuery("SELECT * FROM stud ");//查询数据库中的字段
				while (rs.next()) {//显示下一个字段
					num1 = rs.getString("学号");//获得学号
					
					if (num1.equals(num.getText().trim())) {
						String sql2="delete from stud where 学号="+"'"+num1+"'";                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
						System.out.println(sql2);
						sql.executeUpdate(sql2);
						System.out.println("删除成功！");
						flag = 1;
						break;
					}
				}
				sql.close();
				con.close();
			} catch (SQLException ex) {
				System.out.println("SQLException:" + ex.getMessage());
			}
			if (flag == 0) {
				JOptionPane.showMessageDialog(null, "这个学号不存在,请重新输入!", "错误!", JOptionPane.YES_NO_OPTION);
				num.setText("");
				
			}
		}
		/*if (e.getSource() == b1) {
			int n = JOptionPane.showConfirmDialog(this, "确定要删除该学号及			全部信息吗?", "学籍管理系统", JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				} catch (ClassNotFoundException ee) {
				}
				try {
					con = DriverManager.getConnection("jdbc:odbc:stud", "", "");
					sql = con.createStatement();
					num1 = "'" + num.getText().trim() + "'";
					String temp = "DELETE FROM stud WHERE 学号=" + num1;
					sql.executeUpdate(temp);
					num.setText("");
					name.setText(" ");
					sex.setText("");
					cla.setText(" ");
					professional.setText(" ");
					birth.setText(" ");
					sql.close();
					con.close();
				} catch (SQLException ex) {
				}
			} else if (n == JOptionPane.NO_OPTION) {
			}
		}*/

	}
}

