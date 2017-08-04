package cn.test;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import cn.frame.StuFrame;

public class Test {
	public static void main(String[] args) {
		String url = "jdbc:mysql:///users-info";//指定databaseURL（定位数据库的主机名和数据库名称）
		
		try {
			Class.forName("com.mysql.jdbc.Driver");//加载驱动程序
			
		} catch (java.lang.ClassNotFoundException e) {
		}
		try {
			System.out.println("准备连接数据库");
			Connection con = DriverManager.getConnection(url, "root", "wang18121996");//建立连接
			System.out.println("数据库连接成功");
		
			System.out.println("student table created ");
			
			con.close();
		} catch (SQLException exe) {
		}
		StuFrame fra = new StuFrame();//创建一个stuFrame类的对象
		fra.setBounds(300, 80, 500, 400);//框架边界长度分别设定为300，80，500，400
		fra.setVisible(true);//设置true显示框架
		/* 窗口事件处理 */
		fra.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

}
