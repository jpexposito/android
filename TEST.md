<div align="justify">

# Incluyendo test en la App.   


<div align="center">
  <img src="https://miro.medium.com/max/1400/1*bBa99biSpI9BsaVdnzOMQw.png" width="600px" >
</div>


  __Android__ incluye diferentes tipos de test, para poder ver como evoluciona nuestro código sin tener que lanzar la _app_.

## Tipos de pruebas y ubicación

  La ubicación del código de tu prueba dependerá del tipo de prueba que escribas. Android Studio proporciona directorios de código fuente (conjuntos de orígenes) para los siguientes dos tipos de pruebas:

### Pruebas de unidad local

___Ubicación: module-name/src/test/java/___.

  Estas son pruebas que se ejecutan en la máquina virtual Java (JVM) local de tu máquina. Usa estas pruebas para minimizar el tiempo de ejecución cuando tus pruebas no tengan dependencias de framework de Android o cuando puedas simularlas.

  Durante el tiempo de ejecución, las pruebas se ejecutan en relación con la versión modificada de android.jar, en la que se quitan todos los modificadores final. De esta manera, puedes usar bibliotecas de simulación populares, como __Mockito__.

### Pruebas instrumentadas

___Ubicación: module-name/src/androidTest/java/.___

  Son pruebas que se ejecutan en un dispositivo o emulador de hardware. Esas pruebas tienen acceso a las API de Instrumentation, te brindan acceso a información como el Context de la app que estás probando y te permiten controlar la app desde el código de prueba. Úsalas cuando escribas pruebas de IU de integración y funcionales para automatizar la interacción de usuarios, o cuando tus pruebas tengan dependencias de Android que los objetos ficticios no puedan contemplar.

  Debido a que las pruebas instrumentadas se compilan en un APK (independiente del APK de tu app), deben tener su propio archivo AndroidManifest.xml. Sin embargo, Gradle genera automáticamente ese archivo durante la compilación para que no se vea en el conjunto de orígenes de tu proyecto. Puedes agregar tu propio archivo de manifiesto si es necesario, por ejemplo, a fin de especificar un valor diferente para "minSdkVersion" o registrar objetos de escucha de ejecución solo para tus pruebas. Cuando se compila tu app, Gradle combina varios archivos de manifiesto en uno solo.

## Pruebas realizadas en la Aplicación

  En el desarrollo de la aplicación se han realizado ambos tipos de pruebas. Además se ha incluido [jacoco](https://medium.com/@hhugoac/configuring-jacoco-for-testing-coverage-in-android-9bdad3dde705), para deperminar la covertura de código en nuestra aplicación, elemento ___IMPORTANTE___ en el mundo del __desarrollo de software__.

  Para ejecutar las ___pruebas instrumentadas___ y ver su covertura, hemos de ejecutar desde la terminal el siguiente comando:

  ```console
  ./gradlew createDebugAndroidTestCoverageReport
  ```

  Una vez lanzado el comando y pasado unos instantes hemos de haceder a la carpeta del proyecto ___app/build/reports/androidTest/connected/index.html___ y observer la cobertura de código de las diferentes clases que forman parte de nuestro proyecto. Obteniendo algo similar a esto:

  <div align="center">
    <img src="https://miro.medium.com/max/1400/1*ZhN510g259FerUsJfVJV0A.png" width="600px" >
  </div>

</div>
