package com.example.rest.greeting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import com.example.rest.greeting.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    
    @Query(value = "SELECT p.slug, p.title, p.body, p.created_at, u.name "
                + "FROM Users u INNER JOIN Posts p ON u.id=p.userid", nativeQuery = true)
    List<Object[]> getAllUserPosts();

    @Query(value = "SELECT p.slug, p.title, p.body, p.created_at, u.name "
                + "FROM Users u INNER JOIN Posts p ON u.id=p.userid "
                + "WHERE u.id=:userid", nativeQuery = true)
    List<Object[]> getAllUserPosts(@Param("userid") int userid);

    @Query(value = "SELECT * FROM Users u WHERE UPPER(u.name)=UPPER(?1)", nativeQuery = true)
	Optional<Users> getUserByName(String name);

    Optional<Users> findByEmail(String email);

    Optional<Users> findByusername(String userName);

    @Modifying
    @Transactional
    @Query(
        "UPDATE Users u " 
        + "SET u.name=:name,u.zipcode=:zipcode,u.email=:email,u.password=:password "
        + "WHERE u.id=:userid"
    )
    int updateUserById(
        @Param("userid") Long userId,
        @Param("name") String name,
        @Param("zipcode") String zipcode,
        @Param("email") String email,
        @Param("password") String password

        );
}
