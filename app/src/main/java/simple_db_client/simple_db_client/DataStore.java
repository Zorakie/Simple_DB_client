package simple_db_client.simple_db_client;

import android.content.Context;
import android.content.Intent;

import java.sql.*;
import java.util.List;


/**
 * Created by Pavel on 3. 12. 2015.
 */
public class DataStore {
    public static  class DataStoreClass{
        static Context context;


        static String servername;
        static String port;
        static String name;
        static String pass;
        static List<String> DBResponse;
        static List<String> TableResponse;
        static String ErrorString;
        static String connectionString = "jdbc:mysql://46.28.108.57:3306?user=Ard&password=Mina2&autoReconnect=true&failOverReadOnly=false&maxReconnects=10";
static Exception connExc;
       static Connection mysqlConn;
        static Boolean connResult;
        static Intent activityIntent = new Intent();
        static String currentDB;



    }
}
