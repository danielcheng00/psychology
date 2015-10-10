package com.example.dcheng.psychology;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class PsychologyTestActivity extends FragmentActivity {
    private int questionIndex;
    private TextView textView;
    private TextView indexView;
    private Button previousButton;
    private Button submitButton;
    private RadioGroup radioGroup;
    private static final String[] questions = new String[]{
            "1.爱人送的戒指不见了,你觉得怎样?",
            "2.你注意到某个明星,正好是你喜欢的类型,因此非常高兴,看到他会心跳吗?",
            "3.买东西时,看到很喜欢的东西,虽不是一定要买的必需品,却常买下它."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psychology_test);
        questionIndex = 0;
        textView = (TextView)findViewById(R.id.textView);
        indexView = (TextView)findViewById(R.id.text_index);
        previousButton = (Button)findViewById(R.id.previousItem);
        submitButton = (Button) findViewById(R.id.submit);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        setTextContent(questionIndex);
        submitButton.setEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_yes:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radio_no:
                if (checked)
                    // Ninjas rule
                    break;
        }
        if(questionIndex<questions.length -1) {
            questionIndex++;
            clearChecked();
            setTextContent(questionIndex);
        }
        else
        {
            submitButton.setEnabled(true);
        }

    }

    public void onPreviousItemClick(View view) {
        questionIndex--;
        clearChecked();
        setTextContent(questionIndex);
        submitButton.setEnabled(false);
    }
    private void clearChecked()
    {
        radioGroup.clearCheck();
    }

    private void setTextContent(int index) {
        if(index < questions.length) {
            textView.setText(questions[index]);
            indexView.setText(String.format("当前第%d/%d题",index+1,questions.length));
        }
        previousButton.setEnabled(index != 0);
    }

}
