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

public class UpdateStudent extends Panel implements ActionListener {//����һ��updateStudent�࣬�̳�panel�࣬ʵ��ActionListener�ӿ�
	Connection con;
	Statement sql;
	JButton b1, b2, b3;
	Box box, box0, box1, box2, box3, box4, box5, box6;
	JTextField num, regularGrade, experimentalGrade, finalGrade;
	public UpdateStudent() {
		setLayout(new BorderLayout());//����һ��BorderLayout���ֹ�����
		Font font = new Font("��������", Font.BOLD, 30);//��������Ϊ�������Σ���СΪ30
		UIManager.put("Label.font", font);//������������
		b1 = new JButton("��ʼ�޸�");//������ť����ʼ�޸ġ�
		b1.setFont(new Font("�����п�", Font.BOLD, 30));//��������Ϊ�����п�����С30
		b1.setBackground(Color.white);//��ť����ɫΪ��ɫ
		b1.setForeground(Color.black);//��ť������ɫΪ��ɫ
		b2 = new JButton("¼���޸�");//������ť��¼���޸ġ�
		b2.setFont(new Font("�����п�", Font.BOLD, 30));//����Ϊ�����п�����СΪ30
		b2.setBackground(Color.white);//������ɫ
		b2.setForeground(Color.black);//�����ɫ
		b3 = new JButton("����");//������ť�����á�
		b3.setFont(new Font("�����п�", Font.BOLD, 30));//����Ϊ�����п�����СΪ30
		b3.setForeground(Color.black);//�����ɫ
		b3.setBackground(Color.white);//������ɫ
		b1.addActionListener(this);//�����¼�����
		b2.addActionListener(this);//�����¼�����
		b3.addActionListener(this);//�����¼�����
		num = new JTextField(18);//�����ı��򣬴�С18
		regularGrade= new JTextField(20);//�����ı��򣬴�С20
		experimentalGrade = new JTextField(20);//�����ı��򣬴�С20
		finalGrade = new JTextField(20);//�����ı��򣬴�С20
		
		Panel pNorth = new Panel();//�������
		JLabel jl = new JLabel("�޸�ѧ���ɼ���Ϣ ");//������ǩ���޸�ѧ����Ϣ��
		jl.setForeground(Color.black);//��������Ϊ��ɫ
		jl.setFont(new Font("�����п�", Font.BOLD, 35));//��������Ϊ�����п�����С35
		pNorth.add(jl);//����ǩ�������
		add(pNorth, "North");//������������壬�����ڱ���
		/*���´���Ϊ����ǩ���벻ͬ����壬����ͬ�������������*/
		box0 = Box.createHorizontalBox();
		box0.add(new JLabel("����Ҫ�޸���Ϣ��ѧ��:"));
		box0.add(Box.createHorizontalStrut(8));
		box0.add(num);
		box0.add(Box.createHorizontalStrut(8));
		box0.add(b1);
		
		
		box1 = Box.createHorizontalBox();
		box1.add(new JLabel("(��)ƽʱ�ɼ�:"));
		box1.add(Box.createHorizontalStrut(8));
		box1.add(regularGrade);
		box2 = Box.createHorizontalBox();
		box2.add(new JLabel("(��)ʵ��ɼ�:"));
		box2.add(Box.createHorizontalStrut(8));
		box2.add(experimentalGrade);
		box3 = Box.createHorizontalBox();
		box3.add(new JLabel("(��)��ĩ�ɼ�:"));
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
	
		
		Panel pCenter = new Panel();//����һ�����
		pCenter.add(box);//��box�����������
		add(pCenter, "Center");//�����ܣ��������м�
		setBackground(Color.pink);//���������ɫΪpink
	}
	public void actionPerformed(ActionEvent e) {//�¼���������
		String num1,regularGrade1, experimentalGrade1, finalGrade1;
		int flag = 0;
		if (e.getSource() == b1) {//����������ʼ�޸ġ�
			try {
				Class.forName("com.mysql.jdbc.Driver");//��������
			} catch (ClassNotFoundException ce) {
				System.out.println("SQLException:" + ce.getMessage());
			}
			try {
				con = DriverManager.getConnection("jdbc:mysql:///users-info", "root", "wang18121996");//��������
				sql = con.createStatement();//������дsql�������
				String sql2="select* from stud";//��ѯ�ֶ�
				System.out.println(sql2);
				ResultSet rs = sql.executeQuery(sql2);
				while (rs.next()) {//������ʾ��������
					num1 = rs.getString("ѧ��");
					regularGrade1 = rs.getString("ƽʱ�ɼ�");
					experimentalGrade1= rs.getString("ʵ��ɼ�");
					finalGrade1 = rs.getString("��ĩ�ɼ�");
					
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
			if (flag == 0) {//���û����Ӧѧ��
				JOptionPane.showMessageDialog(null, "û�и�ѧ�������Ϣ!���������룡","ѧ������ϵͳ", JOptionPane.ERROR_MESSAGE);//���û�д�ѧ������Ϣ
				regularGrade.setText("");
				
				experimentalGrade.setText("");
				finalGrade.setText("");
				/*���ϴ����ʾ�ı���Ϊ��*/
				
			}
		}
		if (e.getSource() == b2) {//��������¼���޸ġ����������Ӧ�޸�
			num1 = num.getText().trim();
			regularGrade1 = "'" + regularGrade.getText().trim() + "'";
			experimentalGrade1 = "'" + experimentalGrade.getText().trim() + "'";
			
			finalGrade1 = "'" + finalGrade.getText().trim() + "'";
			
			try {
				Class.forName("com.mysql.jdbc.Driver");//��������
			} catch (ClassNotFoundException ee) {
			}
			try {
				con = DriverManager.getConnection("jdbc:mysql:///users-info", "root", "wang18121996");//��������
				sql = con.createStatement();//������дsql�������
				String temp = "update stud set ƽʱ�ɼ�=" +regularGrade1  + ","
						+ "ʵ��ɼ�=" + experimentalGrade1 + ","
						+ "����ɼ�=" + finalGrade1 + " where ѧ��="+ "'" + num1 + "'";
				System.out.println(temp);
				sql.executeUpdate(temp);
				sql.close();
				con.close();
				JOptionPane.showMessageDialog(this, "�޸ĳɹ�!", "ѧ������ϵͳ", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException ex) {
				System.out.println(ex);
			}
		}
		if (e.getSource() == b3) {//���������ã����������
			num.setText("");
			regularGrade.setText(" ");
			experimentalGrade.setText("");
			finalGrade.setText(" ");
		
		}
	}
}

