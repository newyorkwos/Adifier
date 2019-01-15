package com.adifier.util;

import com.adifier.domain.ProductInfo;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: create Bean Utility
 * @author: StevenWu
 * @create: 2019-01-15 14:58
 **/

public class CustomBeanUtils {

    /**
     * get null value of properties
     * @param source
     * @return
     */
    public static String[] getNullpropertyNames(Object source){
        BeanWrapper beanWrapper=new BeanWrapperImpl(source);
        PropertyDescriptor[] pds=beanWrapper.getPropertyDescriptors();
        List<String> nullProperNames=new ArrayList<>();
        for(PropertyDescriptor pd:pds){
            String propertyName=pd.getName();
            if(beanWrapper.getPropertyValue(propertyName)==null){
                nullProperNames.add(propertyName);
            }
        }
        return nullProperNames.toArray(new String[nullProperNames.size()]);


    }
}
