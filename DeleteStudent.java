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

public class DeleteStudent  extends Panel implements ActionListener{//����һ��DeleteStudent�̳�Panel,ʵ��ActionListener�ӿ�
	Connection con;//����һ��Connection���ͱ���
	Statement sql;//����һ��Statement���Ͷ���
	JTextField num;//����һ��JTextField���Ͷ���
	JButton  b1;//����һ��JButton���Ͷ���
	Box box, box0;//��������Box���ͱ���
	ButtonGroup bg;//����һ��ButtonGroup���ͱ���
	
	public DeleteStudent() {
		setLayout(new BorderLayout());
		Font font = new Font("��������", Font.BOLD, 30);//��������Ϊ�������Σ���СΪ30
		UIManager.put("Label.font", font);//����ǩ�������
		b1 = new JButton("ȷ��ɾ��");//����JButton����ȷ��ɾ����
		b1.setForeground(Color.black);//���ð�ť������ɫΪ��ɫ
		b1.setFont(new Font("�����п�", Font.BOLD, 30));//���ð�ť����Ϊ�����п�����СΪ30
		b1.setBackground(Color.white);//���ð�ť����ɫΪ��ɫ
		b1.addActionListener(this);//�����¼�����
		
		num = new JTextField(24);//�����ı����СΪ24
		
		
		Panel pNorth = new Panel();//����һ�����pNorth
		JLabel jl = new JLabel("ɾ��ѧ��������Ϣ ");//����һ����ǩ��ɾ��ѧ����Ϣ��
		jl.setForeground(Color.black);//����Ϊ��ɫ
		jl.setFont(new Font("�����п�", Font.BOLD, 35));//��������Ϊ�����п�����СΪ35
		pNorth.add(jl);//��j1����pNorth���
		add(pNorth, "North");//��pNorth�������
		
		box0 = Box.createHorizontalBox();
		box0.add(new JLabel("����Ҫɾ����ѧ��:"));//����ǩ������Ҫɾ����ѧ�š�����box0�����
		box0.add(Box.createHorizontalStrut(8));
		box0.add(num);//���ı���������
		box0.add(Box.createHorizontalStrut(8));
		box0.add(b1);//����ť�������

		
		
		box = Box.createVerticalBox();
		box.add(box0);//��box0��������box�����
		box.add(Box.createVerticalStrut(12));
		
		
		Panel pCenter = new Panel();//����һ��pCenter���
		pCenter.add(box);//��box�����뵽pCenter�����
		add(pCenter, "Center");//��pCenter�����������
		setBackground(Color.pink);//����屳��ɫ����Ϊpink
	}
	public void actionPerformed(ActionEvent e) {//�����¼���������
		String num1;//����һ���ַ�������
		int flag = 0;//����һ�����ͱ���
		if (e.getSource() == b1) {//����¼�Դ�ǡ�ȷ��ɾ����
			try {
				Class.forName("com.mysql.jdbc.Driver");//������������
			} catch (ClassNotFoundException ee) {
				System.out.println("SQLException:" + ee.getMessage());
			}
			try {
				con = DriverManager.getConnection("jdbc:mysql:///users-info", "root", "wang18121996");//��������
				sql = con.createStatement();//����ִ��sql�������
				ResultSet rs = sql.executeQuery("SELECT * FROM stud ");//��ѯ���ݿ��е��ֶ�
				while (rs.next()) {//��ʾ��һ���ֶ�
					num1 = rs.getString("ѧ��");//���ѧ��
					
					if (num1.equals(num.getText().trim())) {
						String sql2="delete from stud where ѧ��="+"'"+num1+"'";                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
						System.out.println(sql2);
						sql.executeUpdate(sql2);
						System.out.println("ɾ���ɹ���");
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
				JOptionPane.showMessageDialog(null, "���ѧ�Ų�����,����������!", "����!", JOptionPane.YES_NO_OPTION);
				num.setText("");
				
			}
		}
		/*if (e.getSource() == b1) {
			int n = JOptionPane.showConfirmDialog(this, "ȷ��Ҫɾ����ѧ�ż�			ȫ����Ϣ��?", "ѧ������ϵͳ", JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				} catch (ClassNotFoundException ee) {
				}
				try {
					con = DriverManager.getConnection("jdbc:odbc:stud", "", "");
					sql = con.createStatement();
					num1 = "'" + num.getText().trim() + "'";
					String temp = "DELETE FROM stud WHERE ѧ��=" + num1;
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

