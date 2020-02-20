package fr.eni.demoswing;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class EcranPrincipal extends JFrame {
	private JTextField txtLogin;
	private JPasswordField txtPassword;
	private JButton btnOk;

	public EcranPrincipal() {
		// Change le titre de la fenêtre
		setTitle("Demo SWING");

		// Ferme l'application quand on ferme l'écran
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// méthode qui rend visible l'écran
		setVisible(true);

		// Dimensions de l'écran
		setSize(600, 500);

		// Centre l'écran
		setLocationRelativeTo(null);

		// Appelle le contenu du panneau
		setContentPane(getPanneauPrincipal());

	}

	private JPanel getPanneauPrincipal() {
		JPanel pane = new JPanel();

		// Choix du gestionnaire de mise en page
		pane.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		//
		// Ligne 1 :
		gbc.gridx = 0;
		gbc.gridy = 0;
		// gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 10, 5, 10);
		pane.add(new JLabel("Login : "), gbc);
		// pane.add(getPanneauHautGauche());

		// Ligne 2 :
		gbc.gridx = 1;
		pane.add(getTxtLogin(), gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		pane.add(new JLabel("Mot de passe : "), gbc);

		gbc.gridx = 1;
		pane.add(getTxtPassword(), gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		// Définit la largeur de la ligne
		gbc.gridwidth = 2;
		// Aligne à la fin
		gbc.anchor = GridBagConstraints.LINE_END;
		pane.add(getBtnOk(), gbc);

		return pane;

	}

	private JPanel getPanneauHautGauche() {
		JPanel pane = new JPanel();

		pane.setLayout(new FlowLayout());

		pane.add(new JLabel("Libellé 1 : "));
		pane.add(new JLabel("Libellé 2 : "));
		return pane;
	}

	public JTextField getTxtLogin() {
		if (txtLogin == null) {
			txtLogin = new JTextField(30);
			txtLogin.setBackground(Color.CYAN);

		}
		return txtLogin;
	}

	public JPasswordField getTxtPassword() {
		if (txtPassword == null) {
			txtPassword = new JPasswordField(30);

		}
		return txtPassword;
	}

	public JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("Valider");
			// btnOk.addActionListener(new MaClasseAction());
			// btnOk.addActionListener(this);
			btnOk.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Login :" + txtLogin.getText() + "-Mot de passe :" + txtPassword.getText());
				}
			});
			// Lambda >= JAVA 8
//			btnOk.addActionListener((e)->{
//				System.out.println("Login :" + txtLogin.getText() + "-Mot de passe :" + txtPassword.getText());
//			}
//					);
		}
		return btnOk;
	}

	public void setBtnOk(JButton btnOk) {
		this.btnOk = btnOk;
	}

	public void setTxtLogin(JTextField txtLogin) {
		this.txtLogin = txtLogin;
	}
}
