package accountBook;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JPanel;

import accountBook.Calender;
//import accountBook.Recall;

public class Calculator  implements ActionListener{
	String id;
	JTextField T1,T2,T3,text,text2;
	JFrame mainFrame;
	 int j=0;
	 int oldnum,temp,result,ducthre;
	 String tempFun,tempInput="",str,str2,str3;
	 boolean finish=false;
	 JButton Button[] = new JButton[16];
	JButton dutch,help,home,pounder,calculator,mypage;
	 public void actionPerformed(ActionEvent e) {
		  // 입력 판단, 기능 실행
		  String input = e.getActionCommand();
		  if(input.equals("+")){
		   oldnum = temp;
		   tempFun = "+";
		   tempInput ="";
		   T2.setText("더하기");
		  }else if(input.equals("-")){
		   oldnum = temp;
		   tempFun = "-";
		   tempInput ="";
		   T2.setText("빼기");
		  }else if(input.equals("X")){
		   oldnum = temp;
		   tempFun = "X";
		   tempInput ="";
		   T2.setText("곱하기");
		  }else if(input.equals("/")){
		   oldnum = temp;
		   tempFun = "/";
		   tempInput ="";
		   T2.setText("나누기");
		  }else if(input.equals("C")){
		   tempInput ="";
		   temp = 0;
		   oldnum = 0;
		   T1.setText("");
		   T2.setText("초기화");
		  }else if(input.equals("=")){
		   if(tempFun.equals("+")){
		    result = oldnum+temp;
		    T1.setText(String.valueOf(result));
		    finish = true;
		   }else if(tempFun.equals("-")){
		    result = oldnum-temp;
		    T1.setText(String.valueOf(result));
		    finish = true;
		   }else if(tempFun.equals("X")){
		    result = oldnum*temp;
		    T1.setText(String.valueOf(result));
		    finish = true;
		   }else if(tempFun.equals("/")){
		    result = oldnum/temp;
		    T1.setText(String.valueOf(result));
		    finish = true;
		   }
		  }else if(e.getSource()==dutch){
			   str = text.getText();
			   int i = Integer.parseInt(str);
			   str2 = text2.getText();
			   int i2 = Integer.parseInt(str2);
			   ducthre = i/i2;
			   str3 = String.valueOf(ducthre);
			   T3.setText(str3);
			   finish = true;
		  }else if(e.getSource()==help){
			  final Frame fs = new Frame("도움말");
			  fs.add(new JLabel("이미지로 도움말 추가할예정!!"));
			  fs.setVisible(true);
			  fs.addWindowListener(new WindowAdapter(){
				  public void windowClosing(WindowEvent e){
				  fs.setVisible(false);
				  fs.dispose();
				  }
			  });
			  fs.setSize(250, 150);
			  fs.setLocation(200, 200);
		  }else if(e.getSource()==home){
			  mainFrame.dispose();
			  new Calender(id);
		  }else if(e.getSource()==pounder){
			  mainFrame.dispose();
			 // new Recall();
		  }else if(e.getSource()==mypage){
			  mainFrame.dispose();
				new UserInfo_gui(id);
		  }else if(e.getSource()==calculator){
			  mainFrame.dispose();
				new Calculator(id);
		  }
		  
		  else{
		   if(finish){
		    T1.setText("0"); 
		    finish = false;
		    temp = 0;
		    oldnum = 0;
		    tempInput="";
		   }
		   tempInput += e.getActionCommand();
		   System.out.println(tempInput);
		   T1.setText(tempInput);
		   temp = Integer.parseInt(tempInput);
		  }
		  
		 }
	 
