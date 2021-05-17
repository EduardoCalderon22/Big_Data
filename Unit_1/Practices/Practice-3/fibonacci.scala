Fibonacci 

// V1
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

//V2
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

//V3
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

//V4
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

//V5
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