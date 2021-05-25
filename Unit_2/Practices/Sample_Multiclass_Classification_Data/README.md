## 

### Import Libraries which will be essential for the regression and classification of the data.
```scala
import org.apache.spark.ml.classification.{LogisticRegression, OneVsRest}
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
```
### Load the file which will generate the results.
```scala
val inputData = spark.read.format("libsvm").load("sample_multiclass_classification_data.txt")
```
### Generate the division of the train and test set.
```scala
val Array(train, test) = inputData.randomSplit(Array(0.8, 0.2))
```
### Instantiate the base classifier.
```scala
val classifier = new LogisticRegression().setMaxIter(10).setTol(1E-6).setFitIntercept(true)
```
### An instance of the One Vs Rest classifier is created.
```scala
val ovr = new OneVsRest().setClassifier(classifier)
```
### The multiclass model is trained.
```scala
val ovrModel = ovr.fit(train)
```
### The model is scored on the test data.
```scala
val predictions = ovrModel.transform(test)
```
### The evaluator is obtained.
```scala
val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")
```
### The classification error in the test data is calculated.
```scala
val accuracy = evaluator.evaluate(predictions)
println(s"Test Error = ${1 - accuracy}")
```