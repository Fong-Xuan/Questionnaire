package nthu.questionnaire;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Debug;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private QuestionsMgr QManaeger;
    private RadioGroup radioGroupQuestions;
    private RadioButton q1,q2,q3,q4;
    private Button previousPage;
    private Button nextPage;
    private static final int numberOfQuestions = 5;
    private int page_now;
    private int MAXPageCount = 4;
    private int[] record;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getQuestionLayout(0);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        QManaeger = new QuestionsMgr(this);
        QManaeger.parse();
        page_now = 0;
        record = new int[numberOfQuestions];

        previousPage = (Button)findViewById(R.id.previous);
        nextPage = (Button)findViewById(R.id.next);

        setButton();

    }
    private RadioGroup.OnCheckedChangeListener radGroupQuesListener =
            new RadioGroup.OnCheckedChangeListener(){
                @Override
                public void onCheckedChanged(RadioGroup group,int checkedId){
                    //TO DO
                    Log.i("OnCheckedChange", "OnCheckedChange");


                }


            };



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



    public int getQuestionLayout(int index){

        Resources res = getResources();
        int id = res.getIdentifier("question_"+String.valueOf(index+1), "layout", getPackageName());


        QuestionFragment fragment = QuestionFragment.newInstance(id);
        Bundle args = new Bundle();
        args.putInt("id", id);
        fragment.setArguments(args);

        int id_tmp = fragment.getArguments().getInt("id", 0);
        fragment.setLayoutId(id);

        Log.i("test", "getQuestionLayout: "+String.valueOf(index));

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        fragmentTransaction.replace(R.id.questionFragment, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


        return id;

    }

    private void setButton(){
        previousPage = (Button)findViewById(R.id.previous);
        nextPage = (Button)findViewById(R.id.next);
        previousPage.setOnClickListener(this);
        nextPage.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        int vId = v.getId();
        if(vId == R.id.previous){
            if(page_now>0){
                QuestionFragment fragment  = (QuestionFragment)getFragmentManager().findFragmentById(R.id.questionFragment);


                getQuestionLayout(--page_now);
            }
        }else if(vId == R.id.next){
            if(page_now < (MAXPageCount-1)) {

                getQuestionLayout(++page_now);
            }
        }
    }

}
