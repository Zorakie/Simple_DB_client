package simple_db_client.simple_db_client;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

public class DBList extends AppCompatActivity {
Button btnAddDB;
Button btnRemoveDB;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dblist);

        btnAddDB = (Button) findViewById(R.id.btnAddDB);
        btnAddDB = (Button) findViewById(R.id.btnRemoveDB);
        lv = (ListView) findViewById(R.id.db_lv);
       getDBLis();

    }



    public void getDBLis(){


        new GetDBList(this.getApplicationContext(),DBList.this).execute();

    }


}
