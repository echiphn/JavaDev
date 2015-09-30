package org.tdd.framework.mockito;

import java.util.ArrayList;
import java.util.List;

class Person {
	private List<String> friends;

    public Person() { }

    public Person(String name) {
        friends = new ArrayList<>();
    }

    public List<String> getFriends() {
        return friends;
    }

    public void addFriend(String friend) {
        if (!friends.contains(friend)) friends.add(friend);
    }

}