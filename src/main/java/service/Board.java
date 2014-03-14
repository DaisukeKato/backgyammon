package service;

import org.springframework.stereotype.Service;

import domain.Canvas;

import static service.BoardParameters.CENTER_AREA_WIDTH;
import static service.BoardParameters.SIZE;
import static service.BoardParameters.eachTriangleWidth;
import static service.BoardParameters.eachTriangleHeight;

@Service
public class Board {
	
	public Canvas init(){
		
		Canvas canvas = new Canvas("mainboard", SIZE);
		
		float centerPosition[] = new float[2];
		centerPosition[0] = SIZE[0] / 2;
		centerPosition[1] = SIZE[1] / 2;
		
		canvas.addRectangular(centerPosition, SIZE, "lemonchiffon", "lemonchiffon", 1);
		
		float triangleCenterPosition[] = new float[2];
		triangleCenterPosition[0] = eachTriangleWidth / 2;
		triangleCenterPosition[1] = 0;
		byte triangleDirection = -1;
		boolean colorGreenFlg = false;
		for(int i = 0; i < 24; ++i){
			if(colorGreenFlg){
				canvas.addIsoschlesTriangle(triangleDirection, triangleCenterPosition, eachTriangleHeight, eachTriangleWidth, "royalblue", "royalblue", 1);
				colorGreenFlg = false;
			}else{
				canvas.addIsoschlesTriangle(triangleDirection, triangleCenterPosition, eachTriangleHeight, eachTriangleWidth, "red", "red", 1);
				colorGreenFlg = true;
			}
			triangleCenterPosition[0] += eachTriangleWidth;
			if(i == 5||i == 17){
				triangleCenterPosition[0] += CENTER_AREA_WIDTH;
			}
			if(i == 11){
				triangleDirection = 1;
				triangleCenterPosition[0] = eachTriangleWidth / 2;
				triangleCenterPosition[1] = SIZE[1];
			}
		}
		
		return canvas;
		
	}

}
