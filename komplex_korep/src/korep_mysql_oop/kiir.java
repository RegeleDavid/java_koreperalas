package korep_mysql_oop;

public class kiir extends kapcsolat {

	String[] t;
	String[][] m;
	public kiir() {
		super();
	}
	int db(){
		int db=0;
		try {
			ps=con.prepareStatement("SELECT * FROM `n_j` ");
			rs=ps.executeQuery();
			while(rs.next()){
				db++;
			}
		} catch (Exception e) {
			return -1;
		}
		return db;
	}
	
	public String matrinx_nev(String nev){
		String szo="";
		int db=0;
		try {
			ps=con.prepareStatement("SELECT * FROM `n_j` where nev=?");
			ps.setString(1, nev);
			rs=ps.executeQuery();
			while(rs.next()){
				for (int i = 0; i < 2; i++) {
					szo+=rs.getString(i+2)+" ";
				}
				szo+="\n";
				db++;
			}
		} catch (Exception e) {
			return null;
		}
		return szo;
	}
	
//	String[][] matrinx(){
//
//		int db=0;
//		try {
//			ps=con.prepareStatement("SELECT * FROM `n_j` ");
//			rs=ps.executeQuery();
//			while(rs.next()){
//				for (int i = 0; i < 2; i++) {
//					m[db][i]=rs.getString(i+2);
//				}
//				db++;
//			}
//		} catch (Exception e) {
//			return null;
//		}
//		return m;
//	}
	String[] tomg(){
		t=new String[db()];
		int db=0;
		try {
			ps=con.prepareStatement("SELECT * FROM `n_j` ");
			rs=ps.executeQuery();
			while(rs.next()){
				t[db]=rs.getString(2);
				db++;
			}
		} catch (Exception e) {
			return null;
		}
		return t;
	}
	void tomb_kiirasa(){
		String[] t=tomg();
		for (String string : t) {
			System.out.print(string+", ");
		}
	}
//	void matrx_kiirasa(){
//		m=matrinx();
//		for (String[] strings : m) {
//			for (String string : strings) {
//				System.out.print(string+" ");
//			}
//			System.out.println();
//		}
//	}
	public boolean login(String n, String j){
		try {
			ps=con.prepareStatement("SELECT * FROM `n_j` WHERE nev=? AND jelszo=?");
			ps.setString(1, n);
			ps.setString(2, j);
			rs=ps.executeQuery();
			while(rs.next()){
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	
	void login_kiir(String n,String j){
		if(login(n, j)){
			System.out.println("sikeres belepes");
		}else{
			System.out.println("sikertelen belepes");
		}
	}
	public static void main(String[] args) {
		kiir k=new kiir();
		System.out.println(k.db());
		k.tomb_kiirasa();
		System.out.println();
		k.login_kiir("a","a");
		
		System.out.println(k.matrinx_nev("a"));
	}

}
