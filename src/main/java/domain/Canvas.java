package domain;

import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.HashMap;

public class Canvas {
	
	public String id;
	public float size[] = {0, 0};
	
	public Set<Map<String, String>> imageObjects;
	
	public Canvas(String id, float size[]){
		
		this.id = id;
		
		this.size = size;
		
		this.imageObjects = new LinkedHashSet<Map<String, String>>();
		
	}
	
	public void addIsoschlesTriangle(byte direction, float basePosition[], float height, float width, String intColor, String pathColor, float pathWeight){
		float topVertex[] = new float[2];
		float rightUnderVertex[] = new float[2];
		
		Map<String, String> triangleParameters = new HashMap<String, String>();
		
		triangleParameters.put("type", "path");
		triangleParameters.put("fill", intColor);
		triangleParameters.put("stroke", pathColor);
		triangleParameters.put("stroke-width", Float.toString(pathWeight));
		
		if(direction == 1){
			topVertex[0] = basePosition[0];
			topVertex[1] = basePosition[1] - height;
			
			rightUnderVertex[0] = basePosition[0] - width / 2;
			rightUnderVertex[1] = basePosition[1];
		}else if(direction == -1){
			topVertex[0] = basePosition[0];
			topVertex[1] = basePosition[1] + height;
			
			rightUnderVertex[0] = basePosition[0] - width / 2;
			rightUnderVertex[1] = basePosition[1];
		}
		
		StringBuffer dValue = new StringBuffer("M " + Float.toString(topVertex[0]) + " " + Float.toString(topVertex[1]) + " ");
		dValue.append("L " + Float.toString(rightUnderVertex[0]) + " " + Float.toString(rightUnderVertex[1]) + " ");
		dValue.append("H " + Float.toString(rightUnderVertex[0] + width) + " Z");
		
		triangleParameters.put("d", dValue.toString());
		
		this.imageObjects.add(triangleParameters);
	}
	
	public void addRectangular(float centerPosition[], float size[], String intColor, String pathColor, float pathWeight){
		float leftUpperPosition[] = new float[2];
		leftUpperPosition[0] = centerPosition[0] - size[0] / 2;
		leftUpperPosition[1] = centerPosition[1] - size[1] / 2;
		
		Map<String, String> rectangularParameters = new HashMap<String, String>();
		
		rectangularParameters.put("type", "rect");
		rectangularParameters.put("x", Float.toString(leftUpperPosition[0]));
		rectangularParameters.put("y", Float.toString(leftUpperPosition[1]));
		rectangularParameters.put("width", Float.toString(size[0]));
		rectangularParameters.put("height", Float.toString(size[1]));
		rectangularParameters.put("fill", intColor);
		rectangularParameters.put("stroke", pathColor);
		rectangularParameters.put("stroke-width", Float.toString(pathWeight));
		
		this.imageObjects.add(rectangularParameters);
	}
	
	public void addCircle(float centerPosition[], float radius, String intColor, String pathColor, float pathWeight){
		Map<String, String> circleParameters = new HashMap<String, String>();
		
		circleParameters.put("type", "circle");
		circleParameters.put("cx", Float.toString(centerPosition[0]));
		circleParameters.put("cy", Float.toString(centerPosition[1]));
		circleParameters.put("r", Float.toString(radius));
		circleParameters.put("fill", intColor);
		circleParameters.put("stroke", pathColor);
		circleParameters.put("stroke-width", Float.toString(pathWeight));
		
		this.imageObjects.add(circleParameters);
	}
	
	public void addCircleWithId(String id, float centerPosition[], float radius, String intColor, String pathColor, float pathWeight){
		Map<String, String> circleParameters = new HashMap<String, String>();
		
		circleParameters.put("type", "circle");
		circleParameters.put("id", id);
		circleParameters.put("cx", Float.toString(centerPosition[0]));
		circleParameters.put("cy", Float.toString(centerPosition[1]));
		circleParameters.put("r", Float.toString(radius));
		circleParameters.put("fill", intColor);
		circleParameters.put("stroke", pathColor);
		circleParameters.put("stroke-width", Float.toString(pathWeight));
		
		this.imageObjects.add(circleParameters);
	}
	
