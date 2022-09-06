package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HistoryDAO;
import dao.LotteryDAO;
import entity.History;

/**
 * Servlet implementation class SearchHistory
 */
@WebServlet("/SearchHistory")
public class SearchHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String thoiGian = request.getParameter("thoiGian");
		String tinh = request.getParameter("tinh");
		int page = Integer.parseInt(request.getParameter("page"));
		int count = 0;
		int size = 5;
		int endPage = 0;
		List<History> listH = null;
		if(thoiGian != null && tinh == null) {
			try {
				count = HistoryDAO.countSearchTime(thoiGian);
				listH = HistoryDAO.getMatchTimeHistory(page, thoiGian);
				endPage = count / size;
				if(count % size != 0) {
					endPage++;
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(thoiGian == null && tinh != null) {
			try {
				count = HistoryDAO.countSearchCity(tinh);
				listH = HistoryDAO.getMatchCityHistory(page, tinh);
				endPage = count / size;
				if(count % size != 0) {
					endPage++;
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(thoiGian != null && tinh != null) {
			try {
				count = HistoryDAO.countSearch(thoiGian, tinh);
				listH = HistoryDAO.getMatchHistory(page, thoiGian, tinh);
				endPage = count / size;
				if(count % size != 0) {
					endPage++;
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(thoiGian == null && tinh == null) {
			response.sendRedirect("HistoryController");
		}
		List<String> listCity = null;
		try {
			listCity = LotteryDAO.getListCity();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listCity", listCity);
		request.setAttribute("endPage", endPage);
		request.setAttribute("listHistory", listH);
		request.setAttribute("thoiGianH", thoiGian);
		request.setAttribute("tinhH", tinh);
		request.getRequestDispatcher("jsp/history.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
