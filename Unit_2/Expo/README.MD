## Decision Tree Classifier

# Tree Classifier

Un árbol de decisiones es un modelo de aprendizaje automático supervisado que se utiliza para predecir un objetivo mediante el aprendizaje de las reglas de decisión de las funciones. Como sugiere el nombre, podemos pensar en este modelo como un desglose de nuestros datos al tomar una decisión basada en hacer una serie de preguntas.

Por otra parte es más bien como  un proceso de dividir los datos de entrada, este es un procedimiento numérico en el que se alinean todos los valores y se prueban diferentes puntos de división utilizando distintos métodos. Todas las variables de entrada y todos los puntos de división posibles se evalúan y se elige la que tenga mejor resultado.

# Utilizacion 


# Ventajas

* Fácil de entender. Incluso para personas con antecedentes no analíticos, no se requiere ningún conocimiento estadístico para leerlos e interpretarlos.

* Útil en la exploración de datos. El árbol de decisiones es una de las forma más rápidas para identificar las variables más significativas y la relación entre dos o más. Con la ayuda de los árboles de decisión podemos crear nuevas variables o características que tengan mejor poder para predecir la variable objetivo.

* Se requiere menos limpieza de datos. Requiere menos limpieza de datos en comparación con algunas otras técnicas de modelado. A su vez, no está influenciado por los valores atípicos y faltantes en la data.

* El tipo de datos no es una restricción. Puede manejar variables numéricas y categóricas.

* Método no paramétrico. Es considerado un método no paramétrico, esto significa que los árboles de decisión no tienen suposiciones sobre la distribución del espacio y la estructura del clasificador.

 # Fundamentos

 Un árbol de decisión se construye mediante particiones recursivas: a partir del nodo raíz (conocido como el primer padre), cada nodo se puede dividir en nodos secundarios izquierdo y derecho. Estos nodos se pueden dividir aún más y ellos mismos se convierten en nodos principales de sus nodos secundarios resultantes.

 # Ejemplo 1 


   ǀ Por ejemplo,¿el nodo raíz se Work to do? Se divide en los nodos secundarios Stay in y se Outlook se basa en si hay trabajo por hacer o no. El Outlook nodo se divide en tres nodos secundarios. 
Entonces, ¿cómo sabemos cuál es el punto de división óptimo en cada nodo?
Comenzando desde la raíz, los datos se dividen en la función que da como resultado la mayor ganancia de información  (explicada con más detalle a continuación). En un proceso iterativo, luego repetimos este procedimiento de división en cada nodo hijo hasta que las hojas sean puras, es decir, las muestras de cada nodo pertenecen todas a la misma clase. ǀ

 

 # Ejemplo 2


 # Ejemplo 3


# Video

https://www.youtube.com/watch?v=UhY5vPfQIrA

# Conclusión
El clasificador de árbol de decisión es una técnica de clasificación simple y ampliamente utilizada. Aplica una idea sencilla para resolver el problema de clasificación. Ya que este plantea una serie de preguntas cuidadosamente elaboradas sobre los atributos del registro de prueba. Cada vez que recibe una respuesta, se hace una pregunta de seguimiento hasta que se llega a una conclusión. 

# Referencias
https://towardsdatascience.com/https-medium-com-lorrli-classification-and-regression-analysis-with-decision-trees-c43cdbc58054

https://scikit-learn.org/stable/auto_examples/tree/plot_tree_regression.html

