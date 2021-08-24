package com.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "empId",
        "empName",
        "emailId"
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetails implements Serializable {

    @JsonProperty("empId")
    public Integer empId;

    @JsonProperty("empName")
    public String empName;

    @JsonProperty("emailId")
    public String emailId;

    private final static long serialVersionUID = -7045996746488513959L;
}
