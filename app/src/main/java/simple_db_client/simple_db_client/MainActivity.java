package simple_db_client.simple_db_client;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.*;

public class MainActivity extends AppCompatActivity {

    TextView txtHost;
    TextView txtPort;
    TextView txtLoginName;
    TextView txtPassword;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHost = (TextView) findViewById(R.id.txtHost);
        txtPort = (TextView) findViewById(R.id.txtPort);
        txtLoginName = (TextView) findViewById(R.id.txtLoginName);
        txtPassword = (TextView) findViewById(R.id.txtPassword);
        login = (Button) findViewById(R.id.btnLogin);



    }




    public void klik(View view){

        DataStore.DataStoreClass.servername = txtHost.getText().toString();
        DataStore.DataStoreClass.port = txtPort.getText().toString();
        DataStore.DataStoreClass.name = txtLoginName.getText().toString();
        DataStore.DataStoreClass.pass = txtPassword.getText().toString();

        Context context;
        /*Activity activity;
        activity = MainActivity.this;
        context = activity.getApplicationContext();*/
        context = this.getApplicationContext();
        Toast.makeText(getBaseContext(),context.toString(),Toast.LENGTH_LONG).show();

        DataStore.DataStoreClass.activityIntent = new Intent(this.getApplicationContext(), DBList.class);
        DataStore.DataStoreClass.activityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
new ConnCore(this.getApplicationContext(),MainActivity.this).execute();
       /* if((new ConnCore().execute())==true){
        Intent inent = new Intent(this, TableRows.class);
Intent intent2 = new Intent(getApplicationContext(), TableRows.class);
        // calling an activity using <intent-filter> action name
        //  Intent inent = new Intent("com.hmkcode.android.ANOTHER_ACTIVITY");

        startActivity(inent);

        }*/

    }



}
