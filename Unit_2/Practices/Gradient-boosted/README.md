# Gradient Boosted Tree Classifier

We import the libraries we occupy
```scala
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.{GBTClassificationModel, GBTClassifier}
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer}
```
We load the txt file of the established path
```scala
val data = spark.read.format("libsvm").load("sample_libsvm_data.txt")
```
We will create a column using stringIndexer so that the data has its categorization
```scala
val labelIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(data)
```
We create a vector that will have a maximum of 4 categories
```scala
val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4).fit(data)
```
We separate the data into two parts, one called training with 70% and the other test set with 30%
```scala
val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3))
```
The GPT model is trained
```scala
val gbt = new GBTClassifier().setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures").setMaxIter(10).setFeatureSubsetStrategy("auto")
```
We convert the indexed tags to original tags
```scala
val labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(labelIndexer.labels)
```
We adjust Pipeline and the indexes
```scala
val pipeline = new Pipeline().setStages(Array(labelIndexer, featureIndexer, gbt, labelConverter))
```
The model is trained and the indexers are executed
```scala
val model = pipeline.fit(trainingData)
```
We create the predictions.
```scala
val predictions = model.transform(testData)
```
We select the first 5 rows to display them
```scala
predictions.select("predictedLabel", "label", "features").show(5)
```
We select prediction and calculation of the test error.
```scala
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")
val accuracy = evaluator.evaluate(predictions)
println(s"Test Error = ${1.0 - accuracy}")
```
Finally show learned of the GBT model 
```scala
val gbtModel = model.stages(2).asInstanceOf[GBTClassificationModel]
println(s"Learned classification GBT model:\n ${gbtModel.toDebugString}")
```



