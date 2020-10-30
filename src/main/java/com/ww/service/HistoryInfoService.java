package com.ww.service;

import java.util.List;
import java.util.Map;

/**
 * @Auther: lixin
 * @Date: 2020/10/17 16:55
 */
public interface HistoryInfoService {

    List<Map<String, Object>> myTasksCompleted(String userId);

    List<Map<String, Object>> myProcessStarted(String userId);
}
