package service.dice;

import domain.Canvas;

public class DiceFive extends Dice implements DiceEach {
	
	public Canvas init(){
		Canvas canvas = super.init();
		
		float centerPosition[] = {SIZE/ 2 / 2, SIZE / 2};
		float sideMargin = SIZE / 4;
		
		float dotPositions[][] = new float[5][2];
		
		dotPositions[0] = centerPosition;
		dotPositions[1][0] = sideMargin;
		dotPositions[1][1] = sideMargin;
		dotPositions[2][0] = sideMargin;
		dotPositions[2][1] = SIZE - sideMargin;
		dotPositions[3][0] = SIZE - sideMargin;
		dotPositions[2][1] = sideMargin;
		dotPositions[3][0] = SIZE - sideMargin;
		dotPositions[2][1] = SIZE - sideMargin;
		
		return setSvgXml(dotPositions, canvas);
		
	}

}
