<div align="justify">

# App MVC Lluvia de Ideas

<div align="center">
  <img src="https://coworkingfy.com/wp-content/uploads/2020/01/grupo-personas-aportando-ideas-reunion-1024x612.jpg" width="600px" >
</div>

## Introducción

   Esta __App__ tiene como objetivo ir describiendo la creación de una aplicación con arquitectura _mvc_, a la que se le irán  incluyendo elementos y características con __JAVA__ como lenguaje de programación.

## MVC

  La aplicación va estar estructurada bajo el __modelo-vista-controlador__.
  - Modelo. Es la capa encargada de realizar la gestión de la información con la _BBDD_.
  En el ejemplo, el paquete será:

```console
  es.system.jpexposito.model
```

  - Vista. La vista no es más que la interfaz de entrada del usuario, que en caso de una _app en android_ son las pantallas de entrada o salida de información.

  En el ejemplo, el paquete será:

```console
  es.system.jpexposito.view
```


  - Controlador. Un controlador no es más que el responsable de controlar las acciones que se realizan con el fin de que la información que llega a la capa de modelo/vista cumpla una serie de requerimientos o validaciones, así como formatos.
  Un ejemplo sería _Un controlador recibe la entrada, la valida y pasa la entrada validada al modelo._

  En el ejemplo, el paquete será:

```console
  es.system.jpexposito.controller
```

## Pasos

  Vamos a ver los pasos para la creación de esta app:
  - __Paso 1__. File > New > New Project > Select Empty Activity > Next > Da un nombre a tu app, por ejemplo _App Login_ > finish.
  - __Paso 2__. Crea la estructura de paquetes, dentro de app/java.
    - Modelo. __tu_paquete.model__.
    - Vista. __tu_paquete.view__.
    - Modelo.__tu_paquete.controller__.
  Para hacerlo, botón derecho > New > Package. Cada uno de estos paquetes contendrá las _interfaces y clases_ correspondientes en cada paquete.   
  - __Paso 3__. Creación de las interfaces y clases correspondientes.
    - _Modelo_. En la paquete modelo hemos de crear las clases [IUser](mvc/loginApp/app/src/main/java/es/system/jpexposito/model/IUser.java) y [User](mvc/loginApp/app/src/main/java/es/system/jpexposito/model/User.java). La primera contendrá la interfaz con el getter del password y email, junto con el método de validación. Por último la clase _User_ contendra la implementación de los métodos.
    - _Controlador_. En este paquete hemos de crear la interfaz [ILoginController](mvc/loginApp/app/src/main/java/es/system/jpexposito/controller/ILoginController.java) con el método _OnLogin_, asi como su implementación en [LoginController](mvc/loginApp/app/src/main/java/es/system/jpexposito/controller/LoginController.java). Como podemos observar su resposabilidad es conectar vista y modelo y realizar la operación indicada en el método _OnLogin_.
    - _Vista_. Por último en este paquete se debe de implementar la clase interfaz [ILoginView](mvc/loginApp/app/src/main/java/es/system/jpexposito/view/ILoginView.java), con los métodos _OnLoginSuccess_ y _OnLoginError_ que serán implementados en la clase [MainActivity](mvc/loginApp/app/src/main/java/es/system/jpexposito/MainActivity.java), clase principal encargada de lanzar la app.
  - __Paso 4__. Identificadores de la interfaz y captación en la clase [MainActivity](mvc/loginApp/app/src/main/java/es/system/jpexposito/MainActivity.java).
```java
  EditText email,password;
  email = (EditText) findViewById(R.id.email);
```
  A modo de ejemplo, vamos a ver como asignamos valor a variable __email__. Para ello debemos de hacer uso del método __findViewById(R.id.email)__, donde __R.id.email__ es el identificador que le hemos dado en fichero [activity_main.xml](/mvc/loginApp/app/src/main/res/layout/activity_main.xml)
```xml
  <EditText
      android:id="@+id/email"
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      android:layout_margin="20dp"
      android:hint="Email"/>
```
  De la misma forma accederemos a los valores de las restantes variables definidas.

    __Recuerda siempre utilizar identificadores con valores descriptivos, que sean fáciles de encontrar__.

  Igualmente haremos uso de los eventos de los botones que estemos utilizando en nuestra __app__. Pongamos un ejemplo.
```java
            loginb = (Button) findViewById(R.id.loginb);
            loginPresenter = new LoginController(this);
            loginb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loginPresenter.OnLogin(email.getText().toString().trim(),password.getText().toString().trim());
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
```
  Podemos observar como estamos conectando nuestro botón, con nuestra vista, y con el evento _onClick_.

  __No obstante, puedes copiar el ejemplo, y probarlo para comprender su funcionamiento y llevar el comportamiento a tu proyecto__.

<div>  
