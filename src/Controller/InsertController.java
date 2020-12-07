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


public class InsertController extends HttpServlet {
	
	Util u = new Utilimpl();
	Statement s = u.st();
	private static final long serialVersionUID = 1L;
   
	public InsertController() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String str = request.getParameter("val");
	int id = Integer.parseInt(request.getParameter("id"));
	
	if(str.equals("pur")){
		try {
			int i = s.executeUpdate("DELETE FROM purchaser WHERE p_id="+id+";");
			if(i>0){
				RequestDispatcher rd = request.getRequestDispatcher("p.pop?i=1");
				rd.forward(request, response);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		int p = Integer.parseInt(request.getParameter("p"));
		
		switch (p) {
		case 1:
			
			String pname = request.getParameter("purchaser_name");
			String item1 = request.getParameter("item");
			int amount = Integer.parseInt(request.getParameter("Amountpaid"));
			int qty = Integer.parseInt(request.getParameter("qty"));
			int price1 = 0;
			switch (item1) {
			case "Coke": price1 = 25;
			break;
			case "Pepsi": price1 = 35;
			break;
			case "Soda": price1 = 45;
			break;

			default:
				break;
			}
			
			try {
				int i = s.executeUpdate("INSERT INTO purchaser(p_name,item,qty,price) VALUES('"+pname+"','"+item1+"','"+qty+"','"+price1+"');");
				if(i>0){
					ResultSet rs = s.executeQuery("select * from stock where item_name='"+item1+"';");
					if(rs.next()){
					int stock = rs.getInt("item_qty")-qty;	
					
					int io = s.executeUpdate("UPDATE stock SET item_qty="+stock+" where item_name='"+item1+"';");
					}
					int refund = amount-(price1*qty);
					String msg;
					if(refund>0){
						msg = "Amount to be refund is Rs.'"+refund+"'";
					}
					else{
						msg = "Please pay Rs.'"+refund+"' more";
					}
					request.setAttribute("msg", msg);
					RequestDispatcher rd = request.getRequestDispatcher("p.pop?i=1");
					rd.forward(request, response);
				}
				else{
					System.out.println("Error in Insertion");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		

		default:
			break;
		}
	
		
		
	}

}
