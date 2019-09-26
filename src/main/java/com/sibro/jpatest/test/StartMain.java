package com.sibro.jpatest.test;

import com.sibro.jpatest.dao.StudentDAO;
import com.sibro.jpatest.entity.StudentEntity;
import com.sibro.jpatest.repository.StudentRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
@Component
public class StartMain implements Runnable {
    @Autowired
    private StudentRepository stuRepository;
    @Resource
    private StudentDAO studao;

    @Override
    public void run() {
        find();
    }

    @Test
    public void create(){
        StudentEntity studentEntity=new StudentEntity();
        studentEntity.setName("小明");
        studentEntity.setSex(2);
        studentEntity.setTeacher("蚊子哥");
        studao.save(studentEntity);
    }

    @Test
    public void find(){
        List<StudentEntity> stus = stuRepository.find();
        System.out.println("repository方式查询：");
        for (StudentEntity e : stus){
             System.out.println("编号:"+e.getId()+"   姓名："+e.getName()+"   性别："+e.getSex()+"   老师："+e.getTeacher());
        }
        System.out.println("DAO方式查询：");
        List<StudentEntity> stus2 = studao.findAll();
        for (StudentEntity e : stus2){
            System.out.println("编号:"+e.getId()+"   姓名："+e.getName()+"   性别："+e.getSex()+"   老师："+e.getTeacher());
        }
    }
    @Test
    public void insert(){
        System.out.println(1111111111);
    }
    @Test
    public void delete(){
        System.out.println(1111111111);
    }
}
