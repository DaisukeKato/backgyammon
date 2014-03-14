package service.dice;

import domain.Canvas;

public class DiceTwo extends Dice implements DiceEach {
	
	@Override
	public Canvas init(){
		Canvas canvas = super.init();
		
		float dotToDotDistance = SIZE / 3;
		
		float dotPositions[][] = new float[2][2];
		dotPositions[0][0] = dotToDotDistance * 2;
		dotPositions[0][1] = dotToDotDistance;
		dotPositions[1][0] = dotToDotDistance;
		dotPositions[1][1] = dotToDotDistance * 2;
		
		return setSvgXml(dotPositions, canvas);
		
	}

}
