package com.thor.mongoplus.util;

import com.thor.mongoplus.condition.interfaces.Func;
import com.thor.mongoplus.exception.MongoPlusException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import java.beans.Introspector;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: lingjun.jlj
 * @date: 2022/3/3 22:55
 * @description: 针对对象的字段，获取字段内容
 */
public class ReflectLambdaUtils {

    private static final Logger logger = LoggerFactory.getLogger(ReflectLambdaUtils.class);

    /**
     * 根据参数获取字段名称
     *
     * @param func
     * @return
     */
    public static <E, R> String getFieldName(Func<E, R> func) {
        Field field = getField(func);
        // 判断实体类上是否定义注解
        if (field.isAnnotationPresent(org.springframework.data.mongodb.core.mapping.Field.class)) {
            org.springframework.data.mongodb.core.mapping.Field fd =
                    field.getAnnotation(org.springframework.data.mongodb.core.mapping.Field.class);
            String value = fd.value();
            String name = fd.name();
            if (StringUtils.isNoneBlank(value)) {
                return value;
            }
            if (StringUtils.isNotBlank(name)) {
                return name;
            }
        }
        return field.getName();
    }

    /**
     * 获取表达式的字段
     *
     * @param func
     * @return
     */
    public static <E, R> Field getField(Func<E, R> func) {
        try {
            Method method = func.getClass().getDeclaredMethod("writeReplace");
            method.setAccessible(Boolean.TRUE);
            // 调用 writeReplace 方法，返回一个 writeReplace 对象
            SerializedLambda serializedLambda = (SerializedLambda) method.invoke(func);
            String getterMethod = serializedLambda.getImplMethodName();
            String fieldName = Introspector.decapitalize(getterMethod.replace("get", ""));

            // 第3步 获取的Class是字符串，并且包名是“/”分割，需要替换成“.”，才能获取到对应的Class对象
            String declaredClass = serializedLambda.getImplClass().replace("/", ".");
            Class<?> aClass = Class.forName(declaredClass, false, ClassUtils.getDefaultClassLoader());

            // 第4步 Spring 中的反射工具类获取Class中定义的Field
            return ReflectionUtils.findField(aClass, fieldName);
        } catch (ReflectiveOperationException e) {
            logger.error("解析类字段出现异常", e);
            throw new MongoPlusException("解析字段时出现异常");
        }
    }
}
