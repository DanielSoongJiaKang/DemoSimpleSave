package sg.edu.rp.c346.id19045346.demosimplesave;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

       // String msg = "No greetings";

        //Step 2a : Obtain an instance of the Shared Preferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //Step 2b : Retrieve the saved data with the key "greeting" from the SharedPreference object
        String msg = prefs.getString("greetings","No greetings!");

        
        Toast toast = Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    protected void onPause() {
        super.onPause();


        // Step 1a : Obtain an instance of the SharedPreference
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);


        //Step 1b: Obtain an instance of the SharedPreference Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();

        //Step 1c : Add the key-value pair
        prefEdit.putString("greetings","Hello!");


        //Step 1d : Call commit() to save the changes into SharedPreference
        prefEdit.commit();
    }
}
