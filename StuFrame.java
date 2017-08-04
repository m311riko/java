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

public class StuFrame extends Frame implements ActionListener  {//stuFrame类继承Frame类，实现ActionListener接口
	MenuBar menubar;//定义一个MenuBar类型的变量
	Menu menu_select;//定义一个Menu类型的变量
	MenuItem item_stud_add, item_stud_search, item_stud_update,
			item_stud_delete, item_exit;//定义多个MenuItem类型的变量
	AddStudent luru;//定义一个AddStudent类型的变量
	QueryStudent chaxun;//定义一个QueryStudent类型的变量
	UpdateStudent xiugai;//定义一个UpdateStudent类型的变量
	DeleteStudent shanchu;//定义一个DeletStudent类型的变量
	Box box, box1, box2;//定义三个Box类型的变量
	public StuFrame() {
		super("南京邮电大学学生信息管理系统");
		luru = new AddStudent();//实现AddStudent类型的对象
		chaxun = new QueryStudent();//实现QueryStudent类型的对象
		xiugai = new UpdateStudent();//实现UpdateStudent类型对象
		shanchu = new DeleteStudent();//实现DeleteStudent类型对象
		menubar = new MenuBar();//实现MenuBar类型对象
		menu_select = new Menu("菜单选项");//实现Menu类型对象，并添加题目“菜单选项”
		menu_select.setFont(new Font("华文行楷", Font.BOLD, 20));//给菜单选项设置字体为“华文行楷”，指定字体为20号
		item_stud_add = new MenuItem("录入学生基本信息");//实现MenuItem类型对象，添加内容为“录入学生基本信息”
		item_stud_add.addActionListener(this);//加入事件监听
		item_stud_update = new MenuItem("修改学生基本信息");//实现MenuItem类型另一个对象，添加内容为“修改学生基本信息”
		item_stud_update.addActionListener(this);//添加事件监听
		item_stud_search = new MenuItem("查询学生基本信息");//实现MenuItem类型对象，添加内容为“查询学生基本信息”
		item_stud_search.addActionListener(this);//添加事件监听
		item_stud_delete = new MenuItem("删除学生基本信息");//实现MenuItem类型对象，添加内容为“删除学生基本信息”
		item_stud_delete.addActionListener(this);//添加事件监听
		item_exit = new MenuItem("退出");//实现MenuItem类型对象，添加内容为“删除”
		item_exit.addActionListener(this);//添加事件监听
		menu_select.add(item_stud_search);//将“查询学生基本信息”组件添加到“菜单选项”面板中
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
		Label label = new Label("南京邮电大学学生成绩信息管理系统", Label.CENTER);//定义一个名为label的标签，名为“南京邮电大学学生成绩管理系统”，设置在中间位置
		label.setFont(new Font("华文行楷", Font.BOLD, 85));//设置标签字体为“华文行楷”，字体大小为85
		label.setForeground(Color.pink);//设置字体颜色为粉红色
		this.add(label);//将标签加入面板
	}
	public void actionPerformed(ActionEvent e) {//定义一个事件监听方法，actionPerformed方法使用事件的getSource()方法来检查事件源，确定哪个按钮触发了这个事件
		if (e.getSource() == item_stud_add) {//如果按钮触发了add，则执行添加事件
			removeAll();
			add(luru, "Center");
			validate();
		}
		if (e.getSource() == item_stud_search) {//如果触发了search按钮，则执行选择事件
			removeAll();
			add(chaxun, "Center");
			validate();
		}
		if (e.getSource() == item_stud_update) {//如果触发了更新按钮，则执行录入事件
			removeAll();
			add(xiugai, "Center");
			validate();
		}
		if (e.getSource() == item_stud_delete) {//如果触发了delete按钮，则执行删除事件
			removeAll();
			add(shanchu, "Center");
			validate();
		}
		if (e.getSource() == item_exit) {//如果触发了exit按钮，则执行退出事件
			JFrame f4 = new JFrame();//定义一个名为f4的框架
			Exit exit1 = new Exit(f4);//定义一个名为exit1的退出类对象，将f4框架添加到exit1中
			exit1.setBounds(500, 240, 300, 120);//设置框架边界为500，240，300，120
			exit1.setVisible(true);//设置框架可见
		}
	}
}
