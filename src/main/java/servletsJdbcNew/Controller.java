package servletsJdbcNew;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/save")
public class Controller extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name= req.getParameter("name");
		long phone= Long.parseLong(req.getParameter("phone"));
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		Customer customer=new Customer();
		customer.setId(id);
		customer.setName(name);
		customer.setPhone(phone);
		customer.setEmail(email);
		customer.setPassword(password);
		
		CustomerCRUD crud=new CustomerCRUD();
		
		try {
			int result=crud.signUp(customer);
			
			if(result!=0) {
				resp.getWriter().print("login sucess");
			}
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		
	}
	
}
