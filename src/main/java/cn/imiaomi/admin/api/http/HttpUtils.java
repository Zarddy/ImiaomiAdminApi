package cn.imiaomi.admin.api.http;

import javax.servlet.http.HttpServletResponse;

public class HttpUtils {

    public static final String HEADER_AUTHORIZATION = "Authorization";

    public static void setupResponseHeader(HttpServletResponse response) {
        if (null == response)
            return;

        //这里填写你允许进行跨域的主机ip
        response.setHeader("Access-Control-Allow-Origin", "*");
        //允许的访问方法
        response.setHeader("Access-control-Allow-Methods", "POST, GET, OPTIONS");
        //Access-Control-Max-Age 用于 CORS 相关配置的缓存
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Authorization, Origin, X-Requested-With, Content-Type, Accept");
    }

    public static HttpResult initResponseResult(HttpServletResponse response,
                                                HttpStatusCode code,
                                                String msg) {
        return initResponseResult(response, code, msg, 0, null);
    }

    public static HttpResult initResponseResult(HttpServletResponse response,
                                                HttpStatusCode code,
                                                String msg,
                                                Object result) {
        return initResponseResult(response, code, msg, 0, result);
    }

    public static HttpResult initResponseResult(HttpServletResponse response,
                                                HttpStatusCode code,
                                                String msg,
                                                long total,
                                                Object result) {
        setupResponseHeader(response);

        HttpResult httpResult = new HttpResult();
        httpResult.setCode(code.value());
        httpResult.setMsg(msg);
        httpResult.setTotal(total);
        httpResult.setResult(result);
        return httpResult;
    }
}
