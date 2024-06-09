package org.example.helloworld.repo;

import org.example.helloworld.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query("select count(*) from sys_user where username=?1")
    int findByName(String username);

    @Query("select count(*) from sys_user where username=?1 and password=?2")
    int login(String username, String password);

    @Modifying
    @Query("insert into sys_user (username,password) values (?1,?2)")
    void register(String username, String password);
}
