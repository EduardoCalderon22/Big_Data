# Random Forest Classifier

We import the necessary libraries for this example
```scala
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.{RandomForestClassificationModel, RandomForestClassifier}
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer}
import org.apache.spark.sql.SparkSession
```
We started a spark session
```scala
val spark = SparkSession.builder().getOrCreate()
```
Load data and convert to DataFrame
```scala
val data = spark.read.format("libsvm").load("data/mllib/sample_libsvm_data.txt")
```
We create two objects in which we enter the name of the input values and the name of the output.
```scala
val labelIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(data)
val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4).fit(data)
```
We split the data into training and test sets (70% training and 30% for tests)
```scala
val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3))
```
We create the rf variable, load the data and the values of the columns for the Random Forest model
```scala
val rf = new RandomForestClassifier().setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures").setNumTrees(10)
```
Convert indexed labels back to original labels.
```scala
val labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(labelIndexer.setLabels)
```
We adjust the  Pipeline with chain indexers and forest.
```scala
val pipeline = new Pipeline().setStages(Array(labelIndexer, featureIndexer, rf, labelConverter))
val model = pipeline.fit(trainingData)
```
We create the variable where will do the predictions and show test rows
```scala
val predictions = model.transform(testData)
predictions.select("predictedLabel", "label", "features").show(5)
```
We create an object where the evaluation will be carried out, we create the accuracy variable where the evaluation and the prediction will be carried out. 
```scala
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")
val accuracy = evaluator.evaluate(predictions)
println(s"Test Error = ${(1.0 - accuracy)}")
```
Finally we print Random Forest Model
```scala
val rfModel = model.stages(2).asInstanceOf[RandomForestClassificationModel]
println(s"Learned classification forest model:\n ${rfModel.toDebugString}")
```

