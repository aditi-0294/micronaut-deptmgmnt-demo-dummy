package com.service;

import com.model.ObjectFactory;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public interface DeptMgmtService {

    // get all department list
    public List<ObjectFactory> getAllDeptData();

    // get data for a particular department
    public List<ObjectFactory> getDeptDataById(int deptId);

}
