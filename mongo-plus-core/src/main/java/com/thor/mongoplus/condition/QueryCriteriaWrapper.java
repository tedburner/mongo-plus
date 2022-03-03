package com.thor.mongoplus.condition;


import com.thor.mongoplus.condition.interfaces.Compare;
import com.thor.mongoplus.condition.interfaces.Func;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * @author: lingjun.jlj
 * @date: 2022/3/3 22:28
 * @description: 查询包装类
 */
public class QueryCriteriaWrapper extends CriteriaWrapper {

    private Query query;

    public QueryCriteriaWrapper() {
        this.query = new Query();
    }
}
