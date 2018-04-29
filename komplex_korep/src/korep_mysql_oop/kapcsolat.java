package korep_mysql_oop;
import java.sql.*;
public class kapcsolat {

	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public kapcsolat() {
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost/nev_jelszo","root","");
			System.out.println(":)");
		} catch (Exception e) {
			System.out.println(":(");
		}
	}
	void beszar_con(){
		if(con!=null){
			try {
				System.out.println("siker");
				con.close();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else{
			System.out.println("null értekel rér vissza");
		}
	}
	public static void main(String[] args) {
		kapcsolat k=new kapcsolat();
		k.beszar_con();
		
	}

}
