package com.zj.demo.repository;

import com.zj.demo.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Creator: zhuji
 * Date: 2018/10/28
 * Time: 11:00
 * Description:
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
