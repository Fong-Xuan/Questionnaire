package nthu.questionnaire;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private QuestionsMgr QManaeger;
    private RadioGroup radioGroupQuestions;
    private RadioButton q1,q2,q3,q4;
    private Button previousPage;
    private Button nextPage;
    private static final int numberOfQuestions = 5;
    private int page_now;
    private int[] record;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        QManaeger = new QuestionsMgr(this);
        QManaeger.parse();
        page_now = 0;
        record = new int[numberOfQuestions];
        radioGroupQuestions = (RadioGroup)findViewById(R.id.radioGroup1);
        q1 = (RadioButton) findViewById(R.id.radButton1);
        q2 = (RadioButton) findViewById(R.id.radButton2);
        q3 = (RadioButton) findViewById(R.id.radButton3);
        q4 = (RadioButton) findViewById(R.id.radButton4);
        radioGroupQuestions.setOnCheckedChangeListener(radGroupQuesListener);
        previousPage = (Button)findViewById(R.id.previous);
        nextPage = (Button)findViewById(R.id.next);

    }
    private RadioGroup.OnCheckedChangeListener radGroupQuesListener =
            new RadioGroup.OnCheckedChangeListener(){
                @Override
                public void onCheckedChanged(RadioGroup group,int checkedId){
                    //TO DO
                    Log.i("OnCheckedChange", "OnCheckedChange");


                }


            };

    public void onPreviousClick(View view){
        //TO DO
        Toast toast = Toast.makeText(this,
                "Previous button", Toast.LENGTH_LONG);
        toast.show();
    }
    public void onNextClick(View view){
        //TO DO
        Toast toast = Toast.makeText(this,
                "Next button", Toast.LENGTH_LONG);
        toast.show();

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
}
