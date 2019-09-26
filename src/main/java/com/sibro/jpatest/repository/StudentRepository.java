package com.sibro.jpatest.repository;

import com.sibro.jpatest.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository()
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
    /*
     * 根据用户名查询
     * */
    @Query("select t from StudentEntity t where t.name = :name")
    StudentEntity findByStudentName(@Param("name") String name);

    /*
     * 查询全部
     * */
    @Query("select t from StudentEntity t")
    List<StudentEntity> find();

    /*
     * 删除  必须加入@Modifying和@Transactional
     * */
    @Modifying
    @Transactional
    @Query("delete from StudentEntity u where u.id=:id")
    int deleteStudentById(@Param("id") Integer id);


    /*
     * 修改
     * */
    @Modifying
    @Transactional
    @Query("update StudentEntity u set u.name = :name where u.id=:id")
    int queryStudentById(@Param("id") Integer id,@Param("name") String name);

    /*
    * 插入
    * */
    @Transactional
    @Modifying
    @Query(value = "insert into student value(?,?,?)", nativeQuery = true)
    int insertStudentBy(@Param("name")Integer name,@Param("sex") String sex,@Param("teacher") String teacher);
}
