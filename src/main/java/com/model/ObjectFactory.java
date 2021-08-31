package com.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "deptId",
        "deptName",
        "deptLocation",
        "employeeDetails"
})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Introspected
public class ObjectFactory implements Serializable {

    @JsonProperty("deptId")
    public Integer deptId;

    @JsonProperty("deptName")
    public String deptName;

    @JsonProperty("deptLocation")
    public String deptLocation;

    @JsonProperty("employeeDetails")
    public List<EmployeeDetails> employeeDetails;
    private final static long serialVersionUID = 3110017670998166390L;

}
