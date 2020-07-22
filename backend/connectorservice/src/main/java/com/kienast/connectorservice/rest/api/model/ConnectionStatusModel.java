package com.kienast.connectorservice.rest.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ConnectionStatusModel
 */

public class ConnectionStatusModel   {
  @JsonProperty("statuscode")
  private Integer statuscode;

  public ConnectionStatusModel statuscode(Integer statuscode) {
    this.statuscode = statuscode;
    return this;
  }

  /**
   * Get statuscode
   * @return statuscode
  */
  @ApiModelProperty(value = "")


  public Integer getStatuscode() {
    return statuscode;
  }

  public void setStatuscode(Integer statuscode) {
    this.statuscode = statuscode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConnectionStatusModel connectionStatus = (ConnectionStatusModel) o;
    return Objects.equals(this.statuscode, connectionStatus.statuscode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statuscode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnectionStatusModel {\n");
    
    sb.append("    statuscode: ").append(toIndentedString(statuscode)).append("\n");
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

