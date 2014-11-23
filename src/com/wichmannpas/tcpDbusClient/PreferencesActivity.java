package com.wichmannpas.tcpDbusClient;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.EditText;

public class PreferencesActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preferences);
		
		SharedPreferences preferences = getSharedPreferences("preferences", MODE_PRIVATE);
		EditText tcpHost = (EditText)findViewById(R.id.tcpHost);
		EditText tcpPort= (EditText)findViewById(R.id.tcpPort);
		EditText target = (EditText)findViewById(R.id.target);
		tcpHost.setText(preferences.getString("host", ""));
        tcpPort.setText(preferences.getString("target", "spotify"));
    	target.setText(String.valueOf(preferences.getInt("port", 12341)));
	}
}
