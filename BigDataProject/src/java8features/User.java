/**
 *  Author: Inigo Alonso Ruiz
 */

package java8features;

/**
 * 
 * @author inigo
 *
 *         Simple User Class
 */
public class User {

	/* Each User has a name and an age */
	private String name;
	private Integer age;

	/**
	 * 
	 * @param name
	 *            of the user
	 * @param age
	 *            of the user
	 */
	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	public User() {
	}

	/* Getters and Setters */

	public String getName() {
		return ( name != null ) ? name : "";
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Name: " + getName() + ", Age:" + age;
	}

}
