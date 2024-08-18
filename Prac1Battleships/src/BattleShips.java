import java.util.Scanner;
import java.util.Random;  //Additional import
public class BattleShips {

    private char[][] grid = new char [10][10];
    //TODO: Add your code here
    
    public void print() {
    	for (int i = 0; i < 10; i++) {
    		System.out.print("\t"+i);  
    	}
    	System.out.println();
    	for (int i = 0; i < 10; i++) {
    		System.out.print(i);
    		for (int j = 0; j < 10; j++){
    			System.out.print("\t" + "[");
    			if (grid[i][j] == 'H') { //Check for what is in the array for printing
    				System.out.print("H");
    			}else if(grid[i][j] == 'M') {
    				System.out.print("M");
    			}else {
    				System.out.print(" ");
    			}
    			System.out.print("]");
    		}
    		System.out.println();
    	}
    }
    
    public void placeships() {
    	for (int i = 5; i > 0; i--) { //Size of ships been looped
    		boolean validPremise = true;
    		Random rand = new Random();  
    		int x = 0;
    	    int y = 0;
    	    
    	    while (validPremise) {
    	    	x = rand.nextInt(10);
    	    	y = rand.nextInt(10-i);  //randomizing where ships are
    	    	validPremise = false;
    	    	for (int j = y; j < y + i; j++) {
    	    		if (grid[x][j] == 'S') {  //Sorting where ships are and avoiding overlaps
    	    			validPremise = true;
    	    		}
    	    	}
    	    }
    	    for (int j = y; j < y + i; j++) {
    	    	grid[x][j] = 'S';
    	    }
    	}
    }
    
    private boolean canFire(int row, int col) {
    	if (grid[row][col] == 'H' || grid[row][col] == 'M') {  //Check for if a hit has been done at particular co-rodinates
    		return false;
    	}else {
    		return true;
    	}
    	
    }
    
    public void processFire(int row, int col) {
    	if (canFire(row,col)) { //Check for if there is a ship 
    		if (grid[row][col] == 'S') {
    			grid[row][col] = 'H';
    		}else {
    			grid[row][col] = 'M';  //Else if there's none
    		}
    	}else
		    System.out.println("Already Hit Position: ( " +row+ " , " +col+ " )"); //If already been hit
    }
    
    public boolean gameOver() {
    	for (int i = 0; i < 10; i++) {
    		for (int j = 0; j < 10; j++) {
    			if (grid[i][j] == 'S') {  //Checks if there is still a ship or part of a ship
    				return false;
    			}
    		}
    	}
    	return true;
    }
}