	public Calculator(String id){
		this.id = id;
		mainFrame = new JFrame("동아리 회계 장부");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(1500,900);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setResizable(false);
		mainFrame.setLayout(null);
		try{
			UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");//LookAndFeel Windows 스타일 적용
			SwingUtilities.updateComponentTreeUI(mainFrame) ;
		}catch(Exception e){
		}	
		
		//전체패널
		JPanel panel = new JPanel();
		panel.setBounds(0, 90, 1362, 741);
		mainFrame.add(panel);
		panel.setLayout(null);
		panel.setVisible(true);
		
		JPanel menubar = new JPanel();
		menubar.setBounds(0, 10, 1500, 70);
		//menubar.setBackground(Color.WHITE);
		mainFrame.add(menubar);
		menubar.setLayout(null);
		
		home = new JButton("홈");
		home.setBounds(95, 12,  173, 47);
		home.addActionListener(this);
		menubar.add(home);
		
		pounder = new JButton("회비체크");
		pounder.setBounds(483, 12,  173, 47);
		pounder.addActionListener(this);
		menubar.add(pounder);
		
		calculator = new JButton("더치페이계산기");
		calculator.setBounds(870, 12,  173, 47);
		calculator.addActionListener(this);
		menubar.add(calculator);
		
		mypage = new JButton("마이페이지");
		mypage.setBounds(1231, 12,  173, 47);
		mypage.addActionListener(this);
		menubar.add(mypage);
		  
		//infomation
		  JLabel info = new JLabel("더치페이 계산기");
		  info.setBounds(10, 64, 352, 29);
		  panel.add(info);
		  
		
		//자동 더치페이 계산
		JPanel gragh = new JPanel();
		gragh.setBounds(0, 100, 715, 641);
		panel.add(gragh);
		gragh.setLayout(null);
		JLabel label = new JLabel("총 사용할 금액");
		label.setBounds(99, 80, 178, 57);
		gragh.add(label);
		text = new JTextField(10);
		text.setBounds(392, 89, 204, 39);
		gragh.add(text);
		JLabel label2 = new JLabel("명수");
		label2.setBounds(99, 200, 133, 39);
		gragh.add(label2);
		text2 = new JTextField(10);
		text2.setBounds(392, 200, 204, 39);
		gragh.add(text2);
		dutch = new JButton("더치페이");
		dutch.setBounds(267, 340, 133, 50);
		dutch.addActionListener(this);
		gragh.add(dutch);
		T3 = new JTextField("",10);
		T3.setBounds(132, 468, 434, 67);
		gragh.add(T3);
		T3.setEnabled(false);
		mainFrame.add(panel,BorderLayout.CENTER);
		
		//계산기
		  JPanel calcu = new JPanel();
		  calcu.setBounds(715, 100, 647, 641);
		  panel.add(calcu);
		  T2 = new JTextField("",5);
		  T2.setBounds(469, 20, 142, 35);
		  T2.setEnabled(false);
		  JPanel P1 = new JPanel();
		  P1.setBounds(12, 10, 623, 55);
		  JPanel P2 = new JPanel();
		  P2.setBounds(125, 102, 388, 458);
		  P1.setLayout(null);
		  T1 = new JTextField("",20);
		  T1.setBounds(12, 10, 400, 35);
		  P1.add(T1);
		  calcu.add(P1.add(T2));
		  calcu.setLayout(null);
		  //calcu.setLayout(null);
		  
		  //P2.setLayout(null);
		  P2.setLayout(new GridLayout(4,4,10,10));
		  
		  //버튼에 값 대입
		  String btnValue[] = {"7","8","9","/","4","5","6","X","1","2","3","-","C","0","=","+"};
		  for(int i=0;i <=15;i++){
		   Button[i] = new JButton(btnValue[i]);
		   P2.add(Button[i]);
		   Button[i].addActionListener(this);
		   Button[i].setBackground(new Color(175,175,175));
		   Button[i].setFont(new Font("굴림",Font.BOLD,18));
		   Button[i].setForeground(Color.WHITE);
		   if(i==3 || i==7 || i==11 || i==15){
		    Button[i].setBackground(new Color(153,0,255));
		    Button[i].setFont(new Font("굴림",Font.BOLD,18));
		    Button[i].setForeground(Color.WHITE);
		   }else if(i==12||i==14){
		    Button[i].setBackground(new Color(255,166,0));
		    Button[i].setFont(new Font("굴림",Font.BOLD,18));
		    Button[i].setForeground(Color.DARK_GRAY);
		   }
		  }
		  calcu.add(P1);
		  calcu.add(P2);
		  
		  //도움말
		  help = new JButton("?");
		  help.setBounds(1303, 59, 47, 39);
		  panel.add(help);
		  help.addActionListener(this);

		mainFrame.setVisible(true);
		 }
}
