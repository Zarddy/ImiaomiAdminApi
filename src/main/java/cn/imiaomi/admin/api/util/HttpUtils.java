package cn.imiaomi.admin.api.util;

import cn.imiaomi.admin.api.pojo.JsonResult;

import javax.servlet.http.HttpServletResponse;

public class HttpUtils {

    public static final String HEADER_AUTHORIZATION = "Authorization";

    public static void setupResponseHeader(HttpServletResponse response) {
        //这里填写你允许进行跨域的主机ip
        response.setHeader("Access-Control-Allow-Origin", "*");
        //允许的访问方法
        response.setHeader("Access-control-Allow-Methods", "POST, GET, OPTIONS");
        //Access-Control-Max-Age 用于 CORS 相关配置的缓存
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Authorization, Origin, X-Requested-With, Content-Type, Accept");
    }

    public static JsonResult initResponseResult(HttpServletResponse response,
                                                int status, String msg, Object data) {
        setupResponseHeader(response);
        return new JsonResult(status, msg, data);
    }
}
