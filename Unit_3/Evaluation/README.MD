# Unit 3 K-Means

This practice is to try to group clients from specific regions from a wholesale distributor. This based on the sales of some product categories. The big data information source was taken up in the following link, giving credit to the teacher Jose Christian Romero
https://github.com/jcromerohdz/BigData/blob/master/Spark_clustering/Wholesale%20customers%20data.csv

Embed the necessary libraries for data grouping in the data analysis section
```scala
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.clustering.KMeans
import org.apache.spark.ml.feature.{VectorAssembler,StringIndexer,VectorIndexer,OneHotEncoder}
import org.apache.spark.ml.linalg.Vectors
```
Library line that solves and minimizes errors in the grouping lines
```scala
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)
```
Create an instance of the Spark session
```scala
val spark = SparkSession.builder().getOrCreate()
```
Import the Kmeans library for the clustering algorithm
```scala
import org.apache.spark.ml.clustering.KMeans
```
Load the Wholesale Customers Data dataset
```scala
val dataset = spark.read.option("header","true").option("inferSchema","true").csv("Wholesale customers data.csv")
```
Select the following columns: Fresh, Milk, Grocery, Frozen, Detergents_Paper, Delicassen and call this set feature_data
```scala
val feature_data = dataset.select($"Fresh", $"Milk", $"Grocery", $"Frozen", $"Detergents_Paper", $"Delicassen")
```
Import Vector Assembler and Vector
```scala
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors
```
Create a new Vector Assembler object for the feature columns as an input set, remembering that there are no labels
```scala
val assembler = new VectorAssembler().setInputCols(Array("Fresh", "Milk", "Grocery", "Frozen", "Detergents_Paper", "Delicassen")).setOutputCol("features")
```

