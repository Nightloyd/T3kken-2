public class Game{

private static Character setupCharacter(String mvh){
	System.out.println(mvh);
	String namn = Keyboard.readString();
	System.out.println("Och hitchans?");
	int userHitChance = Keyboard.readInt();
	Weapon vapen = setupWeapon();
	Shield protection = setupShield();

	return new Character(namn, userHitChance, protection, vapen);
}

	private static Weapon setupWeapon(){
		System.out.println("Vill du ha ett longsword?");
		String svar = Keyboard.readString();
		if(svar.equalsIgnoreCase("ja"))
			return new Weapon();
		System.out.println("Vilket vapen vill du ha?");
		String typ = Keyboard.readString();
		System.out.println("Vad är minimiskadan på det vapnet?");
		int damageMinimum = Keyboard.readInt();
		System.out.println("Vad är maxskadan på det vapnet?");
		int damageMaximum = Keyboard.readInt();
		return new Weapon(typ, damageMinimum, damageMaximum);
		}
		
	private static Shield setupShield(){
		System.out.println("Vill du ha en Big Shield?");
		String svar = Keyboard.readString();
		if(svar.equalsIgnoreCase("ja"))
			return new Shield();
		System.out.println("Vilken sköld vill du ha?");
		String typ = Keyboard.readString();
		System.out.println("Hur mycket absorbar skölden i procent?");
		int damageAbsorbPercent = Keyboard.readInt();
		return new Shield(typ, damageAbsorbPercent);
	}

	public static boolean fajt(Character a, Character b){
		int dam = a.hit(b);
		b.setHp(b.getHp()-dam);
		
		if(b.getHp() < 1){
			b.dies();
			System.out.println(a.getName() + " har krossat " + b.getName());
			System.out.println("Det verkar som om " + a.getWeapon().getType() + " är ett överlägset vapen.");
			return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		System.out.println("Välkommen till aftonnens huvudattraktion");
		
		Character a = setupCharacter("I vänster ringhörna ser vi?");
		Character b = setupCharacter("Och i höger har vi?");

		boolean mer = true;
		while(mer){
			mer = fajt(a,b);
			if(mer)
				mer = fajt(b,a);
			
		}
	}
}