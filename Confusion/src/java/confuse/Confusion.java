/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package confuse;


 import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Confusion extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String myname=request.getParameter("txt");
		
		try {
			PrintWriter out =response.getWriter();
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","root","9623022232");
			  
			PreparedStatement ps= con.prepareStatement("insert into con values(?)");
			ps.setString(1, myname);
			
			int count = ps.executeUpdate();
			  
			  if (count > 0) {
				  
				  response.setContentType("text/html");
				  out.print("<h3> User Registered Successfully...!! </h3>");	  
			  }
			  else {
				  response.setContentType("text/html");
				  out.print("<h3> User Not Registered due to some technical error </h3>"); 
			  }
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
