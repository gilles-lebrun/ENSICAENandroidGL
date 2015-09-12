package test.ensicaen.fr.mysimpleapp;

import android.app.Activity;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentFirstActivity extends Activity {
    private ViewGroup viewGroup;
    private TextView textView;
    private ImageView imageView1, imageView2, imageView3;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_first);
        viewGroup = (ViewGroup) findViewById(R.id.fragment_first_activity);
        if (viewGroup==null) Log.d("ANIMATION","viewGroup is null !!!");
        textView = (TextView) findViewById(R.id.textViewAnimation);
        imageView1 = (ImageView) findViewById(R.id.iconSun1);
        imageView2 = (ImageView) findViewById(R.id.iconSun2);
        imageView3 = (ImageView) findViewById(R.id.iconSun3);
        count = 0;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fragment_first, menu);
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

    public void launchAnim(View view) {
        Log.v("ANIMATION", "effect : Explode, Fade or Slide");
        // voir : https://developer.android.com/reference/android/transition/Transition.html
        switch (count/2){
            case 0:
                TransitionManager.beginDelayedTransition(viewGroup, new Explode());
                break;
            case 1:
                TransitionManager.beginDelayedTransition(viewGroup, new Fade());
                break;
            case 2:
                TransitionManager.beginDelayedTransition(viewGroup, new Slide());
                break;
            case 3:
                TransitionManager.beginDelayedTransition(viewGroup, new AutoTransition());
                break;
            default:
                Log.d("ANIMATION", "Erreur de valeur pour le switch");

        }

        Log.v("ANIMATION","toggle");
        toggle(textView, imageView1, imageView2, imageView3);
        count+=1;
        count%=8;
    }

    private static void toggle(View... views){
        for (View v:views
             ) {
            boolean isVisible = v.getVisibility() == View.VISIBLE;
            v.setVisibility(isVisible ? View.INVISIBLE : View.VISIBLE);

        }

    }
}
