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

public class AddStudent extends Panel implements ActionListener{//����һ��addStudent��̳�Panel�࣬ʵ��ActionListener�ӿ�
	Connection con;//����һ��Connection���ͱ���
	Statement sql;//����һ��Statement���ͱ���
	Panel pNorth, pCenter;//��������Panel���ͱ���
	JButton done, readd;//��������JButton���ͱ���
	Box box, box0, box1, box2, box3, box4, box5, box6, box7,box8,box9,box10;//������Box���ͱ���
	JTextField num, name, courseId, courseName, card, regularGrade,experimentalGrade,finalGrade;//������JTextField���ͱ���
	public AddStudent() {
		setLayout(new BorderLayout());//����BorderLayout���Ͳ��ֹ�����
		Font font = new Font("��������", Font.BOLD, 30);//��������Ϊ�������Σ������СΪ22
		UIManager.put("Label.font", font);//����ǩ�������
		num = new JTextField(26);//����JTextField����num���ı����С����Ϊ26
		name = new JTextField(20);//����JTextField����name���ı����С����Ϊ20
		courseId = new JTextField(20);//����JTextField����courseId,�ı����С����Ϊ20
		courseName=new JTextField(20);//����JTextField����courseName���ı����С����Ϊ20
		card=new JTextField(20);//����JTextField����card���ı����С����Ϊ20
		regularGrade=new JTextField(20);//regularGrade�ı����С����Ϊ20
		experimentalGrade=new JTextField(20);//experimentalGrade�ı����С����Ϊ20
		finalGrade=new JTextField(20);//finalGrade�ı����С����Ϊ20
		
		box0 = Box.createHorizontalBox();//Box�������creatHorizontalBox()����
		JLabel jl = new JLabel("            ¼��ѧ��������Ϣ            ");//����һ����ǩj1�������Ϣ��¼��ѧ��������Ϣ��
		jl.setForeground(Color.BLACK);//����������ɫΪ��ɫ
		jl.setFont(new Font("�����п�", Font.BOLD, 35));//��������Ϊ�����п�����СΪ34
		box0.add(jl);//����ǩ����box0�����
		
		box1 = Box.createHorizontalBox();
		box1.add(new JLabel("ѧ��:    "));//����Ϊ��ѧ�š��ı�ǩ����box1�����
		box1.add(Box.createHorizontalStrut(8));
		box1.add(num);//����Ϊnum���ı������box1�����
		box2 = Box.createHorizontalBox();
		box2.add(new JLabel("����:    "));//����Ϊ���������ı�ǩ����box2�����
		box2.add(Box.createHorizontalStrut(8));
		box2.add(name);//����Ϊname���ı������box2�����
		box3 = Box.createHorizontalBox();
		box3.add(new JLabel("�γ̺�: "));//����Ϊ���γ̺š��ı�ǩ����box3�����
		box3.add(Box.createHorizontalStrut(8));
		box3.add(courseId);//��courseId�ı������box3���
		box4 = Box.createHorizontalBox();
		box4.add(new JLabel("�γ���  "));//�����γ�������ǩ����box4���
		box4.add(Box.createHorizontalStrut(8));
		box4.add(courseName);//��courseName�ı������box4�����
		box5 = Box.createHorizontalBox();
		box5.add(new JLabel("ѧ��     "));//����ѧ�֡���ǩ����box5���
		box5.add(Box.createHorizontalStrut(8));
		box5.add(card);//��card�ı������box5
		box6 = Box.createHorizontalBox();
		box6.add(new JLabel("ƽʱ�ɼ�"));//����ƽʱ�ɼ�����ǩ����box6
		box6.add(Box.createHorizontalStrut(8));
		box6.add(regularGrade);//��regularGrade�ı������box6
		
		box7 = Box.createHorizontalBox();
		box7.add(new JLabel("ʵ��ɼ�"));//����ʵ��ɼ�����ǩ����box7
		box7.add(Box.createHorizontalStrut(8));
		box7.add(experimentalGrade);//��experimentalGrade�ı������box7
		
		box8 = Box.createHorizontalBox();
		box8.add(new JLabel("��ĩ�ɼ�"));//������ĩ�ɼ�����ǩ����box8
		box8.add(Box.createHorizontalStrut(8));
		box8.add(finalGrade);//��finalGrade�ı������box8
		
		
		done = new JButton("¼��");//������¼�롱��ťdone
		done.setFont(new Font("�����п�", Font.BOLD, 30));//��������Ϊ�����п�����СΪ22
		done.setForeground(Color.black);//��������ɫΪ��ɫ
		done.setBackground(Color.white);//���ñ���ɫΪ��ɫ
		done.addActionListener(this);//����ť�����¼�����
		box9 = Box.createHorizontalBox();
		box9.add(done);//����ť����box9���
		box9.add(Box.createHorizontalStrut(8));
		readd = new JButton("����");//���������á���ť
		readd.setFont(new Font("�����п�", Font.BOLD, 30));//��������Ϊ�����п�����СΪ22
		readd.setForeground(Color.black);//����������ɫΪ��ɫ
		readd.setBackground(Color.white);//���ñ�����ɫΪ��ɫ
		readd.addActionListener(this);//����ť�����¼�����
		box10 = Box.createHorizontalBox();
		box10.add(readd);//����ť����box10
		
		box = Box.createVerticalBox();
		box.add(box0);//��box0������box���
		box.add(Box.createVerticalStrut(12));//��϶����Ϊ12
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
		
		
		pCenter = new Panel();//����һ��pCenter���
		pCenter.add(box);//��box������pCenter�����
		add(pCenter, "Center");//��pCenter���벢����������м�
		setBackground(Color.pink);//���ñ���ɫΪ�ۺ�ɫ
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {//�����¼���������
		String num0, num1, name1, courseId1, courseName1;//�����ĸ��ַ�������
		String card1;//����һ���ַ�������
		String regularGrade1;//����һ���ַ�������
		String experimentalGrade1;//����һ���ַ�������
		String finalGrade1;//����һ���ַ�������
		int out = 1;//����һ�����ͱ���
		if (e.getSource() == done) {//ʹ���¼���getSource()��������¼�Դ��ȷ�������¼��İ�ť�����������¼�롱��ť
			name1 = name.getText();//Ϊ�����������ı�
			if (name1.equals("")) {
				JOptionPane.showMessageDialog(this, "�Բ���,��������Ϊ��!");
			}
			else {
				try {
					Class.forName("com.mysql.jdbc.Driver");//�������ݿ���������
				} catch (java.lang.ClassNotFoundException ee) {
				}
				try {
					con = DriverManager.getConnection("jdbc:mysql:///users-info", "root", "wang18121996");//��������
					sql = con.createStatement();//����ִ��sql�������
					ResultSet rs = null;//���Ϊ��
					boolean Abook;//����һ��boolean���͵ı���
					rs = sql.executeQuery("select * from stud");//�������ݿ��е���䣬��ѯ���ݿ��е��ֶ�
					while (rs.next()) {//������ʾ��Ϣ
						num1 = rs.getString("ѧ��");//�����ݿ��е�ѧ�Ÿ�ֵ��num1
						if (num1.equals(num.getText().trim())) {
							num.setText("");
							JOptionPane.showMessageDialog(this, "�Բ���,��ѧ							���Ѵ���!", "ѧ������ϵͳ",
							JOptionPane.ERROR_MESSAGE);//���ò����ظ�����ѧ��
							out = 0;
							break;
						}
					}
					con.close();
					sql.close();
				} catch (SQLException r) {
				}
				try{
					Class.forName("com.mysql.jdbc.Driver");//������������
				} catch (java.lang.ClassNotFoundException ee) {
				}
				try {
					con = DriverManager.getConnection("jdbc:mysql:///users-info", "root", "wang18121996");//��������
					sql = con.createStatement();//����ִ��sql�������
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
					sql.executeUpdate(temp);//�������ݿ��е����
					sql.close();
					con.close();
				} catch (SQLException err) {
					JOptionPane.showMessageDialog(this, "��Ϣ¼�����,������¼��!", "ѧ������ϵͳ",
					JOptionPane.ERROR_MESSAGE);//��ʾ��Ϣ�����ǵĴ���ʽ
					out = 0;
				}
				if (out == 1) {
					JOptionPane.showMessageDialog(this, "¼��ɹ�!", 
					"ѧ������ϵͳ",
							JOptionPane.INFORMATION_MESSAGE);//��ʾ��Ϣ��ȷʱ�Ĵ���ʽ
					num.setText("");//��num�������ı���Ϣ
					name.setText(" ");//��name�������ı���Ϣ
					courseId.setText("");
					courseName.setText(" ");
					card.setText(" ");
					regularGrade.setText(" ");
					experimentalGrade.setText(" ");
					
					finalGrade.setText(" ");
					
				}
			}
		}
		if (e.getSource() == readd) {//������������á���ť
			num.setText("");//��������numֵ
			name.setText(" ");//��������nameֵ
			courseId.setText("");//��������courseIdֵ
			courseName.setText(" ");
			card.setText(" ");
			regularGrade.setText(" ");
			experimentalGrade.setText(" ");
		
			finalGrade.setText(" ");
			
		}
	}
	

}
