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
	private Integer dni;
	private Integer age;

	/**
	 * 
	 * @param name
	 *            of the user
	 * @param age
	 *            of the user
	 */
	public User(Integer dni, Integer age) {
		this.dni = dni;
		this.age = age;
	}
	
	public User() {
	}

	/* Getters and Setters */

	public Integer getDni() {
		return ( dni != null ) ? dni : 0;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Dni: " + getDni() + ", Age:" + age;
	}

}
