package com.kienast.connectorservice.rest.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;

/**
 * ConnectionCommandRequestModel
 */

public class ConnectionCommandRequestModel   {
  @JsonProperty("session")
  private String session;

  @JsonProperty("command")
  private String command;

  @JsonProperty("token")
  private String token;

  public ConnectionCommandRequestModel session(String session) {
    this.session = session;
    return this;
  }

  /**
   * Get session
   * @return session
  */
  @ApiModelProperty(value = "")


  public String getSession() {
    return session;
  }

  public void setSession(String session) {
    this.session = session;
  }

  public ConnectionCommandRequestModel command(String command) {
    this.command = command;
    return this;
  }

  /**
   * Get command
   * @return command
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getCommand() {
    return command;
  }

  public void setCommand(String command) {
    this.command = command;
  }

  public ConnectionCommandRequestModel token(String token) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConnectionCommandRequestModel connectionCommandRequest = (ConnectionCommandRequestModel) o;
    return Objects.equals(this.session, connectionCommandRequest.session) &&
        Objects.equals(this.command, connectionCommandRequest.command) &&
        Objects.equals(this.token, connectionCommandRequest.token);
  }

  @Override
  public int hashCode() {
    return Objects.hash(session, command, token);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnectionCommandRequestModel {\n");
    
    sb.append("    session: ").append(toIndentedString(session)).append("\n");
    sb.append("    command: ").append(toIndentedString(command)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
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

