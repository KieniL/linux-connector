package com.kienast.linuxconnector.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

@RestController
public class RootController {

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	public String index() throws JSchException {

		String pass = "12345670";
		String user = "root";
		String host = "10.0.0.1";
		int port = 22;

		try {
			JSch jsch = new JSch();
			Session session = jsch.getSession(user, host, port);
			session.setPassword(pass);
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect(3000);

			ChannelExec channelExec = (ChannelExec) session.openChannel("exec");

			InputStream in = channelExec.getInputStream();

			channelExec.setCommand("ls -la");
			channelExec.connect();

			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line;
			int index = 0;

			while ((line = reader.readLine()) != null) {
				System.out.println(++index + " : " + line);
			}

			int exitStatus = channelExec.getExitStatus();
			channelExec.disconnect();
			session.disconnect();
			if (exitStatus < 0) {
				System.out.println("Done, but exit status not set!");
			} else if (exitStatus > 0) {
				System.out.println("Done, but with error!");
			} else {
				System.out.println("Done!");
			}
		} catch (Exception e) {
			System.err.println("Error: " + e);
		}

		return "<h1>Hello at my Linux Connector Application</h1>";
	}
}
