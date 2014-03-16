package service;

class BoardParameters {
	
	static final float SIZE[] = {(float)570, (float)550};
	static final float CENTER_AREA_WIDTH = 50;
	static final float CENTER_AREA_HEIGHT = 60;
	
	static float eachTriangleWidth;
	static float eachTriangleHeight;
	
	static {
		eachTriangleWidth = (SIZE[0] - CENTER_AREA_WIDTH) / 12;
		eachTriangleHeight = (SIZE[1] - CENTER_AREA_HEIGHT) / 2;
	}

}
