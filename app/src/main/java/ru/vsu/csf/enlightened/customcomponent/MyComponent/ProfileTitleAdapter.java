package ru.vsu.csf.enlightened.customcomponent.MyComponent;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import ru.vsu.csf.enlightened.customcomponent.Model.Profile;
import ru.vsu.csf.enlightened.customcomponent.R;

/** Created by enlightenedcsf on 07.10.14. */
public class ProfileTitleAdapter extends ArrayAdapter<ProfileTitle> {

    private ArrayList<Profile> list;

    public ProfileTitleAdapter(Context context, ArrayList<Profile> list) {
        super(context, R.layout.profile_title);
        this.list = list;
    }


    /*@Override
    public ProfileTitle getItem(int position) {
        return super.getItem(position);
    }*/

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ProfileTitle item = (ProfileTitle) convertView;

        if (item == null) {
            item = new ProfileTitle(getContext());
        }

        item.populate(list.get(position));
        return item;
    }
}
