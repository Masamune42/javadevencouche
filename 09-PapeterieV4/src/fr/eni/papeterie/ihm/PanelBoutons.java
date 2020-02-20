package fr.eni.papeterie.ihm;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelBoutons extends JPanel {
	private List<IPanelBoutonsObserver> observateurs;
	private JButton boutonBack;
	private JButton boutonNew;
	private JButton boutonSave;
	private JButton boutonDelete;
	private JButton boutonForward;

	public PanelBoutons() {
		setLayout(new FlowLayout());
		// Ajout de chaque bouton lors de l'instanciation de la classe
		this.add(getBoutonBack());
		this.add(getBoutonNew());
		this.add(getBoutonSave());
		this.add(getBoutonDelete());
		this.add(getBoutonForward());
		// On sera au début de la liste donc on désactive le bouton de retour
		boutonBack.setEnabled(false);
		observateurs = new ArrayList<>();
	}

	public void addPanelBoutonObserver(IPanelBoutonsObserver observateur) {
		observateurs.add(observateur);
	}

	private JButton creerBouton(String chemin) {
		JButton bouton = new JButton();
		try {
			Image img = ImageIO.read(getClass().getResource(chemin));
			bouton.setIcon(new ImageIcon(img));
		} catch (Exception e) {
			System.out.println(e);
		}
		return bouton;
	}

	// méthodes public pour boutons back et forward pour les griser quand besoin
	public JButton getBoutonBack() {
		if (boutonBack == null) {
			boutonBack = creerBouton("resources\\Back24.gif");
			boutonBack.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					for (IPanelBoutonsObserver obs : observateurs) {
						obs.precedent();
					}

				}
			});
		}
		return boutonBack;
	}

	public JButton getBoutonForward() {
		if (boutonForward == null) {
			boutonForward = creerBouton("resources/Forward24.gif");
			boutonForward.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					for (IPanelBoutonsObserver obs : observateurs) {
						obs.suivant();
					}

				}
			});
		}
		return boutonForward;
	}

	private JButton getBoutonNew() {
		if (boutonNew == null) {
			boutonNew = creerBouton("resources/New24.gif");
			boutonNew.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					for (IPanelBoutonsObserver obs : observateurs) {
						obs.nouveau();
					}

				}
			});
		}
		return boutonNew;
	}

	private JButton getBoutonSave() {
		if (boutonSave == null) {
			boutonSave = creerBouton("resources/Save24.gif");
			boutonSave.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					for (IPanelBoutonsObserver obs : observateurs) {
						obs.enregistrer();
					}
				}
			});
		}
		return boutonSave;
	}

	private JButton getBoutonDelete() {
		if (boutonDelete == null) {
			boutonDelete = creerBouton("resources/Delete24.gif");
			boutonDelete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					for (IPanelBoutonsObserver obs : observateurs) {
						obs.supprimer();
					}
				}
			});
		}
		return boutonDelete;
	}

}
