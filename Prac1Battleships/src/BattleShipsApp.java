import java.util.Scanner;
public class BattleShipsApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// TODO: Add your code here
		BattleShips battle = new BattleShips();
		battle.placeships();
		battle.print();
		while (!battle.gameOver()) {
			System.out.print("Enter Row: ");  //Input for co-ordinates
			int a = sc.nextInt();
			System.out.print("Enter Column: ");
			int b = sc.nextInt();
			while (!(-1 < a && a < 10) || !(-1 < b && b < 10) ) {  //Check for valid co-ordinates
				System.out.print("Invalid Entry \nEnter Row: ");
				a = sc.nextInt();
				System.out.print("Enter Column: ");
				b = sc.nextInt();
			}
			battle.processFire(a, b);
			battle.print();
		}
	}
}
