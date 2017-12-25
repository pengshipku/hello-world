package com.niit.store.order.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

import com.niit.store.cart.domain.Cart;
import com.niit.store.cart.domain.CartItem;
import com.niit.store.order.domain.Order;
import com.niit.store.order.domain.OrderItem;
import com.niit.store.order.service.OrderException;
import com.niit.store.order.service.OrderService;
import com.niit.store.user.domain.User;
public class OrderServlet extends BaseServlet {
	private OrderService service= new OrderService();
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Order order = new Order();//��������
		order.setOid(CommonUtils.uuid());
		order.setOrdertime(new Date());
		order.setOwner((User)request.getSession().getAttribute("session_user"));
		order.setState(1);
		Cart cart = (Cart)request.getSession().getAttribute("session_cart");
		order.setTotal(cart.getTotal());
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		for(CartItem cartItem: cart.getCartItems()){
			OrderItem orderItem = new OrderItem();
			orderItem.setBook(cartItem.getBook());
			orderItem.setIid(CommonUtils.uuid());
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setOrder(order);
			orderItemList.add(orderItem);
		}
		order.setOrderItemList(orderItemList);
		service.add(order);
		request.setAttribute("order", order);
		request.getSession().removeAttribute("session_cart");
		return "jsps/order/desc.jsp";
	}
	public String myOrders(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User session_user = (User)request.getSession().getAttribute("session_user");
		List<Order> orderList = service.myOrders(session_user.getUid());
		System.out.println(orderList.get(0));
		request.setAttribute("orderList", orderList);
		return "jsps/order/list.jsp";
	}
	public String load(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("order", service.load(request.getParameter("oid")));
		return "jsps/order/desc.jsp";
	}
	public String confirm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			service.confirm(request.getParameter("oid"));
			request.setAttribute("msg", "��ϲ�����׳ɹ�");
		} catch (OrderException e) {
			request.setAttribute("msg", e.getMessage());
		}
		return "jsps/msg.jsp";
	}
	public String pay(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oid = request.getParameter("oid");// �������	
		String p0_Cmd = "Buy";// ҵ�����ͣ��̶�ֵΪbuy��������
		String p1_MerId = "10001126856";// ���ױ�ע����̺�
		String p2_Order = oid;//�������
		String p3_Amt = "0.01";// ֧���Ľ��
		String p4_Cur = "CNY";// �����ֱң��̶�ֵΪCNY����ʾ�����
		String p5_Pid = "��ȥ";// ��Ʒ����
		String p6_Pcat = "";// ��Ʒ����
		String p7_Pdesc = "";// ��Ʒ����
		
		String p8_Url = "http://localhost:8080/bookstore/OrderServlet?method=back";// ���̵ķ���ҳ�棬��֧���ɹ����ױ����ض������ҳ��
		String p9_SAF = "";// �ͻ���ַ
		String pa_MP = "";// ��Ʒ��չ��Ϣ
		String pd_FrpId = request.getParameter("pd_FrpId");// ֧��ͨ������ѡ������
		String pr_NeedResponse = "1";// Ӧ����ƣ��̶�ֵΪ1

		// ��Կ�����ױ��ṩ��ֻ���̻����ױ�֪�������Կ��
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";

		// ͨ������Ĳ�������Կ�������㷨������hmacֵ
		// ������˳���Ǳ���ģ����û��ֵҲ���ܸ���null����Ӧ�ø������ַ�����
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
				p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
				pd_FrpId, pr_NeedResponse, keyValue);
		
		// �����в������ӵ����ص�ַ����
		String url = "https://www.yeepay.com/app-merchant-proxy/node";
		url += "?p0_Cmd=" + p0_Cmd + 
				"&p1_MerId=" + p1_MerId +
				"&p2_Order=" + p2_Order + 
				"&p3_Amt=" + p3_Amt + 
				"&p4_Cur=" + p4_Cur + 
				"&p5_Pid=" + p5_Pid + 
				"&p6_Pcat=" + p6_Pcat + 
				"&p7_Pdesc=" + p7_Pdesc + 
				"&p8_Url=" + p8_Url + 
				"&p9_SAF=" + p9_SAF + 
				"&pa_MP=" + pa_MP + 
				"&pd_FrpId=" + pd_FrpId + 
				"&pr_NeedResponse=" + pr_NeedResponse + 
				"&hmac=" + hmac;
		// �ض�������
		response.sendRedirect(url);
		return "";
	}
}
