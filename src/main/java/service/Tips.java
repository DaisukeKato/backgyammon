package service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;

import static common.constant.Color.color;
import static service.BoardParameters.SIZE;
import static service.BoardParameters.eachTriangleWidth;
import static service.BoardParameters.CENTER_AREA_WIDTH;
import domain.Canvas;
import domain.LatticeOperation;
import domain.TipPositionLattice;
import domain.TipPositionLatticeOverFlow;

@Service
public class Tips {
	
	private static final float TIPS_RADIUS_FACTOR = (float) 0.98;
	
	private float tipsRadius;
	
	public Tips(){
		this.tipsRadius = (eachTriangleWidth / 2) * TIPS_RADIUS_FACTOR;
	}
	
	public void init(Canvas canvas) throws IllegalArgumentException, TipPositionLatticeOverFlow{
		LatticeOperation latticeOperation = new LatticeOperation();
		TipPositionLattice lattice = latticeOperation.init();
		
		latticeToSvg(canvas, lattice);
	}
	
	private void latticeToSvg(Canvas canvas, TipPositionLattice lattice){
		float centerPosition[] = new float[2];
		centerPosition[0] = SIZE[0] - eachTriangleWidth / 2;
		centerPosition[1] = SIZE[1] - tipsRadius;
		for(short i = 1; i <= 24; i++){
			if(!lattice.map.containsKey(i)){
				completeEachLot(i, centerPosition);
				continue;
			}
			for(Iterator<Short> j = lattice.map.get(i).iterator(); j.hasNext();){
				short tipColor = j.next();
				if(tipColor == 1){
					canvas.addCircle(centerPosition, tipsRadius, color.get("tip1"), color.get("tip1"), 1);
				}else if(tipColor == 2){
					canvas.addCircle(centerPosition, tipsRadius, color.get("tip2"), color.get("tip2"), 1);
				}
				if(i <= 12){
					centerPosition[1] -= tipsRadius * 2;
				}else{
					centerPosition[1] += tipsRadius * 2;
				}
			}
			completeEachLot(i, centerPosition);
		}
	}
	
	private void completeEachLot(short lotNo, float[] centerPosition){
		if(lotNo < 12){
			centerPosition[0] -= eachTriangleWidth;
		}
		if(lotNo > 12){
			centerPosition[0] += eachTriangleWidth;
		}
		if(lotNo == 6){
			centerPosition[0] -= CENTER_AREA_WIDTH;
		}
		if(lotNo == 18){
			centerPosition[0] += CENTER_AREA_WIDTH;
		}
		if(lotNo < 12){
			centerPosition[1] = SIZE[1] - tipsRadius;
		}else{
			centerPosition[1] = tipsRadius;
		}
	}
}
