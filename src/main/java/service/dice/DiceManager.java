package service.dice;

import java.util.Random;
import org.springframework.stereotype.Service;

import domain.Canvas;

@Service
public class DiceManager {
	
	public Canvas init(){
		Random random = new Random();
		Dice dice;
		
		int result = random.nextInt() % 6;
		
		switch(result){
			case 1: 
				dice = new DiceOne();
			case 2:
				dice = new DiceTwo();
			case 3:
				dice = new DiceThree();
			case 4:
				dice = new DiceFour();
			case 5:
				dice = new DiceFive();
			default:
				dice = new DiceSix();
		}
		
		return dice.init();
	}

}
