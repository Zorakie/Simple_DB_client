package simple_db_client.simple_db_client;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.provider.ContactsContract;
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
 * Created by Pavel on 4. 12. 2015.
 */
public class UseDatabase extends AsyncTask<Void, Void, Boolean> {

    SQLException exc;
    String myresult = "";
    Activity activity;
    Context context;
    public UseDatabase(Context context, Activity currActivity) {
        this.context = context.getApplicationContext();
        this.activity = currActivity;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        Statement stmt;
        try {
            DataStore.DataStoreClass.mysqlConn.setCatalog(DataStore.DataStoreClass.currentDB);
             stmt = DataStore.DataStoreClass.mysqlConn.createStatement() ;

        } catch (SQLException e) {
           exc=e;
            return false;
        }

        DataStore.DataStoreClass.TableResponse = new ArrayList<String>();
        try{

        ResultSet rs = stmt.executeQuery("SHOW TABLES");


        while ( rs.next() ) {
            DataStore.DataStoreClass.TableResponse.add(rs.getString(1));

          /*  bar = rs.getString("bar");
            beer = rs.getString("beer");
            price = rs.getFloat("price");
            System.out.println(bar + " sells " + beer + " for " + price + " Dollars.");*/


        }
            return true;
          }
        catch (SQLException e){
            exc=e;

            return false;}



    }

    @Override
    protected void onPostExecute (Boolean b) {

        if(b) {
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, DataStore.DataStoreClass.TableResponse){
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    TextView text = (TextView) view.findViewById(android.R.id.text1);
                    text.setTextColor(Color.BLACK);
                    return view;
                }
            };
            ListView lv = (ListView) activity.findViewById(R.id.tableList);
            lv.setAdapter(arrayAdapter);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {


                   /* DataStore.DataStoreClass.currentDB = ((TextView) view).getText().toString();
                    Toast.makeText(context, DataStore.DataStoreClass.currentDB,
                            Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(context, TableList.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);*/
                    //  new UseDatabase(context,activity).execute();


                   /*AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
                   alertDialog.setTitle("Error");
                   alertDialog.setMessage(DataStore.DataStoreClass.connExc.toString());
                   alertDialog.show();*/

                }
            });

        }

        else{AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
    alertDialog.setTitle("Error");
    alertDialog.setMessage("USE " + DataStore.DataStoreClass.currentDB + exc.toString());
    alertDialog.show();}


    }
}
