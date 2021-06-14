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
