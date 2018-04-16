package cn.imiaomi.admin.api.service;

import cn.imiaomi.admin.api.pojo.AuthUser;

public interface AuthUserService {

    AuthUser getUserByAccountPassword(String account, String password);
}
