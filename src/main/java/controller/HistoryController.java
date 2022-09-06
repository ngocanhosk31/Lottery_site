package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.HistoryDAO;
import dao.LotteryDAO;
import entity.Account;
import entity.History;

/**
 * Servlet implementation class HistoryController
 */
@WebServlet("/HistoryController")
public class HistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		Account acc = (Account)session.getAttribute("accountU");
		String email = acc.getEmail();
		int count = 0;
		int index;
		try {
			count = HistoryDAO.count(email);
			int size = 5;
			int endPage = count / size;
			if(count % size != 0) {
				endPage++;
			}
			request.setAttribute("endPage", endPage);
			
			if(request.getParameter("page") == null) {
				index = 1;
			}else {
				index = Integer.parseInt(request.getParameter("page"));
			}
			List<History> listH = HistoryDAO.getHistory(index, email);
			List<String> listCity = LotteryDAO.getListCity();
			request.setAttribute("listCity", listCity);
			request.setAttribute("listHistory", listH);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("jsp/history.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
