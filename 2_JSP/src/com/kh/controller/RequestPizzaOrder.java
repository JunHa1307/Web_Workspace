package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestPizzaOrder
 */
@WebServlet("/RequestPizzaOrder")
public class RequestPizzaOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestPizzaOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String pizza = request.getParameter("pizza");
		String[] topping = request.getParameterValues("topping");
		String[] side = request.getParameterValues("side");

		int cost = 0;
		if(pizza.equals("치즈피자")){
			cost += 5000;
		}else if(pizza.equals("콤비네이션피자")){
			cost += 6000;
		}else if(pizza.equals("포테이토피자")){
			cost += 6000;
		}else if(pizza.equals("고구마피자")){
			cost += 6000;
		}else if(pizza.equals("불고기피자")){
			cost += 6000;
		}
		for(int i = 0; i < topping.length; i++){
			if(topping[i].equals("고구마무스")){
				cost += 1000;
			}else if(topping[i].equals("콘크림무스")){
				cost += 1500;
			}else if(topping[i].equals("파인애플토핑")){
				cost += 1500;
			}else if(topping[i].equals("치즈토핑")){
				cost += 1500;
			}else if(topping[i].equals("치즈크러스트")){
				cost += 1500;
			}else if(topping[i].equals("치즈바이트")){
				cost += 1500;
			}
		}
		for(int i = 0; i < side.length; i++){
			if(side[i].equals("오븐구이 통닭")){
				cost += 9000;
			}else if(side[i].equals("치킨스틱&윙")){
				cost += 4900;
			}else if(side[i].equals("치즈오븐스파게티")){
				cost += 4000;
			}else if(side[i].equals("새우탕&웨지감자")){
				cost += 3500;
			}else if(side[i].equals("갈릭포테이토")){
				cost += 3000;
			}else if(side[i].equals("콜라")){
				cost += 1500;
			}else if(side[i].equals("사이다")){
				cost += 1500;
			}else if(side[i].equals("갈릭소스")){
				cost += 500;
			}else if(side[i].equals("피클")){
				cost += 300;
			}else if(side[i].equals("핫소스")){
				cost += 100;
			}else if(side[i].equals("파마산 치즈가루")){
				cost += 100;
			}
		}
		
		request.setAttribute("pizza", pizza);
		request.setAttribute("topping", topping);
		request.setAttribute("side", side);
		request.setAttribute("cost", cost);
		RequestDispatcher view = request.getRequestDispatcher("views/reponsePizzaOrderForm.jsp");
		view.forward(request, response);
	}

}
