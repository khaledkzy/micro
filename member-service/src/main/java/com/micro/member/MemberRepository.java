package com.micro.member;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *  JpaRepository<User, Integer>
 *      User = The name of the entity to store
 *      Integer = Data type of the id
 */
public interface MemberRepository extends JpaRepository<Member, Integer> {
}
