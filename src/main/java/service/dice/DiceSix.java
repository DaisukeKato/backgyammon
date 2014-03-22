package service.dice;

import domain.Canvas;

public class DiceSix extends Dice implements DiceEach {
	
	public Canvas init(){
		float xDotToDotSpace = SIZE / 3;
		float yDotToDotSpace = SIZE / 4;
		
		float curDotPosX = xDotToDotSpace;
		float curDotPosY = yDotToDotSpace;
		float dotPositions[][] = new float[6][2];
		
		Canvas canvas = super.init();
		
		for(int i = 0; i < 6; i++){
			dotPositions[i][0] =  curDotPosX;
			dotPositions[i][1] =  curDotPosY;
			if(i == 2){
				curDotPosX += xDotToDotSpace;
				curDotPosY = yDotToDotSpace;
			}else{
				curDotPosY += yDotToDotSpace;
			}
		}
		
		return setSvgXml(dotPositions, canvas);
	}

}
