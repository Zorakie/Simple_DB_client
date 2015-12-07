package simple_db_client.simple_db_client;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Pavel on 3. 12. 2015.
 */
public class GetDBList extends AsyncTask<Void, Void, Boolean> {
    Activity activity;
    Context context;
    public GetDBList(Context context, Activity activity){
        this.activity = activity;
        this.context = context;
    }

    @Override
    protected Boolean doInBackground(Void... params){


        //Statement stmt = null;
        String query = "SHOW DATABASES";
        DataStore.DataStoreClass.DBResponse = new ArrayList<String>();



        try {
            DatabaseMetaData meta = DataStore.DataStoreClass.mysqlConn.getMetaData();
            ResultSet res = meta.getCatalogs();
            while (res.next()) {
                DataStore.DataStoreClass.DBResponse.add(res.getString("TABLE_CAT"));

            }
            res.close();
            return true;
        }
        catch (SQLException e){

            AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
            alertDialog.setTitle("Error");
            alertDialog.setMessage(e.toString());
            alertDialog.show();
            return false;
        }





    }

    @Override
    protected void onPostExecute(Boolean b){
       if(b) {
           ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, DataStore.DataStoreClass.DBResponse){
               @Override
               public View getView(int position, View convertView, ViewGroup parent) {
                   View view = super.getView(position, convertView, parent);
                   TextView text = (TextView) view.findViewById(android.R.id.text1);
                   text.setTextColor(Color.BLACK);
                   return view;
               }
           };
           ListView lv = (ListView) activity.findViewById(R.id.db_lv);
           lv.setAdapter(arrayAdapter);

           lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
               public void onItemClick(AdapterView<?> parent, View view,
                                       int position, long id) {


                   DataStore.DataStoreClass.currentDB = ((TextView) view).getText().toString();
                   Toast.makeText(context, DataStore.DataStoreClass.currentDB,
                           Toast.LENGTH_SHORT).show();

                   Intent intent = new Intent(context, TableList.class);
                   intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                   context.startActivity(intent);
                 //  new UseDatabase(context,activity).execute();


                   /*AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
                   alertDialog.setTitle("Error");
                   alertDialog.setMessage(DataStore.DataStoreClass.connExc.toString());
                   alertDialog.show();*/

               }
           });

       }


    }
}
