package com.db.poc.dbpoc.repository;

import com.db.poc.dbpoc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from users where username = :param1", nativeQuery = true)
    User findByUserName(@Param("param1") String uName);

}
