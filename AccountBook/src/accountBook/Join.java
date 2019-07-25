package accountBook;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTextArea;

public class Join extends JFrame {
	public JButton btn_Join;
    public JTextField club_nameText;
    public JTextField passText;
    public JTextField club_memberText;
    public JTextField idText;
    public String id;
    String setClubName;
    String setId;
    String setPass;
    String setClubMem;
    int flag;

	public Join(String id,int flag, String setClubName, String setId,String setPass,String setClubMem){
		this.id = id;
		this.flag = flag;
		this.setClubName =setClubName;
		this.setId = setId;
		this.setPass=setPass;
		this.setClubMem = setClubMem;      
		
		// panel
        JPanel panel = new JPanel();
        placeLoginPanel(panel);
       
        // add
        getContentPane().add(panel);        
		
        
		Dimension screen =Toolkit.getDefaultToolkit().getScreenSize(); 
		Dimension f1_size = super.getSize();
		  
		int left = (screen.width / 2) - (f1_size.width/3);
		int top = (screen.height / 5) - (f1_size.height/2);
		
		setLocation(left,  top);
		setResizable(true);
		setSize(300, 500);
		setVisible(true);
	}

	public void placeLoginPanel(JPanel panel){
		panel.setLayout(null); 
		
        JLabel club_nameLabel = new JLabel("���Ƹ���");
        club_nameLabel.setLocation(30, 84);
        club_nameLabel.setSize(73,25);
        panel.add(club_nameLabel);
        
        JLabel idlabel = new JLabel("���̵�");
        idlabel.setBounds(40, 130, 47, 25);
        panel.add(idlabel);
       
        JLabel passLabel = new JLabel("��й�ȣ");
        passLabel.setLocation(30, 171);
        passLabel.setSize(73,25);
        panel.add(passLabel);
        
        JLabel memberLabel = new JLabel("���Ƹ� ���");
        memberLabel.setLocation(24, 216);
        memberLabel.setSize(93,25);
        panel.add(memberLabel);
       
        club_nameText = new JTextField(20);
        club_nameText.setLocation(115, 82);
        club_nameText.setSize(142,30);
        club_nameText.setText(setClubName);
        panel.add(club_nameText);
        
        idText = new JTextField(20);
        idText.setBounds(115, 127, 142, 30);
        idText.setText(setId);
        if(flag == 1){
        	idText.setEditable(false); 	
        }
        panel.add(idText);

        
        passText = new JTextField(20);
        passText.setBounds(115, 169, 142, 30);
        passText.setText(setPass);
        panel.add(passText);
        
        JTextArea club_memberText = new JTextArea();
        club_memberText.setLineWrap(true); // �ڵ� �ٹٲ�
        club_memberText.setText(setClubMem);
        JScrollPane scrollPane = new JScrollPane(club_memberText);
        scrollPane.setBounds(5, 242, 270, 161);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVisible(true);
        panel.add(scrollPane);
        
		DB_Input in = new DB_Input();
        if(flag == 1){
    		// setting
            setTitle("��������");
            
    		 JLabel label = new JLabel("��������");
    	     label.setFont(new Font("����", Font.PLAIN, 16));
    	     label.setHorizontalAlignment(SwingConstants.CENTER);
    	     label.setBounds(92, 25, 109, 30);
    	     panel.add(label);
    	     
	        btn_Join = new JButton("��������");
	        btn_Join.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		String queryStr ="UPDATE user_info set club_name='"+club_nameText.getText()+"', u_pass="+passText.getText()+", club_member='"+club_memberText.getText()+"' where id ="+id;
	        		System.out.println(queryStr);
	        		in.productInsert(queryStr);
	        		JOptionPane.showMessageDialog(null, "�������� ����!");
	        		dispose(); //����
	        	}
	        });
        }else{
    		// setting
            setTitle("ȸ������");
            
    		 JLabel label = new JLabel("ȸ������");
    	     label.setFont(new Font("����", Font.PLAIN, 16));
    	     label.setHorizontalAlignment(SwingConstants.CENTER);
    	     label.setBounds(92, 25, 109, 30);
    	     panel.add(label);
    	     
	        btn_Join = new JButton("ȸ������");
	        btn_Join.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		//�ߺ�üũ 
		        		String query = "SELECT U_ID FROM user_info WHERE u_id='"+idText.getText()+"'";
		        		String u_id = in.productSelect("getDuplicate",query);
		        		System.out.println(u_id);
		        		if(u_id != ""){
		        			idText.setText("");passText.setText("");
		        			JOptionPane.showMessageDialog(null, "���̵� �̹� �ֽ��ϴ�.");
		        			dispose();
		        		}else{	        		
		        		//ȸ������ insert
		        		String queryStr ="INSERT INTO user_info (club_name, u_id, u_pass, club_member) VALUES ('"+club_nameText.getText()+"','"+idText.getText()+"', "+passText.getText()+",'"+club_memberText.getText()+"')";
		        		System.out.println(queryStr);
		        		in.productInsert(queryStr);
		        		
		        		//Calender_info_id Table�����
			        	String query1 = "SELECT ID FROM user_info WHERE u_id='"+idText.getText()+"'";
			        	System.out.println(query1);
			        	id = in.productSelect("getId", query1);
		       		
		        		in.tableCreate(id);

		        		JOptionPane.showMessageDialog(null, "ȸ������ ����!");
		        		dispose(); //����
		        		}
	        	}
	        });
        }
        btn_Join.setLocation(81, 409);
        btn_Join.setSize(124,30);
        panel.add(btn_Join);
    }
}
