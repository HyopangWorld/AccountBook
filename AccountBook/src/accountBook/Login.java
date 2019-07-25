package accountBook;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
 
public class Login extends JFrame{
    public JButton btnLogin;
    public JButton btnJoin;
    public JPasswordField passText;
    public JTextField userText;
    public String id;
 
    
    public Login() {               
        // panel
        JPanel panel = new JPanel();
        placeLoginPanel(panel);
              
        // add
        getContentPane().add(panel);
        
		JLabel lb = new JLabel();
		lb.setLocation(0, 0);
		panel.add(lb);
		lb.setSize(385, 353);
       
        // 프레임 setting
        setTitle("동아리회계장부");
        setSize(400, 300);
		Dimension screen =Toolkit.getDefaultToolkit().getScreenSize(); // 모니터화면의 해상도 얻기
		Dimension f1_size = super.getSize(); // 프레임크기
		  
		int left = (screen.width / 2) - (f1_size.width / 2);
		int top = (screen.height / 2) - (f1_size.height /2 );
		
		setLocation(left,  top); // left, top 설정
		setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
   
    
    public void placeLoginPanel(JPanel panel){
        panel.setLayout(null); 
        JLabel userLabel = new JLabel("아이디");
        userLabel.setBounds(62, 50, 80, 25);
        panel.add(userLabel);
       
        JLabel passLabel = new JLabel("비밀번호");
        passLabel.setBounds(62, 106, 80, 25);
        panel.add(passLabel);
       
        userText = new JTextField(20);
        userText.setBounds(153, 50, 160, 25);
        panel.add(userText);
       
        passText = new JPasswordField(20);
        passText.setBounds(153, 106, 160, 25);
        panel.add(passText);
        
        btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		DB_Input in = new DB_Input();
        		//pass가 db에 있는지 확인
        		String queryString = "SELECT U_PASS FROM user_info WHERE U_ID = '"+userText.getText()+"'";
        		System.out.println(queryString);
        		if(passText.getText().equals(in.productSelect("getPass",queryString))/*||("".equals(in.productSelect("getPass",queryString)) != true)*/){
            		String query = "SELECT ID FROM user_info WHERE U_ID='"+userText.getText()+"'";
            		id = in.productSelect("getId", query);
        			Calender cl = new Calender(id);
        			dispose();
        		}else{
        			JOptionPane.showMessageDialog(null, "잘못된 정보입니다.로그인 실패");
        		}
        	}
        });
        btnLogin.setBounds(62, 163, 100, 25);
        panel.add(btnLogin);
        
        btnJoin = new JButton("회원가입");
        btnJoin.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		new Join(id, 0,"","","","");
        	}
        });
        btnJoin.setBounds(213, 163, 100, 25);
        panel.add(btnJoin);
    }
}
