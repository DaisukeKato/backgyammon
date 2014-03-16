package service.dice;

import domain.Canvas;

abstract class Dice {
	
	protected static final float SIZE = 100;
	private static final float GEN_DOT_SIZE = (float)9.5; //サイコロの１辺の長さをいくつで割るか
	private static final float VERTEX_RADIUS = 8;
	
	
	protected Canvas init(){
		float size[] = {SIZE, SIZE};
		
		float centerPosition[] = new float[2];
		for(int i = 0; i < 2; i++){
			centerPosition[i] = SIZE / 2;
		}
		
		Canvas canvas = new Canvas("dice", size);
		
		canvas.addWithoutEdgeSquare(centerPosition, SIZE, VERTEX_RADIUS, "white", "black", (float)0.2);
		
		return canvas;
	}
	
	protected Canvas setSvgXml(float[][] dotPositions, Canvas canvas){
		float dotRadius = SIZE / GEN_DOT_SIZE;
		
		for(int i = 0; i < dotPositions.length; i++){
			float eachDotPosition[] = new float[2];
			eachDotPosition[0] = dotPositions[i][0];
			eachDotPosition[1] = dotPositions[i][1];
			canvas.addCircle(eachDotPosition, dotRadius, "black", "black",(float)0.1);
		}
		
		return canvas;
	}

}
