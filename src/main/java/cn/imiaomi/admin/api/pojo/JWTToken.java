package cn.imiaomi.admin.api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.shiro.authc.AuthenticationToken;

public class JWTToken implements AuthenticationToken {

    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @JsonIgnore
    @Override
    public Object getPrincipal() {
        return token;
    }

    @JsonIgnore
    @Override
    public Object getCredentials() {
        return token;
    }

    public String getToken() {
        return token;
    }
}
