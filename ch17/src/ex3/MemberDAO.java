package ex3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDAO {
	private static final String driver="oracle.jdbc.driver.OracleDriver";  //상수에 DB연결 관련 데이터를 세팅한다.
	private static final String url ="jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private static final String user = "scott";
	private static final String pwd="1234";
	
	private Connection con;  //DB연결에 사용되는 객체를  선언한다.
    private	Statement stmt;
    private ResultSet rs;	
    
    
    // public ArrayList<MemberVO> list(){
    	//public ArrayList<MemberVO> list(String _name){
    public ArrayList<MemberVO> list(MemberVO vo){
    	String _name=null;
    	int _age=0;
    		
    	ArrayList<MemberVO> list=new ArrayList<MemberVO>();
    	
    	
    	_name=vo.getName();
    	_age=vo.getAge();
    	
    	
    	try{
    		connDB();
    		String query="select * from Member";
    		if(_name!=null && _age !=0){
    			query+=" where name='"+_name+"' and age="+_age;
    		}else if(_name!=null && _age==0) {
    			query+=" where name='"+_name+"'";
    		}else if(_name==null && _age !=0) {
    			query+=" where age='"+_age;
    		}
    		
    		/*if(_name != null)
    			query+=" where name='"+_name+"'";
    		*/

    		System.out.println(query);
    		ResultSet rs=stmt.executeQuery(query);
    		
    		while(rs.next()){
    			String id=rs.getString("id");
    			String name=rs.getString("name");
    			int height=rs.getInt("height");
    			int weight=rs.getInt("weight");
    			int age=rs.getInt("age");
    			
    			MemberVO data=new MemberVO();
    			
    			data.setId(id);
    			data.setName(name);
    			data.setHeight(height);
    			data.setWeight(weight);
    			data.setAge(age);
    			
    			list.add(data);
    		}
    		rs.close();
    		stmt.close();
    		con.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return list;
    }
    
    public void modMember(MemberVO vo) {
    	String _name=null;
    	int _age=0;
    	
    	_name=vo.getName();
    	_age=vo.getAge();
    	
    	try {
    		connDB();
    		String query="update Member ";
    		query+= " set age="+_age;
    		query+= " where name'"+_name+"'";
    		System.out.println(query);
    		stmt.executeUpdate(query);
    		
    		
    			
    	}catch(Exception e) {
    		e.printStackTrace();
    		
    	}
    }
    	

    	public void delMember(MemberVO vo){
    		String _name=null;
    		
    		_name=vo.getName();
    		
    		try {
    			connDB();
    			String query="delete from Member ";
    			query+=" where name='"+_name+"'";
    			
    			System.out.println(query);
    			stmt.executeUpdate(query);
    			
    					
    		}catch(Exception e) {
    		e.printStackTrace();
    		}
    		
    	}
  
    
    public void connDB(){
    	try{
    		Class.forName(driver);
    		System.out.println("Oracle 드라이버 로딩 성공");
    		con=DriverManager.getConnection(url,user,pwd);
    		System.out.println("Connection 생성 성공");
    		stmt=con.createStatement();
    		System.out.println("Statement 생성 성공");
    		
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }

}
