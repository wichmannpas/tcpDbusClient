/*
 * Written by Pascal Wichmann
 */

package com.wichmannpas.tcpDbusClient;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends ActionBarActivity {

	private String tcpTarget;
	private String tcpHost;
	private int tcpPort;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        SharedPreferences preferences = getSharedPreferences("preferences", MODE_PRIVATE); 
        String initialized = preferences.getString("initialized", null);
        if (initialized == null) {
        	//set default values now
        	Editor editor = preferences.edit();
        	editor.putString("initialized", "true");
        	editor.putString("target", "spotify");
        	editor.putString("host", "192.168.2.201");
        	editor.putInt("port", 12341);
        	editor.commit();
        }
        tcpTarget = preferences.getString("target", "spotify");
    	tcpHost = preferences.getString("host", "192.168.2.201");
    	tcpPort = preferences.getInt("port", 12341);
    }

    public void playPause(View view) {
    	//start asynchronous network task
    	TcpClient tcpClientInstance = new TcpClient(tcpTarget, "PlayPause", tcpHost, tcpPort);
    	tcpClientInstance.execute();
    }
    
    public void next(View view) {
    	//start asynchronous network task
    	TcpClient tcpClientInstance = new TcpClient(tcpTarget, "Next", tcpHost, tcpPort);
    	tcpClientInstance.execute();
    }
    
    public void previous(View view) {
    	//start asynchronous network task
    	TcpClient tcpClientInstance = new TcpClient(tcpTarget, "Previous", tcpHost, tcpPort);
    	tcpClientInstance.execute();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_preferences) {
        	Intent intent = new Intent(this, PreferencesActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
