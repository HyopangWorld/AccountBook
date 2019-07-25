package accountBook;

import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.Color;

import accountBook.Calculator;
import accountBook.Calender;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Recall extends JFrame implements ActionListener{
	JButton btnNewButton,home,pounder,calculator,mypage,delete,add;
	//JPanel list;
	int count=0;
	JPanel detail[];
	JPanel panel;
	JScrollPane scrollPane,list;
	JLabel lblDb;
	private JTable percent[];
	JRadioButton check;
	JTextArea textArea[];
	JButton btn_share[];
	String id;
	 public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==home){
			  dispose();
			  new Calender(id);
		  }else if(e.getSource()==calculator){
			  dispose();
			  new Calculator(id);
		  }else if(e.getSource()==mypage){
			  dispose();
			  new UserInfo_gui(id);
		  }else if(e.getSource()==delete){
			  count--;
			  if(count<0){
				  JOptionPane.showMessageDialog(null, "�� �̻� ������ ������ �����ϴ�!", "Warning", JOptionPane.WARNING_MESSAGE);
			  }
			  else {
				  System.out.println(count);
				  for(int i=count;i>=1;i--){
					 detail[i].setVisible(false);
					 detail[i].repaint();
				  }
			  }
		  }else if(e.getSource()==add){
			  count++;
			  System.out.println(count);
			  list.removeAll();
			  for(int i=0;i<count;i++){
				//�ڼ��� Ȱ�� ����
					detail = new JPanel[count];
					detail[i] = new JPanel();
					detail[i].addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							final JFrame fs = new JFrame("�󼼳���");
							fs.getContentPane().setLayout(null);
							panel = new JPanel();
							panel.setBounds(12, 10, 314, 180);
							lblDb = new JLabel("DB���� �ҷ��� ����");
							panel.add(lblDb);
							fs.getContentPane().add(panel);
							
							scrollPane = new JScrollPane();
							scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
							scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
							scrollPane.setBounds(12, 200, 314, 253);
							for(int i=0;i<3;i++){
								check = new JRadioButton("���"+i);
								scrollPane.add(check);
							}
							fs.getContentPane().add(scrollPane);
							fs.setVisible(true);
							fs.addWindowListener(new WindowAdapter(){
							public void windowClosing(WindowEvent e){
							  fs.setVisible(false);
							  fs.dispose();
							  }
							 });
							fs.setSize(360, 530);
							fs.setLocation(10, 3);
						}
					});
					detail[i].setForeground(Color.WHITE);
					detail[i].setBounds(12, 10, 390, 221);
					detail[i].setBorder(BorderFactory.createLineBorder(Color.GREEN));
					detail[i].setLayout(null);
					textArea = new JTextArea[count];
					textArea[i] = new JTextArea();
					textArea[i].setBounds(12, 10, 283, 146);
					detail[i].add(textArea[i]);
					percent = new JTable[count];
					percent[i] = new JTable();
					percent[i].setBackground(Color.PINK);
					percent[i].setBounds(12, 158, 366, 53);
					detail[i].add(percent[i]);
					btn_share = new JButton[count];
					btn_share[i] = new JButton("����");
					btn_share[i].setBounds(308, 10, 70, 39);
					detail[i].add(btn_share[i]);
					list.add(detail[i]);
					list.revalidate();
					list.repaint();
			  }
		  }
		 
	 }
	public Recall(String id){
		super("���Ƹ� ȸ�� ���");
		this.id = id;
		Container con = getContentPane();
		setSize(1500,900);
		getContentPane().setLayout(null);
		//��� �޴��� �г�
		JPanel menubar = new JPanel();
		menubar.setBounds(0, 0, 1362, 46);
		getContentPane().add(menubar);
		menubar.setLayout(null);
		//�޴��� ��ư
		home = new JButton("Ȩ");
		home.setBounds(121, 10, 106, 36);
		home.addActionListener(this);
		menubar.add(home);
		
		pounder = new JButton("�� ��� �� �� ���");
		pounder.setBounds(432, 10, 106, 36);
		menubar.add(pounder);
		
		calculator = new JButton("��ġ���̰���");
		calculator.setBounds(766, 10, 106, 36);
		calculator.addActionListener(this);
		menubar.add(calculator);
		
		mypage = new JButton("����������");
		mypage.setBounds(1085, 10, 106, 36);
		mypage.addActionListener(this);
		menubar.add(mypage);
		
		//���� �г�
		JPanel info = new JPanel();
		info.setBounds(10, 47, 898, 46);
		getContentPane().add(info);
		info.setLayout(null);
		//����
		JLabel collect = new JLabel("Ȱ���� ȸ������");
		collect.setBounds(12, 10, 297, 26);
		info.add(collect);
		
		//���� �߰� ��ư �г�
		JPanel adddelete = new JPanel();
		adddelete.setBounds(920, 47, 430, 46);
		getContentPane().add(adddelete);
		adddelete.setLayout(null);
		//���� �� �߰� ��ư
		delete = new JButton("����");
		delete.setBounds(214, 10, 77, 36);
		delete.addActionListener(this);
		adddelete.add(delete);
		add = new JButton("�߰�");
		add.setBounds(303, 10, 77, 36);
		add.addActionListener(this);
		adddelete.add(add);
		
		list = new JScrollPane();
		list.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		list.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		list.setBounds(20, 103, 1330, 628);
		getContentPane().add(list);
		
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new Recall("1");
	}
}