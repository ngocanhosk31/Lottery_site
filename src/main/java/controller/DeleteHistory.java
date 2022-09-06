package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.HistoryDAO;
import dao.LotteryDAO;

/**
 * Servlet implementation class DeleteHistory
 */
@WebServlet("/DeleteHistory")
public class DeleteHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("id");
		try {
			HistoryDAO.deleteHistory(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("delMess", "Xoá thành công");
		request.getRequestDispatcher("HistoryController").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String[] arrayId = request.getParameterValues("idHistory");
		if(request.getParameter("idHistory") == null) {
			request.setAttribute("delMessErr", "Vui lòng chọn các bản ghi trước khi xoá");
			request.getRequestDispatcher("HistoryController").forward(request, response);
		}else {
			for(int i = 0; i < arrayId.length; i++) {
				try {
					HistoryDAO.deleteHistory(arrayId[i]);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			request.setAttribute("delMess", "Xoá thành công");
			request.getRequestDispatcher("HistoryController").forward(request, response);
		}
	}

}
