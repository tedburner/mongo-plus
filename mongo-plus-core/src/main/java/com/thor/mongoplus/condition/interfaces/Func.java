package com.thor.mongoplus.condition.interfaces;

import java.io.Serializable;
import java.util.function.Function;

/**
 * @author: lingjun.jlj
 * @date: 2022/3/3 23:04
 * @description:
 */
@FunctionalInterface
public interface Func <E, R> extends Function<E, R>, Serializable {
}
