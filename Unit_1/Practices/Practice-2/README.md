# Practice 2

### &nbsp;&nbsp;Practice 2.

#### &nbsp;&nbsp;&nbsp;&nbsp; Instructions.

    1.-Create a list called "list" with the elements "red", "white", "black".
    2.-Add 5 more items to "list" "green", "yellow", "blue", "orange", "pearl".
    3.-Bring the "list" "green", "yellow", "blue" items.
    4.-Create a number array in the 1-1000 range in 5-in-5 steps
    5.-What are the unique elements of the List list (1,3,3,4,6,7,3,7) use conversion to sets.
    6.-Create a mutable map called names containing the following"Jose", 20, "Luis", 24, "Ana", 23, "Susana", "27".
    6.-a. Print all map keys.
    7.-b. Add the following value to the map ("Miguel", 23).



#### In this practice, we created array, list and map.
     
</br>

#### &nbsp;&nbsp;&nbsp;&nbsp; Code.

```scala  
/*1.-Create a list called "list" with the elements "red", "white", "black"*/
         var lista = collection.mutable.MutableList("red","white","black") 

``` 
```scala
         /*2.-Add 5 more items to "list" "green", "yellow", "blue", "orange", "pearl"*/
          lista += ("green","yellow", "blue", "orange", "pearl")

``` 

 ```scala
         /*3.-Bring the "list" "green", "yellow", "blue" items*/
             lista(3)
             lista(4)
             lista(5)
``` 

            
 ```scala
         /*4.-Create a number array in the 1-1000 range in 5-in-5 steps*/
               var v = Range(1,1000,5)
```                

 ```scala
         /*5.-What are the unique elements of the List list (1,3,3,4,6,7,3,7) use conversion to sets*/
              var l = List(1,3,3,4,6,7,3,7)
               l.toSet
```                

 ```scala
         /*6.-Create a mutable map called names containing the following"Jose", 20, "Luis", 24, "Ana", 23, "Susana", "27*/
          var map=collection.mutable.Map(("Jose", 20),("Luis", 24),("Ana", 23),("Susana", "27"))
```           

```scala
         /*6.-a. Print all map keys*/
           map.keys
```            

```scala
         /*7.-b. Add the following value to the map ("Miguel", 23)*/
          map += ("Miguel"->23)
```           