public class Game{

	public void go(){
		System.out.println("Välkommen till aftonnens huvudattraktion");
		
		Character a = SetUp.setupCharacter("I vänster ringhörna ser vi?");
		Character b = Character.loadCharacter();
		System.out.println("och i höger har vi " + b.getName());
		a.saveCharacter();
		
		Event e = new Event();
		e.fajt(a, b);
	}
}