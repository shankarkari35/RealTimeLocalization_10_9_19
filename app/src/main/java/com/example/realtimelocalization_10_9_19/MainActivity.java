package com.example.realtimelocalization_10_9_19;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.media.VolumeShaper;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
Button changelang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changelang=findViewById(R.id.button3);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));
    changelang.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showchangelanguagedilog();
        }
    });
    }

  private void showchangelanguagedilog() {
        final String[]listItems={"Kannada","English","telugu"};
        final AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
      builder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int i) {
                      builder.setTitle("lagugages");
                      if(i==0)
                      {
                          setLocale(" Kannada");
                          recreate();
                      }
                         else if(i==1){
                      }
                          setLocale("English");
                          recreate();
                      }
                     /* else if (i==2){
                          setLocale("telugu");
                          recreate();
                      }*/

                  }

              });

    }

    private void setLocale(String lang) {
        Locale locale=new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration=new Configuration();
         configuration.locale=locale;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());
       SharedPreferences.Editor editor=getSharedPreferences("setting",MODE_PRIVATE.edit());
        editor.putString("Mylang",lang);
       editor.apply();
    }

    private void loadLocale() {
        SharedPreferences.Editor editor=getSharedPreferences("setting",MODE_PRIVATE.edit());
        editor.putString("Mylang","");
        setLocale("");
    }
}
