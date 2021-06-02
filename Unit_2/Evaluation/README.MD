# Multilayer perceptron

En las siguientes instrucciones volveremos a algunas importaciones importantes para la realización del problema y la percepción de los datos.
Estos datos se recuperaron del repositorio: https://github.com/jcromerohdz/iris
Usaremos Liberia Mlib que puede ayudarnos en la percepción multicapa.
Para el primer paso, debe limpiar los datos a través de este script.

```scala
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.feature. {VectorAssembler, StringIndexer}
import org.apache.spark.ml.linalg.Vectors
```

#### Cargamos los datos del iris del .csv para ser evaluados.
```scala
val data = spark.read.option ("header", "true").option("inferSchema", "true").format ("csv").load("C:/Repositorios/Big_Data/Unit_2/Evaluation/iris.csv")
```

#### Convertimos los datos de la columna "species" a valores numericos.
```scala
val label = new StringIndexer().setInputCol("species").setOutputCol("label")
val labeltransform = label.fit(data).transform(data)
```

#### Convertimos los datos de todas las columnas a un arreglo llamadao "Features" y despues la pasamos a otro arreglo llamado data 2.
```scala
val Features = (new VectorAssembler(). setInputCols (Array ("sepal_length", "sepal_width", "petal_length", "petal_width")).setOutputCol("features"))
val data2 = Features.transform(labeltransform)
```

#### a. Utilice la librería Mllib de Spark el algoritmo de Machine Learning correspondiente a multilayer perceptron.
```scala
    import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
    import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
```
#### 2. ¿Cuáles son los nombres de las columnas?
```scala
    data2.columns
```

![image](https://user-images.githubusercontent.com/60414250/120407438-023f8400-c302-11eb-8a06-840a99af86c1.png)


#### 3. ¿Cómo es el esquema?
```scala
    data2.printSchema()
```

![image](https://user-images.githubusercontent.com/60414250/120407471-11becd00-c302-11eb-95c7-bb0f2771f7e8.png)


#### 4. Imprime las primeras 5 columnas.
```scala
    data2.show(5)
```

![image](https://user-images.githubusercontent.com/60414250/120407502-200ce900-c302-11eb-83a2-9b5f5ed86f02.png)


#### 5. Usa el metodo describe () para aprender mas sobre los datos del DataFrame.
```scala
    data2.describe().show()
```

![image](https://user-images.githubusercontent.com/60414250/120407550-387d0380-c302-11eb-8813-eedcaebdcf1e.png)


#### 6. Haga la transformación pertinente para los datos categoricos los cuales serán nuestras etiquetas a clasificar.
```scala
// Cubre el algoritmo en trabajar con caractisticas, dividido en grupos de datos.
    val data3 = data2.select("features", "label")
    data3.show()
    
    ![image](https://user-images.githubusercontent.com/60414250/120407584-4fbbf100-c302-11eb-962c-ba850f2768ba.png)
    
// Se separaremos los datos de entrenamientos y los datoss de testing usando los datos indexados dentro de la siguente linea.
    val splits = data3.randomSplit(Array(0.7, 0.3), seed = 1234L)
    val train = splits(0)
    val test = splits(1)
```

#### 7. Construya el modelo de clasificación y explique su arquitectura.
```scala
    val layers = Array[Int](4, 5, 4, 3)
// Se configura el entrenador del algoritmo Multilayer
    val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setBlockSize(128).setSeed(1234L).setMaxIter(100)
// Se entrana el modelo, entrenado los datos del entrenamiento ejecutado con anterioridad
    val modelML = trainer.fit(train)
// Se ejecutara un modelo con los datos de prueba.
    val result = modelML.transform(test)
    val predictionAndLabels = result.select("prediction", "label")
// Se ejecuta la estimacion de los datos depediendo de la precision del modelo resultante.
    val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")
//Mostramos la prediccion
    predictionAndLabels.show (50)
    
    ![image](https://user-images.githubusercontent.com/60414250/120407729-94e02300-c302-11eb-9d12-ccb7aaef9e73.png)
![image](https://user-images.githubusercontent.com/60414250/120407807-b8a36900-c302-11eb-9c29-f3f688d1edf7.png)

//Mostramos los datos del resultado generado. 
    result.show (30)
```

![image](https://user-images.githubusercontent.com/60414250/120407880-ceb12980-c302-11eb-8e0b-0f2836c19cf0.png)

#### 8. Resultado de impricion de los resultados del modelo.
```scala
    println(s"Test set accuracy = ${evaluator.evaluate(predictionAndLabels)}")
```

![image](https://user-images.githubusercontent.com/60414250/120407921-dffa3600-c302-11eb-8963-580414a98d9a.png)
