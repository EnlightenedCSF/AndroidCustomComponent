package ru.vsu.csf.enlightened.customcomponent.Model;

import android.graphics.drawable.Drawable;

/** Created by enlightenedcsf on 07.10.14. */
public class Profile {

    private String name;
    private String email;
    private int icon;

    public Profile(String name, String email, int icon) {
        this.name = name;
        this.email = email;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
