package ru.vsu.csf.enlightened.customcomponent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import ru.vsu.csf.enlightened.customcomponent.Model.Profile;
import ru.vsu.csf.enlightened.customcomponent.MyComponent.ProfileTitle;
import ru.vsu.csf.enlightened.customcomponent.MyComponent.ProfileTitleAdapter;

public class MainActivity extends ActionBarActivity {

    static final String FILTER_TAG = "filter";

    ArrayList<Profile> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         data = new ArrayList<Profile>(){{
            add(new Profile("1st", "john@etc.com", R.drawable.icon_joe));
            add(new Profile("2nd", "key@china.ch", R.drawable.icon_key));
            add(new Profile("3rd", "another@one.com", R.drawable.icon_next));
            add(new Profile("4th", "key@china.ch", R.drawable.icon_key));
            add(new Profile("5th", "another@one.com", R.drawable.icon_next));
            add(new Profile("6th", "john@etc.com", R.drawable.icon_joe));
            add(new Profile("7th", "key@china.ch", R.drawable.icon_key));
            add(new Profile("8th", "another@one.com", R.drawable.icon_next));
            add(new Profile("9th", "john@etc.com", R.drawable.icon_joe));
            add(new Profile("10th", "key@china.ch", R.drawable.icon_key));
            add(new Profile("11th", "another@one.com", R.drawable.icon_next));
        }};

        final ListView list = (ListView) findViewById(R.id.myListView);
        list.setAdapter(new ProfileTitleAdapter(this, data));

        Button extractBtn = (Button) findViewById(R.id.btnExtract);
        extractBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, FilterActivity.class);

                ArrayList<String> content = new ArrayList<String>();
                for (int i = 0; i < list.getChildCount(); i++) {
                    if (((ProfileTitle) list.getChildAt(i)).getIsChecked()) {
                        content.add(data.get(i).getName());
                    }
                }

                String[] parcel = new String[content.size()];
                parcel = content.toArray(parcel);

                intent.putExtra(MainActivity.FILTER_TAG, parcel);

                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }
}
