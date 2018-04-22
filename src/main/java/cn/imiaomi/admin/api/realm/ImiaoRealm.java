package cn.imiaomi.admin.api.realm;

import cn.imiaomi.admin.api.pojo.AuthUser;
import cn.imiaomi.admin.api.pojo.JWTToken;
import cn.imiaomi.admin.api.service.AuthUserService;
import cn.imiaomi.admin.api.util.JWTUtils;
import com.alibaba.druid.util.StringUtils;
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

        String username = JWTUtils.getUsername(principalCollection.toString());
        AuthUser authUser = authUserService.getUserByUsername(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole("role");
//        Set<String> permissions = new HashSet<>(Arrays.asList());
//        simpleAuthorizationInfo.addStringPermissions(permissions);
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

        String token = (String) authenticationToken.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtils.getUsername(token);
        if (StringUtils.isEmpty(username)) {
            throw new AuthenticationException("token invalid");
        }

        AuthUser authUser = authUserService.getUserByUsername(username);
        if (authUser == null) {
            throw new AuthenticationException("User didn't existed!");
        }

        if (!JWTUtils.verify(token, username, authUser.getPassword())) {
            throw new AuthenticationException("Username or password error");
        }

        return new SimpleAuthenticationInfo(token, token, "imiao_realm");
    }
}
