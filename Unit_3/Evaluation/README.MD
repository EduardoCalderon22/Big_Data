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
Use the assembler object to transform feature data
```scala
val traning = assembler.transform(feature_data)
```
Create a K Means model with K = 3
```scala
val kmeans = new KMeans().setK(3).setSeed(1L)
val model = kmeans.fit(traning)
```
Evaluate the groups using Within Set Sum of Squared Errors WSSSE and print the centroids.
```scala
val WSSSE = model.computeCost(traning)
println(s"Within Set Sum of Squared Errors = $WSSSE")
```
Clustering Center Results Printing
```scala
println("Cluster Centers: ")
model.clusterCenters.foreach(println)
```

### Conclution

The center of the group is the average of all the points (elements) that belong to that group.
  K-means could be used in many unsupervised classification problems that groups objects into k groups based on their characteristics. Grouping is done by minimizing the sum of distances between each object and the centroid of its group or cluster. A data optimization analysis problem about customers with quantity of wholesale products in categories has been solved.
