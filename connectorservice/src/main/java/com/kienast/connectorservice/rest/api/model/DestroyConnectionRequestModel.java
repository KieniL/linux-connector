package com.kienast.connectorservice.rest.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DestroyConnectionRequestModel
 */

public class DestroyConnectionRequestModel   {
  @JsonProperty("session")
  private String session;

  @JsonProperty("token")
  private String token;

  public DestroyConnectionRequestModel session(String session) {
    this.session = session;
    return this;
  }

  /**
   * Get session
   * @return session
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getSession() {
    return session;
  }

  public void setSession(String session) {
    this.session = session;
  }

  public DestroyConnectionRequestModel token(String token) {
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
    DestroyConnectionRequestModel destroyConnectionRequest = (DestroyConnectionRequestModel) o;
    return Objects.equals(this.session, destroyConnectionRequest.session) &&
        Objects.equals(this.token, destroyConnectionRequest.token);
  }

  @Override
  public int hashCode() {
    return Objects.hash(session, token);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DestroyConnectionRequestModel {\n");
    
    sb.append("    session: ").append(toIndentedString(session)).append("\n");
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

