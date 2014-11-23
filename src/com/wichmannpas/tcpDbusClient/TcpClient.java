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

public class TcpClient extends AsyncTask<Void, Void, Void> {
	  
	String tcpAction = "";
	String tcpTarget = "";
	String tcpHost = "";
	int tcpPort;
	
	TcpClient(String target, String action, String host, int port) {
		tcpTarget = target;
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
			output.println(tcpAction + ":::" + tcpTarget + ":::");
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