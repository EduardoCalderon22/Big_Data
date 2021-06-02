# Multilayer perceptron

In the following instructions we will return to some important imports for the realization of the problem and the perception of the data.
This data was retrieved from the repository: https://github.com/jcromerohdz/iris
We will use Liberia Mlib which can help us in multilayer perception.
For the first step, you need to clean the data through this script.

```scala
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.feature. {VectorAssembler, StringIndexer}
import org.apache.spark.ml.linalg.Vectors
```

#### We load the iris data from the .csv to be evaluated.
```scala
val data = spark.read.option ("header", "true").option("inferSchema", "true").format ("csv").load("C:/Repositorios/Big_Data/Unit_2/Evaluation/iris.csv")
```

#### We convert the data in the "species" column to numeric values.
```scala
val label = new StringIndexer().setInputCol("species").setOutputCol("label")
val labeltransform = label.fit(data).transform(data)
```

#### We convert the data of all the columns to an array called "Features" and then we pass it to another array called data 2.
```scala
val Features = (new VectorAssembler(). setInputCols (Array ("sepal_length", "sepal_width", "petal_length", "petal_width")).setOutputCol("features"))
val data2 = Features.transform(labeltransform)
```

#### a. Use the Spark Mllib library the Machine Learning algorithm corresponding to multilayer perceptron.
```scala
    import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
    import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
```
#### 2. What are the names of the columns?
```scala
    data2.columns
```

![image](https://user-images.githubusercontent.com/60414250/120407438-023f8400-c302-11eb-8a06-840a99af86c1.png)


#### 3. What is the scheme like?
```scala
    data2.printSchema()
```

![image](https://user-images.githubusercontent.com/60414250/120407471-11becd00-c302-11eb-95c7-bb0f2771f7e8.png)


#### 4. Print the first 5 columns.
```scala
    data2.show(5)
```

![image](https://user-images.githubusercontent.com/60414250/120407502-200ce900-c302-11eb-83a2-9b5f5ed86f02.png)


#### 5. Use the describe () method to learn more about the data in the DataFrame.
```scala
    data2.describe().show()
```

![image](https://user-images.githubusercontent.com/60414250/120407550-387d0380-c302-11eb-8813-eedcaebdcf1e.png)


#### 6. Make the pertinent transformation for the categorical data which will be our labels to be classified.
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

#### 7. Build the classification model and explain its architecture.
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

#### 8. Printing the results of the model.
```scala
    println(s"Test set accuracy = ${evaluator.evaluate(predictionAndLabels)}")
```

![image](https://user-images.githubusercontent.com/60414250/120407921-dffa3600-c302-11eb-8963-580414a98d9a.png)
