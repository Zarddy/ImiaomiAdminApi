package cn.imiaomi.admin.api.controller;

import cn.imiaomi.admin.api.pojo.JsonResult;
import cn.imiaomi.admin.api.util.HttpUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class WebController {

    @RequestMapping(path = "/401")
    @ResponseStatus(HttpStatus.OK)
    JsonResult unauthorized(HttpServletRequest request, HttpServletResponse response) {
        return HttpUtils.initResponseResult(response, 401, "Unauthorized", null);
    }

    @RequestMapping(path = "/403")
    @ResponseStatus(HttpStatus.OK)
    JsonResult forbidden(HttpServletRequest request, HttpServletResponse response) {
        return HttpUtils.initResponseResult(response, 403, "forbidden", null);
    }

    @RequestMapping(path = "/404")
    @ResponseStatus(HttpStatus.OK)
    JsonResult notFound(HttpServletRequest request, HttpServletResponse response) {
        return HttpUtils.initResponseResult(response, 404, "Page not found", null);
    }
}
