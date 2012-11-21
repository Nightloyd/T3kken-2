import java.util.*;
import java.math.*;
import java.io.*;

public class Character{
	private String name;
	private int hp;
	private int hitChance;
	private Shield shield;
	private Weapon weapon;
	
	public Character(String name, int userHitChance, Shield shield, Weapon weapon){
		this.hp = 100;
		this.hitChance = userHitChance;
		this.name = name;
		this.shield = shield;
		this.weapon = weapon;
	}
	
	public int hit(Character annan){
		Random randomGenerator = new Random();
		int bonk = randomGenerator.nextInt(100);
		if (bonk < this.hitChance){
			int weaponDamage = weapon.damage();
			double shieldAbsorb = shield.damageAbsorbPercent();
			double damage2 = weaponDamage*shieldAbsorb;
			System.out.println(weapon.damage() + " " + shield.damageAbsorbPercent() + " " + damage2);
			int damage = (int)Math.round(damage2);
			System.out.println("Tjoff! " + name + " träffade med " + damage + " skada.");
			return damage;
			
		}
		System.out.println("Klang! " + name + " missade.");
		return 0;
	}
	
	public void saveCharacter(){
		String filnamn = "charsave.txt";
		String resultat = name + " " + hp + " " + shield;
		try{
			FileWriter fw = new FileWriter(new File(filnamn));
			fw.write(resultat);
			fw.close();
		}
		catch(IOException e){
		System.out.println("Hoppsan (" + e.toString() + ")");
		}
	}
	
	public void dies(){
		System.out.println("Aaaaaaaaaargh!");
	}
	
	public String getName(){
		return name;
	}
	
	public void setHp(int hp){
		this.hp = hp;
	}
	
	public int getHp(){
		return hp;
	}
	
	public Shield getshield(){
		return shield;
	}
	
	public Weapon getWeapon(){
		return weapon;
	}
}//Class