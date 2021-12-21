package simongame2;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class GameSQL 
{
	
	public static void main(String[] args) throws Exception 
	{
		createTable();
		alterTable();
		
		System.out.println("Would you like to 1) register or 2) login?");
		Scanner choiceInput = new Scanner(System.in);
		int choice = choiceInput.nextInt();
		if (choice == 1)
		{
			System.out.println("Register");
			registerInputUser();
		}
		else if (choice == 2)
		{
			System.out.println("Login");
			login();
		}
		
		else
		{
			System.out.println("Enter an option please.");
			main(args);
		}
	}

	//Method for user to input desired username for check
	public static void registerInputUser() throws Exception
	{
		try 
		{
			Scanner usernameInput = new Scanner(System.in);
			System.out.println("Please input your desired username");
			String user = usernameInput.nextLine();
			selectUserFromTable(user);
		}catch(Exception e) {System.out.println(e);}
		
	}
	
	//Method for user to input extra details for registration
	public static void register(String username) throws Exception

	{
		try 
		{
			System.out.println("Please enter your first name.");
			Scanner firstInput = new Scanner(System.in);
			String firstName = firstInput.nextLine();
			
			System.out.println("Please enter your last name.");
			Scanner lastInput = new Scanner(System.in);
			String lastName = lastInput.nextLine();
			
			System.out.println("Please enter your password.");
			Scanner passInput = new Scanner(System.in);
			String password = lastInput.nextLine();
			
			insertToTable(username, firstName, lastName, password);
		}catch(Exception e) {System.out.print(e);}
	}
	
	//Method for user to input log in details for check
	public static void login() throws Exception
	{
		try
		{
			System.out.println("Enter your username please.");
			Scanner loginUser = new Scanner(System.in);
			String username = loginUser.nextLine();
			
			System.out.println("Enter your password please.");
			Scanner loginPass = new Scanner(System.in);
			String password = loginPass.nextLine();
			
			checkForUser(username, password);
		}catch(Exception e) {System.out.println(e);}
	}
	
	//Method checks if inputed username and password exist in the database for login
	public static void checkForUser(String username, String password) throws Exception
	{
		try 
		{
			Connection con = getConnection();
			PreparedStatement select = con.prepareStatement("SELECT * FROM finchsimonUsers "
					+ "WHERE username = '"+username+"' AND password = '"+password+"'");
			
			ResultSet result = select.executeQuery();
			
			if (result.next() == true)
			{
				System.out.println("Enter the game!");
				hasPlayedBefore(username);
			}
			
			else
			{
				System.out.println("Login failed, try again!");
				login();
			}
			
		}catch(Exception e) {System.out.println(e);}
	}
	
	public static void hasPlayedBefore(String user) throws Exception
	{
		int gamesPlayed = 0;
		try
		{
			Connection con = getConnection();
			PreparedStatement select = con.prepareStatement("SELECT gamesplayed FROM finchsimonUsers WHERE username = '"+user+"'");
			ResultSet result = select.executeQuery();
			while (result.next())
			{
				gamesPlayed = result.getInt("gamesplayed");
			}
			
			if (gamesPlayed == 0)
			{
				//Do not played before function
				System.out.println("You have not played before");
				
			}
			else
			{
				//Do played before function
				System.out.println("You have played before");
			}
			
		}catch(Exception e) {System.out.println(e);}
	}
	
	//Method checks to see if inputed username is already taken by another user
	public static void selectUserFromTable(String name) throws Exception
	{
		String username = name;
		try 
		{
			Connection con = getConnection();
			PreparedStatement select = con.prepareStatement("SELECT * FROM finchsimonUsers WHERE username = '"+username+"'");
			
			ResultSet result = select.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			if (result.next() == true)
			{
				System.out.println("There are users with this name");
				registerInputUser();
			}
			else
			{
				System.out.println("There are no users with this name");
				register(username);
			}
			System.out.println("Select complete!");
		}catch(Exception e) {System.out.println(e);}
	}
	
	//Inserts user inputed data into the database table
	public static void insertToTable(String user, String first, String last, String pass) throws Exception
	{
		try 
		{
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement("INSERT INTO finchsimonUsers (username, firstname, lastname, password, hiscore, averagescore, gamesplayed, overallScore) "
					+ "VALUES('"+user+"', '"+first+"', '"+last+"', '"+pass+"', 0, 0, 1, 0)");
			
			insert.executeUpdate();
		} catch(Exception e) {System.out.println(e);}
		finally
		{
			System.out.println("Registeration Complete");
			login();
			
		}
	}
	
	//Creates table that will store the users data
	public static void createTable() throws Exception
	{
		try 
		{
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS finchsimonUsers(id int NOT NULL AUTO_INCREMENT, username varchar(255), firstname varchar(255), "
					+ "lastname varchar(255), hiscore int, averagescore float, gamesplayed int, password varchar(255), overallScore int, PRIMARY KEY(id), FOREIGN KEY(hiscore) REFERENCES hiscores(score))");
			create.executeUpdate();
			
			PreparedStatement createScores = con.prepareStatement("CREATE TABLE IF NOT EXISTS hiscores(scoreid int NOT NULL AUTO_INCREMENT, boardposition int, "
			+ "score int, username varchar(255), PRIMARY KEY(scoreid))");
			createScores.executeUpdate();
		}
		catch (Exception e) {System.out.println(e);}
		finally{System.out.println("Function complete.");}
		
	}
		
	//For "emergency" use
	public static void alterTable() throws Exception
	{
		try
		{
			Connection con = getConnection();
			Statement st = con.createStatement();
			st.execute("ALTER TABLE finchsimonUsers "+
			"AUTO_INCREMENT = 1 ");
		}catch(Exception e) {System.out.println(e);}
	}
	
	//Creates connection to database server
	public static Connection getConnection() throws Exception
	{
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://192.168.0.118:3306/assignment0sql";
			String username = "XinVinity";
			String password = "Ethan1";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			return conn;
			} catch(Exception e) {System.out.println(e);}
		return null;
	}
}
