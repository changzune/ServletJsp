package ex3;

import java.util.ArrayList;

public class MemberTest {
	public static void main(String[] args) {
		
		//String _name=null;
		//_name="������";
		MemberVO vo=new MemberVO("ȫ�浿",24);
		
		MemberDAO dao = new MemberDAO();
		
		
		//dao.modMember(vo);
		dao.delMember(vo);
		
		
		//ArrayList<MemberVO> list=dao.list();
		//ArrayList<MemberVO> list=dao.list(_name);
		ArrayList<MemberVO> list=dao.list(vo);
		
		
		if(list.size()==0) {
			System.out.println("��ȸ�� ȸ���� �����ϴ�.");
		}else {
			
		
		for(int i=0; i<list.size(); i++) {
			MemberVO data =(MemberVO) list.get(i);
			String id = data.getId();
			String name = data.getName();
			int height = data.getHeight();
			int weight = data.getWeight();
			int age= data.getAge();
			
			System.out.println("���̵��>>"+id+
								"�̸��� >>"+name+
								"Ű��>>"+height+
								"�����Դ�>>"+weight+
								"���̴�>>"+age);
			
		}
		}
		
		
		
	}

	

}
