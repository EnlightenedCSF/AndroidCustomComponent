package ru.vsu.csf.enlightened.customcomponent.MyComponent;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import ru.vsu.csf.enlightened.customcomponent.R;

/**
 * Created by enlightenedcsf on 29.09.14.
 */
public class ProfileTitle extends RelativeLayout{

    private String mainText;
    private String extraText;

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
            mainText = array.getString(R.styleable.ProfileTitle_mainText);
            extraText = array.getString(R.styleable.ProfileTitle_extraText);
        }
        finally {
            array.recycle();
        }

    }
}
