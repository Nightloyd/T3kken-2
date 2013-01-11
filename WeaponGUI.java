import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class WeaponGUI implements ActionListener{
	
	JFrame frmWeapon = new JFrame("Weapon creation");
	JLabel lblGreeting = new JLabel("Här skapas vapen");
	JLabel lblDummy = new JLabel("");
	JLabel lblType = new JLabel("Type:");
	JLabel lblMaxDamage = new JLabel("Max Damage:");
	JLabel lblMinimumDamage = new JLabel("Minimum Damage:");
	JTextField txtType = new JTextField(25);
	JTextField txtMaxDamage = new JTextField(2);
	JTextField txtMinimumDamage = new JTextField(2);
	JButton btnDone = new JButton("Done!");
	Weapon weapon;
	
	private WindowAdapter hornStang(){
		return new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{System.exit(0);}
		};
	}//hornStang

	public WeaponGUI(){
		frmWeapon.setSize(500, 700);
		frmWeapon.setLayout(new GridLayout(5,2));
		frmWeapon.addWindowListener(hornStang());
		
		frmWeapon.add(lblGreeting);
		frmWeapon.add(lblDummy);
		frmWeapon.add(lblType);
		frmWeapon.add(txtType);
		frmWeapon.add(lblMinimumDamage);
		frmWeapon.add(txtMinimumDamage);
		frmWeapon.add(lblMaxDamage);
		frmWeapon.add(txtMaxDamage);
		frmWeapon.add(btnDone);
		
		frmWeapon.setVisible(true);
	}
	public void actionPerformed (ActionEvent a){
		String ae = a.getActionCommand();
		try{
			if(ae.equals("Done!")){
				String type = lblType.getText();
				int minimumDamage = Integer.parseInt(txtMinimumDamage.getText());
				int maxDamage = Integer.parseInt(txtMaxDamage.getText());
				weapon = new Weapon(type, minimumDamage, maxDamage);
			}
		}
		catch(Exception e){
			System.out.println(""+e.getMessage());
		}
	}//Action Performed
	
}