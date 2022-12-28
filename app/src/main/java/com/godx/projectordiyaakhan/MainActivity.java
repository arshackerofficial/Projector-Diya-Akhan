package com.godx.projectordiyaakhan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.otaliastudios.cameraview.CameraView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        CameraView camera = findViewById(R.id.camera);
        camera.setLifecycleOwner(this);

        annoyingPopup();
    }

    public void annoyingPopup(){
        if (!getSharedPreferences("APP_DATA", MODE_PRIVATE).getString("paise", "nhidite").trim().equals("dete")) {

        EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("ਡਿਵੈਲਪਰ ਦੀ ਹੱਕ ਦੀ ਕਮਾਈ!")
                .setView(input)
                .setMessage("ਇਹਨਾਂ ਤੰਗ ਕਰਨ ਵਾਲੇ ਪੌਪਅੱਪ ਤੋਂ ਬਚਣ ਲਈ ਹੇਠਾਂ ਐਕਟੀਵੇਸ਼ਨ ਕੋਡ ਭਰੋ ਜਾਂ 40 ਸਕਿੰਟ ਦੀ ਉਡੀਕ ਕਰੋ।")
                .setCancelable(false)
                .setPositiveButton("OK", null)
                .create();

        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {

            @Override
            public void onShow(DialogInterface dialog) {

                Button b = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                b.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        if(input.getText().toString().trim().equals("eagle")){
                            getSharedPreferences("APP_DATA", MODE_PRIVATE).edit().putString("paise", "dete").commit();
                            dialog.dismiss();
                        }else{
                            Toast.makeText(MainActivity.this, "Activation Code ਗ਼ਲਤ ਹੈ, 40 sec ਰੁਕੋ ਯਾ Code ਸਹੀ ਭਰੋ|", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        alertDialog.show();

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(alertDialog.isShowing())
                    alertDialog.dismiss();
                }
            }, 40000);
        }
    }
}