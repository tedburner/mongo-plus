package com.thor;

import static org.junit.Assert.assertTrue;

import com.thor.mongoplus.util.ReflectLambdaUtils;
import com.thor.mongoplus.util.UserInfo;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(20);
        userInfo.setName("张三");
        System.out.println(ReflectLambdaUtils.getFieldName(UserInfo::getAge));
    }
}
