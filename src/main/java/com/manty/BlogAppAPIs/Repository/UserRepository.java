package com.manty.BlogAppAPIs.Repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.manty.BlogAppAPIs.Entity.User;


public interface UserRepository extends JpaRepository<User, Integer>{

}
