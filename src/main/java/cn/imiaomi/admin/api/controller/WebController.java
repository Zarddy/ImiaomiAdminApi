package cn.imiaomi.admin.api.controller;

import cn.imiaomi.admin.api.pojo.JsonResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @RequestMapping(path = "/401")
    @ResponseStatus(HttpStatus.OK)
    JsonResult unauthorized() {
        return new JsonResult(401, "Unauthorized", null);
    }

    @RequestMapping(path = "/403")
    @ResponseStatus(HttpStatus.OK)
    JsonResult forbidden() {
        return new JsonResult(403, "Page not found", null);
    }

    @RequestMapping(path = "/404")
    @ResponseStatus(HttpStatus.OK)
    JsonResult notFound() {
        return new JsonResult(404, "Page not found", null);
    }
}
