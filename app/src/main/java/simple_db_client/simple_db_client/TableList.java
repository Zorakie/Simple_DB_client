package simple_db_client.simple_db_client;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class TableList extends AppCompatActivity {
ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_list);
        lv = (ListView) findViewById(R.id.tableList);
        getTables();
    }


    public void getTables(){

        new UseDatabase(this.getApplicationContext(),TableList.this).execute();
    }
}
