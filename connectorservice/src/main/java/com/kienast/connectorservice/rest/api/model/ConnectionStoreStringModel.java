package com.kienast.connectorservice.rest.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ConnectionStoreStringModel
 */

public class ConnectionStoreStringModel   {
  @JsonProperty("store")
  private String store;

  public ConnectionStoreStringModel store(String store) {
    this.store = store;
    return this;
  }

  /**
   * Get store
   * @return store
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getStore() {
    return store;
  }

  public void setStore(String store) {
    this.store = store;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConnectionStoreStringModel connectionStoreString = (ConnectionStoreStringModel) o;
    return Objects.equals(this.store, connectionStoreString.store);
  }

  @Override
  public int hashCode() {
    return Objects.hash(store);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnectionStoreStringModel {\n");
    
    sb.append("    store: ").append(toIndentedString(store)).append("\n");
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

