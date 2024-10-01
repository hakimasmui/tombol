package com.hakimasmui.tombol;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;

public class Tombol extends LinearLayout {

    ImageView icon1;
    TextView text1;

    enum tipe {
        DANGER,
        PRIMARY
    }

    public Tombol(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.Tombol, 0, 0);
        int icon = a.getResourceId(R.styleable.Tombol_icon, 0);
        int tipe = a.getInt(R.styleable.Tombol_tipe, 1);
        String text = a.getString(R.styleable.Tombol_text);

        a.recycle();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.main_tombol, this, true);

        icon1 = v.findViewById(R.id.icon1);
        text1 = v.findViewById(R.id.text1);

        if (icon > 0) {
            icon1.setVisibility(VISIBLE);
            icon1.setImageResource(icon);
        } else {
            icon1.setVisibility(GONE);
        }
        text1.setText(text);

        if (tipe == 0) {
            setBackgroundResource(R.drawable.bg_danger);
        } else {
            setBackgroundResource(R.drawable.bg_primary);
        }
    }
}
