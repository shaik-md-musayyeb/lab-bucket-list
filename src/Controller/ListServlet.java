package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TouristPlace;
import service.ListOperations;


@WebServlet(urlPatterns= {"/list"})
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Create a List object called Bucket List.
	// Your list should be List<TouristPlace>
	List<TouristPlace> bucketList = new ArrayList<TouristPlace>();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String destination = request.getParameter("travel");
		String rank = request.getParameter("rank");
		String add = request.getParameter("add");
		
		String sortbydestination = request.getParameter("sortbydestination");
		String sortbyrank = request.getParameter("sortbyrank");
		String remove = request.getParameter("delete");
		String reset = request.getParameter("reset");
		
		System.out.println("Entering into list");
		// Create an object for the TouristPlace and pass name, destination and rank as arguments
		TouristPlace tp =new TouristPlace(name,destination,rank);
		// Create an object for the ListOperations class
		ListOperations lo =new ListOperations();
		
		if(add!=null) {
			// Call the add method in list operations and store the return list in list variable
			System.out.println("calling add equals method");
			List<TouristPlace> list = lo.add(tp);
		
			request.setAttribute("bucketList", list/*pass the list variable */);
			request.setAttribute("message", "user added successfully");
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/list.jsp");
			rd.forward(request, response);
		}

		if(remove!=null) {
			// call the remove method and store the return list in a list variable
			List<TouristPlace> list = lo.remove(tp);
			request.setAttribute("bucketList", list/*pass the list variable */);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/list.jsp");
			rd.forward(request, response);
		}

		
		if(sortbydestination!=null) {
			
			// call the sortByDestination method and store the value in a list variable
			Object list = lo.sortByDestination(bucketList);
			request.setAttribute("bucketList", list/*pass the list variable */);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/list.jsp");
			rd.forward(request, response);
		}

		if(sortbyrank!=null) {
			Object list = lo.sortByRank(bucketList);
		// call the sortByRank method and store the value in a list variable
			request.setAttribute("bucketList", list/*pass the list variable */);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/list.jsp");
			rd.forward(request, response);
		}

		if(reset!=null) {	
			Object list = lo.reset(bucketList);
			// call the clear method and store the value in a list variable
			request.setAttribute("bucketList", list /*pass the list variable */);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/list.jsp");
			rd.forward(request, response);
		}

	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
