package com.wichmannpas.tcpDbusClient;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

public class PreferencesActivity extends ActionBarActivity {

	public void savePreferences(View view)
	{
		//load SharedPreferences instance
		SharedPreferences preferences = getSharedPreferences("preferences", MODE_PRIVATE);

		//get values of inputs
		EditText tcpHost = (EditText)findViewById(R.id.tcpHost);
		EditText tcpPort= (EditText)findViewById(R.id.tcpPort);
		EditText target = (EditText)findViewById(R.id.target);
		
		//set user values
    	Editor editor = preferences.edit();
    	editor.putString("host", tcpHost.getText().toString());
    	editor.putInt("port", Integer.valueOf(tcpPort.getText().toString()));
    	editor.putString("target", target.getText().toString());
    	editor.commit();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preferences);
		
		SharedPreferences preferences = getSharedPreferences("preferences", MODE_PRIVATE);
		EditText tcpHost = (EditText)findViewById(R.id.tcpHost);
		EditText tcpPort= (EditText)findViewById(R.id.tcpPort);
		EditText target = (EditText)findViewById(R.id.target);
		tcpHost.setText(preferences.getString("host", ""));
		tcpPort.setText(String.valueOf(preferences.getInt("port", 12341)));
        target.setText(preferences.getString("target", "spotify"));
	}
}
