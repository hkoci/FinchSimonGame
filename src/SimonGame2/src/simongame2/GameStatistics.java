package simongame2;

//Saving,reading ability
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import simongamefx.SimonFX;

public class GameStatistics {
    //global variables for game information
	private static int score;
	private static int highscore;
	private static int round;
	private static int lives;
        private static boolean firstTime;
	
	//File directory for saving
	/*
	 * 	String directory = System.getProperty("user.home");
		String fileName = "SimonStats.cfg";
		String absolutePath = directory + File.separator + fileName;
	 */
	
        //path of where the flat file is stored on the PC
	private static final String absolutePath = System.getProperty("user.home") + File.separator + "SimonStats.cfg";
	
	//Constructor will assign the values to any initialised variables.
	public GameStatistics() {
		score = 0;
		highscore = 0;
		round = 0;
		lives = 3;
                firstTime = false;
                String name = SimonFX.getMPName();
		
		InitialiseFileLoading();
	}
        
        //Getters and setters for encapsulation

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		GameStatistics.score = score;
		FileWriter(); //call writer on variable change
	}

	public int getHighscore() {
		return highscore;
	}

	public void setHighscore(int highscore) {
		GameStatistics.highscore = highscore;
		FileWriter(); //call writer on variable change
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		GameStatistics.round = round;
		FileWriter(); //call writer on variable change
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		GameStatistics.lives = lives;
	}
        
        public boolean getIsPlayedFirstTime() {
		return firstTime;
	}

	private static void InitialiseFileLoading() {
                //store current line number
		int lineNumber = 0;

		// read the content from file
		/* the stored file should look like:
		 SimonStats.cfg
		 Score: 0
		 Highscore: 0
		 Level: 0 */
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath))) {
			
		    String line = bufferedReader.readLine(); //stores the line of the currently being read line in file
		    
		    while(line != null) {
		    	lineNumber++; //increment counter for lineNumber (so it can stop on 3 which will be EOF)
		    	switch(lineNumber) {
		    	case 1: //line 1 Score: 0
		    		GameStatistics.score = Integer.valueOf(line.replaceAll("[^0-9]", "")); //Store the value of score in score variable globally, using regex to remove any characters but numbers
		    	case 2: //line 2 Highscore: 0
		    		GameStatistics.highscore = Integer.valueOf(line.replaceAll("[^0-9]", "")); //Store the value of score in score variable globally, using regex to remove any characters but numbers
		    	case 3: //line 3 Level: 0
		    		GameStatistics.round = Integer.valueOf(line.replaceAll("[^0-9]", "")); //Store the value of score in score variable globally, using regex to remove any characters but numbers
		    		break; //break while loop to stop looping
		    	default:
		    		throw new IOException("The file has been incorrectly modified!");
		    	}
		        
		        line = bufferedReader.readLine();
		    }
		} catch (FileNotFoundException e) {
                    //if file cant be read, initialise the filewriter for first time with blank file
                        GameStatistics.firstTime = true;
			FileWriter();
		} catch (IOException e) {
		    // exception handling
			// if file is corrupt or modified, reset stats by making new file again.
			FileWriter();
		}
		
	}
	
	private static void FileWriter() {
		// write the content in file 
		try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absolutePath))) {
		    String fileContent = 
		    		"Score: " + score + '\n' +
		    		"Highscore: " + highscore + '\n' +
		    		"Round: " + round;
		    bufferedWriter.write(fileContent);
		} catch (IOException e) {
		    // exception handling
		}
	}

}