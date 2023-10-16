package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.EncryptionOfDeVigenere;
import service.EncryptionService;

import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;

public class WindowMain extends JFrame implements java.awt.event.ActionListener {

	private JPanel contentPane;
	private JTextField txtFieldTextEncryptDeEncrypt;
	private JTextField keyEncryptionVigenere_txtField;
	private JButton btnEncrypt;
	private JButton btnDecrypt;
	private JTextPane txtPaneDisplayWordEncryptOrDecrypt;
	private JRadioButton substitutionMonoAlpha_RdBtn;
	private JRadioButton vigenere_RdBtn;
	private ButtonGroup buttonGroup;
	EncryptionService service = new EncryptionService();
	EncryptionOfDeVigenere vigenere = new EncryptionOfDeVigenere();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowMain frame = new WindowMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WindowMain() {
		setResizable(false);
		setTitle("Encryption tools");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtFieldTextEncryptDeEncrypt = new JTextField();
		txtFieldTextEncryptDeEncrypt.setToolTipText("Please enter the text to encrypt or decrypt");
		txtFieldTextEncryptDeEncrypt.setBounds(12, 115, 673, 50);
		contentPane.add(txtFieldTextEncryptDeEncrypt);
		txtFieldTextEncryptDeEncrypt.setColumns(10);
		
		btnEncrypt = new JButton("Encrypt");
		btnEncrypt.setBounds(12, 178, 284, 41);
		btnEncrypt.setBackground(Color.black);
		btnEncrypt.setForeground(Color.white);
		btnEncrypt.addActionListener(this);
		btnEncrypt.setActionCommand("btnEncrypt");
		contentPane.add(btnEncrypt);
		
		JLabel lblAffichageTitreMotChiffrerOuDechiffrer = new JLabel("Word Display Encrypt or Decrypt ");
		lblAffichageTitreMotChiffrerOuDechiffrer.setBounds(12, 232, 438, 29);
		contentPane.add(lblAffichageTitreMotChiffrerOuDechiffrer);
		
		btnDecrypt = new JButton("Decrypt");
		btnDecrypt.setBounds(401, 178, 284, 41);
		btnDecrypt.setBackground(Color.black);
		btnDecrypt.setForeground(Color.white);
		btnDecrypt.addActionListener(this);
		btnDecrypt.setActionCommand("btnDecrypt");
		contentPane.add(btnDecrypt);
		
		JLabel lblTitreAffichage = new JLabel("Encryption and Decryption Algorithms");
		lblTitreAffichage.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTitreAffichage.setBounds(12, 13, 673, 39);
		contentPane.add(lblTitreAffichage);
		
		txtPaneDisplayWordEncryptOrDecrypt = new JTextPane();
		txtPaneDisplayWordEncryptOrDecrypt.setToolTipText("Display Text encrypt or decrypt");
		txtPaneDisplayWordEncryptOrDecrypt.setEditable(false);
		txtPaneDisplayWordEncryptOrDecrypt.setBounds(12, 274, 673, 161);
		contentPane.add(txtPaneDisplayWordEncryptOrDecrypt);
		
		keyEncryptionVigenere_txtField = new JTextField();
		keyEncryptionVigenere_txtField.setToolTipText("Enter the De-encryption");
		keyEncryptionVigenere_txtField.setBounds(400, 65, 283, 37);
		keyEncryptionVigenere_txtField.setBackground(new Color(230,255,247));
		contentPane.add(keyEncryptionVigenere_txtField);
		keyEncryptionVigenere_txtField.setColumns(10);
		
		keyEncryptionVigenere_txtField.setVisible(false);
		
		substitutionMonoAlpha_RdBtn = new JRadioButton("Substitution of Monoalphabetic");
		substitutionMonoAlpha_RdBtn.setBounds(12, 71, 217, 25);
		substitutionMonoAlpha_RdBtn.addActionListener(this);
		substitutionMonoAlpha_RdBtn.setActionCommand("substitutionMonoAlpha_RdBtn");
		contentPane.add(substitutionMonoAlpha_RdBtn);
		
		vigenere_RdBtn = new JRadioButton("Encryption key");
		vigenere_RdBtn.setBounds(233, 71, 127, 25);
		vigenere_RdBtn.addActionListener(this);
		vigenere_RdBtn.setActionCommand("vigenere_RdBtn");
		contentPane.add(vigenere_RdBtn);
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(substitutionMonoAlpha_RdBtn);
		buttonGroup.add(vigenere_RdBtn);
		
		getContentPane().setBackground(new Color(200, 220, 255));
		 setVisible(true);
		
		//substitutionMonoAlpha_RdBtn.setSelected(true);
		
		String getTextRdBtnSelected = checkRadioBtnInRadioGroupIsSelected(buttonGroup);
		if (getTextRdBtnSelected.equals(substitutionMonoAlpha_RdBtn.getText())) {
			System.out.println("Hello mono");
		}else if (getTextRdBtnSelected.equals(vigenere_RdBtn.getText())) {
			System.out.println("Hello vigi");
		}
	
	}
	
