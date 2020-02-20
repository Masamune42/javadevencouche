package fr.eni.logging.ihm;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.eni.logging.bll.UtilisateursManager;

public class EcranConnexion extends JFrame {
	private JTextField txtIdentifiant;
	private JPasswordField txtMdp;
	private JButton btnConnexion;
	private UtilisateursManager utilMan= new UtilisateursManager();
	
	public EcranConnexion() {
		// Change le titre de la fenêtre
		setTitle("Connexion");

		// Ferme l'application quand on ferme l'écran
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// méthode qui rend visible l'écran
		setVisible(true);

		// Non redimensionnable
		setResizable(false);

		// Centre l'écran
		setLocationRelativeTo(null);

		// Appelle le contenu du panneau
		setContentPane(getPanneauPrincipal());
		pack();
	}

	private JPanel getPanneauPrincipal() {

		JPanel paneEntree = new JPanel();
		paneEntree.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// Ligne 1 :
		gbc.gridx = 0;
		gbc.gridy = 0;
		// Insère des marges
		gbc.insets = new Insets(5, 10, 5, 10);
		paneEntree.add(new JLabel("identifiant : "), gbc);
		gbc.gridx = 1;
		paneEntree.add(getTxtIdentifiant(), gbc);

		// Ligne 1 :
		gbc.gridx = 0;
		gbc.gridy = 1;
		// Insère des marges
		paneEntree.add(new JLabel("mot de passe : "), gbc);
		gbc.gridx = 1;
		paneEntree.add(getTxtMdp(), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		paneEntree.add(getBtnConnexion(), gbc);
		
		btnConnexion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (verifChamps()) {
					JOptionPane.showMessageDialog(null, "Accès autorisé", "Info", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Accès refusé", "Info", JOptionPane.ERROR_MESSAGE);
				}
				
			}

			private boolean verifChamps() {
				
				return utilMan.verifierUtilisateur(txtIdentifiant.getText(), txtMdp.getText());
			}
		});

		return paneEntree;
	}

	private Component getBtnConnexion() {
		if (btnConnexion == null) {
			btnConnexion = new JButton("Connexion");
		}
		return btnConnexion;
	}

	private Component getTxtMdp() {
		if (txtMdp == null) {
			txtMdp = new JPasswordField(30);
		}
		return txtMdp;
	}

	private Component getTxtIdentifiant() {
		if (txtIdentifiant == null) {
			txtIdentifiant = new JTextField(30);
		}
		return txtIdentifiant;
	}
}
