//1 Comenzamos una simple sesion de spark
import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate() 

//2 Cargamos el archivo csv 
val df = spark.read.option("header", "true").option("inferSchema","true")csv("/home/eduardo/Escritorio/U1/Netflix_2011_2016.csv") 

//3 Mostramos el nombre de las columnas
df.columns 

//4 Se muestra como es el esquema
df.printSchema()

//5 Mostramos las 5 primeras columnas
df.show(5)  

//6 Utilizamos la funcion describe()
df.describe().show()

//7 Creamos un nuevo dataframe y una columna con el nombre "HV Ratio" 
val dfhv = df.withColumn("HV Ratio", df("High")+df("Volume")) 
dfhv.show()

//8 Mostrar el dia que tuvo el pico mas alto en la columna “Close”
df.orderBy($"Close".desc).show(1)
