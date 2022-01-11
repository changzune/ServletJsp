package ex3;

import java.util.ArrayList;

public class MemberTest {
	public static void main(String[] args) {
		
		//String _name=null;
		//_name="박지성";
		MemberVO vo=new MemberVO("홍길동",24);
		
		MemberDAO dao = new MemberDAO();
		
		
		//dao.modMember(vo);
		dao.delMember(vo);
		
		
		//ArrayList<MemberVO> list=dao.list();
		//ArrayList<MemberVO> list=dao.list(_name);
		ArrayList<MemberVO> list=dao.list(vo);
		
		
		if(list.size()==0) {
			System.out.println("조회된 회원이 없습니다.");
		}else {
			
		
		for(int i=0; i<list.size(); i++) {
			MemberVO data =(MemberVO) list.get(i);
			String id = data.getId();
			String name = data.getName();
			int height = data.getHeight();
			int weight = data.getWeight();
			int age= data.getAge();
			
			System.out.println("아이디는>>"+id+
								"이름은 >>"+name+
								"키는>>"+height+
								"몸무게는>>"+weight+
								"나이는>>"+age);
			
		}
		}
		
		
		
	}

	

}
