package com.ww.service;

import java.util.List;

/**
 * @Auther: lixin
 * @Date: 2020/10/17 16:55
 */
public interface AuthorizationService {

    List<String> selectRoleIdsByUserId(String userId);
}