	public void actionPerformed(java.awt.event.ActionEvent e) {
		String getTextRdBtnSelected = checkRadioBtnInRadioGroupIsSelected(buttonGroup);
		if ("btnEncrypt".equals(e.getActionCommand())) {
			if (getTextRdBtnSelected.equals("")) {
				JOptionPane.showMessageDialog(this, "Please select mono alphabetical or vigenere encryption ", "Error", 0);
				return;
			}
			if (getTextRdBtnSelected.equals(substitutionMonoAlpha_RdBtn.getText())) {
				chiffrementMessageMonoAlpha();
			}else if (getTextRdBtnSelected.equals(vigenere_RdBtn.getText())) {
				chiffrementMessageviginere();
			}
		}else if ("btnDecrypt".equals(e.getActionCommand())) {
			if (getTextRdBtnSelected.equals("")) {
				JOptionPane.showMessageDialog(this, "Please select mono alphabetical or vivinere encryption ", "Error", 0);
				return;
			}
			if (getTextRdBtnSelected.equals(substitutionMonoAlpha_RdBtn.getText())) {
				dechiffrementMessageMonoAlpha();
			}else if (getTextRdBtnSelected.equals(vigenere_RdBtn.getText())) {
				dechiffrementMessageviginere();
			}
		}else if ("substitutionMonoAlpha_RdBtn".equals(e.getActionCommand())) {
			keyEncryptionVigenere_txtField.setText("");
			keyEncryptionVigenere_txtField.setVisible(false);
		}else if ("vigenere_RdBtn".equals(e.getActionCommand())) {
			keyEncryptionVigenere_txtField.setVisible(true);
		}
	}
	
	public void chiffrementMessageMonoAlpha() {
		String textAChif_Dechif = txtFieldTextEncryptDeEncrypt.getText().toString();
		if (textAChif_Dechif.equals("")) {
			JOptionPane.showMessageDialog(this, "Please enter a message to encrypt ", "Error", 0);
			return;
		}
		if ((!textAChif_Dechif.isEmpty()) && (textAChif_Dechif != "")) {
			txtPaneDisplayWordEncryptOrDecrypt.setText(service.algoEncryptionText(textAChif_Dechif.toLowerCase()));
		}
	}
	
	public void dechiffrementMessageMonoAlpha() {
		String textAChif_Dechif = txtFieldTextEncryptDeEncrypt.getText().toString();
		if (textAChif_Dechif.equals("")) {
			JOptionPane.showMessageDialog(this, "Please enter a message to decrypt ", "Error", 0);
			return;
		}
		if ((!textAChif_Dechif.isEmpty()) && (textAChif_Dechif != "")) {
			txtPaneDisplayWordEncryptOrDecrypt.setText(service.algoDecryptionText(textAChif_Dechif.toLowerCase()));
		}
	}
	
	public void chiffrementMessageviginere() {
		String textAChif_Dechif = txtFieldTextEncryptDeEncrypt.getText().toString();
		String cleCrypt = keyEncryptionVigenere_txtField.getText().toString();
		if (textAChif_Dechif.equals("")) {
			JOptionPane.showMessageDialog(this, "Please enter a message to encrypt ", "Error", 0);
			return;
		}
		if (cleCrypt.equals("")) {
			JOptionPane.showMessageDialog(this, "Please put an encryption key to encrypt the message ", "Error", 0);
			return;
		}
		if (textAChif_Dechif.equals(cleCrypt)) {
			JOptionPane.showMessageDialog(this, "For absolute security, the encryption key must be different from the message ", "Error", 0);
			return;
		}
		if ((!textAChif_Dechif.isEmpty()) && (textAChif_Dechif != "") || (!cleCrypt.isEmpty()) && (cleCrypt != "")) {
			txtPaneDisplayWordEncryptOrDecrypt.setText(vigenere.encryptWithVigenere(textAChif_Dechif, cleCrypt));
		}
	}
	
	public void dechiffrementMessageviginere() {
		String textAChif_Dechif = txtFieldTextEncryptDeEncrypt.getText().toString();
		String cleCrypt = keyEncryptionVigenere_txtField.getText().toString();
		if (textAChif_Dechif.equals("")) {
			JOptionPane.showMessageDialog(this, "Please enter a message to decrypt ", "Error", 0);
			return;
		}
		if (cleCrypt.equals("")) {
			JOptionPane.showMessageDialog(this, "Please put a decryption key to decrypt the message ", "Error", 0);
			return;
		}
		if ((!textAChif_Dechif.isEmpty()) && (textAChif_Dechif != "") || (!cleCrypt.isEmpty()) && (cleCrypt != "")) {
			txtPaneDisplayWordEncryptOrDecrypt.setText(vigenere.deencryptWithVigenere(textAChif_Dechif, cleCrypt));
		}
	}
	
	String checkRadioBtnInRadioGroupIsSelected(ButtonGroup buttonGroup){
		Enumeration<AbstractButton> bg = buttonGroup.getElements();
		String textRadioButtonSelected = "";
		while (bg.hasMoreElements()) {
			JRadioButton jRadioButton = (JRadioButton) bg.nextElement();
			if (jRadioButton.isSelected()) {
				textRadioButtonSelected = jRadioButton.getText();
			}
		}
		return textRadioButtonSelected;
	}
	
}
