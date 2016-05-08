/**
 *  Author: Inigo Alonso Ruiz
 */

package java8features;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Example Class used to try out the method references of Java 8
 * 
 * @author inigo
 * 
 */
public class MethodReferences {
	
	@SuppressWarnings( "unused" )
	public static void main(String[] args) {
		
		// List
		ArrayList<User> users = new ArrayList<>();

		// Data: User: {name,age}
		users.add(new User("David", 21));
		users.add(new User("Alex", 17));
		users.add(new User("Christian", 35));
		users.add(new User("Lucian", 23));
		users.add(new User("User not a player", 25));
		
		// Get a list of user names
		List<String> userNamesList=users.stream().map(User::getName).collect(Collectors.toList());
		
		// Get a set of user names
		Set<String> userNamesSet = users.stream().map(User::getName).collect(Collectors.toSet());
	}
}
