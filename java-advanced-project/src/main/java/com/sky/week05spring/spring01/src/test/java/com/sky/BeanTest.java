package com.sky;

import com.sky.entity.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {

    @Test
    public void testXml(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student studentByXml = (Student) context.getBean("studentByXml");
        System.out.println(studentByXml);
    }

    public void testAnnotation(){

    }
}
