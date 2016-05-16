/**
 *  Author: Inigo Alonso Ruiz
 */

package java8features;

/**
 * 
 * @author inigo
 *
 *Simple Player Class
 */
public class Player  {
	
	/* Each Player has a name and a value */
	private Integer dni;
	private Integer value;
	
	/**
	 * 
	 * @param name of the player
	 * @param value of the player 
	 */
	public Player(Integer dni, Integer value) {
		this.dni = dni;
		this.value = value;
	}
	
	public Player() {
	}
	/* Getters and Setters */

	public Integer getDni() {
		return ( dni != null ) ? dni : 0;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
	@Override
	public String toString(){
		return "Dni: "+getDni()+", Value:"+value;
	}
	 
}
