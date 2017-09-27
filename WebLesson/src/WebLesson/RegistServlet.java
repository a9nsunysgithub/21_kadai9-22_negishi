package WebLesson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegistServlet extends HttpServlet{
	 protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		 	req.setCharacterEncoding("UTF-8");

		 	Word wd = new Word(req.getParameter("english"), req.getParameter("japanese")); //Wordクラスのインスタンス
			WordDAO wordDAO = new WordDAO(); //WordDAOクラスのインスタンス

			int recordNum = wordDAO.registWords(wd);
			req.setAttribute("recordNum", recordNum);

			List<Word> words = new ArrayList<>();
			words = wordDAO.getWords();//リストを全部取って来る
			int dataCnt = words.size();//リストの数
			req.setAttribute("dataCnt", dataCnt);

		 	HttpSession session = req.getSession(true);
		 	 session.setAttribute("english", req.getParameter("english"));
		 	 session.setAttribute("japanese", req.getParameter("japanese"));

		 	req.getRequestDispatcher("result.jsp").forward(req,res);

	 }}