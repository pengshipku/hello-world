package com.niit.store.user.web.servlet;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.commons.CommonUtils;
import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;
import cn.itcast.servlet.BaseServlet;

import com.niit.store.cart.domain.Cart;
import com.niit.store.user.domain.User;
import com.niit.store.user.service.UserException;
import com.niit.store.user.service.UserService;

public class UserServlet extends BaseServlet {

    private UserService service = new UserService();

    public String quit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, MessagingException {
        request.getSession().invalidate();
        return "r:/jsps/user/login.jsp";
    }

    public String login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, MessagingException {
        User form = CommonUtils.toBean(request.getParameterMap(), User.class);
        try {
            User user = service.login(form);
            HttpSession session_user = request.getSession(true);
            session_user.setAttribute("session_user", user);
            session_user.setAttribute("session_cart", new Cart());
            return "r:/jsps/main.jsp";
        } catch (UserException e) {
            request.setAttribute("msg", e.getMessage());
            request.setAttribute("user", form);
            return "jsps/user/login.jsp";
        }
    }

    public String active(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, MessagingException {
        try {
            service.active(request.getParameter("code"));
            request.setAttribute("msg", "Activate successfully ！");
        } catch (UserException e) {
            // TODO Auto-generated catch block
            request.setAttribute("msg", e.getMessage());
        }

        return "jsps/msg.jsp";
    }

    public String regist(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, MessagingException {
        User form = CommonUtils.toBean(request.getParameterMap(), User.class);
        form.setUid(CommonUtils.uuid());
        form.setCode(CommonUtils.uuid() + CommonUtils.uuid());
        form.setState(false);//javaBean初始化
        //校验
        Map<String, String> errors = new HashMap<String, String>();
        String username = form.getUsername();
        if (username == null || username.trim().isEmpty()) {
            errors.put("username", "UserName is not null!");
        } else if (username.length() < 3 || username.length() > 10) {
            errors.put("username", "The Length of username must be between 3 and 10!");
        }
        String password = form.getPassword();
        if (password == null || password.trim().isEmpty()) {
            errors.put("password", "Password is not null!");
        } else if (password.length() < 3 || password.length() > 10) {
            errors.put("password", "The Length of password must be between 3 and 10!");
        }
        String email = form.getEmail();
        if (email == null || email.trim().isEmpty()) {
            errors.put("email", "Email is not null!");
        } else if (!email.matches("\\w+@\\w+\\.\\w+")) {
            errors.put("email", "The format of email is wrong!");
        }
        if (errors.size() != 0) {
            request.setAttribute("user", form);
            request.setAttribute("errors", errors);
            return "jsps/user/regist.jsp";
        }
        try {
            service.regist(form);
        } catch (UserException e) {
            request.setAttribute("user", form);
            request.setAttribute("msg", e.getMessage());
            return "jsps/user/regist.jsp";
        }
        Properties prop = new Properties();
        prop.load(this.getClass().getClassLoader().getResourceAsStream("/email_template.properties"));
        //发邮件
        String mailContain = MessageFormat.format(prop.getProperty("contain"), form.getCode());
        Session session = MailUtils.createSession(prop.getProperty("host"), prop.getProperty("uname"), prop.getProperty("password"));
        Mail mail = new Mail(prop.getProperty("from"), form.getEmail(), prop.getProperty("subject"), mailContain);
        MailUtils.send(session, mail);
        request.setAttribute("msg", "Congratulation,you have finished the register .Go to your email for activate it ,please!");
        return "jsps/msg.jsp";
    }
}
