package cn.exit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Exit extends JDialog implements ActionListener {//����һ��exit�࣬�̳�JDialog�࣬ʵ��ActionListener�ӿ�
	JFrame mainFrame;//����һ��JFrame����
	JPanel panelS, panelN;//��������JPanel����
	JButton yes, no;//��������JButton����
	JLabel lab;//����һ��JLabel����
	public Exit(JFrame mainFrame) {
		super(mainFrame, "�Ͼ��ʵ��ѧѧ���ɼ���Ϣ����ϵͳ", true);
		// true ����Ϊ��ģʽ�Ի���
		this.mainFrame = mainFrame;
		panelN = new JPanel();//����Panel����
		panelS = new JPanel();//����Panel����
		lab = new JLabel("ȷ��Ҫ�˳�ѧ���ɼ�����ϵͳ��?");//����JLabel����ȷ��Ҫ�˳�ѧ���ɼ�����ϵͳ����
		lab.setForeground(Color.black);//��������Ϊ��ɫ
		lab.setFont(new Font("�����п�", Font.PLAIN, 20));//��������Ϊ�����п�����СΪ20
		panelN.add(lab);//����ǩ��������panelN
		yes = new JButton("�˳�");//����JButton����
		yes.setForeground(Color.black);//���ð�ť����Ϊ��ɫ
		yes.setFont(new Font("�����п�", Font.PLAIN, 20));//���ð�ť����Ϊ�����п�����СΪ20
		yes.addActionListener(this);//�����¼�����
		no = new JButton("ȡ��");//����JButton����ȡ����
		no.setFont(new Font("�����п�", Font.PLAIN, 20));//���ð�ť����Ϊ�����п�����СΪ20
		no.setForeground(Color.black);//���ð�ť������ɫΪ��ɫ
		no.addActionListener(this);//�����¼�����
		panelS.add(yes);//����ť�������panelS
		panelS.add(no);//����ť�������panelS
		getContentPane().add(panelS, BorderLayout.SOUTH);//�������ΪBorderLayout
		getContentPane().add(panelN, BorderLayout.NORTH);//�������ΪBorderLayout
		this.setBackground(Color.yellow);//���ñ���ɫΪ��ɫ
		this.setResizable(false); // ���öԻ���Ϊ���ɸı��С
	}
	public void actionPerformed(ActionEvent e) {//�¼���������
		if (e.getSource() == yes) {//����¼��ǡ�yes��
			System.exit(0);
		}
		if (e.getSource() == no) {//����¼��ǡ�no��
			this.setVisible(false);//���治�ɼ�
		}
	}
}
