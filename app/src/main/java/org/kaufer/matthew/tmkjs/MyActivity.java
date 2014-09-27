package org.kaufer.matthew.tmkjs;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.telephony.SmsManager;


public class MyActivity extends Activity {

    private String number = "+17038320978";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        ViewGroup parentView = (ViewGroup) findViewById(R.id.mainLayout);
        for(int i=0; i < parentView.getChildCount(); i++) {
            Button b = (Button)parentView.getChildAt(i);

            b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String cmd = ((Switch)findViewById(R.id.switch1)).isChecked() ? "1" : "2";
                    cmd += ((Button) v).getText();
                    //send the text cmd to
                    sendSMS(number, cmd);

                }
            });

        }

    }

    private void sendSMS(String num, String message) {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(num, null, message, null, null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
