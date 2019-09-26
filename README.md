#练习jpa的项目
##首先需要hibernate和mysql的jar

###小记：
    在jpa的使用中，它的增删改查都放在repository中，这里有两种方式实现：
    1.用类似于jdbc的写法(例子在package com.sibro.jpatest.dao下)
    
        要先建立HibernateSessionFactory工具类用来从
        EntityManagerFactory中获取EntityManager对象
        
        它的每次进行增删改查都需要
        EntityManager entityManager = HibernateSessionFactory.getEntityManager();
        entityManager.getTransaction().begin();
        *这里增删改查*
        entityManager.getTransaction().commit();
        entityManager.close();
        
    2.注解形式：这种可利用jpql语法(例子在package com.sibro.jpatest.repository下)
        需要在package com.sibro.jpatest下创建JpaConfiguration
        用来配置entity和reposity的位置
        
<font color=#008000>注：不用注解的形式需要persistence.xml(在resources.META-INF下)来配置jpa</font>