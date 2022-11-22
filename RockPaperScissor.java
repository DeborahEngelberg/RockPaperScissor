import java.util.Random; //so that I can use the random module for strategy 1
import java.util.Scanner;
public class RockPaperScissor {
	public static void main(String [] args){
		userInput();
	}
	
	public static void userInput(){ //this function will describe the game, ask for users input and assign it to a variable so it can be used in parameters
		System.out.println("This is a game of Rock Paper Scissor. Rock (defeats scissor, but loses to paper), Paper (defeats rock, but loses to scissors), and Scissors (defeats paper, but loses to rock)");
		Scanner console = new Scanner(System.in); //scanner object
		System.out.print("Which strategy would you like, 1 or 2? "); //first print statement which will be followed by input
		int askStrategy = console.nextInt(); 
		System.out.print("Choose one of these three items: rock, paper, and scissor (or enter \"end game\" to end the game): "); //first print statement which will be followed by input
		String itemChoice = console.next();
		strategyInput(askStrategy,itemChoice);
		
	}
		
	
	public static String strategyInput(int strategy, String response) {
		while (!response.equals("end game")) {
			if (checkResponse(response)==true) {
				if (strategy == 1) {
					response = strategyOne(response);
				}
				else if (strategy == 2) {
					response = strategyTwo(response);
				}
				else {
					System.out.println("Please enter a valid strategy");
					return response;
				}
			}
			else {
				//System.out.println("Please enter a valid item");
				//Scanner console = new Scanner(System.in);
				//System.out.print("Choose one of these three items: rock, paper, and scissor (or enter \"end game\" to end the game): "); //first print statement which will be followed by input
				//response = console.next();
			}
		
		}
		return "";
	}
	
	public static String strategyOne(String response) {
		if (checkResponse(response)) {
			int randomItem = new Random().nextInt(1,4);
			String computerChoice = computerTranslate(randomItem);
			decide (response, computerChoice);
		}
		else {
			return response;
		}
		return "";
	}
	
	public static String strategyTwo (String response) {
		String computer = "paper";
		decide(response, computer);
		return "";
	}
	
	public static boolean checkResponse (String response) {
		response.toLowerCase();
		if (!response.equals("rock") && !response.equals("paper")&& !response.equals("scissor")){
			return false;
		}
		return true;
	}
	public static void decide (String user, String computer) {
		System.out.println("User chose: " + user + " and computer chose: " + computer);
		if (user.equals(computer)) {
			System.out.println("It's a tie!");
		}
		else {
			if(user.equals("rock") && computer.equals("scissor")|| user.equals("scissor") && computer.equals("paper") || user.equals("paper") && computer.equals("rock")) {
				System.out.println("User wins! Computer lost.");
			}
			else if (user.equals("rock") && computer.equals("paper") || user.equals("paper") && computer.equals("scissor") || user.equals("scissor") && computer.equals("rock")){
				System.out.println("Computer wins! User lost.");
			}
		}
	}
	
	public static String computerTranslate(int item) {
		if(item==1) {
			return "rock";
		}
		else if (item==2) {
			return "paper";
		}
		else if (item==3) {
			return "scissor";
		}
		return "";
	}
}