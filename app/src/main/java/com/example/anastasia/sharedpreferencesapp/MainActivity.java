package com.example.anastasia.sharedpreferencesapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_FILE = "com.example.anastasia.sharedpreferencesapp.sharedpreferences";
    private static final String KEY_EDITTEXT = "KEY_EDITTEXT";
    @BindView(R.id.editText)
    EditText mEditText;

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mSharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
        String editTextString = mSharedPreferences.getString(KEY_EDITTEXT, "");
        mEditText.setText(editTextString);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mEditor.putString(KEY_EDITTEXT, mEditText.getText().toString());
        mEditor.apply();
    }
}
