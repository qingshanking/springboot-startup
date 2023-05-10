package com.yanqingshan.admin.common.core.mybatis.handler;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.yanqingshan.admin.common.core.domain.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 通用参数填充实现类
 * <p>
 * 如果没有显式的对通用参数进行赋值，这里会对通用参数进行填充、赋值
 *
 * @author yanqs
 * @date 2023年05月05日 16:36
 */
@Slf4j
@Component
public class DefaultDBFieldHandler implements MetaObjectHandler {
    /**
     * 插入填充字段
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.debug("插入前处理数据");
        if (Objects.nonNull(metaObject) && metaObject.getOriginalObject() instanceof BaseEntity) {
            BaseEntity baseEntity = (BaseEntity) metaObject.getOriginalObject();
            LocalDateTime current = LocalDateTime.now();

            // 创建时间为空，则以当前时间为插入时间
            if (Objects.isNull(baseEntity.getCreateTime())) {
                baseEntity.setCreateTime(current);
            }
            // 更新时间为空，则以当前时间为更新时间
            if (Objects.isNull(baseEntity.getUpdateTime())) {
                baseEntity.setUpdateTime(current);
            }
            // 根据Sa-token 获取当前登录用户
            String userId = Objects.nonNull(StpUtil.getLoginIdDefaultNull()) ? String.valueOf(StpUtil.getLoginIdDefaultNull()) : "test";
            // 当前登录用户不为空，创建人为空，则当前登录用户为创建人
            if (Objects.nonNull(userId) && Objects.isNull(baseEntity.getCreateBy())) {
                baseEntity.setCreateBy(userId);
            }
            // 当前登录用户不为空，更新人为空，则当前登录用户为更新人
            if (Objects.nonNull(userId) && Objects.isNull(baseEntity.getUpdateBy())) {
                baseEntity.setUpdateBy(userId);
            }
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.debug("更新前处理数据");
        // 根据Sa-token 获取当前登录用户
        String userId = Objects.nonNull(StpUtil.getLoginIdDefaultNull()) ? String.valueOf(StpUtil.getLoginIdDefaultNull()) : "test";
        // 更新时间为空，则以当前时间为更新时间
        Object modifyTime = getFieldValByName("updateTime", metaObject);
        if (Objects.isNull(modifyTime)) {
            setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        }
        //设置修改用户id
        setFieldValByName("updateBy", userId, metaObject);
    }
}
