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
		String url = "jdbc:mysql:///users-info";//ָ��databaseURL����λ���ݿ�������������ݿ����ƣ�
		
		try {
			Class.forName("com.mysql.jdbc.Driver");//������������
			
		} catch (java.lang.ClassNotFoundException e) {
		}
		try {
			System.out.println("׼���������ݿ�");
			Connection con = DriverManager.getConnection(url, "root", "wang18121996");//��������
			System.out.println("���ݿ����ӳɹ�");
		
			System.out.println("student table created ");
			
			con.close();
		} catch (SQLException exe) {
		}
		StuFrame fra = new StuFrame();//����һ��stuFrame��Ķ���
		fra.setBounds(300, 80, 500, 400);//��ܱ߽糤�ȷֱ��趨Ϊ300��80��500��400
		fra.setVisible(true);//����true��ʾ���
		/* �����¼����� */
		fra.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

}
