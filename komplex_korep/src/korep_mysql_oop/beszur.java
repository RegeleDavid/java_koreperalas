package korep_mysql_oop;

public class beszur extends kapcsolat {

	public beszur() {
		super();
	}
	
	void beszuras(String n, String j){
		try {
			ps=con.prepareStatement("INSERT INTO `n_j` (`id`, `nev`, `jelszo`) VALUES (NULL, ?,?);");
			ps.setString(1, n);
			ps.setString(2, j);
			ps.executeUpdate();
			} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	boolean van_e_nev(String n){
		
		try {
			ps=con.prepareStatement("SELECT * FROM `n_j` ");
			rs=ps.executeQuery();
			while(rs.next()){
				if(n.equals(rs.getString(2))){
					return false;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public void megnez_beszt(String n, String j){
		if(van_e_nev(n)) {
			beszuras(n, j);
			System.out.println("siker");
		}else{
			System.out.println("van ilyen nev");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new beszur().megnez_beszt("davidas", "david");
	}

}
