package github.upendrasinghktp.jumbleword;

import android.content.ClipData;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CardView text1,text2,text3,text4,text5,text6,text7,text8,text9;
    TextView result;
    CardView resultView,reset;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) actionBar.setTitle(getResources().getString(R.string.app_name));

        text1 = (CardView) findViewById(R.id.txt1);
        text2 = (CardView) findViewById(R.id.txt2);
        text3 = (CardView) findViewById(R.id.txt3);
        text4 = (CardView) findViewById(R.id.txt4);
        text5 = (CardView) findViewById(R.id.txt5);
        text6 = (CardView) findViewById(R.id.txt6);
        text7 = (CardView) findViewById(R.id.txt7);
        text8 = (CardView) findViewById(R.id.txt8);
        text9 = (CardView) findViewById(R.id.txt9);

        result = (TextView) findViewById(R.id.result);
        resultView = (CardView) findViewById(R.id.resultView);
        reset = (CardView) findViewById(R.id.reset);
        setOnListner();
    }


    private void setOnListner()
    {

        text1.setOnLongClickListener(mylongClickListener);
        text2.setOnLongClickListener(mylongClickListener);
        text3.setOnLongClickListener(mylongClickListener);
        text4.setOnLongClickListener(mylongClickListener);
        text5.setOnLongClickListener(mylongClickListener);
        text6.setOnLongClickListener(mylongClickListener);
        text7.setOnLongClickListener(mylongClickListener);
        text8.setOnLongClickListener(mylongClickListener);
        text9.setOnLongClickListener(mylongClickListener);

        resultView.setOnDragListener(mydragListener);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("");
                text1.setVisibility(View.VISIBLE);
                text2.setVisibility(View.VISIBLE);
                text3.setVisibility(View.VISIBLE);
                text4.setVisibility(View.VISIBLE);
                text5.setVisibility(View.VISIBLE);
                text6.setVisibility(View.VISIBLE);
                text7.setVisibility(View.VISIBLE);
                text8.setVisibility(View.VISIBLE);
                text9.setVisibility(View.VISIBLE);
            }
        });
    }

    View.OnLongClickListener mylongClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            if(mediaPlayer != null ) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.sound);
                mediaPlayer.start();
            }

            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                v.startDragAndDrop(data,shadowBuilder,v,0);
            } else {
                v.startDrag(data,shadowBuilder,v,0);
            }
            return true;
        }
    };


    View.OnDragListener mydragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            final View view = (View) event.getLocalState();
            int dragevent = event.getAction();
            switch (dragevent){
                case DragEvent.ACTION_DRAG_ENTERED:
                    if(view.getId() == R.id.txt1){
                        result.append("work" + " ");
                        text1.setVisibility(View.INVISIBLE);
                    }else if(view.getId() == R.id.txt2){
                        result.append("Hindu" + " ");
                        text2.setVisibility(View.INVISIBLE);
                    }else if(view.getId() == R.id.txt3){
                        result.append("eat" + " ");
                        text3.setVisibility(View.INVISIBLE);
                    }else if(view.getId() == R.id.txt4){
                        result.append("love" + " ");
                        text4.setVisibility(View.INVISIBLE);
                    }else if(view.getId() == R.id.txt5){
                        result.append("the" + " ");
                        text5.setVisibility(View.INVISIBLE);
                    }else if(view.getId() == R.id.txt6){
                        result.append("STEP" + " ");
                        text6.setVisibility(View.INVISIBLE);
                    }else if(view.getId() == R.id.txt7){
                        result.append("I" + " ");
                        text7.setVisibility(View.INVISIBLE);
                    }else if(view.getId() == R.id.txt8){
                        result.append("hate" + " ");
                        text8.setVisibility(View.INVISIBLE);
                    }else if(view.getId() == R.id.txt9){
                        result.append("app" + " ");
                        text9.setVisibility(View.INVISIBLE);
                    }

                    if(result.getText().toString().trim().equals("I love the Hindu STEP app"))
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("Level Completed!")
                                .setCancelable(false)
                                .setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        result.setText("");
                                        text1.setVisibility(View.VISIBLE);
                                        text2.setVisibility(View.VISIBLE);
                                        text3.setVisibility(View.VISIBLE);
                                        text4.setVisibility(View.VISIBLE);
                                        text5.setVisibility(View.VISIBLE);
                                        text6.setVisibility(View.VISIBLE);
                                        text7.setVisibility(View.VISIBLE);
                                        text8.setVisibility(View.VISIBLE);
                                        text9.setVisibility(View.VISIBLE);

                                    }
                                });
                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
//                    view.animate()
//                            .x(resultView.getX())
//                            .y(resultView.getY())
//                            .setDuration(500)
//                            .start();
                    break;
            }

            return true;
        }
    };


    public void onDestroy() {

        if(mediaPlayer != null ) {
            mediaPlayer.stop();}
        super.onDestroy();

    }
}
