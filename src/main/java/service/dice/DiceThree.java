package service.dice;

import domain.Canvas;

public class DiceThree extends Dice implements DiceEach {
	
	public Canvas init(){
		Canvas canvas = super.init();
		
		float diceToDiceDistance = SIZE / 4;
		
		float dotPositions[][] = new float[3][2];
		
		for(int i = 1; i <= 3; i++){
			dotPositions[i][0] = SIZE - diceToDiceDistance * i;
			dotPositions[i][1] = diceToDiceDistance * i;
		}
		
		return setSvgXml(dotPositions, canvas);
	}

}
