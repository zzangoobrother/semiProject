package semi.locationInfo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.locationInfo.model.service.LocationInfoService;
import semi.locationInfo.model.vo.LocationInfo;

/**
 * Servlet implementation class LocationListServlet
 */
@WebServlet("/maplist")
public class LocationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocationListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		int currentPage = 1;
		
		int limit = 10;
		
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		LocationInfoService infoService = new LocationInfoService();
		
		RequestDispatcher view = null;
		
		try {
			int listCount = infoService.getListCount();
			
			ArrayList<LocationInfo> list = infoService.selectList(currentPage, limit);
			
			int maxPage = (int) Math.ceil(((double)listCount / limit));
			
			int startPage = (((int)((double)currentPage / limit + 0.9)) - 1) * limit + 1;

			int endPage = startPage + limit -1;
			System.out.println(currentPage + "," + startPage + "," + maxPage + "," + endPage);
			if(maxPage < endPage) {
				endPage = maxPage;
			}
			
			if(list.size() > 0) {
				view = request.getRequestDispatcher("views/location/locationMapView.jsp");
				request.setAttribute("list", list);
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("maxPage", maxPage);
				request.setAttribute("startPage", startPage);
				request.setAttribute("endPage", endPage);
				request.setAttribute("listCount", listCount);
				
				view.forward(request, response);
			} else {
				view = request.getRequestDispatcher("views/location/locationErroe.jsp");
				request.setAttribute("message", "주민센터 주소 불러오기 실패!");
				view.forward(request, response);
			}
		} catch (Exception e) {
			view = request.getRequestDispatcher("views/location/locationErroe.jsp");
			request.setAttribute("message", e.getMessage());
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
