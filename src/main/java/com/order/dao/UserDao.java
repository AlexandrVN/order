package com.order.dao;

import com.order.entity.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

}
