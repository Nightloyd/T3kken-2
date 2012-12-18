import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class CharacterGUI implements ActionListener {
	
	JFrame frmCharacter = new JFrame("Character creation");
	JLabel lblGreeting = new JLabel("Hejsan, h�r skapas gubben");
	JLabel lblDummy = new JLabel("");
	JLabel lblDummyW = new JLabel("");
	JLabel lblDummyS = new JLabel("");
	JLabel lblName = new JLabel("Namn;");
	JLabel lblHitChance = new JLabel("Hit Chance % :");
	JLabel lblWeapon = new JLabel("Vapen:");
	JLabel lblShield = new JLabel("Sk�ld:");
	JTextField txtName = new JTextField(25);
	JTextField txtHitChance = new JTextField(8);
	ButtonGroup bgpWeapon = new ButtonGroup();
	ButtonGroup bgpShield = new ButtonGroup();
	JRadioButton rbnWDefault = new JRadioButton("Standard");
	JRadioButton rbnWNotDefault = new JRadioButton("Egen design");
	JRadioButton rbnSDefault = new JRadioButton("Ingen sk�ld");
	JRadioButton rbnSNotDefault = new JRadioButton("Egen design");
	JButton btnCreate = new JButton("Skapa");
	JButton btnRun = new JButton("K�r");
	
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
	}//konstruktur
	
	public void actionPerformed (ActionEvent a){
		String ae = a.getActionCommand();
		try{
			if(ae.equals("Skapa")){
				String inNamn = txtName.getText();
				int inHitChance = Integer.parseInt(txtHitChance.getText());
				Weapon inWeapon = new Weapon();
				Shield inShield = new Shield();
				Character nyCharacter = new Character(inNamn, inHitChance, inShield, inWeapon);
				nyCharacter.saveCharacter();
			}
			else if (ae.equals("K�r")){
				Game hitit = new Game();
				hitit.go();
			}
		}
		catch(Exception e){
			System.out.println(""+e.getMessage());
			}
		}//action Performed
	
	public static void main(String[] args){
		CharacterGUI denna = new CharacterGUI();
	}

}//class
	
