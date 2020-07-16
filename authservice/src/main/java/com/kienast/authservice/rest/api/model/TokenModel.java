package com.kienast.authservice.rest.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TokenModel
 */

public class TokenModel   {
  @JsonProperty("token")
  private String token;

  @JsonProperty("userid")
  private String userid;

  public TokenModel token(String token) {
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

  public TokenModel userid(String userid) {
    this.userid = userid;
    return this;
  }

  /**
   * Get userid
   * @return userid
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TokenModel token = (TokenModel) o;
    return Objects.equals(this.token, token.token) &&
        Objects.equals(this.userid, token.userid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, userid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TokenModel {\n");
    
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    userid: ").append(toIndentedString(userid)).append("\n");
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

