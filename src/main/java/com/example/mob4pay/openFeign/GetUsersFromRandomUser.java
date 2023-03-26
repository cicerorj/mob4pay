package com.example.mob4pay.openFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "userFromRandomUser", url = "${business.openfeign.api.urls.random-user}")
public interface GetUsersFromRandomUser {

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    String getUsers();
}
