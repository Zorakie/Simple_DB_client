package simple_db_client.simple_db_client;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class TableRows extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_rows);
    }


    public void toastclik(View view){

        Toast.makeText(this.getBaseContext(), "text",
                Toast.LENGTH_SHORT).show();
    }
}
