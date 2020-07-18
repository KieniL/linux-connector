package com.kienast.apiservice.rest.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ConnectionStoreModel
 */

public class ConnectionStoreModel   {
  @JsonProperty("id")
  private String id;

  @JsonProperty("hostname")
  private String hostname;

  @JsonProperty("port")
  private Integer port;

  @JsonProperty("username")
  private String username;

  @JsonProperty("token")
  private String token;

  @JsonProperty("sshkey")
  private String sshkey;

  @JsonProperty("password")
  private String password;

  public ConnectionStoreModel id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ConnectionStoreModel hostname(String hostname) {
    this.hostname = hostname;
    return this;
  }

  /**
   * Get hostname
   * @return hostname
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getHostname() {
    return hostname;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  public ConnectionStoreModel port(Integer port) {
    this.port = port;
    return this;
  }

  /**
   * Get port
   * @return port
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }

  public ConnectionStoreModel username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public ConnectionStoreModel token(String token) {
    this.token = token;
    return this;
  }

  /**
   * Get token
   * @return token
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public ConnectionStoreModel sshkey(String sshkey) {
    this.sshkey = sshkey;
    return this;
  }

  /**
   * Get sshkey
   * @return sshkey
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getSshkey() {
    return sshkey;
  }

  public void setSshkey(String sshkey) {
    this.sshkey = sshkey;
  }

  public ConnectionStoreModel password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConnectionStoreModel connectionStore = (ConnectionStoreModel) o;
    return Objects.equals(this.id, connectionStore.id) &&
        Objects.equals(this.hostname, connectionStore.hostname) &&
        Objects.equals(this.port, connectionStore.port) &&
        Objects.equals(this.username, connectionStore.username) &&
        Objects.equals(this.token, connectionStore.token) &&
        Objects.equals(this.sshkey, connectionStore.sshkey) &&
        Objects.equals(this.password, connectionStore.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, hostname, port, username, token, sshkey, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnectionStoreModel {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    hostname: ").append(toIndentedString(hostname)).append("\n");
    sb.append("    port: ").append(toIndentedString(port)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    sshkey: ").append(toIndentedString(sshkey)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

