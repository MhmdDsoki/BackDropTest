package com.example.dsoki.backdrop;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.roacult.backdrop.BackdropLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    BackdropLayout backdropLayout;
    //declare view of backLayout
    RadioButton rdi_apple,rdi_orange,rdi_water_melon,rdi_picture_one,rdi_picture_two;
    //declare view of frontLayout
    TextView txt_result;
    ImageView img_result;
    //declare layout
    View backLayout,frontLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//A backdrop appears behind all other surfaces in an app,
// displaying contextual and actionable content.
        backdropLayout =(BackdropLayout)findViewById(R.id.container);

        //initialize back and front
        backLayout = backdropLayout.getChildAt(0);
        frontLayout = backdropLayout.getChildAt(1);

        //view
        rdi_apple  =(RadioButton)backLayout.findViewById(R.id.rdi_Apple);
        rdi_orange =(RadioButton)backLayout.findViewById(R.id.rdi_Orange);
        rdi_water_melon =(RadioButton)backLayout.findViewById(R.id.rdi_melon);
        rdi_picture_one =(RadioButton)backLayout.findViewById(R.id.rdi_picture_one);
        rdi_picture_two =(RadioButton)backLayout.findViewById(R.id.rdi_picture_two);

        txt_result =(TextView)frontLayout.findViewById(R.id.txt_result);
        img_result =(ImageView)frontLayout.findViewById(R.id.img_result);

        //Event
        rdi_water_melon.setOnCheckedChangeListener(this);
        rdi_orange.setOnCheckedChangeListener(this);
        rdi_apple.setOnCheckedChangeListener(this);
        MyImageChecked myImageChecked =new MyImageChecked();
        rdi_picture_one.setOnCheckedChangeListener(myImageChecked);
        rdi_picture_two.setOnCheckedChangeListener(myImageChecked);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean b) {
        if (b){
            txt_result.setText(buttonView.getText());
              }
        }

    private class MyImageChecked implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(buttonView.getId()==R.id.rdi_picture_one){
                img_result.setImageResource(R.drawable.ic_launcher_background);
            }
            else if (buttonView.getId()==R.id.rdi_picture_two){
                img_result.setImageResource(R.drawable.ic_launcher_foreground);

            }
        }
    }
}
