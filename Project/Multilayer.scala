// PRACTICE MULTILAYER PERCEPTRON IN SCALA WITH DATAFRAME BANK-FULL

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