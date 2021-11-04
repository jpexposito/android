<div align="justify">


# DEFINICIÓN DE LAYOUTS , SUS TIPOS Y TRABAJO CON ELLOS

<div align="center">
  <img width="400px" src="https://i.blogs.es/ea1229/newproyect/1366_2000.jpg">
</div>


## Introducción

  En este punto se va a describir la construcción de Layouts y la comunicación en __Android__.

  _La interfaz de usuario de tu app es todo aquello que el usuario puede ver y con lo que puede interactuar en ella. Android ofrece una variedad de componentes de IU previamente compilados, como objetos de diseño estructurados y controles de la IU que te permiten compilar la interfaz gráfica de usuario para tu app. Además, también brinda otros módulos de IU para interfaces especiales, como diálogos, notificaciones y menús._

  En este punto veremos algunos, aquellos que utilice la ___app___, y se hará referencia a importantes que se deben de tener en cuenta en el desarrollo de cualquier aplicación.

## Crear Layouts En Android Studio

  Dentro de la estructura de un proyecto en Android Studio existe el directorio res para el almacenamiento de recursos de la aplicación que se está desarrollando.

  Las definiciones XML para los layouts se guardan dentro del subdirectorio ___layout___.

### Tipos de Layout

#### LinearLayout

  El LinearLayout apila todos los elementos hijo que tiene uno detrás de otro y puede ser en vertical __(uno debajo de otro)__ .

  <div align="center">
    <img width="300px" src="https://www.mejorprogramacion.com/wp-content/uploads/2018/04/linearvertical1.png">
  </div>

  ___Por ejemplo la página de validación de nuestra aplicación podría ser de este tipo___.

#### RelativeLayout

  Este Layout posiciona los controles o elementos hijos de forma relativa entre unos y otros, por ejemplo: debajo de, o ala izquierda de.

<div align="center">
  <img width="300px" src="https://www.mejorprogramacion.com/wp-content/uploads/2018/04/relative1.png">
</div>

#### TableLayout

  Es una tabla definida (Filas y Columnas) en las que podemos poner los elementos, es muy parecido a una tabla en HTML.

  Dentro de la etiqueta de éste Layout para cada fila o row debemos poner la etiqueta TableRow para cada fila.

<div align="center">
  <img width="300px" src="https://www.mejorprogramacion.com/wp-content/uploads/2018/04/table1.png">
</div>

### AbsoluteLayout

  Posiciona los elementos de manera absoluta en pantalla según la posición indicada, seguramente es el Layout menos usado ya que dada la gran variedad en los tamaños de pantalla de los dispositivos móviles puede tener problemas en el total de área que se pueda mostrar en la pantalla, es decir, algunos elementos podrían no mostrarse por estar posicionados en un área que está por fuera de la pantalla.

  Cuando seleccionamos éste Layout en Android Studio nos damos cuenta de que la etiqueta la pone tachada y esto significa que está obsoleta, si podemos utilizarla pero debemos evitar su uso por las razones que vimos anteriormente.

<div align="center">
  <img width="300px" src="https://www.mejorprogramacion.com/wp-content/uploads/2018/04/absolute1.png">
</div>


  Existe distintos tipos de ___layouts___ y hemos de seleccionar el que más se detecte a nuestras necesidades.

  Los tipos que podemos encontrar son:

  <div align="center">
    <img src="https://data-flair.training/blogs/wp-content/uploads/sites/2/2020/05/types-of-android-Layouts.jpg">
  </div>

### Elementos dentro de un Layout

  Los elementos que puede contener un layout son:
  - TextView
  - EditText
  - Button
  - Image Button
  - Date Picker
  - RadioButton
  - CheckBox buttons
  - Image View

## Referencia

  - [Tipos y trabajo con layouts en android](https://developer.android.com/guide/topics/ui/declaring-layout?hl=es-419).


</div>
