## Fibonacci V1
Fibonacci Recursive Version
We define the value of n, we create the function fib1 with a condition, if n is less than 2 it returns the value n, otherwise it returns the function fib1. At the end we print the result of fib1.

``` scala
val n=10 
def fib1(n:Int):Int={
    if(n<2)
    {
        return n
    }
    else 
    {
        return(fib1(n-1)+fib1(n-2))
    }
}
println(fib1(n))
```

## Fibonacci V2
Version with explicit formula
This algorithm uses the explicit formula for the fibonacci series, this formula is not as accurate as when using the conventional methods like cycles or recursion.

``` scala
val n = 10 
var phi=((1+math.sqrt(5))/2) 
var j=((math.pow(phi,n)-math.pow((1-phi),n))/(math.sqrt(5))) 


def fib2(n:Double) : Double ={
if (n<2){
return n
}
else {

    return j
}
}
println(fib2(n))
```
## Fibonacci V3
Iterative version
We create a function that will receive and return an INT, we define 3 variables a = 0, b = 1 and c = 0. We did a for loop, the loop will do 3 things: first it will add (b + a) to variable c, then it will give you the value of ba to the variable ay will finally assign the value of c to the variable b. In the end it will return the result.

``` scala
def fib3(num:Int):Int={
    var a = 0
    var b = 1
    var c = 0
    for(k <- Range(0,num)){
        c = b + a 
        a = b 
        b = c 
    }
    return a
}
fib3(5)
fib3(10)
fib3(15)
```

## Fibonacci V4
Iterative version 2 variables
We create a function that will receive and return an Int, we define the variables n, a and b. We create a for loop, the loop will do 2 things: first it will add (b + a) to variable b and then subtract (b - a) and that will be assigned to variable a. Finally it will return the result.

``` scala
def fib4(n:Int):Int={ 
var n : Int = 6 
var a = 0 
var b = 1 

for (k <- 1 to n){
    b = b + a 
    a = b - a 
}
return a 
}
println(fib4(n))
```

## Fibonacci V5
Iterative version vector
We create a function that will receive and return an INT, then we did an if, if the number is less than 2, it will return the exact same number. If not, we declare a vector that will take integers, in position 0 we assign a zero, and in position 1 we assign the number one, then we create a for loop that will iterate from 0 to the number that we give to the algorithm. The cycle will be assigned to the vector in the current position (k), the vector will be assigned to the position k, the resulting sum from the last and penultimate position will finally return the calculated result.

``` scala
def fib5(num:Int):Int={
	if(num<2){
    	return num
	}else{
    	var vector = new Array[Int](num+1)
    	vector(0) = 0
    	vector(1) = 1
    	for (k <- Range(2,num+1)){
        	vector(k)=vector(k-1)+vector(k-2)
    	}
    	return vector(num)
	}
}

fib5(5)
fib5(10)
fib5(15)

```