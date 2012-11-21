import java.util.*;

public class Weapon{
	private String type;
	private int damageMinimum;
	private int damageMaximum;
	
	public Weapon(){
		type = "Long Sword";
		damageMinimum = 4;
		damageMaximum = 12;
	}
	
	public Weapon(String type, int damageMinimum, int damageMaximum){
		this.type = type;
		this.damageMinimum = damageMinimum;
		this.damageMaximum = damageMaximum;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public String getType(){
		return type;
	}
	
	public void setDamageMinimum(int damageMinimum){
		this.damageMinimum = damageMinimum;
	}
	
	public int getDamageMinimum(){
		return damageMinimum;
	}
	
	public void setDamageMaximum(int damageMaximum){
		this.damageMaximum = damageMaximum;
	}
	
	public int getDamageMaximum(){
		return damageMaximum;
	}
	
	public int damage(){
		Random randomGenerator = new Random();
		int dg = randomGenerator.nextInt(damageMaximum - (damageMinimum - 1));
		int dam = damageMinimum + dg;
		return dam;
	}

}