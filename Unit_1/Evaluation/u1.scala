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

//9 el significado de la columna Cerrar “Close”
print("Representa todo y cada uno de los precios con el que cerro en el valor por accion de Netflix de ese mismo dia, en el cual la funcion anterior muestra el ejemplo mas alto de los datos en que se cerro.")

//10. Aqui determinaremos con un select el máximo y mínimo de la columna del Volumen
df.select(max("Volume")).show()
df.select(min("Volume")).show()

//11. Con Sintaxis Scala/Spark.
    //Hint: Basicamente muy parecido a la session de dates, tendran que crear otro
         //dataframe para contestar algunos de los incisos.

//a. ¿Cuántos días fue la columna “Close” inferior a $ 600?
df.filter($"Close" < 600).count()

//b. ¿Qué porcentaje del tiempo fue la columna “High” mayor que $ 500?
print((df.filter($"High">500).count()*100)/1250,"%")

//c. ¿Cuál es la correlación de Pearson entre columna “High” y la columna “Volumen”?
df.select(corr("High", "Volume")).show()

//d. ¿Cuál es el máximo de la columna “High” por año?
val df2=df.withColumn("Year",year(df("Date")))
val dfmax=df2.groupBy("Year").max()
dfmax.select($"Year",$"max(High)").show()
dfmax.select($"Year",$"max(High)").show()

//e. ¿Cuál es el promedio de columna “Close” para cada mes del calendario?
val dfmonth=df.withColumn("Month",month(df("Date")))
val dfmean=dfmonth.select($"Month",$"Close").groupBy("Month").mean()
dfmean.orderBy($"Month".desc).show()
dfmean.orderBy($"Month").show()