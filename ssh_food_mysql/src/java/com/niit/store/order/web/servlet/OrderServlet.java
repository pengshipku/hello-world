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
		Order order = new Order();//创建订单
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
			request.setAttribute("msg", "恭喜，交易成功");
		} catch (OrderException e) {
			request.setAttribute("msg", e.getMessage());
		}
		return "jsps/msg.jsp";
	}
	public String pay(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oid = request.getParameter("oid");// 订单编号	
		String p0_Cmd = "Buy";// 业务类型，固定值为buy，即“买”
		String p1_MerId = "10001126856";// 在易宝注册的商号
		String p2_Order = oid;//订单编号
		String p3_Amt = "0.01";// 支付的金额
		String p4_Cur = "CNY";// 交易种币，固定值为CNY，表示人民币
		String p5_Pid = "我去";// 商品名称
		String p6_Pcat = "";// 商品各类
		String p7_Pdesc = "";// 商品描述
		
		String p8_Url = "http://localhost:8080/bookstore/OrderServlet?method=back";// 电商的返回页面，当支付成功后，易宝会重定向到这个页面
		String p9_SAF = "";// 送货地址
		String pa_MP = "";// 商品扩展信息
		String pd_FrpId = request.getParameter("pd_FrpId");// 支付通道，即选择银行
		String pr_NeedResponse = "1";// 应答机制，固定值为1

		// 密钥，由易宝提供，只有商户和易宝知道这个密钥。
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";

		// 通过上面的参数、密钥、加密算法，生成hmac值
		// 参数的顺序是必须的，如果没有值也不能给出null，而应该给出空字符串。
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
				p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
				pd_FrpId, pr_NeedResponse, keyValue);
		
		// 把所有参数连接到网关地址后面
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
		// 重定向到网关
		response.sendRedirect(url);
		return "";
	}
}
