package com.zengzhx.dp.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.zxing.WriterException;
import com.zengzhx.dp.constant.UserConstant;
import com.zengzhx.dp.model.User;
import com.zengzhx.dp.util.QRUtils;

@Controller
public class LoginController {

	@ResponseBody
	@RequestMapping(value = "/qrlogin", method = RequestMethod.GET)
	public void LoginQR(HttpServletResponse response, HttpServletRequest request) {
		//构建二维码请求的URL地址
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		StringBuilder content = new StringBuilder("");
		content.append(request.getScheme() + "://");
		content.append(request.getLocalAddr()+":" ).append(request.getLocalPort());
		content.append(request.getContextPath() + "/").append("login?name="+name+"&pwd="+pwd);
		try {
			BufferedImage image = QRUtils.genBarcode(content.toString());
			OutputStream out = response.getOutputStream();
			ImageIO.write(image, "png", out);
		} catch (WriterException | IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/login")
	public String Login(User user) {
		User uc = UserConstant.getUser();
		if(uc.getName().equals(user.getName()) 
				&& uc.getPwd().equals(user.getPwd())) {
			return "hello";
		}
		return "qrlogin";
	}

}
