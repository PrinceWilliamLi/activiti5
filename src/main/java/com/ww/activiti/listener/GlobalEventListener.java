package com.ww.activiti.listener;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.event.ActivitiEntityEvent;
import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.activiti.engine.delegate.event.ActivitiEventType;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.task.IdentityLink;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
@Component
public class GlobalEventListener implements ActivitiEventListener {

    protected Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 各类 Event 的处理器
     */
    private Map<ActivitiEventType, EventHandler> handlers = new HashMap<ActivitiEventType, EventHandler>();



    @Override
    public void onEvent(ActivitiEvent event) {
        // TODO Auto-generated method stub
        String processInstanceId = event.getProcessInstanceId();
        logger.debug("processInstanceId {}",processInstanceId);


        logger.debug("事件类型 {}",event.getType());

        if(event.getType().equals(ActivitiEventType.TASK_ASSIGNED)){
            ActivitiEntityEvent entityEvent = (ActivitiEntityEvent) event;
            TaskEntity taskEntity = (TaskEntity) entityEvent.getEntity();
            String assignee = taskEntity.getAssignee();
            if(StringUtils.isNotBlank(assignee)){
                // 给assignee发信息
                logger.debug("assignee {}",assignee);
            }else{
                // 如果走这里那说明人是候选人或者候选组
                Set<IdentityLink> identityLinkList = taskEntity.getCandidates();
                if(!identityLinkList.isEmpty()){
                    for (IdentityLink identityLink : identityLinkList) {
                        // 这个userid是候选用户id
                        String userId = identityLink.getUserId();
                        // 这个groupid是候选组
                        String groupId = identityLink.getGroupId();
                        logger.debug("你好啊+userId :{},groupId :{}",userId,groupId);
                    }
                }
/*            	taskEntity.getIdentityLinks();

            	taskEntity.getCandidates();*/
            }
        }
    }

    @Override
    public boolean isFailOnException() {
        return false;
    }

    public Map<ActivitiEventType, EventHandler> getHandlers() {
        return handlers;
    }

    public void setHandlers(Map<ActivitiEventType, EventHandler> handlers) {
        this.handlers = handlers;
    }

}
