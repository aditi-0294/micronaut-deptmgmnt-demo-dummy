package com.controller;

import com.model.ObjectFactory;
import com.service.DeptMgmtService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Controller("/dept-controller")
public class DeptMgmtController {

    private static Logger logger = LoggerFactory.getLogger(DeptMgmtController.class);

    @Inject
    private DeptMgmtService deptMgmtService;

    public DeptMgmtController(DeptMgmtService deptMgmtService) {
        this.deptMgmtService = deptMgmtService;
    }

    @Get("/getAllDeptData")
    @Produces(MediaType.APPLICATION_JSON)
    /*public List<ObjectFactory> getAllDeptData() {
        return deptMgmtService.getAllDeptData();
        //return null;
    }*/
    public HttpResponse<List<ObjectFactory>> getAllDeptData() {
        logger.info("Getting all department data : {}", deptMgmtService.getAllDeptData());
        return HttpResponse.ok(deptMgmtService.getAllDeptData());
    }

    @Get("/getDeptDataById/{deptId}")
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<ObjectFactory> getDeptDataById(@PathVariable int deptId) {
        logger.info("department id. passed : {}", deptId);
        logger.info("department details :- {}", deptMgmtService.getDeptDataById(deptId));
        Optional<ObjectFactory> optional = Optional.ofNullable(
                deptMgmtService.getDeptDataById(deptId)
        );

        if(optional.isPresent())
            return HttpResponse.ok(deptMgmtService.getDeptDataById(deptId));
        else
            return HttpResponse.notFound();

    }

    @Post("/addNewDept")
    @Consumes(MediaType.APPLICATION_JSON)
    public HttpResponse<ObjectFactory> createNewDepartment(@Body ObjectFactory objectFactory) {
      return HttpResponse.ok(deptMgmtService.createNewDepartment(objectFactory));
    }

}
