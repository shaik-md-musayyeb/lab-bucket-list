package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.TouristPlace;
import service.MapOperations;


@WebServlet(urlPatterns= {"/map"})
public class MapServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
//Create appropriate objects for the map
	Map<String,TouristPlace> bucketList =new HashMap<String,TouristPlace>();
	MapOperations mo = new MapOperations();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String destination = request.getParameter("travel");
		String rank = request.getParameter("rank");
		String add = request.getParameter("add");
		
		String sortRandom = request.getParameter("sortrandomly");
		String sortInEntryOrder = request.getParameter("sortinentryorder");
		String sortAlphabetically = request.getParameter("sortalphabetically");
		String remove = request.getParameter("delete");
		String reset = request.getParameter("reset");
		
		// create object for Toursist class and call the appropriate method
		TouristPlace tp =new TouristPlace(name,destination,rank);
		if(add!=null) {
			// call the add method and store the return value in a map variable
			List<TouristPlace> map = mo.add(tp);
			request.setAttribute("bucketList", map/*return variable */);
			request.setAttribute("message", "user added successfully");
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/list.jsp");
			rd.forward(request, response);
		}

		if(remove!=null) {
			Object map = mo.remove(tp);
			// call the remove method and store the return value in a map variable
			request.setAttribute("bucketList", map/*return variable */);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/list.jsp");
			rd.forward(request, response);
		}

		
		if(sortRandom!=null) {
			Object map = mo.sortRandomly(bucketList);
			// call the sortRandomly method and store the return value in a map variable
			request.setAttribute("bucketList",map/*return variable */);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/list.jsp");
			rd.forward(request, response);
		}

		if(sortInEntryOrder!=null) {
			Object map = mo.sortInEntryOrder(bucketList);
			// call the sortInEntryOrder and store the return value in a map variable
			request.setAttribute("bucketList", map/*return variable */);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/list.jsp");
			rd.forward(request, response);
		}
		if(sortAlphabetically!=null) {
			Object map = mo.sortAlphabetically(bucketList);
			// call the sort Alphabetically and store the return value in a map variable
			request.setAttribute("bucketList",map/*return variable */);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/list.jsp");
			rd.forward(request, response);
		}

		if(reset!=null) {	
			Object map = mo.reset(bucketList);
			// call the reset method and store the return value in a map variable
			request.setAttribute("bucketList", map/*return variable */);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/list.jsp");
			rd.forward(request, response);
		}

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

