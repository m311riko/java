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

public class QueryStudent extends Panel implements ActionListener {//����һ��QueryStudent�࣬�̳�Panel�࣬ʵ��ActionListener�ӿ�
	Connection con;//����һ��Connection����
	Statement sql;//����һ��Sql����
	ButtonGroup bg;//����һ��ButtonGroup����
	JRadioButton male, female;//��������JRadioButton����
	JTextField num, name, courseId, courseName, card,regularGrade,experimentalGrade,finalGrade,totalGrade,totalCard;//������JTextField����
	JButton jb;//����һ��JButton����
	Box box, box0, box1, box2, box3, box4, box5, box6,box7,box8,box9;//������Box����
	int flag = 0;//����һ�����ͱ���
	public QueryStudent() {
		Font font = new Font("��������", Font.BOLD, 30);//�����������Ϊ�������Σ���СΪ30
		UIManager.put("Label.font", font);//���������������
		setLayout(new BorderLayout());//����һ��BorderLayout���ֹ�����
		jb = new JButton("��ѯ");//����һ������ѯ����ť
		jb.setBackground(Color.white);//���ð�ť����ɫΪ��ɫ
		jb.setFont(new Font("�����п�", Font.BOLD, 22));//���ð�ť����Ϊ�����п�����СΪ22
		jb.setForeground(Color.black);//����������ɫΪ��ɫ
		jb.addActionListener(this);//�����¼�����
		num = new JTextField(26);//�����ı�����󣬴�СΪ26
		name = new JTextField(20);//�����ı�����󣬴�СΪ20
		courseId = new JTextField(20);//�����ı�����󣬴�СΪ20
		courseName=new JTextField(20);//�����ı�����󣬴�СΪ20
		card=new JTextField(20);//�����ı�����󣬴�СΪ20
		regularGrade=new JTextField(20);//�����ı�����󣬴�СΪ20
		
		finalGrade=new JTextField(20);//�����ı�����󣬴�СΪ20
		totalGrade=new JTextField(20);//�����ı�����󣬴�СΪ20
		totalCard=new JTextField(20);//�����ı�����󣬴�СΪ20
		experimentalGrade=new JTextField(20);//�����ı�����󣬴�СΪ20
		
		/* ������������ֵ���ɱ༭ */
		name.setEditable(false);
		courseId.setEditable(false);
		courseName.setEditable(false);
		card.setEditable(false);
		regularGrade.setEditable(false);
		
		finalGrade.setEditable(false);
		totalGrade.setEditable(false);
		totalCard.setEditable(false);
		experimentalGrade.setEditable(false);
		Panel p1 = new Panel();//����һ�����
		JLabel jl = new JLabel("��ѯѧ��������Ϣ ");//����һ����ǩ����ѯѧ��������Ϣ��
		jl.setForeground(Color.black);//��������Ϊ��ɫ
		jl.setFont(new Font("�����п�", Font.BOLD, 35));//��������Ϊ�����п�����СΪ35
		p1.add(jl);//��j1��ǩ���뵽p1�����
		add(p1, "North");//��p1����������壬�����ڱ���
		box0 = Box.createHorizontalBox();
		box0.add(new JLabel("����Ҫ��ѯ��ѧ��:"));//����һ����ǩ
		box0.add(Box.createHorizontalStrut(8));
		box0.add(num);//���ı�����뵽box0��
		box0.add(Box.createHorizontalStrut(8));
		box0.add(jb);//����ť���뵽box0��
		box1 = Box.createHorizontalBox();
		box1.add(new JLabel("����:     "));//����ǩ���뵽box1��
		box1.add(Box.createHorizontalStrut(8));
		box1.add(name);//���ı������box1��
		box2 = Box.createHorizontalBox();
		box2.add(new JLabel("�γ̺�:  "));
		box2.add(Box.createHorizontalStrut(8));
		box2.add(courseId);
		box3 = Box.createHorizontalBox();
		box3.add(new JLabel("�γ���     "));
		box3.add(Box.createHorizontalStrut(8));
		box3.add(courseName);
		box4 = Box.createHorizontalBox();
		box4.add(new JLabel("ѧ��     "));
		box4.add(Box.createHorizontalStrut(8));
		box4.add(card);
		box5 = Box.createHorizontalBox();
		box5.add(new JLabel("ƽʱ�ɼ�  "));
		box5.add(Box.createHorizontalStrut(8));
		box5.add(regularGrade);
		box6 = Box.createHorizontalBox();
		box6.add(new JLabel("ʵ��ɼ�  "));
		box6.add(Box.createHorizontalStrut(8));
		box6.add(experimentalGrade);
		box7 = Box.createHorizontalBox();
		box7.add(new JLabel("��ĩ�ɼ�  "));
		box7.add(Box.createHorizontalStrut(8));
		box7.add(finalGrade);
		box8 = Box.createHorizontalBox();
		box8.add(new JLabel("�����ɼ�  "));
		box8.add(Box.createHorizontalStrut(8));
		box8.add(totalGrade);
		box9 = Box.createHorizontalBox();
		box9.add(new JLabel("ʵ��ѧ��"));
		box9.add(Box.createHorizontalStrut(8));
		box9.add(totalCard);
		/*�����ǽ�������뵽����еĲ���*/
		

		/*�����ǽ��������뵽������еĲ���*/
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
		Panel pCenter = new Panel();//����һ�����
		pCenter.add(box);//��box���뵽�����
		add(pCenter, "Center");//����������Ļ�м�
		setSize(300, 250);//��Ϊ300����Ϊ250
		setBackground(Color.pink);//���ñ���ɫΪpink
	}
	public void actionPerformed(ActionEvent e) {//�¼���������
		int flag = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");//����������
		} catch (ClassNotFoundException ee) {
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql:///users-info", "root", "wang18121996");//�������ҵ����ݿ������
			sql = con.createStatement();//������дsql�������
			String num1, name1, courseId1, courseName1; 
			int card1;
			double regularGrade1,experimentalGrade1,finalGrade1,totalGrade1,totalCard1;
			ResultSet rs = sql.executeQuery("SELECT * FROM stud");//��ѯ���ݿ��е��ֶ�
			while (rs.next()) {//���������������
				num1 = rs.getString("ѧ��");
				name1 = rs.getString("����");
				 courseId1 = rs.getString("�γ̺�");
				 courseName1 = rs.getString("�γ���");
				 card1= rs.getInt("ѧ��");
				 regularGrade1 = rs.getDouble("ƽʱ�ɼ�");
				 experimentalGrade1 = rs.getDouble("ʵ��ɼ�");
				 finalGrade1 = rs.getDouble("��ĩ�ɼ�");
				 /*���ϳ���Ϊʹ������������ݿ����ֶε�ֵ*/
				 
				 
				 totalGrade1= getTotalGrade(regularGrade1,experimentalGrade1,finalGrade1);//�������ֵ
				 totalCard1 = getTotalCard(totalGrade1,card1);//�������ֵ
				
				if (num1.equals(num.getText().trim())) {
					name.setText(name1);//��name1��ֵд���ı���
					courseId.setText(courseId1);
					courseName.setText(courseName1);
					card.setText(String.valueOf(card1));
					regularGrade.setText(String.valueOf(regularGrade1));
					experimentalGrade.setText(String.valueOf(experimentalGrade1));
					finalGrade.setText(String.valueOf(finalGrade1));
					totalGrade.setText(String.valueOf(totalGrade1));
					totalCard.setText(String.valueOf(totalCard1));
					/*���ϴ���ΪΪ������д����Ӧ��ֵ*/
					flag = 1;
					break;
				}
			}
			sql.close();
			con.close();
		} catch (SQLException ex) {
		}
		if (flag == 0) {//���û�ж�Ӧ��ֵ
			JOptionPane.showMessageDialog(null, "û�и�ѧ�������Ϣ!���������룡", "ѧ������ϵͳ", JOptionPane.ERROR_MESSAGE);//��ʾ��Ӧ����Ϣ
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
			/*���ϴ����ʾû����Ӧֵʱ�ı���Ϊ��*/
		}
	}
	private double getTotalCard(double totalGrade1, int  card2) {//�����ۺϳɼ�
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
	private double getTotalGrade(double regularGrade1, double experimentalGrade1, double finalGrade1){//����ʵ��ѧ��
		double totalGrade1=0;
		if(experimentalGrade1==-1){
			totalGrade1=regularGrade1*0.3+finalGrade1*0.7;
		}else 
			totalGrade1=regularGrade1*0.15+experimentalGrade1*0.15+finalGrade1*0.7;
		return totalGrade1;
	}

}
