import java.util.*;

public class Shield{
	private String type;
	private int damageAbsorbtion;
	
	public Shield(){
		type = "Big Shield";
		damageAbsorbtion = 20;
	}
	
	public Shield(String type, int damageAbsorbtion){
		this.type = type;
		this.damageAbsorbtion = damageAbsorbtion;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public String getType(){
		return type;
	}
	
	public void setDamageAbsorbtion(int damageAbsorbtion){
		this.damageAbsorbtion = damageAbsorbtion;
	}
	
	public int getDamageAbsorbtion(){
		return damageAbsorbtion;
	}
	
	public double damageAbsorbPercent(){
		double protection = 100-damageAbsorbtion;
		protection /= 100;
		if(protection > 1)
			protection = 1;
		return protection;
	}

}