package ex4;

import java.util.ArrayList;


public class ProductTest {
	public static void main(String []args){
		//ProdVO prod1 = new ProdVO();
		
		ProdVO prod2 =new ProdVO("x20120002","����Ʈ TV","�׷���",200);
		//ProdTO prod3 =new ProdTO("x20120003","��Ʈ��","��",300);
		
		ProdDAO dao  = new ProdDAO();  //DAO�� ȣ���Ѵ�.
		
		dao.addProdInfo(prod2);
		ArrayList<ProdVO> list  = dao.listProdInfo();       //prodDao�� listProdInfo() �޼��带 ȣ���Ͽ� ���ϰ���  ���ڵ带 ���� arraylist ��ü�� ��´�.
		

		for( int i = 0 ; i < list.size(); i++ ){    //list�� �����ϴ� ���ڵ��� ������ŭ �������� ��ȯ�Ѵ�.
				 ProdVO prodData = list.get(i);   
				 String prodCode=prodData.getProdCode();       //getter() �޼��带 �̿��ؼ� TO�� ����� data�� ������ �Ҵ��Ѵ�.
				 String prodName = prodData.getProdName();              
				 String prodColor = prodData.getProdColor();
				 int prodQty = prodData.getProdQty();
				 
				 System.out.print("��ǰ��ȣ�� >>" + prodCode  );
				 System.out.print("��ǰ�̸���  >>"+prodName);
				 System.out.print("��ǰ������>>"+prodColor);
				 System.out.print("��ǰ�԰� ������>>" +prodQty);
				 System.out.println();
		}//end for
	}		
}

