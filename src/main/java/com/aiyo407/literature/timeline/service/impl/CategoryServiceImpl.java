package com.aiyo407.literature.timeline.service.impl;

import com.aiyo407.literature.timeline.entity.Category;
import com.aiyo407.literature.timeline.mapper.CategoryMapper;
import com.aiyo407.literature.timeline.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 时间轴分类 服务实现类
 * </p>
 *
 * @author luzh
 * @since 2021-10-19
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
