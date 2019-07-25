package accountBook;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class UserInfo_gui extends JFrame {
	UserInfo ui;
	JPanel jp;
	String id;
	public UserInfo_gui(String id){
		this.id = id;
		ui = new UserInfo(id);
		jp = new JPanel();
		jp.setLayout(null);
		createUserInfo();
	}
	public void createUserInfo(){
		JLabel titleL = new JLabel("����������");
		titleL.setFont(new Font("���������ڵ�", Font.PLAIN, 50));
		titleL.setBounds(33, 92, 250, 58);
		jp.add(titleL);
		
		getContentPane().add(jp);
		
		JPanel menubar = new JPanel();
		menubar.setBackground(Color.WHITE);
		menubar.setBounds(0, 0, 1482, 71);
		menubar.setLayout(null);
		
		JButton home = new JButton("Ȩ");
		home.setBounds(95, 12, 173, 47);
		home.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();new Calender(id);
			}
		});
		menubar.add(home);
		
		JButton pounder = new JButton("ȸ��üũ");
		pounder.setBounds(483, 12, 173, 47);
		pounder.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
					dispose();new Recall(id);
			}
		});
		menubar.add(pounder);
		
		JButton calculator = new JButton("��ġ���̰���");
		calculator.setBounds(870, 12, 173, 47);
		calculator.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();	new Calculator(id);
			}
		});
		menubar.add(calculator);
		
		JButton mypage = new JButton("����������");
		mypage.setBounds(1231, 12, 173, 47);
		mypage.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();new UserInfo_gui(id);
			}
		});
		menubar.add(mypage);
		
		jp.add(menubar);
		
		JLabel ClubInfo = new JLabel("\uB3D9\uC544\uB9AC \uC815\uBCF4");
		ClubInfo.setFont(new Font("���������ڵ�", Font.PLAIN, 20));
		ClubInfo.setBounds(53, 390, 123, 28);
		jp.add(ClubInfo);
		
		JPanel UserInfoP = new JPanel();
		UserInfoP.setBackground(SystemColor.activeCaption);
		UserInfoP.setBounds(53, 186, 405, 166);
		jp.add(UserInfoP);
		UserInfoP.setLayout(null);
		
		JLabel UserIdL = new JLabel(ui.Idresult);
		UserIdL.setFont(new Font("���������ڵ�", Font.PLAIN, 17));
		UserIdL.setBounds(166, 12, 51, 33);
		UserInfoP.add(UserIdL);
		
		JLabel UserClubL = new JLabel(ui.Clubresult);
		UserClubL.setFont(new Font("���������ڵ�", Font.PLAIN, 17));
		UserClubL.setBounds(166, 67, 51, 33);
		UserInfoP.add(UserClubL);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("���������ڵ�", Font.PLAIN, 20));
		lblId.setBounds(42, 19, 62, 18);
		UserInfoP.add(lblId);
		
		JLabel lblPass = new JLabel("CLUB");
		lblPass.setFont(new Font("���������ڵ�", Font.PLAIN, 20));
		lblPass.setBounds(42, 73, 62, 18);
		UserInfoP.add(lblPass);
		
		JLabel balanceL = new JLabel(ui.Balresult);
		balanceL.setFont(new Font("���������ڵ�", Font.PLAIN, 17));
		balanceL.setBounds(166, 121, 51, 33);
		UserInfoP.add(balanceL);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setFont(new Font("���������ڵ�", Font.PLAIN, 20));
		lblBalance.setBounds(42, 127, 75, 18);
		UserInfoP.add(lblBalance);
		
		JLabel label = new JLabel("\uC778\uC6D0 :");
		label.setFont(new Font("���������ڵ�", Font.PLAIN, 15));
		label.setBounds(53, 445, 62, 18);
		jp.add(label);
		
		JLabel ClubCnt = new JLabel(String.valueOf(ui.length));
		ClubCnt.setBounds(114, 445, 62, 18);
		jp.add(ClubCnt);
		
		JPanel ClubCntP = new JPanel();
		ClubCntP.setBackground(SystemColor.info);
		ClubCntP.setBounds(53, 475, 611, 325);
		jp.add(ClubCntP);
		ClubCntP.setLayout(null);
		
		JButton changeIdBtn = new JButton("\uC815\uBCF4\uC218\uC815");
		changeIdBtn.setBounds(335, 104, 123, 46);
		jp.add(changeIdBtn);
		changeIdBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				Join j = new Join(id,1,ui.Clubresult, ui.Idresult,ui.Passresult,ui.Memberresult);
			}
		});
		changeIdBtn.setFont(new Font("���������ڵ�", Font.PLAIN, 17));
		
		int x=14, y=70, j=53, k=50;
		
		JLabel mem[] = new JLabel[ui.length];
		for(int i=0 ; i<ui.length ; i++){
			mem[i] = new JLabel(ui.member[i]);
			mem[i].setBounds(x, y, 82, 41);
			ClubCntP.add(mem[i]);
			if((x += j) >500){x=14;y+=k;}
			if(y> 499) y=14;
		}
		
		setLocation(250,50);
		setSize(1500,900);
		setVisible(true);
	}
}

