package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LotteryDAO;
import entity.Lottery;
import entity.Validate;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
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
		List<Lottery> listLottery = null;
		if(thoiGian != null && tinh == null) {
			try {
				count = LotteryDAO.countSearchTime(thoiGian);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				listLottery = LotteryDAO.getMatchTimeLottery(page, thoiGian);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			endPage = count / size;
			if(count % size != 0) {
				endPage++;
			}
		}else if(tinh != null && thoiGian == null) {
			try {
				count = LotteryDAO.countSearchCity(tinh);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				listLottery = LotteryDAO.getMatchCityLottery(page, tinh);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			endPage = count / size;
			if(count % size != 0) {
				endPage++;
			}
		}else if(thoiGian != null && tinh != null) {
			try {
				count = LotteryDAO.countSearch(thoiGian, tinh);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				listLottery = LotteryDAO.getMatchLottery(page, thoiGian, tinh);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			endPage = count / size;
			if(count % size != 0) {
				endPage++;
			}
		}else if(thoiGian == null && tinh == null) {
			response.sendRedirect("LotteryController");
//			request.getRequestDispatcher("LotteryController").forward(request, response);
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
		request.setAttribute("thoiGianS", thoiGian);
		request.setAttribute("tinhS", tinh);	
		request.setAttribute("listSLottery", listLottery);
		request.getRequestDispatcher("jsp/searchLotteryResult.jsp").forward(request, response);
		
			




	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
