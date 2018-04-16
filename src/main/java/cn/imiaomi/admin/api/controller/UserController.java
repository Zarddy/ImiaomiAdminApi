package cn.imiaomi.admin.api.controller;

import cn.imiaomi.admin.api.pojo.JsonResult;
import cn.imiaomi.admin.api.service.impl.AuthUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// TODO https://www.jianshu.com/p/6307c89fe3fa

@RestController
public class UserController {

    @Autowired
    AuthUserServiceImpl userService;

    @PostMapping(value = "/login")
    JsonResult loginUser(
            @RequestParam(defaultValue = "") String account,
            @RequestParam(defaultValue = "") String password) {
        return JsonResult.ok(userService.getUserByAccountPassword(account, password));
    }
}
