import java.util.Scanner;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Random; 

public class zgadnijliczbe {
	// Generator pseudolosowej liczby
	static LocalTime localTime = LocalTime.now();
	static int time = localTime.getHour() + localTime.getMinute() + localTime.getSecond();
	static Scanner input = new Scanner(System.in);
	static Random random = new Random(time); 
	///////////////////////
	
	// Rysowanie menu
	public static String menu() {
		Scanner input = new Scanner(System.in);
		System.out.println("Witaj w ZgadnijLiczbe!");
		System.out.println("Wybierz poziom trudnoœci:");
		System.out.println("(a): ³atwy");
		System.out.println("(b): œredni");
		System.out.println("(c): trudny");
		System.out.println("(d): w³asny");
		return input.next();
	}
	///////////////////////
	
	
	//Obs³uga wartoœci wpisanych w menu
	public static void main(String[] args) throws InterruptedException, IOException {
		String choice = menu();
		switch(choice) {
			case "a":
				game("easy", 30);
				break;
			case "b":
				game("medium", 60);
				break;
			case "c":
				game("hard", 100);
				break;
			case "d":
				Scanner input = new Scanner(System.in);
				System.out.println("0-do?");
				if(!input.hasNextInt()) main(args);
				else {
					game("custom", input.nextInt());
					input.close();
				}
				break;
			default:
				cls();
				main(args);
				break;
		}
	}
	///////////////////////
	
	//Gra
	public static void game(String args,int max) throws InterruptedException, IOException {
		cls();
		Scanner input = new Scanner(System.in);
		System.out.println("Tryb rozgrywki: " + args);
		System.out.println("Od:0 do " + max);
		int numer = random.nextInt(max);
		int choice = input.nextInt();
		while(choice != numer) {
			if(choice > numer) {
				System.out.println("Za du¿o");
				choice = input.nextInt();
			}else if(choice < numer) {
				System.out.println("Za ma³o");
				choice = input.nextInt();
			}
		}
		System.out.println("Trafi³eœ");
		Thread.sleep(2500);
		cls();
		System.exit(1);
	}
	///////////////////////
	
	public static void cls() throws InterruptedException, IOException {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}

}
