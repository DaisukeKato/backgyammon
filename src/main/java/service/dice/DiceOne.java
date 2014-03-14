package service.dice;

import domain.Canvas;

public class DiceOne extends Dice implements DiceEach {
	
	@Override
	public Canvas init(){
		Canvas canvas = super.init();
		
		float dotRadius = SIZE / 5;
		float centerPosition[] = new float[2];
		centerPosition[0] = SIZE / 2;
		centerPosition[1] = SIZE / 2;
		canvas.addCircle(centerPosition, dotRadius, "red", "red", (float)1);
		
		return canvas;
	}

}
