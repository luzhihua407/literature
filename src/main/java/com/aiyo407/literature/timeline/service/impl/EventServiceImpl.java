package com.aiyo407.literature.timeline.service.impl;

import com.aiyo407.literature.timeline.entity.TimelineEvent;
import com.aiyo407.literature.timeline.mapper.EventMapper;
import com.aiyo407.literature.timeline.service.IEventService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 时间轴事件 服务实现类
 * </p>
 *
 * @author luzh
 * @since 2021-10-19
 */
@Service
public class EventServiceImpl extends ServiceImpl<EventMapper, TimelineEvent> implements IEventService {

}
