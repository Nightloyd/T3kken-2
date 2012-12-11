public class Event{

	public void fajt(Character a, Character b){
		while(true){
			int dam = a.hit(b);
			b.setHp(b.getHp()-dam);
		
			if(b.getHp() < 1){
				b.dies();
				System.out.println(a.getName() + " har krossat " + b.getName());
				System.out.println("Det verkar som om " + a.getWeapon().getType() + " är ett överlägset vapen.");
				break;
			}
		
		dam = b.hit(a);
		a.setHp(a.getHp()-dam);
		if(a.getHp() < 1){
			a.dies();
			System.out.println(b.getName() + " har krossat " + a.getName());
			System.out.println("Det verkar som om " + b.getWeapon().getType() + " är ett överlägset vapen.");
			break;
			}
		}
	}
}