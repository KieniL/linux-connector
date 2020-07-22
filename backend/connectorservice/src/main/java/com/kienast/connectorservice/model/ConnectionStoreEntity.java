package com.kienast.connectorservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "connstore")
public class ConnectionStoreEntity extends AuditModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;

	@NotBlank
	@Column(name = "hostname", columnDefinition = "text")
	private String hostname;

	@NotBlank
	@Column(name = "post", columnDefinition = "int")
	private int port;
	
	@NotBlank
	@Column(name = "username", columnDefinition = "text")
	private String username;
	
	@NotBlank
	@Column(name = "password", columnDefinition = "text")
	private String password;
	
	@NotBlank
	@Column(name = "sshkey", columnDefinition = "text")
	private String sshkey;

	
	public ConnectionStoreEntity() {
		
	}
	
	public ConnectionStoreEntity(String hostname, int port, String username,
			String password, String sshkey) {
		this.hostname = hostname;
		this.port = port;
		this.username = username;
		this.password = password;
		this.sshkey = sshkey;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSshkey() {
		return sshkey;
	}

	public void setSshkey(String sshkey) {
		this.sshkey = sshkey;
	}
}
