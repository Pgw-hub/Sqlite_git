import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null; // 데이터 베이스 연결.
		try {
			Class.forName("org.sqlite.JDBC");// JDBC 체크.->아까 인터넷통해서 깔았던 파일이 있는지 체크하기.
			
			String dbFile = "myfirst.db";// sqlite 데터 베이스 파일에 연결.
			try {
				con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// 데이터조회
			System.out.println("\n*** 데이터 조회 ***");
			Statement stat1=null;
			try {
				stat1 = con.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String sql1 = "select * from g_artists";
			ResultSet rs1=null;
			try {
				rs1 = stat1.executeQuery(sql1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// sql 명령어를스트링형식으로sql1에 담아서 stat1객체내에 executeQuery로 보내서 resultset에
														// 받는다.
			try {
				while (rs1.next()) {// rs1이 다음이
					String id = rs1.getString("id");
					String name = rs1.getString("name");
					String regdate = rs1.getString("regdate");
					
					System.out.println(id + " " + name +" " + regdate );
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				stat1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					//con.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("\n***  새 데이터 추가  ***");
		Statement stat2=null;
		try {
			stat2 = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql2 = "insert into g_artists (name, a_type, a_year, debut, regdate)" + "values ('방탄소년단','남성','2010년대','2013년',datetime('now','localtime'));";
		int cnt=0;
		try {
			cnt = stat2.executeUpdate(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(cnt > 0)
			System.out.println("데이터가 추가되었습니다.");
		else
			System.out.println("[Error] 데이터 추가 오류!");
		try {
			stat2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n***  새 데이터 추가  ***");
		Statement stat5=null;
		try {
			stat5 = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql5 = "insert into g_artists (name, a_type, a_year, debut, regdate)" + "values ('김수영','여성','2010년대','2013년',datetime('now','localtime'));";
		int cnt5=0;
		try {
			cnt = stat5.executeUpdate(sql5);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(cnt > 0)
			System.out.println("데이터가 추가되었습니다.");
		else
			System.out.println("[Error] 데이터 추가 오류!");
		try {
			stat5.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n***데이터 수정***");
		Statement stat3=null;
		try {
			stat3 = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql3 = "update g_artists set a_year = '2000년대, 2010년대, 2020년대' " + "where id=1 ;";
		int cnt3=0;
		try {
			cnt3 = stat3.executeUpdate(sql3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(cnt3 > 0)
			System.out.println("데이터가 수정되었습니다.");
		else
			System.out.println("[Error] 데이터 수정 오류!");
		try {
			stat3.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n*** 데이터 삭제 ***");
		Statement stat4=null;
		try {
			stat4 = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql4 = "delete from g_artists where id=5 ;";
		int cnt4=0;
		try {
			cnt4 = stat4.executeUpdate(sql4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(cnt4 > 0)
			System.out.println("데이터가 삭제 되었습니다.");
		else
			System.out.println("[Error] 데이터 삭제  오류!");
		try {
			stat4.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}