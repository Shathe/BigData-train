/**
 *  Author: Inigo Alonso Ruiz
 */

package java8features;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
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
		array.add("Lambda");
		array.add("Expressions");

		System.out.print("You can do a lot of cool things with ");
		printArrayList(array);

		// Lists
		ArrayList<Player> players = new ArrayList<>();
		ArrayList<User> users = new ArrayList<>();

		// Data: Player: {name,value}
		players.add(new Player("David", 200));
		players.add(new Player("Alex", 150));
		players.add(new Player("Christian", 350));
		players.add(new Player("Lucian", 210));
		players.add(new Player("Player not a user", 280));

		// Data: User: {name,age}
		users.add(new User("David", 21));
		users.add(new User("Alex", 17));
		users.add(new User("Christian", 35));
		users.add(new User("Lucian", 21));
		users.add(new User("User not a player", 25));

		// Filtering users who are over 30 and whose name starts with a 'C'
		ArrayList<User> olderUsers = (ArrayList<User>) users.stream()
				.filter(u -> u.getAge() > 30 && u.getName().startsWith("C")).collect(Collectors.toList());
		System.out.println("Old users ( > 30 ):");
		printArrayList(olderUsers);

		/*
		 * Getting the users who are also players (Mapping and joining through
		 * their names)
		 */

		// Get the player names (the valid names)
		Set<String> playerNames = players.stream().map(Player::getName).collect(Collectors.toSet());

		// Filter the users whose name are in the playerNames list
		ArrayList<User> UsersWhoPlays = (ArrayList<User>) users.stream().filter(c -> playerNames.contains(c.getName()))
				.collect(Collectors.toList());

		System.out.println("Users who are also players:");
		printArrayList(UsersWhoPlays);
		
		// Gets the maximun value of a player. If this value is less than 200, gets 200
		final int min = 200;
		OptionalInt maxValue= players.stream().filter( player -> player.getValue() > min )
				.mapToInt( Player::getValue ).max();
				
		System.out.println( "Max value: " + maxValue.orElseGet( () -> min ) );
		
		// Gets the adition of the ages of every user
		int totalAges = users.stream().parallel().map(user -> user.getAge()) // or map( User::getAge )
				.reduce( 0, Integer::sum );
				
		System.out.println( "Total ages: " + totalAges );
		System.out.println( "Average age: " + (double)totalAges/users.size() );
		System.out.println();
		
		// Users grouped by the age
		Map< Integer, List< User > > map = users.stream().collect( Collectors.groupingBy( User::getAge ) );
		System.out.println( map );
		System.out.println();

		// Gets the percentage of the age of every user over the group
		Collection< String > result = users.stream()                                        
				.mapToInt( User::getAge )                     	 // Get every age
				.asLongStream()                                  // Gets its stream
				.mapToDouble( points -> points * 100 / totalAges ) // Gets its percentage
				.mapToObj( percentage -> percentage + "%" )      // gets the string with the '%'
				.collect( Collectors.toList() );                 // Gets the list
		System.out.println( result );


	}

}
