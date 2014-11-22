/*
 * Written by Pascal Wichmann
 */

package com.wichmannpas.tcpDbusClient;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.Socket;
import java.net.MalformedURLException;

import android.os.AsyncTask;

public class tcpClient extends AsyncTask<Void, Void, Void> {
	  
	String tcpAction = "";
	String tcpHost = "";
	int tcpPort;
	
	tcpClient(String action, String host, int port) {
		tcpAction = action;
		tcpHost = host;
		tcpPort = port;
	}
	
	@Override
	protected Void doInBackground(Void... arg0) {
		try {
			//open tcp connection
			Socket socket = new Socket(tcpHost, tcpPort);   
			OutputStream out = socket.getOutputStream();       
			PrintWriter output = new PrintWriter(out);         
			
			//print command through tcp connection
			output.println(tcpAction);
			output.flush();
			output.close();
			
			//close tcp connection
			socket.close();    		
		} catch (MalformedURLException e) {
			//TODO: give feedback to user
		} catch(IOException ex) {
			//TODO: give feedback to user
		}
		return null;
	}
}