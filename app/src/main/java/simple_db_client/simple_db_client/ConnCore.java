package simple_db_client.simple_db_client;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.sql.*;
import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.startActivity;


/**
 * Created by Pavel on 1. 12. 2015.
 */

public class ConnCore extends AsyncTask<Void, Void, Boolean> {

Activity activity;
    Context context;
    public ConnCore(Context context, Activity currActivity) {
        this.context = context.getApplicationContext();
        this.activity = currActivity;
    }


    @Override
    protected Boolean doInBackground(Void... params) {


        try{Class.forName("com.mysql.jdbc.Driver");}
        catch(Exception e){
           DataStore.DataStoreClass.connExc = e;
            return false;}


        try{

          DataStore.DataStoreClass.mysqlConn = DriverManager.getConnection(DataStore.DataStoreClass.connectionString);

            return true;
        }catch(Exception e){
            DataStore.DataStoreClass.connExc = e;
            return false;
        }





    }

    @Override
    protected void onPostExecute (Boolean b) {


         if(b == true) {

            Intent intent = new Intent(context, DBList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

            /*super.onPostExecute(null);
            Intent intent = new Intent(ConnCore.this, DBList.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplicationContext().startActivity(intent);*/

        } else {
            AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
            alertDialog.setTitle("Error");
            alertDialog.setMessage(DataStore.DataStoreClass.connExc.toString());
            alertDialog.show();

        }



   /*

     static void getDBs (Context c){
         Statement stmt = null;
         String query = "SHOW DATABASES";
         DBResponse = new ArrayList<String>();



   try {
    DatabaseMetaData meta = mysqlConn.getMetaData();
    ResultSet res = meta.getCatalogs();
    while (res.next()) {
        DBResponse.add(res.getString("TABLE_cat"));
       // model.addRow(new Object[]{db});
    }
    res.close();
     }
    catch (SQLException e){

        AlertDialog alertDialog = new AlertDialog.Builder(c).create();
        alertDialog.setTitle("Error");
        alertDialog.setMessage("Could not get DB LIST");
        alertDialog.show();
    }


     }
*/

    }
}
