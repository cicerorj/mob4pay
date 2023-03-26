package com.example.mob4pay.openFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "userFromDummy", url = "${business.openfeign.api.urls.dummy-json}")
public interface GetUsersFromDummy {

    @RequestMapping(method = RequestMethod.GET, value = "/users", produces = "application/json")
    String getUsers();
}
