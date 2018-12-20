package com.soapman.getssr.controller;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@Controller
public class GetSSRController {

	@RequestMapping("/get")
	@ResponseBody
	public String getssr() {
		String result = "ssr://";
		SSRConfig ssrConfig = new SSRConfig();
		try {
			/// Users/hiboy/Desktop/user-config.json
			/// etc/shadowsocksr/user-config.json
			String value = FileUtil.readJsonData("/etc/shadowsocksr/user-config.json");
			ssrConfig = JSONObject.parseObject(value, SSRConfig.class);
			ssrConfig.setRemarks("hongkong");
			ssrConfig.setGroup("google");
			String serverStr = null;
			try {
				serverStr = CommandUtil.exec("curl ifconfig.me");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ssrConfig.setServer(serverStr);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String basestr = ssrConfig.getServer() + ":" + ssrConfig.getServer_port() + ":" + ssrConfig.getProtocol() + ":"
				+ ssrConfig.getMethod() + ":" + ssrConfig.getObfs() + ":"
				+ Base64.getEncoder().encodeToString(ssrConfig.getPassword().getBytes()) + "/?remarks="
				+ Base64.getEncoder().encodeToString(ssrConfig.getRemarks().getBytes()) + "&group="
				+ Base64.getEncoder().encodeToString(ssrConfig.getGroup().getBytes());
		result = result+Base64.getEncoder().encodeToString(basestr.getBytes());
		return Base64.getEncoder().encodeToString(result.getBytes());
	}
	
	@RequestMapping("/getqr")
	public void getssrqr(HttpServletResponse response) throws IOException {
		String result = "ssr://";
		SSRConfig ssrConfig = new SSRConfig();
		try {
			/// Users/hiboy/Desktop/user-config.json
			/// etc/shadowsocksr/user-config.json
			String value = FileUtil.readJsonData("/etc/shadowsocksr/user-config.json");
			ssrConfig = JSONObject.parseObject(value, SSRConfig.class);
			ssrConfig.setRemarks("hongkong");
			ssrConfig.setGroup("google");
			String serverStr = null;
			try {
				serverStr = CommandUtil.exec("curl ifconfig.me");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ssrConfig.setServer(serverStr);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String basestr = ssrConfig.getServer() + ":" + ssrConfig.getServer_port() + ":" + ssrConfig.getProtocol() + ":"
				+ ssrConfig.getMethod() + ":" + ssrConfig.getObfs() + ":"
				+ Base64.getEncoder().encodeToString(ssrConfig.getPassword().getBytes()) + "/?remarks="
				+ Base64.getEncoder().encodeToString(ssrConfig.getRemarks().getBytes()) + "&group="
				+ Base64.getEncoder().encodeToString(ssrConfig.getGroup().getBytes());
		result = result+Base64.getEncoder().encodeToString(basestr.getBytes());
		result = "http://qr.liantu.com/api.php?text="+result;
		response.sendRedirect(result);
	}

}
