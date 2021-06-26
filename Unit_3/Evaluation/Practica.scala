//Esta practica es tratar de agrupar los clientes de regiones específicas
// de un distribuidor al mayoreo. Esto en base a las ventas de algunas categorías de productos.
//La fuente de infomacion de bigdata fue retomado en el enlace siguiente, dandole credito al docente Jose Christian Romero

// https://github.com/jcromerohdz/BigData/blob/master/Spark_clustering/Wholesale%20customers%20data.csv

// Imporar las liberias necesarias para el agrupamiento de los datos en la seccion de analis de datos.
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.clustering.KMeans
import org.apache.spark.ml.feature.{VectorAssembler,StringIndexer,VectorIndexer,OneHotEncoder}
import org.apache.spark.ml.linalg.Vectors

//Linea de libreria que soluciona y hace la minimizacion errores en las lineas de agrupacion.
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

//Utilice el objeto assembler para transformar feature_data
val traning = assembler.transform(feature_data)

//Crear un modelo Kmeans con K=3
val kmeans = new KMeans().setK(3).setSeed(1L)
val model = kmeans.fit(traning)

//Evalúe los grupos utilizando Within Set Sum of Squared Errors WSSSE e imprima los centroides.
val WSSSE = model.computeCost(traning)
println(s"Within Set Sum of Squared Errors = $WSSSE")

//Imprecion de los resultados de Clusering Centers
println("Cluster Centers: ")
model.clusterCenters.foreach(println)

//Conclusion

// El centro del grupo es el promedio de todos los puntos (elementos) que pertenecen a ese grupo.
// K-means podría usarse en muchos problemas,de clasificación no supervisada que agrupa objetos 
// en k grupos basándose en sus características. El agrupamiento se realiza minimizando la suma de distancias entre cada objeto y el centroide de su grupo o cluster.
// se soluciono un problema de análisis de optimización de datos acerca de los clientes con cantidad de productos mayorista en categorías.