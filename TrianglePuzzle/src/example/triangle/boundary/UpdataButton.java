package example.triangle.boundary;

import java.util.List;



public class UpdataButton {
	
	public static void InitButtons(TrianglePuzzleApp app) {
		app.getBtnSwapButton().setEnabled(false);
		app.getBtnUnselectButton().setEnabled(false);
		app.getBtnResetButton().setEnabled(true);
		
	}
	
	public static void enableSwap(TrianglePuzzleApp app) {
		app.getBtnSwapButton().setEnabled(true);
	}
	
	public static void disableSwap(TrianglePuzzleApp app) {
		app.getBtnSwapButton().setEnabled(false);
	}
	
	public static void enableUnselect(TrianglePuzzleApp app) {
		app.getBtnUnselectButton().setEnabled(true);
	}
	
	public static void disableUnselect(TrianglePuzzleApp app) {
		app.getBtnUnselectButton().setEnabled(false);
	}
	
	public static void enableReset(TrianglePuzzleApp app) {
		app.getBtnResetButton().setEnabled(true);
	}
	
	public static void disableReset(TrianglePuzzleApp app) {
		app.getBtnResetButton().setEnabled(false);
	}

}
