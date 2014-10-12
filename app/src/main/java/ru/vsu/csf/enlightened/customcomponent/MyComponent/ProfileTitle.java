package ru.vsu.csf.enlightened.customcomponent.MyComponent;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ru.vsu.csf.enlightened.customcomponent.Model.Profile;
import ru.vsu.csf.enlightened.customcomponent.R;

/** Created by enlightenedcsf on 29.09.14. */
public class ProfileTitle extends RelativeLayout {

    private TextView mainText;
    private TextView extraText;
    private ImageView iconView;
    private CheckBox isChecked;

    public boolean getIsChecked() {
        return isChecked.isChecked();
    }

    public ProfileTitle(Context context) {
        super(context);
        init(null, context);
    }

    public ProfileTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, context);
    }

    public ProfileTitle(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, context);
    }

    protected void init(AttributeSet attrs, Context context) {
        inflate(getContext(), R.layout.profile_title, this);

        TypedArray array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ProfileTitle, 0, 0);

        try {
            String main = array.getString(R.styleable.ProfileTitle_mainText);
            String extra = array.getString(R.styleable.ProfileTitle_extraText);
            Drawable icon = array.getDrawable(R.styleable.ProfileTitle_profileIcon);
            if (icon == null)
                icon = getResources().getDrawable(R.drawable.ic_launcher);

            mainText = (TextView) findViewById(R.id.profile_title_name);
            extraText = (TextView) findViewById(R.id.profile_title_email);
            iconView = (ImageView) findViewById(R.id.profile_title_icon);
            isChecked = (CheckBox) findViewById(R.id.profile_title_checkbox);

            mainText.setText(main);
            extraText.setText(extra);
            iconView.setImageDrawable(icon);
            isChecked.setChecked(false);

            invalidate();
            requestLayout();
        }
        finally {
            array.recycle();
        }
    }

    public void populate(Profile profile) {
        mainText.setText(profile.getName());
        extraText.setText(profile.getEmail());
        iconView.setImageDrawable(this.getContext().getResources().getDrawable(profile.getIcon()));
        isChecked.setChecked(false);
    }
}