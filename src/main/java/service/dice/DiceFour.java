package service.dice;

import domain.Canvas;

public class DiceFour extends Dice implements DiceEach {
	
	public Canvas init(){
		Canvas canvas = super.init();
		float sideMargin = SIZE / 4;
		float dotToDotSpace = SIZE / 2;
		float dotPositions[][] = new float[4][2];
		
		dotPositions[0][0] = sideMargin;
		dotPositions[0][1] = sideMargin;
		dotPositions[1][0] = dotPositions[0][0];
		dotPositions[1][1] = dotPositions[0][1] + dotToDotSpace;
		dotPositions[2][0] = dotPositions[0][0] + dotToDotSpace;
		dotPositions[2][1] = dotPositions[0][1];
		dotPositions[3][0] = dotPositions[0][0] + dotToDotSpace;
		dotPositions[3][1] = dotPositions[0][1] + dotToDotSpace;
		
		return setSvgXml(dotPositions, canvas);
	}

}
