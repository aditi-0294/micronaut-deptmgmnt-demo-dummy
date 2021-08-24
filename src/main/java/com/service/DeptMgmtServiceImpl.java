package com.service;

import com.model.ObjectFactory;
import com.utils.JsonUtil;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class DeptMgmtServiceImpl implements DeptMgmtService {

    @Inject
    private JsonUtil jsonUtil;

    public List<ObjectFactory> getAllDeptData() {
        List<ObjectFactory> objectFactory = new ArrayList<>();
        objectFactory = jsonUtil.getDepartmentDetailedListfromJson(objectFactory.getClass());
        // objectFactory = jsonUtil.getDepartmentDetailedListfromJson(ObjectFactory.class);
        // return (List<String>) ObjectFactory;
        return objectFactory;
    }

    @Override
    public List<ObjectFactory> getDeptDataById(int deptId) {
        return null;
    }
}
