package accountBook;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Calendar;
import java.awt.Choice;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Input_gui extends JFrame{
	Calendar cal = Calendar.getInstance();
	String id, setY, setM, setD;
	int flag;
	String y;
	String m;
	String d ;
	int money;
	String using;
	String inOrout = null;
	String setMoney, setUsing, setInOrout;
	
	public Input_gui(String id, String setY, String setM, String setD, String setMoney, String setUsing, String setInOrout){
		this.id = id;
		this.setY = setY;
		this.setM = setM;
		this.setD = setD;
		this.setMoney = setMoney;
		this.setUsing = setUsing;
		this.setInOrout = setInOrout;
	}
	
	public void setInput_gui(){
		System.out.println(setMoney+" "+setUsing+" "+setInOrout);
		y = String.valueOf(cal.get(cal.YEAR));
		
		JPanel inputPanel = new JPanel();
		
		//��¥
		Choice YearCh = new Choice();
		YearCh.setFont(new Font("��������", Font.PLAIN, 25));
		YearCh.setBounds(195, 149, 88, 35);
		for(int k =-3; k<2;k++){YearCh.add(String.valueOf(cal.get(cal.YEAR)+k));}
		YearCh.select(setY);
		inputPanel.setLayout(null);
		inputPanel.add(YearCh);
		
		Choice MonCh = new Choice();
		MonCh.setFont(new Font("��������", Font.PLAIN, 25));
		MonCh.setBounds(289, 149, 66, 35);
		for(int k = 1; k <= 12; k++){
			if(k < 10)MonCh.add("0"+String.valueOf(k));
			else MonCh.add(String.valueOf(k));
		}MonCh.select(setM);
		inputPanel.add(MonCh);
		
		
		Choice DayCh = new Choice();
		DayCh.setFont(new Font("��������", Font.PLAIN, 25));
		DayCh.setBounds(361, 149, 63, 35);
		for(int k = 1; k <= 31; k++){
			if(k < 10)DayCh.add("0"+String.valueOf(k));
			else DayCh.add(String.valueOf(k));
		}DayCh.select(setD);
		inputPanel.add(DayCh);
		
		//����&���� Ȯ�� üũ�ڽ�
		ButtonGroup bg = new ButtonGroup();
		JCheckBox outCh = new JCheckBox("����",false);
		outCh.setBackground(Color.WHITE);
		outCh.setFont(new Font("��������", Font.PLAIN, 25));
		outCh.setBounds(126, 42, 77, 37);
		JCheckBox inCh= new JCheckBox("����",true);
		inCh.setBackground(Color.WHITE);
		inCh.setFont(new Font("��������", Font.PLAIN, 25));
		inCh.setBounds(276, 42, 77, 37);
		if(setInOrout == "����"){outCh.setSelected(true);}
		else{inCh.setSelected(true);}
		bg.add(outCh);bg.add(inCh);
		inputPanel.add(outCh); inputPanel.add(inCh);
		
		JLabel label = new JLabel("\uAE30\uC785\uB0A0\uC9DC");
		label.setFont(new Font("��������", Font.PLAIN, 25));
		label.setBounds(58, 155, 96, 29);
		inputPanel.add(label);
		
		//�ݾ� �Է�
		JTextField moneyText = new JTextField();
		moneyText.setFont(new Font("��������", Font.PLAIN, 20));
		moneyText.setBounds(195, 259, 179, 43);
		moneyText.setText(setMoney);
		moneyText.setColumns(10);
		inputPanel.add(moneyText);
		
		JLabel label_1 = new JLabel("\uB0B4\uC5ED");
		label_1.setFont(new Font("��������", Font.PLAIN, 25));
		label_1.setBounds(77, 380, 48, 29);
		inputPanel.add(label_1);
		
		//���� �Է�
		JTextField usingText = new JTextField();
		usingText.setFont(new Font("��������", Font.PLAIN, 20));
		usingText.setColumns(10);
		usingText.setBounds(195, 372, 218, 49);
		usingText.setText(setUsing);
		inputPanel.add(usingText);
		
		JLabel label_2 = new JLabel("\uAE08\uC561");
		label_2.setFont(new Font("��������", Font.PLAIN, 25));
		label_2.setBounds(77, 264, 48, 29);
		inputPanel.add(label_2);
		
		JLabel label_3 = new JLabel("(\uC6D0)");
		label_3.setFont(new Font("��������", Font.PLAIN, 20));
		label_3.setBounds(377, 273, 48, 29);
		inputPanel.add(label_3);
		
		//�Է� ��ư
		JButton input = new JButton("�Է�");
		input.setFont(new Font("��������", Font.PLAIN, 25));
		input.setBounds(195, 463, 90, 48);
		inputPanel.add(input);
		input.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//�Է��� �� �޾Ƽ� calender_info db�� insert�ϱ�
				if(inCh.isSelected())inOrout = inCh.getText();
				else inOrout = outCh.getText();
				
				 y = YearCh.getItem(YearCh.getSelectedIndex());
				 m = MonCh.getItem(MonCh.getSelectedIndex());
				 d = DayCh.getItem(DayCh.getSelectedIndex());
				 money = Integer.valueOf(moneyText.getText());
				 using = usingText.getText();
				
			    Input in = new Input(id);
			    flag = 0;
			    try {
					flag = in.account(y,m,d,inOrout,money,using);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			    System.out.println("input_gui flag action���� = "+flag);
			    dispose();
			  }
		});
		
		//�г� setting
		inputPanel.setBackground(Color.WHITE);
		setSize(500, 600);
		
		Dimension screen =Toolkit.getDefaultToolkit().getScreenSize();
		//setSize(screen.width*5/7, screen.height*4/5);
		Dimension f1_size = super.getSize();
		  
		int left = (screen.width / 2) - (f1_size.width / 2);
		int top = (screen.height / 2) - (f1_size.height /2 );
		
		setLocation(left,  top);
		setResizable(true);
		getContentPane().add(inputPanel);
		setVisible(true);
		
	}
}

