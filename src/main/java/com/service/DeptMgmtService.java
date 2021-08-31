package com.service;

import com.model.ObjectFactory;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public interface DeptMgmtService {

    // get all department list
    public List<ObjectFactory> getAllDeptData();

    // get data for a particular department
    public ObjectFactory getDeptDataById(int deptId);

    // creating new department details
    public ObjectFactory createNewDepartment(ObjectFactory objectFactory);



}
