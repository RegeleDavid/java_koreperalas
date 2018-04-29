package korep_mysql_oop;

public class tabla extends kapcsolat{
	public tabla() {
		// TODO Auto-generated constructor stub
		super();
	}
	public String[][] matrix(){
		try {
			int db=0;
			String[][] t=new String[db()][2];
			ps=con.prepareStatement("SELECT * FROM `n_j` ");
			rs=ps.executeQuery();
			while(rs.next()){
				for (int i = 0; i < 2; i++) {
					t[db][i]=rs.getString(i+2);
				}
				db++;
			}
			return t;
		} catch (Exception e) {
			return null;
		}
	}
	private int db(){
		try {
			int db=0;
			ps=con.prepareStatement("SELECT * FROM `n_j` ");
			rs=ps.executeQuery();
			while(rs.next()){
				db++;
			}
			return db;
		} catch (Exception e) {
			return -1;
		}
	}
	public static void main(String[] args) {
		String[][] t=new tabla().matrix();
		for (String[] strings : t) {
			for (String string : strings) {
				System.out.print(string+" ");
			}
			System.out.println();
		}

	}

}
