package fr.eni.demoswing;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DemoSwingApp {
	public static void main(String[] args) {
		// Solution 1 : tout mettre dans le main

		// SOlution 2 :
		// SwingUtilities.invokeLater(new MonRunnable());

		// Solution 3 :
		// SwingUtilities.invokeLater(new MonRunnableInterne());

		// Solution 4 : Classe anonyme, beaucoup utilisé en Swing
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				EcranPrincipal ecran = new EcranPrincipal();

			}
		});

	}

	// Solution 3 : Classe interne (forcément static)
//	static class MonRunnableInterne implements Runnable {
//
//		@Override
//		public void run() {
//			EcranPrincipal ecran = new EcranPrincipal();
//			
//		}
//
//	}
}
