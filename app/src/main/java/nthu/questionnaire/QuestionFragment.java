package nthu.questionnaire;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by fongxuan on 1/22/17.
 */

public class QuestionFragment extends Fragment {


    private int layoutId = 0;

    private View v;
    public static QuestionFragment newInstance(int id) {
        QuestionFragment f = new QuestionFragment();


        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putInt("id", id);
        f.setArguments(args);
        Log.i("test", "instance: "+String.valueOf(id));

        return f;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("test", "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       // v = inflater.inflate(getLayoutId(), container, false);
        if(getLayoutId() == 0){
            v = inflater.inflate(R.layout.question1, container, false);

        }
        else
            v = inflater.inflate(layoutId, container, false);
        Log.i("test", "onCreateView: "+String.valueOf(layoutId));


      // getLayoutId();
        return v;
    }

    public int getLayoutId(){
/*        if(this == null){
            Log.i("test", "null");
        }
        Log.i("test", "getId: "+this.getArguments().getInt("id", 0));

        return this.getArguments().getInt("id", 0);*/
        return layoutId;

    }

    public void setLayoutId(int id){
        layoutId = id;

    }


}
