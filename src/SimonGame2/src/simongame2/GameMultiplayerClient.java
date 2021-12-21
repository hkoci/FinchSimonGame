/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simongame2;

import java.net.*;
import java.io.*;


public class GameMultiplayerClient
{
	public static void main(String[] args) throws Exception
	{
		Socket s = new Socket("Localhost",9999);
		System.out.println("connected");
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true)
		{
			String so = br.readLine();
			dout.writeUTF(so);
			if (so.equalsIgnoreCase("Exit"))
			{
				break;
			}
		}
		s.close();
		
	}

}
