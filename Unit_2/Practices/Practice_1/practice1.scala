//////////////////////////////////////////////
//// LINEAR REGRESSION EXERCISE ///////////
/// Complete las tareas comentadas ///
///////////////////////////////////////////

// Import LinearRegression
import org.apache.spark.ml.regression.LinearRegression

// Optional: Use the following code to configure errors
//for this, to have as a result a scalability of the correct data
import org.apache.log4j._
Logger.getLogger ("org"). SetLevel (Level.ERROR)

// Start a simple Spark Session
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()

// Use Spark for the Clean-Ecommerce csv file.
val data  = spark.read.option("header","true").option("inferSchema", "true").format("csv").load("Clean-Ecommerce.csv")

// Print the schema in the DataFrame.
data.printSchema()
root
 |-- Email: string (nullable = true)
 |-- Avatar: string (nullable = true)
 |-- Avg Session Length: double (nullable = true)
 |-- Time on App: double (nullable = true)
 |-- Time on Website: double (nullable = true)
 |-- Length of Membership: double (nullable = true)
 |-- Yearly Amount Spent: double (nullable = true)

// Print an example row from the DataFrane.
data.show(1)
+--------------------+------+------------------+-----------------+-----------------+--------------------+-------------------+
|               Email|Avatar|Avg Session Length|      Time on App|  Time on Website|Length of Membership|Yearly Amount Spent|
+--------------------+------+------------------+-----------------+-----------------+--------------------+-------------------+
|mstephenson@ferna...|Violet| 34.49726772511229|12.65565114916675|39.57766801952616|  4.0826206329529615|  587.9510539684005|
+--------------------+------+------------------+-----------------+-----------------+--------------------+-------------------+
only showing top 1 row

////////////////////////////////////////////////////// ////
//// Configure the DataFrame for Machine Learning ////
////////////////////////////////////////////////////// ////

// Transform the data frame to take the form of
// ("label", "features")
val colnames = data.columns
val firstrow = data.head(1)(0)
println("\n")
println("Example data row")
for(ind <- Range(1, colnames.length)){
    println(colnames(ind))
    println(firstrow(ind))
    println("\n")
}

//Transform the data frame so that it takes the form of ("label", "features")
Import VectorAssembler and Vectors:

// Import VectorAssembler and Vectors
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors

// Rename the column Yearly Amount Spent as "label"
data.select(data("Yearly Amount Spent").as("label")).show

// Also from the data take only the numerical column
data.select(data("Yearly Amount Spent").as("label"), $"Avg Session Length", $"Time on App",$"Time on Website", $"Length of Membership").show

// Leave all this as a new DataFrame called df
val df = data.select(data("Yearly Amount Spent").as("label"), $"Avg Session Length", $"Time on App",$"Time on Website", $"Length of Membership")

// Let the assembler object convert the input values ??????to a vector to characterize the data by periods
val assembler = (Vector("label","Avg Session Length","Time on App","Time on Website","Length of Membership"))

// Use the VectorAssembler object to convert the input columns of the df
// to a single output column of an array named "features"
// Set the input columns from where we are supposed to read the values.
// Call this new assambler.
val assembler = new VectorAssembler().setInputCols(Array("Avg Session Length","Time on App","Time on Website","Length of Membership")).setOutputCol("features")

// Use the assembler to transform our DataFrame to two columns: label and features
val output= assembler.transform(df).select($"label", $"features")

// Create an object for a linear regression model.
val lr = new LinearRegression()

// Fit the model for the data and call this model lrModel
val lrModel = lr.fit(output)

// Print the coefficients and intercept for the linear regression
println(s"Coefficients: ${lrModel.coefficients} Intercept: ${lrModel.intercept}")

// Summarize the model on the training set print the output of some metrics!
println(lrModel)

// Use our model's .summary method to create an object
// called trainingSummary
val trainingSummary = lrModel.summary

// Show the values ??????of residuals, the RMSE, the MSE, and also the R^2.
trainingSummary.residuals.show()
trainingSummary.predictions.show()
trainingSummary.r2 
trainingSummary.rootMeanSquaredError


