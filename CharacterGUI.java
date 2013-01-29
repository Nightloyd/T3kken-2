import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CharacterGUI implements ActionListener {
	
	JFrame frmCharacter = new JFrame("Character creation");
	JLabel lblGreeting = new JLabel("Hejsan, h�r skapas gubben");
	JLabel lblDummy = new JLabel("");
	JLabel lblDummyW = new JLabel("");
	JLabel lblDummyS = new JLabel("");
	JLabel lblName = new JLabel("Namn:");
	JLabel lblHitChance = new JLabel("Hit Chance % :");
	JLabel lblWeapon = new JLabel("Vapen:");
	JLabel lblShield = new JLabel("Sk�ld:");
	JTextField txtName = new JTextField(25);
	JTextField txtHitChance = new JTextField(8);
	ButtonGroup bgpWeapon = new ButtonGroup();
	ButtonGroup bgpShield = new ButtonGroup();
	JRadioButton rbnWDefault = new JRadioButton("Standard sv�rd");
	JRadioButton rbnWNotDefault = new JRadioButton("Egen design sv�rd");
	JRadioButton rbnSDefault = new JRadioButton("Ingen sk�ld");
	JRadioButton rbnSNotDefault = new JRadioButton("Egen design sk�ld");
	JButton btnCreate = new JButton("Skapa");
	JButton btnRun = new JButton("K�r");
	
	Weapon inWeapon;
	Shield inShield;
	
	//denna metod aktiverar krysset i �vre h�gra h�rnet
	private WindowAdapter hornStang(){
		return new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{System.exit(0);}
		};
	}//hornStang

	public CharacterGUI(){
		frmCharacter.setSize(500, 700);
		frmCharacter.setLayout(new GridLayout(8, 2));
		frmCharacter.addWindowListener(hornStang());
		
		frmCharacter.add(lblGreeting);
		frmCharacter.add(lblDummy);
		frmCharacter.add(lblName);
		frmCharacter.add(txtName);
		frmCharacter.add(lblHitChance);
		frmCharacter.add(txtHitChance);
		frmCharacter.add(lblWeapon);
		frmCharacter.add(rbnWDefault);
		frmCharacter.add(lblDummyW);
		frmCharacter.add(rbnWNotDefault);
		frmCharacter.add(lblShield);
		frmCharacter.add(rbnSDefault);
		frmCharacter.add(lblDummyS);
		frmCharacter.add(rbnSNotDefault);
		frmCharacter.add(btnCreate);
		frmCharacter.add(btnRun);
		
		frmCharacter.setVisible(true);
		
		bgpWeapon.add(rbnWDefault);
		bgpWeapon.add(rbnWNotDefault);
		bgpShield.add(rbnSDefault);
		bgpShield.add(rbnSNotDefault);
		
		btnCreate.addActionListener(this);
		btnRun.addActionListener(this);
		rbnWDefault.addActionListener(this);
		rbnWNotDefault.addActionListener(this);
		rbnSDefault.addActionListener(this);
		rbnSNotDefault.addActionListener(this);
		
	}//konstruktur
	
	public void actionPerformed (ActionEvent a){
		String ae = a.getActionCommand();
		try{
			if(ae.equals("Skapa")){
				String inNamn = txtName.getText();
				int inHitChance = Integer.parseInt(txtHitChance.getText());
				Character nyCharacter = new Character(inNamn, inHitChance, inShield, inWeapon);
				nyCharacter.saveCharacter();
			}
			if (ae.equals("K�r")){
				Game hitit = new Game();
				hitit.go();
			}
			
			if (ae.equals("Ingen sk�ld")){
				String namn = "Egen";
				inShield = new Shield(namn , 0);
			}
			
			if (ae.equals("Egen design sk�ld")){
				inShield = new Shield();
			}
			
			if (ae.equals("Standard sv�rd")){
				inWeapon = new Weapon();
			}
			
			else if(ae.equals("Egen design sv�rd")){
				WeaponGUI wg = new WeaponGUI();
				Weapon w = wg.weaponGUIRUN();
			}
		}
		catch(Exception e){
			System.out.println(""+e.getMessage());
			}
		}//action Performed
	
	public static void main(String[] args){
		new CharacterGUI();
	}
	
	public Weapon setInWeapon(String type, int minimumDamage, int maxDamage){
		inWeapon = new Weapon(type, minimumDamage, maxDamage);
		return inWeapon;
	}

}//class
	
