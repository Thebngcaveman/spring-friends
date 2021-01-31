package com.thecaveman.friends.springfriends.repository;

import com.thecaveman.friends.springfriends.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long > {

}
