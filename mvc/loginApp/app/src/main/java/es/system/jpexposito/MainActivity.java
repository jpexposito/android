package es.system.jpexposito;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import es.system.jpexposito.activity.Pantalla1Activity;
import es.system.jpexposito.view.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Button button;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         button = (Button) findViewById(R.id.pantallaPrincipal);
         button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        Intent anteriorPantalla = new Intent(Pantalla1Activity.this,
        MainActivity.class);
        startActivity(anteriorPantalla);
        }
        });**/
    }

    public void cambioPantalla1(View view) {
        Intent anteriorPantalla = new Intent(MainActivity.this,
                Pantalla1Activity.class);
        startActivity(anteriorPantalla);
    }

    @Override
    public void OnLoginSuccess(String message) {

    }

    @Override
    public void OnLoginError(String message) {

    }

    /**
    EditText email,password;
    Button loginb;
    Button crearuser;
    ILoginController loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (EditText) findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        loginb = (Button) findViewById(R.id.loginb);
        loginPresenter = new LoginController(this);
        loginb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.OnLogin(email.getText().toString().trim(),password.getText().toString().trim());
            }
        });

        crearuser = (Button) findViewById(R.id.crearuser);
        //loginPresenter = new LoginController(this);
        crearuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_login_register);
                //loginPresenter.OnLogin(email.getText().toString().trim(),password.getText().toString().trim());
            }

        });
    }
    @Override
    public void OnLoginSuccess(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void OnLoginError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
    */
}