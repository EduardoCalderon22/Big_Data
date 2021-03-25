We create the listEvens function, we will start a For loop that will check if the elements of a list are even or not. When finished with all the elements of the list it will show a message with the word "Done"
```scala
def listEvens(list:List[Int]): String ={
    for(n <- list){
        if(n%2==0){
            println(s"$n is even")
        }else{
            println(s"$n is odd")
        }
    }
    return "Done"
}
```
We define the 2 lists of elements that we will use in the function.
```scala
val l = List(1,2,3,4,5,6,7,8)
val l2 = List(4,3,22,55,7,8)
```
We execute the listEvens function with the 2 lists that we made
```scala
listEvens(l)
listEvens(l2)
```
Start the afortunado function, create a variable for get the result final. If the element in the current index is different than 7, it will add the number to the variable 'res', but it is equal to 7, it will sum 14 to the variable 'res', at the end of the cycle, it will print the final result of 'res'. 
```scala
//3 7 afortunado
def afortunado(list:List[Int]): Int={
    var res=0
    for(n <- list){
        if(n==7){
            res = res + 14
        }else{
            res = res + n
        }
    }
    return res
}
```
Create of the list 'af' and the usage of the afortunado function
```scala
val af= List(1,7,7)
println(afortunado(af))
```
We create the "balance" function , we start 2 variables with the value of 0. The function returns a true if "primera" and "segunda" are the same, after checks the list through each index and adds the number in the current index to "primera", while "segunda" subtracts the number in the index from itself.
```scala
def balance(list:List[Int]): Boolean={
    var primera = 0
    var segunda = 0

    segunda = list.sum

    for(i <- Range(0,list.length)){
        primera = primera + list(i)
        segunda = segunda - list(i)

        if(primera == segunda){
            return true
        }
    }
    return false 
}
```
Create the lists to use the "balance" function 
```scala
val bl = List(3,2,1)
val bl2 = List(2,3,3,2)
val bl3 = List(10,30,90)
```
Check the function
```scala
balance(bl)
balance(bl2)
balance(bl3)
```
This function check if a string is a palindrome.
```scala
def palindromo(palabra:String):Boolean ={
    return (palabra == palabra.reverse)
}
```
Create the values for palabra 1, 2 y 3, we check if the function "palindromo"
is working.
```scala
val palabra = "OSO"
val palabra2 = "ANNA"
val palabra3 = "JUAN"

println(palindromo(palabra))
println(palindromo(palabra2))
println(palindromo(palabra3))
```