package accountBook;

import java.sql.SQLException;

//��� �����
public class Input {
	String id; // id�� �ֱ�
	private int balance;
	
	//������ �Լ��� id �� �޾ƿ���
	public Input(String id){
		this.id  = id;
	}
	
	//����&���� �� �Է� �� DB�޼��带�θ��� �޼���
	public int account(String p_y, String p_m, String p_d, String p_inOrout, int p_money, String using) throws SQLException{
		DB_Input dbInput = new DB_Input();
		int flag=0;
		//���� ����
		String queryinsertStr = "INSERT INTO calender_info_"+id+"(date, inOrout, money, p_use) VALUES (" +p_y+""+p_m+""+p_d+ ",'"+p_inOrout+"',"+p_money+",'"+using+"')";
		dbInput.productInsert(queryinsertStr);
		System.out.println("Input Class flag="+flag);
		
		//�ܰ� ����
		String queryStr ="SELECT BALANCE FROM USER_INFO WHERE ID ="+id;
		balance = Integer.valueOf(dbInput.productSelect("getBalance",queryStr));
		System.out.println(balance);
		if(p_inOrout == "����"){
			balance -= p_money;
			System.out.println("��������");	
		}
		else if(p_inOrout == "����"){
			balance += p_money;
			System.out.println("��������");
		}
		System.out.println(balance);
		//�ܰ� ������Ʈ == �ܰ��� 0���ϸ� �ȵǰ� �ɸ��� ��� �߰��ϱ�!
		String queryUpStr="UPDATE user_info SET balance="+balance+" WHERE id="+id;
		System.out.println(queryUpStr);
		dbInput.productUpdateDelete(queryUpStr);
		
		//new Calender(id);
		System.out.println("Input Class return flag="+flag);
		return flag;
	}
	
	
	//������ ���� �޼���
	public void resuitGallery(char resuit){
		System.out.println("������ ����");
	}
}
