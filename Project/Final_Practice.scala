// PRACTICE SVM IN SCALA WITH DATAFRAME BANK-FULL


// We load the VectorAssembler Library.
import org.apache.spark.ml.feature.VectorAssembler

// We clean the dataset csv "bank-full".
// We load the data.
val datosBank = spark.read.option("header","true").option("inferSchema","true").format("csv").load("C:/Repositorios/Big_Data/Project/bank-full.csv")
datosBank.show() 

val datosBank = spark.read.option("header","true").option("inferSchema","true").option("delimiter",";").format("csv").load("C:/Repositorios/Big_Data/Project/bank-full.csv")
datosBank.show() 

datosBank.printSchema()
// We make a change to the column and for a yes.
val cambio1 = datosBank.withColumn("y",when(col("y").equalTo("yes"),1).otherwise(col("y")))
// Now with a no with the same structured.
val cambio2 = cambio1.withColumn("y",when(col("y").equalTo("no"),2).otherwise(col("y")))
//Now the column still works as a string int
val nuevacolum = cambio2.withColumn("y",'y.cast("Int"))
nuevacolum.show(1) 

// We make an array of the features with VectorAssembler to generate the transformation to the data.
val assembler = (new VectorAssembler().setInputCols(Array("balance","day","duration","pdays","previous")).setOutputCol("features"))
val Ldata = assembler.transform(nuevacolum)
Ldata.show(1) 

// We replace the name of the columns "y" and "label" by "label" and "feactures"
val cambio = Ldata.withColumnRenamed("y", "label")
val feat = cambio.select("label","features") 
// The result of a clean dataframe
feat.show() 

// We load the LinearSVM Library
import org.apache.spark.ml.classification.LinearSVC

val c1 = feat.withColumn("label",when(col("label").equalTo("1"),0).otherwise(col("label")))
val c2 = c1.withColumn("label",when(col("label").equalTo("2"),1).otherwise(col("label")))
val c3 = c2.withColumn("label",'label.cast("Int"))

val lsvc = new LinearSVC().setMaxIter(10).setRegParam(0.1)

// We train the model
val lsvcModel = lsvc.fit(c3)  

// We print the coefficients and intercepts for linear svc with the demonstration of the clean and classified structure in this model.
println(s"Coefficients: ${lsvcModel.coefficients} Intercept: ${lsvcModel.intercept}")

// ----------------------------------------------------------------- //

// PRACTICE MULTIPLAYER PERCEPTRON IN SCALA WITH DATAFRAME BANK-FULL

//Now we will carry out the procedure of the Multilayer perceptron structure in scala, with trained data of 70% and test of 30%

// Libraries to use
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator

// Training data: 70 and test: 30
// With this to see the split test
val splits = feat.randomSplit(Array(0.7, 0.3), seed = 1234L)
val train = splits(0)
val test = splits(1)

// The neural network to be used is specified.
val capasN = Array[Int](5, 6, 3, 4)

// The creation of the trainer is done and the parameters are given
// The classifier model is being used
val entrenador = new MultilayerPerceptronClassifier().setLayers(capasN).setBlockSize(128).setSeed(1234L).setMaxIter(100)

// The model is put together and trained.
val model = entrenador.fit(train)

// The variable of the test results is created.
val resultados = model.transform(test)
resultados.show()

// Prediciendo la exactitud con un evaluador
val predictionAndLabels = resultados.select("prediction", "label")
val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")

// The proof of the model is printed with in its accuracy
println(s"Test set accuracy = ${evaluator.evaluate(predictionAndLabels)}")