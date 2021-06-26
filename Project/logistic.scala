// We import the necessary libraries to make our Logistic Regression 
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.feature.StringIndexer
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.log4j._

// We create our spark variable to start a normal session
val spark = SparkSession.builder().getOrCreate()

// Load the data as a DataFrame.
val data  = spark.read.option("header","true").option("inferSchema","true").option("delimiter", ";").format("csv").load("bank-full.csv")

// We use the StringIndexer function to transform this data into numeric. With Labeltransform we make an adjustment and transform data.
val label = new StringIndexer().setInputCol("y").setOutputCol("label")
val labeltransform = label.fit(data).transform(data)

// VectorAssembler is used to join several columns.
val assembler = new VectorAssembler().setInputCols (Array ("balance", "day", "duration", "pdays", "previous")).setOutputCol("features")
val data2 = assembler.transform(labeltransform)

// We create a training variable that contains features and label.
val training = data2.select("features", "label")

// We create a split to divide 70% of the data in train and 30% in test.
val splits = training.randomSplit(Array(0.7, 0.3), seed = 12345)
val train = splits(0)
val test = splits(1)

// We print training set and test set.
println("training set = ", train.count())
println("test set = ", test.count())

// We create our variable for logistic regression. We also make the variables model and result.
val lr = new  LogisticRegression().setMaxIter(10).setRegParam(0.1)
val model = lr.fit(train)
val result = model.transform(test)
val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")

// We print result
println(s"Coefficients: ${model.coefficients}")
println(s"Intecept: ${model.intercept}")
println(s"Accuraccy = ${evaluator.evaluate(result)}")
