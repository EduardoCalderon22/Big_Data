// En las siguientes instrucciones volveremos a algunas importaciones importantes para la realización del problema y la percepción de los datos.

// Estos datos se recuperaron del repositorio: https://github.com/jcromerohdz/iris
// Usaremos Liberia Mlib que puede ayudarnos en la percepción multicapa.
// Para el primer paso, debe limpiar los datos a través de este script.

import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.feature. {VectorAssembler, StringIndexer}
import org.apache.spark.ml.linalg.Vectors

// Cargamos los datos del iris del .csv para ser evaluados.
val data = spark.read.option ("header", "true").option("inferSchema", "true").format ("csv").load("C:/Repositorios/Big_Data/Unit_2/Evaluation/iris.csv")

// Convertimos los datos de la columna "species" a valores numericos
val label = new StringIndexer().setInputCol("species").setOutputCol("label")
val labeltransform = label.fit(data).transform(data)

// Convertimos los datos de todas las columnas a un arreglo llamadao "Features" y despues la pasamos a otro arreglo llamado data 2.
val Features = (new VectorAssembler(). setInputCols (Array ("sepal_length", "sepal_width", "petal_length", "petal_width")).setOutputCol("features"))
val data2 = Features.transform(labeltransform)

// a. Utilice la librería Mllib de Spark el algoritmo de Machine Learning correspondiente a multilayer perceptron
    import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
    import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator

// 2. ¿Cuáles son los nombres de las columnas?
    data2.columns

// 3. ¿Cómo es el esquema?
    data2.printSchema()

// 4. Imprime las primeras 5 columnas.
    data2.show(5)
    
// 5. Usa el metodo describe () para aprender mas sobre los datos del DataFrame.
    data2.describe().show()

// 6. Haga la transformación pertinente para los datos categoricos los cuales serán nuestras etiquetas a clasificar.

// Cubre el algoritmo en trabajar con caractisticas, dividido en grupos de datos.
    val data3 = data2.select("features", "label")
    data3.show()
// Se separaremos los datos de entrenamientos y los datoss de testing usando los datos indexados dentro de la siguente linea.
    val splits = data3.randomSplit(Array(0.7, 0.3), seed = 1234L)
    val train = splits(0)
    val test = splits(1)

// 7. Construya el modelo de clasificación y explique su arquitectura.
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
//Mostramos los datos del resultado generado. 
    result.show (30)

// 8. Resultado de impricion de los resultados del modelo.
    println(s"Test set accuracy = ${evaluator.evaluate(predictionAndLabels)}")
