package cn.imiaomi.admin.api.controller;

import cn.imiaomi.admin.api.http.HttpResult;
import cn.imiaomi.admin.api.http.HttpStatusCode;
import cn.imiaomi.admin.api.http.HttpUtils;
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
    HttpResult unauthorized(HttpServletRequest request, HttpServletResponse response) {
        return HttpUtils.initResponseResult(response, HttpStatusCode.NO_PERMISSION, "Unauthorized", null);
    }

    @RequestMapping(path = "/403")
    @ResponseStatus(HttpStatus.OK)
    HttpResult forbidden(HttpServletRequest request, HttpServletResponse response) {
        return HttpUtils.initResponseResult(response, HttpStatusCode.FORBIDDEN, "forbidden", null);
    }

    @RequestMapping(path = "/404")
    @ResponseStatus(HttpStatus.OK)
    HttpResult notFound(HttpServletRequest request, HttpServletResponse response) {
        return HttpUtils.initResponseResult(response, HttpStatusCode.NOT_FOUND, "Page not found", null);
    }
}
