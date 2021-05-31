
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

// 6. Haga la transformación pertinente para los datos categoricos los cuales serán nuestras etiquetas a clasificar.

// Cubre el algortmo en trabajar con caractisticas, dividido en grupos de datos.
val vectorFeatures = (new VectorAssembler (). setInputCols (Array ("sepal_length", "sepal_width", "petal_length", "petal_width")). setOutputCol ("features"))
//Transformar utilizando solo el dataframe.
val features = vectorFeatures.transform (dataClean)
// Convertir una columna como la columna indice(muy similar a la columna del factor X)
val speciesIndexer = new StringIndexer (). setInputCol ("species"). setOutputCol ("label")
// Se adjunta el indice con las caracteristicas del vector.
val dataIndexed = speciesIndexer.fit (features) .transform (features)

// 7. Construya el modelo de clasificación y explique su arquitectura.
// Splits aqui se utlizo para separar y para optener valores como archivos csv delimitados por tuberias.
val splits = dataIndexed.randomSplit (Array (0.6, 0.4), seed = 1234L)
//Declarar el 60% de la informacion con la variable train.
val train = splits (0)
// Aqui se declara la otra infomacion de 40%.
val test = splits (1)

// 8. Imprima los resultados del modelo