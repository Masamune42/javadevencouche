package fr.escape.launcher;

import java.lang.reflect.Field;

import fifthLevel.Fifth;
import fr.eni.deepForest.GCD;
import fr.eni.deepForest.Sixieme.MonException;
import fr.eni.deepForest.Sixieme.Sixieme;
import fr.eni.deepForest.levelOne.ToFirstFlag;
import fr.eni.deepForest.levelThree.ThirdLevel;
import fr.eni.deepForest.levelTwo.CursorLinkedList;
import fr.eni.deepForest.levelTwo.DrapeauDeux;
import fr.eni.deepForest.nivQuatre.FourthLevelApplication;

public class Launcher {

	public static void main(String[] args) throws Exception {

		ToFirstFlag m = new ToFirstFlag();

		m.getClass().getConstructors();

		ToFirstFlag f1 = new ToFirstFlag();

		System.out.println("Flag 1 : ");
		System.out.println(f1.getFirstFlag());
		String level1 = f1.getFirstFlag();

		System.out.println("Flag 2 : ");
		System.out.println(DrapeauDeux.drapeauDeux());
		// String level2 = DrapeauDeux.drapeauDeux();
		DrapeauDeux d2 = new DrapeauDeux();
		
		// taille = 72
		CursorLinkedList<String> cll = new CursorLinkedList<>();
		// cll.indexOf("LA_CLE_NUMERIQUE");
		int level2 = 72;

		System.out.println("Flag 3 : ");
		ThirdLevel.get().thirdLevel();
		String level3 = "La DetTE tEChnIqUE vous EvITErez !!!";

		System.out.println("Flag 4 : ");
		FourthLevelApplication.main(args);
		String level4 = "Dans GCD le graal se trouve.";

		System.out.println("Flag 5 : ");
		Fifth fifth = new Fifth();
		String level5 = "A la simplicite tu te convertiras.";
		System.out.println(level5);

		System.out.println("Flag 6 : ");
		String level6 = "";
		try {
			Sixieme.jeNacceptePasLesNombresNegatifs(-2);
		} catch (MonException e) {
			System.out.println(e.getNiveauCinq());
			level6 = e.getNiveauCinq();

		}

		System.out.println();
		try {
			GCD t = new GCD(level1, level2, level3, level4, level5, level6);
			System.out.println(t.graal());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
