package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginTest
 */
@WebServlet("/LoginTest")
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter()	;
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		System.out.println("���̵�:" + id);
		System.out.println("��й�ȣ: " + pw);
		
		if(id !=null &&(id.length()!=0)) {
			if(id.equals("admin")) {
				out.print("<html><body>");
				out.print("<font size='12'>�����ڷ� �α��� �߽��ϴ�.</font>");
				out.print("<br>");
				out.print("<input type='button' value='ȸ�����������ϱ�' />");
				out.print("<input type='button' value='ȸ�����������ϱ�' />");
				out.print("</body></html>");
			}else{
				out.print("<html>");
				out.print("<boby>");
				out.print(id + "�� �α����Ͽ����ϴ�.");
				out.print("</body>");
				out.print("</html>");
			}
			out.print("<html>");
			out.print("<boby>");
			out.print(id + "�� �α����Ͽ����ϴ�.");
			out.print("</body>");
			out.print("</html>");
		}else {
			out.print("<html>");
			out.print("<body>");
			out.print("���̵� �Է��ϼ���");
			out.print("<br>");
			out.print("<a href='http://localhost:8090/pro/test01/login.html'>�α���â���� �̵� </a>");
			out.print("</body>");
			out.print("</html>");
		}
		
		
		
	}

}
