package Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Util;
import UtilImpl.Utilimpl;

/**
 * Servlet implementation class FileController
 */
public class FileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Util u = new Utilimpl();
		Statement st = u.st();
		int i = Integer.parseInt(request.getParameter("i"));
		String s = null;
		switch (i) {
		case 1: 
			ResultSet rs,rsa;
			try {
				rs = st.executeQuery("select * from purchaser");
				
				rsa = st.executeQuery("select * from stock");
				request.setAttribute("stock",rsa);
				//request.setAttribute("rs", rs);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			s = "purchase";
			
			break;
		case 2: 
			try {
				
				int io = st.executeUpdate("UPDATE stock SET item_qty=10 ;");				
				rsa = st.executeQuery("select * from stock");
				request.setAttribute("stock",rsa);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			s = "seller";
		
		break;	

		default:
			break;
		}
		RequestDispatcher rd = request.getRequestDispatcher(s+".jsp");
		rd.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
