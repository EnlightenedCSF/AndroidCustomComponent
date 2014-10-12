package ru.vsu.csf.enlightened.customcomponent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


public class FilterActivity extends ActionBarActivity {

    EditText text;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_filter);

        text = (EditText) findViewById(R.id.filterText);
        Bundle message = getIntent().getExtras();
        if (message != null) {
            String[] results = message.getStringArray(MainActivity.FILTER_TAG);
            String res = "";
            for (String s : results) {
                res += s;
            }
            text.setText(res);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.filter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
