package com.thecaveman.friends.springfriends.services;

import com.thecaveman.friends.springfriends.model.Friend;
import com.thecaveman.friends.springfriends.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//implement from ../services/FriendService || interface
@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    private FriendRepository friendRepository;

    @Override
    public List<Friend> getAllFriends() {
        return friendRepository.findAll(); //return everything
    }

    @Override
    public void saveFriends(Friend friend) {
        this.friendRepository.save(friend);
    }

    @Override
    public Friend getFriendsById(long id) {
        Optional<Friend> optional = friendRepository.findById(id);
        Friend friend = null;
        if(optional.isPresent()){
            friend = optional.get();
        }
        else{
            throw new RuntimeException(" Friend not found ::"+id);
        }
        return friend;
    }

    @Override
    public void deleteFriendsById(long id) {
        this.friendRepository.deleteById(id);
    }
}