	//角無し正方形の各パラメータからsvgの要素情報を返す
	public void addWithoutEdgeSquare(float centerPosition[], float size, float vertexRadius, String intColor, String pathColor, float pathWeight) throws IllegalArgumentException{
		for(int i = 0; i < 2; i++){
			if(centerPosition[i] < 0||centerPosition[i] > this.size[i]) throw new IllegalArgumentException("角無し正方形の位置または大きさが表示区域内に収まりません");
			if(centerPosition[i] < size / 2||centerPosition[i] + size / 2 > this.size[i]) throw new IllegalArgumentException("角無し正方形の位置または大きさが表示区域内に収まりません");
		}
		if(size <= vertexRadius * 2){
			throw new IllegalArgumentException("角無し正方形のサイズ指定の不整合です");
		}
		
		float upperLineLeftEdge[] = new float[2];
		float upperLineRightEdge[] = new float[2];
		float underLineLeftEdge[] = new float[2];
		float underLineRightEdge[] = new float[2];
		float leftLineTop[] = new float[2];
		float leftLineBottom[] = new float[2];
		float rightLineTop[] = new float[2];
		float rightLineBottom[] = new float[2];
		
		upperLineLeftEdge[0] = centerPosition[0] - size / 2 + vertexRadius;
		upperLineLeftEdge[1] = centerPosition[1] - size / 2;
		
		upperLineRightEdge[0] = centerPosition[0] + size / 2 - vertexRadius;
		upperLineRightEdge[1] = centerPosition[1] - size / 2;
		
		underLineLeftEdge[0] = centerPosition[0] - size / 2 + vertexRadius;
		underLineLeftEdge[1] = centerPosition[1] + size / 2;
		
		underLineRightEdge[0] = centerPosition[0] + size / 2 - vertexRadius;
		underLineRightEdge[1] = centerPosition[1] + size / 2;
		
		leftLineTop[0] = centerPosition[0] - size / 2;
		leftLineTop[1] = centerPosition[1] - size / 2 + vertexRadius;
		
		leftLineBottom[0] = centerPosition[0] - size / 2;
		leftLineBottom[1] = centerPosition[1] + size / 2 - vertexRadius;
		
		rightLineTop[0] = centerPosition[0] + size / 2;
		rightLineTop[1] = centerPosition[1] - size / 2 + vertexRadius;
		
		rightLineBottom[0] = centerPosition[0] + size / 2;
		rightLineBottom[1] = centerPosition[1] + size / 2 - vertexRadius;
		
		Map<String, String> squareParameters = new HashMap<String, String>();
		
		squareParameters.put("type", "path");
		
		squareParameters.put("fill", intColor);
		squareParameters.put("stroke", pathColor);
		squareParameters.put("stroke-width", Float.toString(pathWeight));
		
		StringBuffer dValue = new StringBuffer();
		dValue.append("M " + Float.toString(leftLineTop[0]) + " " + Float.toString(leftLineTop[1]) + " ");
		dValue.append("A" + Float.toString(vertexRadius) + " " + Float.toString(vertexRadius) + " " + "0 0 1 ");
		dValue.append(Float.toString(upperLineLeftEdge[0]) + " " + Float.toString(upperLineLeftEdge[1]) + " ");
		dValue.append("H " + Float.toString(upperLineRightEdge[0]) + " ");
		dValue.append("A " + Float.toString(vertexRadius) + " " + Float.toString(vertexRadius) + " 0 0 1 ");
		dValue.append(Float.toString(rightLineTop[0]) + " "+ Float.toString(rightLineTop[1]) + " ");
		dValue.append("V" + Float.toString(rightLineBottom[1]) + " ");
		dValue.append("A " + Float.toString(vertexRadius) + " " + Float.toString(vertexRadius) + " 0 0 1 ");
		dValue.append(Float.toString(underLineRightEdge[0]) + " " + Float.toString(underLineRightEdge[1]) + " ");
		dValue.append("H " + Float.toString(underLineLeftEdge[0]) + " ");
		dValue.append("A " + Float.toString(vertexRadius) + " " + Float.toString(vertexRadius) + " 0 0 1 ");
		dValue.append(Float.toString(leftLineBottom[0]) + " " + Float.toString(leftLineBottom[1]) + " Z");
		
		squareParameters.put("d", dValue.toString());
		
		this.imageObjects.add(squareParameters);
		
	}
	
}
