package es.system.jpexposito.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import es.system.jpexposito.MainActivity;
import es.system.jpexposito.R;

public class Pantalla2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Button button;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
    }

    public void cambioPantallaPrincipal(View view) {
        Intent anteriorPantalla = new Intent(Pantalla2Activity.this,
                MainActivity.class);
        startActivity(anteriorPantalla);
    }
}