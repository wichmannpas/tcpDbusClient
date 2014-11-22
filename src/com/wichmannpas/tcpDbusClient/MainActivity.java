/*
 * Written by Pascal Wichmann
 */

package com.wichmannpas.tcpDbusClient;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends ActionBarActivity {

	private static String tcpHost = "192.168.2.201";
	private static int tcpPort = 12341;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playPause(View view) {
    	//start asynchronous network task
    	tcpClient tcpClientInstance = new tcpClient("playPause", tcpHost, tcpPort);
    	tcpClientInstance.execute();
    }
    
    public void next(View view) {
    	//start asynchronous network task
    	tcpClient tcpClientInstance = new tcpClient("next", tcpHost, tcpPort);
    	tcpClientInstance.execute();
    }
    
    public void previous(View view) {
    	//start asynchronous network task
    	tcpClient tcpClientInstance = new tcpClient("previous", tcpHost, tcpPort);
    	tcpClientInstance.execute();
    }
}
