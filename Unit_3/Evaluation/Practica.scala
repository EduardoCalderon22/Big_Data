//Esta practica es tratar de agrupar los clientes de regiones específicas
// de un distribuidor al mayoreo. Esto en base a las ventas de algunas categorías de productos.
//La fuente de infomacion de bigdata fue retomado en el enlace siguiente, dandole credito al docente Jose Christian Romero

// https://github.com/jcromerohdz/BigData/blob/master/Spark_clustering/Wholesale%20customers%20data.csv

// Imporar las liberias necesarias para el agrupamiento de los datos en la seccion de analis de datos.
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.clustering.KMeans
import org.apache.spark.ml.feature.{VectorAssembler,StringIndexer,VectorIndexer,OneHotEncoder}
import org.apache.spark.ml.linalg.Vectors

//Linea de liberia que soluciona y hace la minimizacion errores en las lineas de agrupacion.
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

//Cree una instancia de la sesión Spark
val spark = SparkSession.builder().getOrCreate()

//Importar la librería de Kmeans para el algoritmo de agrupamiento
import org.apache.spark.ml.clustering.KMeans

//Carga el dataset de Wholesale Customers Data
val dataset = spark.read.option("header","true").option("inferSchema","true").csv("Wholesale customers data.csv")

//Seleccione las siguientes columnas: Fresh, Milk, Grocery, Frozen, Detergents_Paper, Delicassen y llamar a este conjunto feature_data
val feature_data = dataset.select($"Fresh", $"Milk", $"Grocery", $"Frozen", $"Detergents_Paper", $"Delicassen")

//Importar Vector Assembler y Vector
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors

//Crea un nuevo objeto Vector Assembler para las columnas de caracteristicas como un conjunto de entrada, recordando que no hay etiquetas
val assembler = new VectorAssembler().setInputCols(Array("Fresh", "Milk", "Grocery", "Frozen", "Detergents_Paper", "Delicassen")).setOutputCol("features")


