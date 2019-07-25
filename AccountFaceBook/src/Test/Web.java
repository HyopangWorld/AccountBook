package Test;

import java.io.IOException; 
import java.net.URI; 
import java.net.URISyntaxException; 
import java.awt.Desktop; 

public class Web { 
	public static void main(String [] args){ 
		try { 
			Desktop.getDesktop().browse(new URI("https://www.facebook.com/sharer/sharer.php?=https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/20246504_1822872844707987_8449001754102478931_n.jpg?oh=9614d241ebd85d208f3ba39af7605dc3&oe=5A503A7B")); 
			} catch (IOException e) { 
				e.printStackTrace(); 
		}catch (URISyntaxException e) {
			e.printStackTrace(); 
			} 
		} 
}
