
// In the following instructions we will return to some important imports for the realization of the problem and the perception of the data.

// This data was retrieved from the repository: https://github.com/jcromerohdz/iris
//We will use the Liberia Mlib that can help us in multilayer perception.
// For the first step, you have to clean the data through this script.

import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.feature. {VectorAssembler, StringIndexer}
import org.apache.spark.ml.linalg.Vectors

// Loading data from iris data file.
val data = spark.read.option ("header", "true"). option ("inferSchema", "true"). format ("csv"). load ("/home/eduardo/Escritorio/Datos/Big_Data/Unit_2/Evaluation/iris.csv")

// Convertimos los datos de la columna "species" a valores numericos
val label = new StringIndexer().setInputCol("species").setOutputCol("label")
val labeltransform = label.fit(data).transform(data)

// Convertimos los datos de todas las columnas a un arreglo llamadao "Features" y despues la pasamos a otro arreglo llamado data 2
val Features = (new VectorAssembler (). setInputCols (Array ("sepal_length", "sepal_width", "petal_length", "petal_width")). setOutputCol ("features"))
val data2 = Features.transform (labeltransform)

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

