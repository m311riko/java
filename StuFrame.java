package cn.frame;
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
import javax.swing.JFrame;

import cn.add.AddStudent;
import cn.delete.DeleteStudent;
import cn.exit.Exit;
import cn.query.QueryStudent;
import cn.update.UpdateStudent;

public class StuFrame extends Frame implements ActionListener  {//stuFrame��̳�Frame�࣬ʵ��ActionListener�ӿ�
	MenuBar menubar;//����һ��MenuBar���͵ı���
	Menu menu_select;//����һ��Menu���͵ı���
	MenuItem item_stud_add, item_stud_search, item_stud_update,
			item_stud_delete, item_exit;//������MenuItem���͵ı���
	AddStudent luru;//����һ��AddStudent���͵ı���
	QueryStudent chaxun;//����һ��QueryStudent���͵ı���
	UpdateStudent xiugai;//����һ��UpdateStudent���͵ı���
	DeleteStudent shanchu;//����һ��DeletStudent���͵ı���
	Box box, box1, box2;//��������Box���͵ı���
	public StuFrame() {
		super("�Ͼ��ʵ��ѧѧ����Ϣ����ϵͳ");
		luru = new AddStudent();//ʵ��AddStudent���͵Ķ���
		chaxun = new QueryStudent();//ʵ��QueryStudent���͵Ķ���
		xiugai = new UpdateStudent();//ʵ��UpdateStudent���Ͷ���
		shanchu = new DeleteStudent();//ʵ��DeleteStudent���Ͷ���
		menubar = new MenuBar();//ʵ��MenuBar���Ͷ���
		menu_select = new Menu("�˵�ѡ��");//ʵ��Menu���Ͷ��󣬲������Ŀ���˵�ѡ�
		menu_select.setFont(new Font("�����п�", Font.BOLD, 20));//���˵�ѡ����������Ϊ�������п�����ָ������Ϊ20��
		item_stud_add = new MenuItem("¼��ѧ��������Ϣ");//ʵ��MenuItem���Ͷ����������Ϊ��¼��ѧ��������Ϣ��
		item_stud_add.addActionListener(this);//�����¼�����
		item_stud_update = new MenuItem("�޸�ѧ��������Ϣ");//ʵ��MenuItem������һ�������������Ϊ���޸�ѧ��������Ϣ��
		item_stud_update.addActionListener(this);//����¼�����
		item_stud_search = new MenuItem("��ѯѧ��������Ϣ");//ʵ��MenuItem���Ͷ����������Ϊ����ѯѧ��������Ϣ��
		item_stud_search.addActionListener(this);//����¼�����
		item_stud_delete = new MenuItem("ɾ��ѧ��������Ϣ");//ʵ��MenuItem���Ͷ����������Ϊ��ɾ��ѧ��������Ϣ��
		item_stud_delete.addActionListener(this);//����¼�����
		item_exit = new MenuItem("�˳�");//ʵ��MenuItem���Ͷ����������Ϊ��ɾ����
		item_exit.addActionListener(this);//����¼�����
		menu_select.add(item_stud_search);//������ѯѧ��������Ϣ�������ӵ����˵�ѡ������
		menu_select.add(item_stud_add);
		menu_select.add(item_stud_update);
		menu_select.add(item_stud_delete);
		menu_select.add(item_exit);
		menubar.add(menu_select);
		setMenuBar(menubar);
		/*ImageIcon img = new ImageIcon("E:\\44.png");
		JLabel hy = new JLabel(img);
		hy.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		add(hy);
		setVisible(true);*/
		Label label = new Label("�Ͼ��ʵ��ѧѧ���ɼ���Ϣ����ϵͳ", Label.CENTER);//����һ����Ϊlabel�ı�ǩ����Ϊ���Ͼ��ʵ��ѧѧ���ɼ�����ϵͳ�����������м�λ��
		label.setFont(new Font("�����п�", Font.BOLD, 85));//���ñ�ǩ����Ϊ�������п����������СΪ85
		label.setForeground(Color.pink);//����������ɫΪ�ۺ�ɫ
		this.add(label);//����ǩ�������
	}
	public void actionPerformed(ActionEvent e) {//����һ���¼�����������actionPerformed����ʹ���¼���getSource()����������¼�Դ��ȷ���ĸ���ť����������¼�
		if (e.getSource() == item_stud_add) {//�����ť������add����ִ������¼�
			removeAll();
			add(luru, "Center");
			validate();
		}
		if (e.getSource() == item_stud_search) {//���������search��ť����ִ��ѡ���¼�
			removeAll();
			add(chaxun, "Center");
			validate();
		}
		if (e.getSource() == item_stud_update) {//��������˸��°�ť����ִ��¼���¼�
			removeAll();
			add(xiugai, "Center");
			validate();
		}
		if (e.getSource() == item_stud_delete) {//���������delete��ť����ִ��ɾ���¼�
			removeAll();
			add(shanchu, "Center");
			validate();
		}
		if (e.getSource() == item_exit) {//���������exit��ť����ִ���˳��¼�
			JFrame f4 = new JFrame();//����һ����Ϊf4�Ŀ��
			Exit exit1 = new Exit(f4);//����һ����Ϊexit1���˳�����󣬽�f4�����ӵ�exit1��
			exit1.setBounds(500, 240, 300, 120);//���ÿ�ܱ߽�Ϊ500��240��300��120
			exit1.setVisible(true);//���ÿ�ܿɼ�
		}
	}
}
