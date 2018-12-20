package com.soapman.getssr.controller;

import java.util.Base64;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		//ssr://MzUuMjQxLjc5LjMyOjI1NTU6YXV0aF9zaGExX3Y0OmFlcy0xMjgtY3RyOnBsYWluOllYTmtabWRvYW10cw
		
//		String basestr = "35.241.79.32:2555:auth_sha1_v4:aes-128-ctr:plain:"
//				+ Base64.getEncoder().encodeToString("asdfghjkl".getBytes());
//		String result = Base64.getEncoder().encodeToString(basestr.getBytes());
//		System.out.println(result);
		System.out.println(Base64.getEncoder().encodeToString("asdfghjkl".getBytes()));
	}

}
