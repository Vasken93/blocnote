package comaxeldroz.httpsgithub.calcultonimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import comaxeldroz.httpsgithub.calcultonimc.ImcCalculator;
import comaxeldroz.httpsgithub.calcultonimc.Listener;

public class MainActivity extends AppCompatActivity
{
    private ImcCalculator _cal;
    private Button _b, _b2;
    private EditText _e, _e2;
    private RadioButton _r, _r2;
    //private Listener listener;
    private TextView _text;
    private double _res;
    boolean _centimeter = true;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //listener = new Listener();
        Log.d("Debug", "START2");
        _cal = new ImcCalculator();
        _b = (Button)findViewById(R.id.button);
        _b2 = (Button)findViewById(R.id.button2);
        _e = (EditText) findViewById(R.id.editText);
        _e2 = (EditText) findViewById(R.id.editText2);
        _text = (TextView)findViewById(R.id.textView3);
        _r = (RadioButton) findViewById(R.id.radioButton);
        _r2 = (RadioButton) findViewById(R.id.radioButton2);

        _r.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                _centimeter = true;
            }
        });
        _r2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                _centimeter = false;
            }
        });
        _b.setOnClickListener(new OnClickListener(){ // Notre classe anonyme
         public void onClick(View view){
             String str;
             double a, b;
             a = Double.parseDouble((String)_e.getText().toString());
             b = Double.parseDouble((String)_e2.getText().toString());
             _cal.setWeight(a);
             _cal.setSize(b, _centimeter);
             _cal.display();
             _res = _cal.calculate();
             _res = Math.round(_res  * 100.00) / 100.00;
             str = "Votre IMC est : " + _res;
             _text.setText(str);
         }
        });
        //_b.setOnClickListener(listener);
        _b2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                _text.setText("Votre IMC est : ");
            }
        });
    }

}
