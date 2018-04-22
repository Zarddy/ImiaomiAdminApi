package cn.imiaomi.admin.api.controller;

import cn.imiaomi.admin.api.pojo.AuthUser;
import cn.imiaomi.admin.api.pojo.JWTToken;
import cn.imiaomi.admin.api.pojo.JsonResult;
import cn.imiaomi.admin.api.service.impl.AuthUserServiceImpl;
import cn.imiaomi.admin.api.util.JWTUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// TODO 当前使用 https://www.jianshu.com/p/f37f8c295057
// TODO https://www.jianshu.com/p/6307c89fe3fa

@RestController
public class UserController {

    @Autowired
    AuthUserServiceImpl userService;

    @PostMapping(value = "/login")
    JsonResult loginUser(
            @RequestParam(defaultValue = "") String account,
            @RequestParam(defaultValue = "") String password) {
        AuthUser authUser = userService.getUserByAccountPassword(account, password);
        if (authUser == null) {
            return JsonResult.errorException("登录失败");

        } else {
            return JsonResult.ok(new JWTToken(JWTUtils.sign(account, password)));
        }
    }

    /**
     * 登入的用户才可以进行访问
     * @return
     */
    @RequestMapping("/require_auth")
    @RequiresAuthentication
    JsonResult requireAuth() {
        return new JsonResult(200, "You are authenticated", null);
    }
}
