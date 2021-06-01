# Decision Tree Classifier


In the following instructions we will return to some important imports for the realization of the problem and the perception of the data.
This data was retrieved from the repository: https://github.com/jcromerohdz/iris
We will use the Liberia Mlib that can help us in multilayer perception.
For the first step, you have to clean the data through this script.

```scala
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.feature. {VectorAssembler, StringIndexer}
import org.apache.spark.ml.linalg.Vectors
```

### Loading data from iris data file.
```scala
val data = spark.read.option ("header", "true").option("inferSchema", "true").format ("csv").load("C:/Repositorios/Big_Data/Unit_2/Evaluation/iris.csv")
```

### Convertimos los datos de la columna "species" a valores numericos.
```scala
val label = new StringIndexer().setInputCol("species").setOutputCol("label")
val labeltransform = label.fit(data).transform(data)
```

### Convertimos los datos de todas las columnas a un arreglo llamadao "Features" y despues la pasamos a otro arreglo llamado data 2.
```scala
val Features = (new VectorAssembler(). setInputCols (Array ("sepal_length", "sepal_width", "petal_length", "petal_width")).setOutputCol("features"))
val data2 = Features.transform(labeltransform)
```

### a. Utilice la librería Mllib de Spark el algoritmo de Machine Learning correspondiente a multilayer perceptron.
```scala
    import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
    import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
```

### 2. ¿Cuáles son los nombres de las columnas?
```scala
    data2.columns
```

### 3. ¿Cómo es el esquema?
```scala
    data2.printSchema()
```

### 4. Imprime las primeras 5 columnas.
```scala
    data2.show(5)
 ```

### 5. Usa el metodo describe () para aprender mas sobre los datos del DataFrame.
```scala
    data2.describe().show()
```

### 6. Haga la transformación pertinente para los datos categoricos los cuales serán nuestras etiquetas a clasificar.
```scala

// Cubre el algoritmo en trabajar con caractisticas, dividido en grupos de datos.
    val data3 = data2.select("features", "label")
    data3.show()

    val splits = data3.randomSplit(Array(0.7, 0.3), seed = 1234L)
    val train = splits(0)
    val test = splits(1)
```

### 7. Construya el modelo de clasificación y explique su arquitectura.
```scala
    val layers = Array[Int](4, 5, 4, 3)
    val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setBlockSize(128).setSeed(1234L).setMaxIter(100)
    val modelML = trainer.fit(train)
    val result = modelML.transform(test)
    val predictionAndLabels = result.select("prediction", "label")
    val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")
    predictionAndLabels.show (50)
    result.show (30)
```

### 8. Imprima los resultados del modelo.
```scala
    println(s"Test set accuracy = ${evaluator.evaluate(predictionAndLabels)}")
```