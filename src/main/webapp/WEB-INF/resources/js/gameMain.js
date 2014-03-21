/**
 * 
 */
function mouseOn(e){
	var currentTip = e.target;
	currentTip.style.setProperty("stroke", "yellow");
}

function mouseOut(e){
	var currentTip = e.target;
	currentTip.style.setProperty("stroke", currentTip.style.getPropertyValue("fill"));
}

function init(){
	var tips = document.querySelectorAll("#mainboard > circle");
	for(var i = 0; i < tips.length; i++){
		tips[i].addEventListener("mouseover", mouseOn, false);
		tips[i].addEventListener("mouseout", mouseOut, false);
	}
}

window.addEventListener("load", init, false);