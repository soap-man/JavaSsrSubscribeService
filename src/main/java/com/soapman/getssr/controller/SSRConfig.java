package com.soapman.getssr.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SSRConfig {
	//35.241.79.32:2555:auth_sha1_v4:aes-128-ctr:plain:YXNkZmdoamts
	//ip:port:protocol:method:obfs:password
	private String server;
	private String server_port;
	private String protocol;
	private String method;
	private String obfs;
	private String password;
	private String remarks;
	private String group;
}
