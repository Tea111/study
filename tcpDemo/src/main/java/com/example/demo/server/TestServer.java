package com.example.demo.server;

import com.example.demo.model.TestModel;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @User: WMJ
 * @create: 2019/9/5
 * @Description: No Description
 */
public class TestServer {

    public static void main(String[] arg) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        TestModel model = new TestModel("111",22);
        Class classzz = model.getClass();

        ConcurrentSkipListMap map = new ConcurrentSkipListMap();
        List list = new LinkedList();


        Field[] fields = classzz.getDeclaredFields();
        for (Field field : fields) {
            String key = field.getName();
            PropertyDescriptor descriptor = new PropertyDescriptor(key, classzz);
            Method method = descriptor.getReadMethod();
            Object value = method.invoke(model);

            System.out.println(key + ":" + value);

        }

        int i = 10;
        int m = i + (i>>1);
        System.out.println(m);

    }
}
