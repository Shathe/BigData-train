/**
 *  Author: Inigo Alonso Ruiz
 */

package java8features;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Example Class used to try out the new lambda expressions of Java 8
 * 
 * @author inigo
 * 
 */
public class LambdaExpressions {

	/**
	 * Prints the content (each element) of an ArrayList
	 * 
	 * @param list
	 */
	public static void printArrayList(ArrayList<?> list) {
		list.forEach(e -> {
			System.out.println(e.toString());
		});

		System.out.println();
	}

	public static void main(String[] args) {

		// listing the elements of an array
		ArrayList<String> array = new ArrayList<>();
		array.add("Lambda Expressions");
		array.add("wiiiiiiiiiiiiiii");

		System.out.print("You can do a lot of cool things with ");
		printArrayList(array);

		// Lists
		ArrayList<Player> players = new ArrayList<>();
		ArrayList<User> users = new ArrayList<>();

		// Data: Player: {name,value}
		players.add(new Player(1, 200));
		players.add(new Player(2, 150));
		players.add(new Player(3, 350));
		players.add(new Player(4, 210));
		players.add(new Player(5, 280));

		// Data: User: {name,age}
		users.add(new User(1, 21));
		users.add(new User(2, 17));
		users.add(new User(3, 35));
		users.add(new User(4, 21));
		users.add(new User(6, 25));

		
		// Filtering users who are over 30
		ArrayList<User> olderUsers = (ArrayList<User>) users.stream()
				.filter(u -> u.getAge() > 30 /* you can set more filters */).collect(Collectors.toList());
		System.out.println("Old users ( > 30 ):");
		printArrayList(olderUsers);

		/*
		 * Getting the users who are also players (Mapping and joining through
		 * their names)
		 */

		// Get the player names (the valid names)
		Set<Integer> playerDnis = players.stream().map(Player::getDni).collect(Collectors.toSet());

		// Filter the users whose name are in the playerNames list
		ArrayList<User> UsersWhoPlays = (ArrayList<User>) users.stream().filter(c -> playerDnis.contains(c.getDni()))
				.collect(Collectors.toList());

		System.out.println("Users who are also players:");
		printArrayList(UsersWhoPlays);

		// Gets the maximun value of a player. If this value is less than 200, gets 200
		final int min = 200;
		OptionalInt maxValue = players.stream().filter(player -> player.getValue() > min).mapToInt(Player::getValue).max();

		System.out.println("Max value: " + maxValue.orElseGet(() -> min));

		// Gets the adition of the ages of every user
		int totalAges = users.stream().parallel().map(user -> user.getAge()) // or
																				// map(
																				// User::getAge
																				// )
				.reduce(0, Integer::sum);

		System.out.println("Total ages: " + totalAges);
		System.out.println("Average age: " + (double) totalAges / users.size());
		System.out.println();
		System.out.println(" Users grouped by the age");
		// Users grouped by the age
		Map<Integer, List<User>> map = users.stream().collect(Collectors.groupingBy(User::getAge));
		System.out.println(map);
		System.out.println();
		System.out.println("percentage of the age of every user over the group");
		// Gets the percentage of the age of every user over the group
		Collection<String> result = users.stream().mapToInt(User::getAge) // Get every age
				.asLongStream() // Gets its stream
				.mapToDouble(points -> points * 100 / totalAges) // Gets its percentage
				.mapToObj(percentage -> percentage + "%") // gets the string
															// with the '%'
				.collect(Collectors.toList()); // Gets the list
		System.out.println(result);

	}

}
