package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LotteryDAO;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/DeleteLottery")
public class DeleteLottery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteLottery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("id");
		LotteryDAO.deleteLottery(id);
		request.setAttribute("messageL", "Xoá thành công");
		request.getRequestDispatcher("LotteryController").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		String[] arrayId = request.getParameterValues("idLottery");
		if(request.getParameter("idLottery") == null) {
			HttpSession session = request.getSession();
			session.setAttribute("errorDeleteL", "Vui lòng chọn các bản ghi trước khi xoá");
			response.sendRedirect("LotteryController");
		}else {
			for(int i = 0; i < arrayId.length; i++) {
				LotteryDAO.deleteLottery(arrayId[i]);
			}
			HttpSession session = request.getSession();
			session.setAttribute("messageL", "Xoá thành công");
			response.sendRedirect("LotteryController");
		}
	}

}
