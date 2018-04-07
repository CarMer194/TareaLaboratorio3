package com.example.carlos.tarealaboratorio3;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("\n\n\n*******si sirve el levantamiento*******\n");
    }

    public void compartir (View v){
        System.out.println("\n\n\n*******si sirve el onclick*******\n");
        String mensaje,facebook,github, gmail;
        Resources recurso;
        Uri imageUri = Uri.parse("android.resource://" + getPackageName()
                + "/drawable/" + "codigo_del_proletario");
        Intent sendIntent = new Intent();
        recurso = getResources();
        mensaje = recurso.getString(R.string.mensajecompartir);
        facebook="facebook: "+ recurso.getString(R.string.carlos_merino);
        github="github: "+recurso.getString(R.string.carmer194);
        gmail="gmail: " + recurso.getString(R.string.carlos_merino194);

        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, mensaje +" " + " "+ facebook +" "+ github +" "+gmail);
        sendIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
        sendIntent.setType("image/*");
        sendIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(Intent.createChooser(sendIntent, "send"));
    }
}
