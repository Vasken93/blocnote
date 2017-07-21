package comaxeldroz.httpsgithub.blocnote;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Debug;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import comaxeldroz.httpsgithub.blocnote.MyListener;

public class MainActivity extends AppCompatActivity
{
    public String color;
    public TextView textView;

    private Button b;
    private ArrayList<View> viewGroup;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Debug", "Start");
        MyListener listener = new MyListener(this);
        viewGroup = getWindow().getDecorView().getTouchables();
        textView = (TextView)findViewById(R.id.textView5);
        //istener.onClick(findViewById(R.id.button));
        //b = (Button)findViewById(R.id.button);
        //b.setOnClickListener(listener);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();
        color = "#180F11";
        color = preferences.getString("COLOR", "#180F11");
        textView.setTextColor(Color.parseColor(color));
        findViewById(R.id.black_color).setSelected(true);

        textView.setText(preferences.getString("TEXT", ""));
        ((EditText)findViewById(R.id.editText)).setText(preferences.getString("TEXT", ""));
        for (View v : viewGroup)
        {
            if (v.getId() == R.id.editText)
                ((EditText)v).addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
                    {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
                    {
                    }

                    @Override
                    public void afterTextChanged(Editable editable)
                    {
                        textView.setText(editable);
                    }
                });
            else
                v.setOnClickListener(listener);
        }

    }

    protected void saveText()
    {
        String str;
        Log.d("SaveTextDebug", "line 2");
        str = ((EditText)findViewById(R.id.editText)).getText().toString();
        Log.d("SaveTextDebug", "line 3");
        editor.putString("TEXT", str);
        editor.commit();
    }
    protected void saveColor()
    {
        String str;
        Log.d("SaveTextDebug", "line 2");
        str = ((EditText)findViewById(R.id.editText)).getText().toString();
        Log.d("SaveTextDebug", "line 3");
        editor.putString("COLOR", color);
        editor.commit();
    }
}
