package com.ww.activiti.listener;

import org.activiti.engine.delegate.event.ActivitiEvent;

public interface EventHandler {
    void handle(ActivitiEvent event);
}
