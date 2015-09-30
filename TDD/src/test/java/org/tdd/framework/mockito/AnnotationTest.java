package org.tdd.framework.mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AnnotationTest {
	@InjectMocks
	FriendshipsMongo friendships;
	@Mock
	FriendsCollection friends;

	@Test
	public void testMockito() {
		Person joe = new Person("Joe");
		doReturn(joe).when(friends).findByName("Joe");
		assertThat(friends.findByName("Joe")).isEqualTo(joe);
	}

	@Test
	public void joeHas5Friends() {
		List<String> expected = Arrays.asList("Audrey", "Peter", "Michael",
				"Britney", "Paul");
		Person joe = spy(new Person("Joe"));

		doReturn(joe).when(friends).findByName("Joe");
		doReturn(expected).when(joe).getFriends();

		assertThat(friendships.getFriendsList("Joe")).hasSize(5).containsOnly(
				"Audrey", "Peter", "Michael", "Britney", "Paul");
	}

}
