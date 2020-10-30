package com.ww.service;

import java.util.List;
import java.util.Map;

/**
 * @Auther: lixin
 * @Date: 2020/10/17 16:55
 */
public interface RuntimeInfoService {

    List<Map<String, Object>> myTasks(String userId);

    boolean rejected(String taskId, String rejectElemKey, String dealReason);
}
