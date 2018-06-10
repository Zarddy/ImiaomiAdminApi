package cn.imiaomi.admin.api.realm;

import cn.imiaomi.admin.api.dto.AuthTokenDTO;
import cn.imiaomi.admin.api.pojo.AuthUser;
import cn.imiaomi.admin.api.pojo.JWTToken;
import cn.imiaomi.admin.api.service.AuthUserService;
import cn.imiaomi.admin.api.util.AuthWebTokenUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用于处理用户是否合法
 */
@Service
public class ImiaoRealm extends AuthorizingRealm {

    @Autowired
    AuthUserService authUserService;

    /**
     * 必须重写此方法，不然shiro会报错
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如：checkRole，checkPermission之类
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole("role");
        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String token = String.valueOf(authenticationToken.getCredentials());
        AuthWebTokenUtil util = new AuthWebTokenUtil();
        AuthTokenDTO admin = util.parseAndValidate(token);

        if (admin == null) {
            throw new AuthenticationException("token invalid");
        }

        AuthUser authUser = authUserService.getUserByUsername(admin.getUsername());
        if (authUser == null) {
            throw new AuthenticationException("User didn't existed!"); // 用户不存在
        }

        return new SimpleAuthenticationInfo(token, token, this.getClass().getSimpleName());
    }
}
