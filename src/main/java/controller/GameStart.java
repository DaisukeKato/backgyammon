package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Canvas;
import domain.TipPositionLatticeOverFlow;
import service.Board;
import service.Tips;
import service.dice.DiceManager;

@Controller
public class GameStart {
	
	@Autowired
	Board board;
	
	@Autowired
	Tips tips;
	
	@Autowired
	DiceManager dice;
	
	@RequestMapping("int/com/start")
	public String init(Model model) throws IllegalArgumentException, TipPositionLatticeOverFlow{
		Canvas gameBoard = board.init();
		tips.init(gameBoard);
		
		Canvas dice1 = dice.init();
		Canvas dice2 = dice.init();
		
		model.addAttribute("boardSvgId", gameBoard.id);
		model.addAttribute("boardSvgSize", gameBoard.size);
		model.addAttribute("boardSvgContext", gameBoard.imageObjects);
		
		model.addAttribute("dice1SvgId", dice1.id);
		model.addAttribute("dice1SvgSize", dice1.size);
		model.addAttribute("dice1SvgContext", dice1.imageObjects);
		
		model.addAttribute("dice2SvgId", dice2.id);
		model.addAttribute("dice2SvgSize", dice2.size);
		model.addAttribute("dice2SvgContext", dice2.imageObjects);
		
		return "internal/gameMain";
	}
	
	@ExceptionHandler
	public String internalErrorHandler(Exception e){
		Logger logger = LogManager.getLogger(this.getClass().getName());
		logger.catching(e);
		return "external/internalError";
	}
	
}
