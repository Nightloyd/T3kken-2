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
			int damage = (int)Math.round(weapon.damage() * shield.damageAbsorbPercent());
			System.out.println("Tjoff! " + name + " träffade med " + damage + " skada.");
			return damage;
			
		}
		System.out.println("Klang! " + name + " missade.");
		return 0;
	}
	
	public void saveCharacter(){
		String filnamn = "Saves/charsave.txt";
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
	
	public static Character loadCharacter(){
		String filnamn = "Saves/charsave.txt";
		String resultat = "";
		try {
			FileReader fr = new FileReader(new File(filnamn));
			int a = fr.read();
			char b;
			while (a != -1) {
				b = (char)a;
				resultat += b;
				a = fr.read();
			}
			fr.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Hittade inte filen (" + e.toString() + ")");
		}
		catch(IOException e) {
			System.out.println("Hoppsan! (" + e.toString() + ")");
		}
		StringTokenizer st = new StringTokenizer(resultat);
		String name = st.nextToken();
		int hp = Integer.parseInt(st.nextToken());
		int skill = Integer.parseInt(st.nextToken());
		return new Character(name, skill, new Shield(), new Weapon());
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