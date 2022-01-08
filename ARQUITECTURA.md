<div align="justify">

# ARQUITECTURA EN ANDROID

  En esta sección, analizamos un caso práctico para demostrar cómo estructurar una app que hará uso de distintos recursos.

___ESTOS RECURSOS SE IRÁN DESCRIBIENDO A LO LARGO DE LA DESCRICIÓN___.

## APP

  _Imagina que estamos creando una app que requiere gestionar usuarios, con unos campos mínimos de información_.

  Para ello vamos a gestionar la siguiente información:

  ```java
  User {
    private String first_name;
    private String last_name;
    private String email;
    private String avatar;
    ...
  ```

  Como podemos observar los campos son: _first_name, last_name, email, avatar_.

  En este punto y teniendo en cuenta los datos que debemos de gestionar, una buena práctica es ___identificar la clave primaria, que utilizaremos de modo que nos ayude a simplificar las operaciones que vamos a realizar sobre la información___.

  Dichas operaciones son, en el 99% un ___CRUD___:

  <div align="center">
    <img width="400px" src="https://www.dorusomcutean.com/wp-content/uploads/2020/03/crud.jpg">
  </div>

  </br>

  Cada una de estas __acciones__ llevan asociadas un tipo de __operación__ en la cualquier sistema de almacenamiento que se este utilizando.

  | Acción | Método |
  | --- | --- |
  | Create | 	POST |
  | Read | GET |
  | Update |	PUT/PATCH |
  | Delete | DELETE |

  Teniendo en cuenta lo anterior descrito: ¿cual sería la clave primaria que seleccionarias?
  - Opción 1: Un identificador que provee la BBDD, o que incluye el programador.
  - Opción 2: Seleccionar uno de los campos que podremos seleccionar como único dado sus características.

<details>
  <summary>SOLUCIÓN</summary>
    Seleccionar si es posible un campo de User, por ejemplo email. Campo único.
</details>

  Tras todo lo anterior, la clase User va a pertencer al modelo de la APP, o a nuesta ___[API](https://www.redhat.com/es/topics/api/what-are-application-programming-interfaces#:~:text=Una%20API%20es%20un%20conjunto,de%20saber%20c%C3%B3mo%20est%C3%A1n%20implementados)___.

  Inicialmente nuestra clase se llamara UserModel, y tendrá un aspecto similar al siguiente:

  ```java
  public class UserModel {

    private String first_name;
    private String last_name;
    private String email;
    private String avatar;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public UserModel(String first_name, String last_name, String email, String avatar) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.avatar = avatar;
    }
}
```

  Como podemos se trata de una clase normal formada por sus atributos, get/set y el pertinente constructor.

  ```java
  public UserModel(String first_name, String last_name, String email, String avatar)
  ```

  Después de la primera descripción vamos a comenzar a desarrollar a través de ___Android Studio___.

## Creación de la Estrucctura de la App

  Para comenzar, vamos a seleccionar el tipo de app que deseamos crear. Por ello, vamos a seleccionar Empty Activity:

  <div align="center">
    <img width="400px" src="https://i.blogs.es/ea1229/newproyect/1366_2000.jpg">
  </div>

</br>

<details>
  <summary>MOTIVO</summary>
    Si seleccionar otro tipo de estructura incial se generará información extra que no será necesaria en nuestro desarrollo.
</details>

En primer lugar vamos a utilizar nuestra apliación en un ___entorno local___. Es por ello que vamos a comenzar el desarrollo y el almacenamiento en una BBDD local ___SQLITE___.


Dicho esto, debemos de crear la estructura que gestiona la BBDD siguiendo el [patrón de android](https://developer.android.com/oauth2authorize?return_url=https%3A%2F%2Fdeveloper.android.com%2Ftraining%2Fdata-storage%2Fsqlite%3Fhl%3Des&prompt=none&auto_signin=True&scopes=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fdeveloperprofiles+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fdeveloperprofiles.award).

Recuerda que dicho patrón define la construcción de un __contrat y un entry__. Teniendo en cuenta la información anterior será similar a:

```java
public final class UserContract {

    private UserContract() {}

    public static class UserEntry implements BaseColumns {
        public static final String TABLE_NAME = "User";
        public static final String COLUMN_NAME_FIST_NAME = "first_name";
        public static final String COLUMN_NAME_LAST_NAME = "last_name";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String COLUMN_NAME_AVATAR = "avatar";
    }
}
```

  Recuerda que utilizando __implements BaseColumns__ vamos a heredar la columna __\_ID__.

___IMPORTANTE___:
</br>
_Android almacena tu base de datos en la carpeta privada de tu app. Los datos están seguros porque, de forma predeterminada, esta área no es accesible para otros usuarios y apps_.

### Conexión a la BBDD

  La clase ___SQLiteOpenHelper___ contiene un conjunto útil de ___API para administrar tu base de datos___. Cuando utilizas esta clase para obtener referencias a tu base de datos, el sistema realiza las operaciones crear y actualizar la base de datos solo cuando es necesario y no durante el inicio de la app.

  La clase que debemos de extender __extends SQLiteOpenHelper__, y será similar a la siguiente:

  ```java
  public class UserDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "User.db";

    public UserDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        //db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //onUpgrade(db, oldVersion, newVersion);
    }
}
```

Cosas a tener en cuenta:
- Crea un __ComunHelper__ siempre y cuando tengas que interactuar con ___más de una tabla___.
- __onCreate(..)__ se llama cada vez que la aplicación está recién instalada. __onUpgrade__ se llama siempre que la aplicación se actualiza y se inicia y la versión de la base de datos no es la misma.

## Referencias

- [Arquitectura Android](https://developer.android.com/jetpack/guide?hl=es-419#recommended-app-arch).
- [Gestión de BBDD en Android](https://developer.android.com/oauth2authorize?return_url=https%3A%2F%2Fdeveloper.android.com%2Ftraining%2Fdata-storage%2Fsqlite%3Fhl%3Des&prompt=none&auto_signin=True&scopes=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fdeveloperprofiles+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fdeveloperprofiles.award).

</div>
