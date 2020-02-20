package fr.eni.papeterie.ihm;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bll.BLLReferenceEnDoubleEception;
import fr.eni.papeterie.bll.CatalogueManager;
import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;

public class EcranPrincipal extends JFrame {
	private JTextField txtReference;
	private JTextField txtDesignation;
	private JTextField txtMarque;
	private JTextField txtStock;
	private JTextField txtPrix;
	private JTextField txtType;
	private JTextField txtGrammage;
	private JTextField txtCouleur;
	private JRadioButton radioRamette;
	private JCheckBox check80g;
	private JCheckBox check100g;
	private JRadioButton radioStylo;
	CatalogueManager mger = CatalogueManager.getInstance();
	List<Article> articles;
	JComboBox<String> listeCouleurs;
	String choix[] = { "", "bleu", "rouge", "vert", "jaune", "noir" };
	private JButton boutonBack;
	private JButton boutonNew;
	private JButton boutonSave;
	private JButton boutonDelete;
	private JButton boutonForward;
	private int i = 0;

	public EcranPrincipal() {
		// Change le titre de la fenêtre
		setTitle("Gestion stocks");

		// Ferme l'application quand on ferme l'écran
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// méthode qui rend visible l'écran
		setVisible(true);
		
		// Non redimensionnable
		setResizable(false);

		// Dimensions de l'écran
		// setSize(600, 500);
		try {
			articles = mger.getCatalogue();
			// System.out.println("taille du catalogue : " + articles.size());
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Centre l'écran
		setLocationRelativeTo(null);

		// Appelle le contenu du panneau
		setContentPane(getPanneauPrincipal());
		pack();
	}

	private JPanel getPanneauPrincipal() {

		JPanel pane = new JPanel();
		// Choix du gestionnaire de mise en page
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

		JPanel paneEntree = new JPanel();
		paneEntree.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// Ligne 1 :
		gbc.gridx = 0;
		gbc.gridy = 0;
		// Insère des marges
		gbc.insets = new Insets(5, 10, 5, 10);
		paneEntree.add(new JLabel("Référence : "), gbc);
		gbc.gridx = 1;
		paneEntree.add(getTxtReference(), gbc);

		// Ligne 2 :
		gbc.gridx = 0;
		gbc.gridy = 1;
		paneEntree.add(new JLabel("Désignation : "), gbc);
		gbc.gridx = 1;
		paneEntree.add(getTxtDesignation(), gbc);

		// Ligne 3 :
		gbc.gridx = 0;
		gbc.gridy = 2;
		paneEntree.add(new JLabel("Marque : "), gbc);
		gbc.gridx = 1;
		paneEntree.add(getTxtMarque(), gbc);

		// Ligne 4 :
		gbc.gridx = 0;
		gbc.gridy = 3;
		paneEntree.add(new JLabel("Stock : "), gbc);
		gbc.gridx = 1;
		paneEntree.add(getTxtStock(), gbc);

		// Ligne 5 :
		gbc.gridx = 0;
		gbc.gridy = 4;
		paneEntree.add(new JLabel("Prix : "), gbc);
		gbc.gridx = 1;
		paneEntree.add(getTxtPrix(), gbc);

		// Ligne 6 :
		gbc.gridx = 0;
		gbc.gridy = 5;
		paneEntree.add(new JLabel("Type : "), gbc);
		// Crée un nouveau panneau
		JPanel paneType = new JPanel();
		// Choisit le layout du panneau, choix de l'axe des boutons
		paneType.setLayout(new BoxLayout(paneType, BoxLayout.Y_AXIS));
		// Création des bouton radios et ajout au panneau des types

		paneType.add(getRadioRamette());
		paneType.add(getRadioStylo());
		// paneType.setBorder(BorderFactory.createLineBorder(Color.black));
		ButtonGroup groupeType = new ButtonGroup();
		groupeType.add(radioRamette);
		groupeType.add(radioStylo);

		// Placement du panneau des types par rapport au gbc indiqué
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		paneEntree.add(paneType, gbc);

		gbc.gridx = 0;
		gbc.gridy = 6;
		paneEntree.add(new JLabel("Grammage : "), gbc);
		JPanel paneGrammage = new JPanel();
		// paneGrammage.setLayout(new BoxLayout(paneGrammage, BoxLayout.Y_AXIS));
		paneGrammage.setLayout(new GridLayout(2, 1));
		check80g = new JCheckBox("80 grammes");
		paneGrammage.add(check80g);
		check100g = new JCheckBox("100 grammes");
		paneGrammage.add(check100g);
		ButtonGroup groupeGrammage = new ButtonGroup();
		groupeGrammage.add(check80g);
		groupeGrammage.add(check100g);

		gbc.gridx = 1;
		// gbc.anchor = GridBagConstraints.CENTER;
		paneEntree.add(paneGrammage, gbc);

		gbc.gridy = 7;
		gbc.gridx = 0;
		paneEntree.add(new JLabel("Couleur : "), gbc);

		listeCouleurs = new JComboBox<String>(choix);

		gbc.gridx = 1;
		paneEntree.add(listeCouleurs, gbc);
		pane.add(paneEntree);
		JPanel paneBoutons = new JPanel();
		paneBoutons.setLayout(new FlowLayout());

		// Création des boutons avec un appel de lazy loading
		// Ajout au panneau des boutons
		paneBoutons.add(getBoutonnBack());
		paneBoutons.add(getBoutonNew());
		paneBoutons.add(getBoutonSave());
		paneBoutons.add(getBoutonDelete());
		paneBoutons.add(getBoutonForward());
		// On sera au début de la liste donc on désactive le bouton de retour
		boutonBack.setEnabled(false);
		pane.add(paneBoutons, gbc);

		// Affichage de l'article à l'indice i (ici i=0, donc 1er article)
		if (articles.get(i) != null) {
			afficherArticle(articles.get(i));
		}
		return pane;
	}

	private JRadioButton getRadioStylo() {
		if (radioStylo == null) {
			radioStylo = new JRadioButton("Stylo");
			radioStylo.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					listeCouleurs.setEnabled(true);
					check80g.setEnabled(false);
					check100g.setEnabled(false);
				}
			});
		}
		return radioStylo;
	}

	private JRadioButton getRadioRamette() {
		if (radioRamette == null) {
			radioRamette = new JRadioButton("Ramette");
			radioRamette.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					listeCouleurs.setEnabled(false);
					check80g.setEnabled(true);
					check100g.setEnabled(true);
				}
			});
		}
		return radioRamette;
	}

	private void supprimerArticle() {
		try {
			int indexArticle = i;
			mger.removeArticle(articles.get(i).getIdArticle());
			if (indexArticle != 0) {
				i = indexArticle - 1;
			} else {
				i = 0;
			}
			articles = mger.getCatalogue();
			if (i == articles.size() - 1) {
				boutonBack.setEnabled(true);
				boutonForward.setEnabled(false);
			} else if (i > 0) {
				boutonBack.setEnabled(true);
				boutonForward.setEnabled(true);
			} else {
				boutonBack.setEnabled(false);
				boutonForward.setEnabled(true);
			}
			afficherArticle(articles.get(i));
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void modifierArticle() {
		try {
			articles.get(i).setReference(txtReference.getText());
			articles.get(i).setDesignation(txtDesignation.getText());
			articles.get(i).setMarque(txtMarque.getText());
			if (txtStock.getText().equals("")) {
				throw new BLLException();
			} else {

				articles.get(i).setQteStock(Integer.parseInt(txtStock.getText()));
			}
			if (txtPrix.getText().equals("")) {
				throw new BLLException();
			} else {

				articles.get(i).setPrixUnitaire(Float.parseFloat(txtPrix.getText()));
			}
			if (articles.get(i) instanceof Stylo) {
				((Stylo) (articles.get(i))).setCouleur(listeCouleurs.getSelectedItem().toString());
			} else {
				if (check80g.isSelected()) {
					((Ramette) (articles.get(i))).setGrammage(80);
				} else {
					((Ramette) (articles.get(i))).setGrammage(100);
				}
			}
			mger.updateArticle(articles.get(i));
		} catch (BLLException e) {
			JOptionPane.showMessageDialog(this, "Veuillez vérifier les champs entrés", "Erreur de saisie",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void ajouterArticle() {
		Article article;
		try {
			if (radioStylo.isSelected()) {
				article = new Stylo();
				article.setReference(txtReference.getText());
				article.setDesignation(txtDesignation.getText());
				article.setMarque(txtMarque.getText());
				if (txtStock.getText().equals("")) {
					throw new BLLException("Veuillez vérifier les champs entrés");
				} else {
					article.setQteStock(Integer.parseInt(txtStock.getText()));
				}
				if (txtPrix.getText().equals("")) {
					throw new BLLException("Veuillez vérifier les champs entrés");
				} else {
					article.setPrixUnitaire(Float.parseFloat(txtPrix.getText()));

				}
				((Stylo) article).setCouleur(listeCouleurs.getSelectedItem().toString());

			} else {
				article = new Ramette();
				article.setReference(txtReference.getText());
				article.setDesignation(txtDesignation.getText());
				article.setMarque(txtMarque.getText());
				if (txtStock.getText().equals("")) {
					throw new BLLException("Stock vide");
				} else {
					article.setQteStock(Integer.parseInt(txtStock.getText()));
				}

				if (txtPrix.getText().equals("")) {
					throw new BLLException("Prix vide");
				} else {
					article.setPrixUnitaire(Float.parseFloat(txtPrix.getText()));
				}

				if (check80g.isSelected()) {
					((Ramette) (article)).setGrammage(80);
				} else {
					((Ramette) (article)).setGrammage(100);
				}
			}
			mger.addArticle(article);
		} catch (BLLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
			// System.out.println("attention pas bon !");
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "Des valeurs numériques svp", "Erreur de saisie",
					JOptionPane.ERROR_MESSAGE);
		} catch(BLLReferenceEnDoubleEception e2) {
			JOptionPane.showMessageDialog(null, "Référence déjà existante", "Erreur de saisie",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void EffacerInfos() {
		txtReference.setText("");
		txtDesignation.setText("");
		txtMarque.setText("");
		txtStock.setText("");
		txtPrix.setText("");
		check80g.setEnabled(true);
		check100g.setEnabled(true);
		listeCouleurs.setEnabled(true);
		radioRamette.setEnabled(true);
		radioStylo.setEnabled(true);
	}

	private void afficherArticle(Article article) {
		txtReference.setText(article.getReference());
		txtDesignation.setText(article.getDesignation());
		txtMarque.setText(article.getMarque());
		txtStock.setText(Integer.toString(article.getQteStock()));
		txtPrix.setText(Float.toString(article.getPrixUnitaire()));

		if (article instanceof Stylo) {
			radioStylo.setSelected(true);
			String couleur = ((Stylo) article).getCouleur();
			listeCouleurs.setSelectedItem(couleur);
			check80g.setSelected(false);
			check100g.setSelected(false);
			check80g.setEnabled(false);
			check100g.setEnabled(false);
			listeCouleurs.setEnabled(true);
			radioRamette.setEnabled(false);
			radioStylo.setEnabled(true);
		} else if (article instanceof Ramette) {
			radioRamette.setSelected(true);
			check80g.setEnabled(true);
			check100g.setEnabled(true);
			listeCouleurs.setEnabled(false);
			radioRamette.setEnabled(true);
			radioStylo.setEnabled(false);
			int grammage = ((Ramette) article).getGrammage();
			listeCouleurs.setSelectedItem("");
			if (grammage == 80) {
				check80g.setSelected(true);
			} else {
				check100g.setSelected(true);
			}
		}
	}

	private JButton getBoutonnBack() {
		if (boutonBack == null) {
			boutonBack = creerBouton("resources\\Back24.gif");
			boutonBack.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					i--;
					// System.out.println(i);
					afficherArticle(articles.get(i));
					if (i > 0) {
						boutonForward.setEnabled(true);
					} else {
						boutonBack.setEnabled(false);
					}
				}
			});
		}
		return boutonBack;
	}

	private JButton getBoutonNew() {
		if (boutonNew == null) {
			boutonNew = creerBouton("resources/New24.gif");
			boutonNew.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					EffacerInfos();
					i = articles.size();
					boutonForward.setEnabled(false);
					boutonBack.setEnabled(true);
					radioRamette.setSelected(true);
					listeCouleurs.setEnabled(false);
					check80g.setEnabled(true);
					check100g.setEnabled(true);
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
					try {
						if (i == articles.size()) {
//							if (refPasEnDouble()) {
								ajouterArticle();

//							} else {
//								throw new BLLException("Référence en double !");
//							}
						} else {
							modifierArticle();
						}
						// i = 0;
						articles = mger.getCatalogue();
						if (i != articles.size()) {
							afficherArticle(articles.get(i));
						}
					} catch (BLLException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erreur de saisie",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return boutonSave;
	}

//	protected boolean refPasEnDouble() {
//		for (int i = 0; i < articles.size(); i++) {
//			if (articles.get(i).getReference().equals(txtReference.getText())) {
//				return false;
//			}
//		}
//		return true;
//	}

	private JButton getBoutonDelete() {
		if (boutonDelete == null) {
			boutonDelete = creerBouton("resources/Delete24.gif");
			boutonDelete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					supprimerArticle();
				}
			});
		}
		return boutonDelete;
	}

	private JButton getBoutonForward() {
		if (boutonForward == null) {
			boutonForward = creerBouton("resources/Forward24.gif");
			boutonForward.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (i < articles.size() - 1) {
						i++;
						// System.out.println("++");
					} else {
						// System.out.println("==");
					}
//					System.out.println(i);
//					System.out.println(articles.size());
					afficherArticle(articles.get(i));
					if (i + 1 < articles.size()) {
						boutonBack.setEnabled(true);
					} else {
						boutonForward.setEnabled(false);
					}
				}
			});
		}
		return boutonForward;
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

	public JTextField getTxtReference() {
		if (txtReference == null) {
			txtReference = new JTextField(20);
		}
		return txtReference;
	}

	public JTextField getTxtDesignation() {
		if (txtDesignation == null) {
			txtDesignation = new JTextField(20);
		}
		return txtDesignation;
	}

	public JTextField getTxtMarque() {
		if (txtMarque == null) {
			txtMarque = new JTextField(20);
		}
		return txtMarque;
	}

	public JTextField getTxtStock() {
		if (txtStock == null) {
			txtStock = new JTextField(20);
		}
		return txtStock;
	}

	public JTextField getTxtPrix() {
		if (txtPrix == null) {
			txtPrix = new JTextField(20);
		}
		return txtPrix;
	}

	public JTextField getTxtType() {
		if (txtType == null) {
			txtType = new JTextField(20);
		}
		return txtType;
	}

	public JTextField getTxtGrammage() {
		if (txtGrammage == null) {
			txtGrammage = new JTextField(20);

		}
		return txtGrammage;
	}

	public JTextField getTxtCouleur() {
		if (txtCouleur == null) {
			txtCouleur = new JTextField(20);
		}
		return txtCouleur;
	}

}
