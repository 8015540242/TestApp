package com.example.foray.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;
import android.widget.ImageView;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
GestureDetector.OnDoubleTapListener {
    ViewGroup mlayout;
    private TextView textView;
    private Button btn;
    private Button nextbtn;
    MyDBHandler dbHandler;
    EditText nametxt;
    EditText degtxt;
    EditText adrtxt;
    TextView disptxt;
    private Button savebtn;
    private Button delbtn;
    private GestureDetectorCompat gestureDetector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Gesture method implement starts

        textView = (TextView) findViewById(R.id.txtgest);
        btn = (Button) findViewById(R.id.clckbtn);
        this.gestureDetector = new GestureDetectorCompat(this, this);
        gestureDetector.setOnDoubleTapListener(this);


        //Gobutton Click Event starts

        nextbtn = (Button) findViewById(R.id.nextbtn);

        //Intilialize the database view's
        disptxt = (TextView) findViewById(R.id.disptxt);
        nametxt = (EditText) findViewById(R.id.nametxt);
        degtxt = (EditText) findViewById(R.id.degtxt);
        adrtxt = (EditText) findViewById(R.id.adrtxt);
        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();






        nextbtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getApplicationContext(), dataBase_Ex_Activity.class);
                        startActivity(i);

                    }
                }
        );


        /////Animation stats here////
        mlayout = (ViewGroup) findViewById(R.id.mlayout);


        mlayout.setOnTouchListener(
                new RelativeLayout.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        moveImage();
                        return true;
                    }
                }
        );






        /*final TextView textView1=(TextView)findViewById(R.id.disptxt);
        final TextView textView2=(TextView)findViewById(R.id.restxt);
        final Button btn=(Button) findViewById(R.id.clkbtn);
        */


        /////////OnClickEvent Invoked//////////
        btn.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        textView.setText("OnClick Invoked ");

                    }

                }
        );

        ///////LongClickEvent Invoked//////

        btn.setOnLongClickListener(
                new Button.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        textView.setText("onLongClick Invoked");
                        return true;
                    }
                }
        );

    }

    //Add the Student info to the DB

    public void addButtonClicked(View view) {
        Students students = new Students(nametxt.getText().toString(), degtxt.getText().toString(), adrtxt.getText().toString());
        dbHandler.addStudents(students);
        printDatabase();
    }

    //Delete the Items from the database

    public void delButtonClicked(View view) {
        String inputText = nametxt.getText().toString();
        dbHandler.deleteStudents(inputText);
        printDatabase();


    }


    public void printDatabase() {
        String dbString = dbHandler.databaseToString();
        nametxt.setText("");
        degtxt.setText("");
        adrtxt.setText("");
        disptxt.setText(dbString);
    }


















    //--------On create Method Ends--------------------//


    public void moveImage(){
        View imgv1 =(ImageView) findViewById(R.id.imgv1);


        //change the positon button///
        RelativeLayout.LayoutParams postionRules = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);

        postionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
        postionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);
        imgv1.setLayoutParams(postionRules);


        //change the positon button///
        ViewGroup.LayoutParams sizeRules = imgv1.getLayoutParams();
        sizeRules.width= 600;
        sizeRules.height=550;
        imgv1.setLayoutParams(sizeRules);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        textView.setText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        textView.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        textView.setText("onDoubleTapEvent");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        textView.setText("onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        textView.setText("onShowPress");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        textView.setText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        textView.setText("onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        textView.setText("onLongPress");

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        textView.setText("onFling");
        return true;
    }

               /////////End Gesture/////

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        this.gestureDetector.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }
}



