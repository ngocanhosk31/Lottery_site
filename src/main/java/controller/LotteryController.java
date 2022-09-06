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

import dao.LotteryDAO;
import entity.Lottery;

/**
 * Servlet implementation class LotteryController
 */
@WebServlet("/LotteryController")
public class LotteryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LotteryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		int count = 0;
		try {
			count = LotteryDAO.count();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int size = 5;
		int endPage = count / size;
		if(count % size != 0) {
			endPage++;
		}
		request.setAttribute("endPage", endPage);
		List<Lottery> listLottery = null;
		List<String> listCity = null;
		int index;
		if(request.getParameter("page") == null) {
			index = 1;
		}else {
			index = Integer.parseInt(request.getParameter("page"));
		}
			try {
				listLottery = LotteryDAO.getListLottery(index);
				listCity = LotteryDAO.getListCity();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		request.setAttribute("listCity", listCity);
		request.setAttribute("listLottery", listLottery);
		request.getRequestDispatcher("jsp/lotteryManager.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
