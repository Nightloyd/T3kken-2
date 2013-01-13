public class SetUp{

	public static Character setupCharacter(String mvh){
	System.out.println(mvh);
	String namn = Keyboard.readString();
	System.out.println("Och hitchans?");
	int userHitChance = Keyboard.readInt();
	Weapon vapen = setupWeapon();
	Shield protection = setupShield();

	return new Character(namn, userHitChance, protection, vapen);
}

	public static Weapon setupWeapon(){
		System.out.println("Vill du ha ett longsword?");
		String svar = Keyboard.readString();
		if(svar.equalsIgnoreCase("ja"))
			return new Weapon();
		System.out.println("Vilket vapen vill du ha?");
		String typ = Keyboard.readString();
		System.out.println("Vad �r minimiskadan p� det vapnet?");
		int damageMinimum = Keyboard.readInt();
		System.out.println("Vad �r maxskadan p� det vapnet?");
		int damageMaximum = Keyboard.readInt();
		return new Weapon(typ, damageMinimum, damageMaximum);
		}
		
	public static Shield setupShield(){
		System.out.println("Vill du ha en Big Shield?");
		String svar = Keyboard.readString();
		if(svar.equalsIgnoreCase("ja"))
			return new Shield();
		System.out.println("Vilken sk�ld vill du ha?");
		String typ = Keyboard.readString();
		System.out.println("Hur mycket absorbar sk�lden i procent?");
		int damageAbsorbPercent = Keyboard.readInt();
		return new Shield(typ, damageAbsorbPercent);
	}


}