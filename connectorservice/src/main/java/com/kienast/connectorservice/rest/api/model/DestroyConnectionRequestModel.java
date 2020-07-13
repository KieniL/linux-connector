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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DestroyConnectionRequestModel destroyConnectionRequest = (DestroyConnectionRequestModel) o;
    return Objects.equals(this.session, destroyConnectionRequest.session);
  }

  @Override
  public int hashCode() {
    return Objects.hash(session);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DestroyConnectionRequestModel {\n");
    
    sb.append("    session: ").append(toIndentedString(session)).append("\n");
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

