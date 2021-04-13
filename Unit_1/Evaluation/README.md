# Evaluation Unit 1

### 1. Start a simple Spark session.
The libraries for the dataframes are imported. We declare the variable 'spark' to assign the packages.
```scala
import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate() 
```

### 2. Upload Netflix Stock CSV file, have Spark infer data types
The variable df is created to save the data from the csv file.
```scala
val df = spark.read.option("header", "true").option("inferSchema","true")csv("/home/eduardo/Escritorio/U1/Netflix_2011_2016.csv") 
```

### 3. What are the column names?
The 'Columns' function will show us the name of the columns of the dataframe.
```scala
df.columns 
```

### 4. How is the scheme?
The 'printSchema' function works to see the types of data that each column has and also if it allows accepting null values ​​or not.
```scala
df.printSchema()
/*
 |-- Date: timestamp (nullable = true)
 |-- Open: double (nullable = true)
 |-- High: double (nullable = true)
 |-- Low: double (nullable = true)
 |-- Close: double (nullable = true)
 |-- Volume: integer (nullable = true)
 |-- Adj Close: double (nullable = true)
 */
```

### 5. Print the first 5 columns.
Only show top 5 rows
```scala
df.show(5)  
```

### 6. Use describe () to learn about the Data Frame.
The Describe function, we show the Data Frame and also some data such as the count, mean, min, max and the standard deviation.
```scala
df.describe().show()
```

### 7. Create a new dataframe with a new column called “HV Ratio” which is the relationship between the price in the “High” column versus the “Volume” column of shares traded for a day. (Hint: It is a column operation). 
We create a new dataframe and a new column called 'HV Ratio'. For this column we use the columns 'High' vs 'Volume'.
```scala
val dfhv = df.withColumn("HV Ratio", df("High")+df("Volume")) 
dfhv.show()
```

### 8.- What day had the highest peak in the “Close” column?
With Order By, we select Close and order it in descending order and we will show the first column
```scala
df.orderBy($"Close".desc).show(1)
```

