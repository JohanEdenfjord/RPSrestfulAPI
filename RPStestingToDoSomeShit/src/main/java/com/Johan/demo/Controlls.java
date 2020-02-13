package com.Johan.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlls {

	@GetMapping(path = "/hello-World")
	public String helloWorld2() { //you can do easier code with the GetMapping Annotation! But its limited! so we use RequestMapping!
		return "hello World";
	}
	
	@RequestMapping(value = "/score/wins", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getWins() {
		
		String pattern = "{\"Wins\":\"%s\"}";		
		return String.format(pattern, ScoreBean.wins);
	}
	
	@RequestMapping(value = "/score/loss", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getLoss() {
		
		String pattern = "{\"Losses\":\"%s\"}";		
		return String.format(pattern, ScoreBean.loss);
		
	}
	
	@RequestMapping(value = "/score/ties", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getTies() {
		
		String pattern = "{\"Ties\":\"%s\"}";		
		return String.format(pattern, ScoreBean.ties);
		
	}
	
	@RequestMapping(value = "/score/wins", method = RequestMethod.POST)
	public int increaseWins() { //But when we want to call this we need to make a post! And we need to build it. in a form for example! 
		ScoreBean.wins++;
		return ScoreBean.wins;
	}
	//you can build a different html and have a form to point to the localhost you started!

	//same for the other values!
	
	@RequestMapping(value = "/score/loss", method = RequestMethod.POST)
	public int increaseLoss() {
		ScoreBean.loss++;
		return ScoreBean.loss;
	}
	
	@RequestMapping(value = "/score/ties", method = RequestMethod.POST)
	public int increaseTies() {
		ScoreBean.ties++;
		return ScoreBean.ties;
	}
	//to avoid to use the data in the controller you have to do a "Bean"
	
	@RequestMapping(value = "/score", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getScoreBean() { //we want to do a specific thing in /score and return maybe more than one value!(JSON)!
		String pattern = "{ \"wins\":\"%s\", \"losses\":\"%s\", \"ties\": \"%s\"}"; //this is a standard formation for JSON and it points to a certain site!
		
		return String.format(pattern, ScoreBean.wins, ScoreBean.loss, ScoreBean.ties);//returns a string in the JSON pattern!
	}
	
	
	
	@RequestMapping(value = "/score", method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public String update(int wins,int losses, int ties) {//this is what we have to look at. How to do it! and probably make a god thing to work with it! 
		
		ScoreBean.wins = wins;
		ScoreBean.loss = losses;
		ScoreBean.ties = ties;
		
		String pattern = "{ \"wins\":\"%s\", \"losses\":\"%s\", \"ties\": \"%s\"}"; //this is a standard formation for JSON and it points to a certain site!		
		return String.format(pattern, ScoreBean.wins, ScoreBean.loss, ScoreBean.ties);//returns a string in the JSON pattern!
		
	}
	
	@RequestMapping(value="/playerVSComputer", method = RequestMethod.POST)
	public String VSComputer(String player) {
			Machine cpu = new Machine();	//Creates the CPU player! called cpu to make it easy!	
			String result= cpu.computer(); //calls the cpu Move!
			String pattern = "{ \"player\":\"%s\", \"Computer\":\"%s\", \"ties\": \"%s\"}";
			
			if(result.equals(player)) { //Compares it to the player move and returns result and adds wins/ties/loss!
				ScoreBean.ties++;				
				return String.format(pattern, ScoreBean.wins, ScoreBean.loss, ScoreBean.ties);			
			}else{
				if (player.equals("rock")) {
					if (result.equals("scissor")) {
						
						ScoreBean.wins++;
						return String.format(pattern, ScoreBean.wins, ScoreBean.loss, ScoreBean.ties);
					} else {
						
						ScoreBean.loss++;
						return String.format(pattern, ScoreBean.wins, ScoreBean.loss, ScoreBean.ties);
					}
				}

				else if (player.equals("scissor")) {
					if (result.equals("paper")) {
						
						ScoreBean.wins++;
						return String.format(pattern, ScoreBean.wins, ScoreBean.loss, ScoreBean.ties);
					} else {
						
						ScoreBean.loss++;
						return String.format(pattern, ScoreBean.wins, ScoreBean.loss, ScoreBean.ties);
					}
				}

				else if (player.equals("paper")) {
					if (result.equals("rock")) {
						
						ScoreBean.wins++;
						return String.format(pattern, ScoreBean.wins, ScoreBean.loss, ScoreBean.ties);
					} else {
						
						ScoreBean.loss++;
						return String.format(pattern, ScoreBean.wins, ScoreBean.loss, ScoreBean.ties);
					}
			}
		
		}
		return "unexpected wrong";	
	}
	
	@RequestMapping(value="/playerVSPlayer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String VSPlayer(String player, String player2) {
		   String pattern = "{ \"player 1\":\"%s\", \"Player 2\":\"%s\", \"ties\": \"%s\"}";		
			
			if(player2.equals(player)) { //Compares it to the players moves and returns result and adds to wins/ties/loss!
				ScoreBean.ties++;				
				return String.format(pattern, ScoreBean.wins, ScoreBean.loss, ScoreBean.ties);			
			}else{
				
				if (player.equals("rock")) {
					if (player2.equals("scissor")) {						
						ScoreBean.wins++;
						return String.format(pattern, ScoreBean.wins, ScoreBean.loss, ScoreBean.ties);
					} else {						
						ScoreBean.loss++;
						return String.format(pattern, ScoreBean.wins, ScoreBean.loss, ScoreBean.ties);
					}
				}

				else if (player.equals("scissor")) {
					if (player2.equals("paper")) {						
						ScoreBean.wins++;
						return String.format(pattern, ScoreBean.wins, ScoreBean.loss, ScoreBean.ties);
					} else {						
						ScoreBean.loss++;
						return String.format(pattern, ScoreBean.wins, ScoreBean.loss, ScoreBean.ties);
					}
				}

				else if (player.equals("paper")) {
					if (player2.equals("rock")) {						
						ScoreBean.wins++;
						return String.format(pattern, ScoreBean.wins, ScoreBean.loss, ScoreBean.ties);
					} else {
						ScoreBean.loss++;
						return String.format(pattern, ScoreBean.wins, ScoreBean.loss, ScoreBean.ties);
					}
			}
		
		}
		return "unexpected wrong";	
	}


}
	
	
	

