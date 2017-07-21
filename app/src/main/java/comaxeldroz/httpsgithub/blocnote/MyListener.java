package comaxeldroz.httpsgithub.blocnote;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.TextWatcher;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by drozdz_b on 21/07/17.
 */

public class MyListener implements View.OnClickListener
{
    private Activity _act;

    public MyListener(Activity act)
    {
        _act = act;
    }
    @Override
    public void onClick(View v)
    {
        int id;
        EditText editText;
        //_act.setContentView(R.layout.activity_main);
        id = v.getId();
        editText = (EditText)_act.findViewById(R.id.editText);
        switch (id)
        {
            case R.id.button :
                editText.setText(editText.getText()+"<b></b>");
                Log.d("Debug", "Button bold clicked");
                break;
            case R.id.button2:
                editText.setText(editText.getText()+"<i></i>");
                break;
            case R.id.button3:
                editText.setText(editText.getText()+"<u></u>");
                break;

            case R.id.hide:
                Button b = (Button)v;
                View opt = _act.findViewById(R.id.options);
                Log.d("Debug", "Hide button name is <"+b.getText()+">");
                if (b.getText() == "DISPLAY")
                {
                    b.setText("HIDE");
                    opt.setVisibility(LinearLayout.VISIBLE);
                }
                else
                {
                    b.setText("DISPLAY");
                    opt.setVisibility(LinearLayout.GONE);
                }
                break;
            case R.id.smiley1:
                editText.setText(editText.getText()+":)");
                break;
            case R.id.smiley2:
                editText.setText(editText.getText()+":D");
                break;
            case R.id.smiley3:
                editText.setText(editText.getText()+";)");
                break;
            case R.id.black_color:
                ((MainActivity)_act).color = "#180F11";
                ((MainActivity)_act).textView.setTextColor(Color.parseColor(((MainActivity)_act).color));
                break;
            case R.id.blue_color:
                ((MainActivity)_act).color = "#310AEF";
                ((MainActivity)_act).textView.setTextColor(Color.parseColor(((MainActivity)_act).color));
                break;
            case R.id.red_color:
                ((MainActivity)_act).color = "#EF0A23";
                ((MainActivity)_act).textView.setTextColor(Color.parseColor(((MainActivity)_act).color));
                break;
            case R.id.save_button:
                Log.d("SaveTextDebug", "Start");
                ((MainActivity)_act).saveText();
                ((MainActivity)_act).saveColor();
                Log.d("DebugSaveText", "END");
                break;

            default:
                Log.d("Debug", "This widget is not supported : " + ((TextView)v).getText());
                break;
        }

    }
}