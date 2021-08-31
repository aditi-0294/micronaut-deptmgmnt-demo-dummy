package com.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.model.ObjectFactory;
import com.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class DeptMgmtServiceImpl implements DeptMgmtService {

    private static final Logger logger = LoggerFactory.getLogger(DeptMgmtServiceImpl.class);

    @Inject
    private JsonUtil jsonUtil;

    // get details of all departments
    public List<ObjectFactory> getAllDeptData() {
        List<ObjectFactory> allDeptData = new ArrayList<>();
        allDeptData = jsonUtil.fromJson(allDeptData.getClass());

        return allDeptData;
    }

    // get details of department based on department id.
    @Override
    public ObjectFactory getDeptDataById(int deptId) {
        List<ObjectFactory> deptDataById;
        deptDataById = jsonUtil.fromJson(
                new TypeReference<List<ObjectFactory>>() {
                });

        // code logic works but need to update the code logic

        for(ObjectFactory ob : deptDataById) {
            if(deptId !=0) {
            if(deptId == ob.getDeptId()) {
                    deptId = deptId-1;
                    ob = deptDataById.get(deptId);
                    return ob;
                }

            }
            else
                return null;

        }

        return null;
    }

    // create new department
    @Override
    public ObjectFactory createNewDepartment(ObjectFactory objectFactory) {
        List<ObjectFactory> addNewDept = new ArrayList<>();
        addNewDept = jsonUtil.fromJson(
                new TypeReference<List<ObjectFactory>>() {
                });

        objectFactory.setDeptId(addNewDept.size()+1);
        addNewDept.add(objectFactory);

        /*logger.debug("Writing to json file :- ");
        jsonUtil.toJson(objectFactory);
        logger.debug(jsonUtil.toJson(objectFactory));*/


       return objectFactory;
    }
}
