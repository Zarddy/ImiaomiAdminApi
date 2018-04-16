package cn.imiaomi.admin.api.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ImiaoExceptionHandler {

    @ExceptionHandler
    public Object errorHandler(HttpServletRequest request,
                               HttpServletResponse response,
                               Exception exception) throws Exception {
        // TODO 出错处理
        return null;
    }
}
