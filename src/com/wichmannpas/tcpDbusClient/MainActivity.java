/*
 * Written by Pascal Wichmann
 */

package com.wichmannpas.tcpDbusClient;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

public class MainActivity extends ActionBarActivity {

	private String tcpTarget;
	private String tcpHost;
	private int tcpPort;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    /*
     * load the tcp server preferences
     */
    public void loadPreferences() {
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

    /*
     * send playPause tcp message
     */
    public void playPause(View view) {
    	//load tcp preferences
    	loadPreferences();
    	
    	//check spinner for other value than default
    	Spinner spinnerTarget = (Spinner)findViewById(R.id.spinnerTarget);
    	String targetChosen = spinnerTarget.getSelectedItem().toString();
    	
    	if (targetChosen != getString(R.string.optionDefault)) {//special target selected?
    		tcpTarget = targetChosen;//using selected target instead of configured one
    	}
    	
    	//start asynchronous network task
    	TcpClient tcpClientInstance = new TcpClient(tcpTarget, "PlayPause", tcpHost, tcpPort);
    	tcpClientInstance.execute();
    }
    
    /*
     * send next tcp signal
     */
    public void next(View view) {
    	//load tcp preferences
    	loadPreferences();
    	
    	//check spinner for other value than default
    	Spinner spinnerTarget = (Spinner)findViewById(R.id.spinnerTarget);
    	String targetChosen = spinnerTarget.getSelectedItem().toString();
    	
    	if (targetChosen != getString(R.string.optionDefault)) {//special target selected?
    		tcpTarget = targetChosen;//using selected target instead of configured one
    	}
    	
    	//start asynchronous network task
    	TcpClient tcpClientInstance = new TcpClient(tcpTarget, "Next", tcpHost, tcpPort);
    	tcpClientInstance.execute();
    }
    
    /*
     * send previous tcp signal
     */
    public void previous(View view) {
    	//load tcp preferences
    	loadPreferences();
    	
    	//check spinner for other value than default
    	Spinner spinnerTarget = (Spinner)findViewById(R.id.spinnerTarget);
    	String targetChosen = spinnerTarget.getSelectedItem().toString();
    	
    	if (targetChosen != getString(R.string.optionDefault)) {//special target selected?
    		tcpTarget = targetChosen;//using selected target instead of configured one
    	}
    	
    	//start asynchronous network task
    	TcpClient tcpClientInstance = new TcpClient(tcpTarget, "Previous", tcpHost, tcpPort);
    	tcpClientInstance.execute();
    }
    
    /*
     * send stop tcp signal
     */
    public void stop(View view) {
    	//load tcp preferences
    	loadPreferences();
    	
    	//check spinner for other value than default
    	Spinner spinnerTarget = (Spinner)findViewById(R.id.spinnerTarget);
    	String targetChosen = spinnerTarget.getSelectedItem().toString();
    	
    	if (targetChosen != getString(R.string.optionDefault)) {//special target selected?
    		tcpTarget = targetChosen;//using selected target instead of configured one
    	}
    	
    	//start asynchronous network task
    	TcpClient tcpClientInstance = new TcpClient(tcpTarget, "Stop", tcpHost, tcpPort);
    	tcpClientInstance.execute();
    }
    
    /*
     * send volume down tcp signal
     */
    public void volumeDown(View view) {
    	//load tcp preferences
    	loadPreferences();
    	
    	//start asynchronous network task
    	TcpClient tcpClientInstance = new TcpClient("down", "volume", tcpHost, tcpPort);
    	tcpClientInstance.execute();
    }
    
    /*
     * send volume up tcp signal
     */
    public void volumeUp(View view) {
    	//load tcp preferences
    	loadPreferences();
    	
    	//start asynchronous network task
    	TcpClient tcpClientInstance = new TcpClient("up", "volume", tcpHost, tcpPort);
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
        } else if (id == R.id.action_about) {
        	//display about message
     
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setIcon(R.drawable.ic_launcher);
            builder.setTitle(R.string.about);
            
            ViewGroup parent = (ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0);
            View messageView = getLayoutInflater().inflate(R.layout.about, parent, false);
            builder.setView(messageView);
            
            builder.create();
            builder.show();
        	
        	return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
