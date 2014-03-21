package service.dice;

import java.util.Random;
import org.springframework.stereotype.Service;

import domain.Canvas;

@Service
public class DiceManager{
	
	public Canvas init(){
		Random random = new Random();
		Dice dice;
		
		int result = Math.abs(random.nextInt()) % 6;
		
		switch(result){
			case 1: 
				dice = new DiceOne();
				break;
			case 2:
				dice = new DiceTwo();
				break;
			case 3:
				dice = new DiceThree();
				break;
			case 4:
				dice = new DiceFour();
				break;
			case 5:
				dice = new DiceFive();
				break;
			case 0:
				dice = new DiceSix();	
				break;
			default:
				throw new InternalError("ローカル変数resultが不正な値" + Integer.toString(result) + "をとりました");
		}
		
		return dice.init();
		
		
	}

}
