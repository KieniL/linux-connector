package com.kienast.connectorservice.rest.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ConnectionStoreModel
 */

public class ConnectionStoreModel   {
  @JsonProperty("hostname")
  private String hostname;

  @JsonProperty("port")
  private BigDecimal port;

  @JsonProperty("username")
  private String username;

  @JsonProperty("password")
  private String password;

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

  public ConnectionStoreModel port(BigDecimal port) {
    this.port = port;
    return this;
  }

  /**
   * Get port
   * @return port
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public BigDecimal getPort() {
    return port;
  }

  public void setPort(BigDecimal port) {
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
    return Objects.equals(this.hostname, connectionStore.hostname) &&
        Objects.equals(this.port, connectionStore.port) &&
        Objects.equals(this.username, connectionStore.username) &&
        Objects.equals(this.password, connectionStore.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hostname, port, username, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnectionStoreModel {\n");
    
    sb.append("    hostname: ").append(toIndentedString(hostname)).append("\n");
    sb.append("    port: ").append(toIndentedString(port)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
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

