package com.thor.mongoplus.condition;

import com.thor.mongoplus.condition.interfaces.Func;
import com.thor.mongoplus.util.ReflectLambdaUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * @author: lingjun.jlj
 * @date: 2022/3/3 22:27
 * @description: 定义包装类
 */
public abstract class CriteriaWrapper {

    private Query query;

    /**
     * 将 wrapper 转换成 criteria
     *
     * @return
     */
    public Criteria build() {

        return new Criteria();
    }

    /**
     * 等于 =
     *
     * @param column 字段
     * @param param    值
     * @return children
     */
    public <E, R> CriteriaWrapper eq(Func<E, R> column, Object param){
        query.addCriteria(Criteria.where(ReflectLambdaUtils.getFieldName(column)).is(param));
        return this;
    }
}
