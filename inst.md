9. Ejemplo de uso de la librería y estructura del 
proyecto 
9.1 Ejemplo de uso 
SportActivityApp app = SportActivityApp.getInstance(); 
 
// 1. Autenticación 
boolean ok = app.login("jpgarcia", "passPER21!"); 
 
if (ok) { 
    // 2. Importar actividad desde fichero GPX 
    Activity activity = app.importActivity(new File("ruta.gpx")); 
 
    // 3. Obtener mapa adecuado y crear proyección 
    MapRegion region = activity.getSuggestedMap(); 
    Image img = new Image(new File(region.getImagePath()).toURI().toString()); 
    MapProjection proj = new MapProjection(region, img.getWidth(), 
img.getHeight()); 
 
    // 4. Dibujar el trazado 
    Polyline route = new Polyline(); 
    for (TrackPoint tp : activity.getTrackPoints()) { 
        Point2D p = proj.project(tp); 
        route.getPoints().addAll(p.getX(), p.getY()); 
    } 
    mapPane.getChildren().add(route); 
 
 
    // 6. Mostrar estadísticas 
    System.out.printf("Distancia: %.2f km%n", 
activity.getTotalDistance()/1000.0); 
    System.out.printf("Duración: %s%n",        activity.getDuration()); 
    System.out.printf("Desnivel+: %.0f m%n",   activity.getElevationGain()); 
 
    // 7. Cerrar sesión (guarda estadísticas automáticamente) 
    app.logout(); 
} 
 
9.2 Estructura del proyecto a desarrollar 
El directorio de trabajo de NetBeans es la carpeta raíz del proyecto. La librería crea y busca 
todos sus ficheros relativos a esa carpeta. La siguiente estructura muestra cómo deben 
organizarse los recursos necesarios para que la aplicación funcione correctamente. 
 
MiProyecto/                         <- raíz del proyecto NetBeans 
│ 
├── lib/                            <- librerías externas 
│   ├── IPC2026.jar                 <- librería proporcionada 
│   └── sqlite-jdbc-x.x.x.jar       <- SQLite JDBC (descargar de Maven) 
│ 
├── maps/                           <- imágenes de mapa 
│   ├── valencia.jpg                <- copiar antes de ejecutar 
│   ├── calderona.jpg               <- copiar antes de ejecutar 
│   └── pirineos.jpg                <- copiar antes de ejecutar 
│ 
├── avatars/                        <- creada automáticamente al registrar 
usuarios 
Caso Prácticas IPC 2026 — Running la Safor 
UPV · DSIC 
│ 
└── sportactivity.db               <- creada automáticamente al arrancar 
Importante:  Las carpetas avatars/ y el fichero sportactivity.db se crean 
automáticamente la primera vez que se ejecuta la aplicación. La carpeta maps/ y los tres 
ficheros JPG deben copiarse manualmente antes de la primera ejecución. Si los mapas 
no están presentes, la librería registra las regiones en la base de datos pero no puede 
mostrar las imágenes. 
9.3 Añadir las librerías en NetBeans 
Para añadir IPC2026.jar y sqlite-jdbc al proyecto: 
1. Clic derecho sobre el proyecto -> Properties -> Libraries 
2. En la pestaña Compile, pulsar 'Add JAR/Folder' 
3. Seleccionar lib/IPC2026.jar 
4. Repetir para lib/sqlite-jdbc-x.x.x.jar 
La librería SQLite JDBC puede descargarse desde poliformat o  desde la siguiente dirección  
https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc. Descargad el fichero 
.jar y guardadlo en la carpeta lib/ del proyecto. 
Versión SQLite:  Usad la versión 3.45 o superior. La librería IPC2026.jar ha sido 
compilada y probada con sqlite-jdbc-3.45.x.jar. 
10. 
Persistencia de los datos 
La librería utiliza una base de datos SQLite que se crea automáticamente en el 
directorio de trabajo del proyecto con el nombre sportactivity.db. No es necesario 
configurar nada; la librería inicializa las tablas al arrancar. 
Si necesitáis inspeccionar el contenido de la base de datos durante el desarrollo, 
podéis usar la aplicación gratuita DB Browser for SQLite (https://sqlitebrowser.org). 
Se proporcionará una base de datos con un usuario genérico para poder probar la 
aplicación antes de tener implementado el registro de usuarios. 
Página 20 de 21 
Caso Prácticas IPC 2026 — Running la Safor 
UPV · DSIC 
11. 
Proyecto base 
Se proporciona el proyecto NetBeans MapaDemo como punto de partida. Este 
proyecto muestra cómo implementar el zoom sobre el mapa usando un Group dentro 
de un ScrollPane, que es la estructura necesaria para que el escalado funcione 
correctamente con los nodos superpuestos. 
Recomendación:  Usad este proyecto como base, eliminando o adaptando lo que 
no sea necesario para vuestra implementación. La estrategia adecuada pasa por 
generar cada vista en un fichero fxml diferente e ir cambiando las diferentes áreas 
del BorderPane según las acciones del usuario. 