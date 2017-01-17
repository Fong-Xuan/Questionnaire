package nthu.questionnaire;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;


public class QuestionsMgr {
    private Context  context;
    public QuestionsMgr(Context context){
        this.context = context;
    }
    public ArrayList<HashMap<String, Object>> parse(){

        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        //XmlPullParser pullParser = Xml.newPullParser();
        AssetManager assetManager = context.getAssets();
        InputStream is;
        try
        {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();

            XmlPullParser pullParser = factory.newPullParser();

            is = assetManager.open("test.xml"); //read files

            pullParser.setInput(is,"utf-8");
            //pullParser.setInput(new StringReader ( "<foo>Hello World!</foo>" ) );


            //利用eventType來判斷目前分析到XML是哪一個部份
            int eventType = pullParser.getEventType();

            //XmlPullParser.END_DOCUMENT表示已經完成分析XML
            while(eventType != XmlPullParser.END_DOCUMENT)
            {

                if (eventType == XmlPullParser.START_TAG) {
                    String name = pullParser.getName();
                    Log.i("START_TAG", name);
                }

                if (eventType == XmlPullParser.TEXT) {
                    String value = pullParser.getText();
                    Log.i("TEXT", value);
                }

                if(eventType == XmlPullParser.END_TAG){
                    Log.i("END_TAG", pullParser.getName());
                }

                /*
                switch (eventType)
                {
                    case XmlPullParser.START_DOCUMENT:
                        break;
                    case XmlPullParser.START_TAG:
                        break;
                    case XmlPullParser.TEXT:
                        String value = pullParser.getText();
                        Log.i("TEXT", value);
                        break;
                    case XmlPullParser.END_TAG:
                        break;
                    case XmlPullParser.END_DOCUMENT:
                        break;
                }*/
                //go to next Tag
                eventType = pullParser.next();
            }

        } catch (IOException e) {
            //tv02.setText(e.toString());
        } catch (XmlPullParserException e) {
            //tv02.setText(e.toString());
        }

        return arrayList;
    }


}
