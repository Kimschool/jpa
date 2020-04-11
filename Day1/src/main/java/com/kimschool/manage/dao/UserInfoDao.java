package com.kimschool.manage.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kimschool.manage.entity.User_Info;

@Component
//@Transactional
public class UserInfoDao {

//	@PersistenceContext
//    EntityManager em;
//
//    public List<UserInfo> findAll(){
//        String jpql = "SELECT id, password, auth, reg_date from user_info";
//        TypedQuery<UserInfo> query = em.createQuery(jpql, UserInfo.class);
//        return query.getResultList();
//    }



}
