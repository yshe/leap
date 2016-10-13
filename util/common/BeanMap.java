package com.yabushan.test.util.common;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * <code>{@link BeanMap}</code>
 *
 * TODO : 实体类转换成map
 *
 * @author yabushan
 * 
 */
public class BeanMap {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Map<String,String> convertBean(Object bean)
            throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        Class type = bean.getClass();
        Map<String,String> returnMap = new HashMap();
        BeanInfo beanInfo = Introspector.getBeanInfo(type);

        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
        for (int i = 0; i< propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            if (!propertyName.equals("class")) {
                Method readMethod = descriptor.getReadMethod();
                String result = String.valueOf(readMethod.invoke(bean, new Object[0]));
                if (result != null) {
                    returnMap.put(propertyName, result);
                } else {
                    returnMap.put(propertyName, "");
                }
            }
        }
        return returnMap;
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Map<String,Object> convertBeanTOMap(Object bean)
    		throws IntrospectionException, IllegalAccessException, InvocationTargetException {
    	Class type = bean.getClass();
    	Map<String,Object> returnMap = new HashMap();
    	BeanInfo beanInfo = Introspector.getBeanInfo(type);
    	
    	PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
    	for (int i = 0; i< propertyDescriptors.length; i++) {
    		PropertyDescriptor descriptor = propertyDescriptors[i];
    		String propertyName = descriptor.getName();
    		if (!propertyName.equals("class")) {
    			Method readMethod = descriptor.getReadMethod();
    			Object result = readMethod.invoke(bean, new Object[0]);
    			if (result != null) {
    				returnMap.put(propertyName, result);
    			} else {
    				returnMap.put(propertyName, "");
    			}
    		}
    	}
    	return returnMap;
    }
}
