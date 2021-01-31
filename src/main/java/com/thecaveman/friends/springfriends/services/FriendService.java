package com.thecaveman.friends.springfriends.services;

import com.thecaveman.friends.springfriends.model.Friend;

import java.util.List;


public interface FriendService {
    List<Friend> getAllFriends();
    void saveFriends(Friend friend);
    Friend getFriendsById(long id);
    void deleteFriendsById(long id);
}
