package ex1;

import java.sql.*;

public class MemberTest {
	
	private static final String driver ="oracle.jdbc.driver.OracleDriver";
	private static final String url ="jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private static final String user="SCOTT";
	private static final String pwd="1234";

	public static void main(String[] args) {
		Connection conn;
		Statement stmt;
		ResultSet rs;
		
		try {
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			conn = DriverManager.getConnection(url,user,pwd);
			System.out.println("Connection 생성 성공");
			
			stmt=conn.createStatement();
			System.out.println("Statement 객체 생성 성공");
			
			String query="insert into Member values('0003','차범근',185,85,33)";
			System.out.println(query);
			
			stmt.executeUpdate(query);
			String query2 = "select * from Member";
			System.out.println(query2);
			
			rs=stmt.executeQuery(query2);
			
			while(rs.next());{
				System.out.print("아이디는>>" +rs.getString("id"));
				System.out.print("이름은>>" + rs.getString("name"));
				System.out.print("키는>>"+rs.getInt("height"));
				System.out.print("체중은>>"+rs.getInt("weight"));
				System.out.print("키는>>"+rs.getInt("age"));
				System.out.println();
			}
			
			rs.close();
			stmt.close();
			conn.close();
		
				
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		


	}

}
