## &nbsp;&nbsp;Practice 1.

#### &nbsp;&nbsp;&nbsp;&nbsp; Instructions.
   
        1.-Develop an algorithm in scala that calculates the radius of a circle
        2.-Develop an algorithm in scala that tells me if a number is a cousin
        3.-Given the variable bird = "tweet", use string interpolation to print "I am writing a tweet"
        4.-Given the variable message = "Hi Luke, I'm your father!" use slilce to extract the  sequence "Luke"
        5.-What is the difference in value and a variable in scala?
        6.-Given the tuple ((2,4,5), (1,2,3), (3,1416,23))) the number 3,1416 returns
             
</br>

#### &nbsp;&nbsp;&nbsp;&nbsp; Code.
We assign the area of ​​the circle, then we create the variable r that will be in charge of obtaining the radius of the circle.
```scala   
      /*1.Develop an algorithm in scala that calculates the radius of a circle*/
      
            var a=3
            var r=math.sqrt(a/math.Pi)        
```   
We declare the number that we will review and the counter, taking into account that a number is prime if it can only be divided between itself and 1 and that the remainder is 0, a loop is started that if certain conditions are met and it will tell us if the number is prime or not.     
```scala     
      /*2. Develop an algorithm in scala that tells me if a number is a cousin*/
        val number = 3
        var cont = 0
        for (i <- Range (1, number + 1)) {
              if (num% i == 0) {
                    cont + = 1
                  }
            }
            if (cont! = 2) {
            println ("Non-prime number")
            } else {
                  println ("The number is prime")
            }
``` 
We assign the word "tweet" to the variable bird and then we interpolate that variable to the final text.
```scala  
      /*3. Given the variable bird = "tweet", use string interpolation to print "I am writing a tweet"n*/
        var bird="tweet"
        printf(s"Estoy ecribiendo un %s",bird)
``` 
We assign the text "Hello Luke, I am your father!" to the message variable and then we use the slice function to get the word luke.
```scala   
        /*4. Given the variable message = "Hi Luke, I'm your father!" use slilce to extract the  sequence "Luke"*/
        var mensaje = "Hola Luke yo soy tu padre!"
        mensaje.slice(5,9)
``` 
Val vs Var
```scala  
      /*5. What is the difference in value and a variable in scala?*/
       Value (val) is immutable once assigned the value this cannot be changed
       Variable (var) once assigned you can reassign the value, as long as the new value sea of the same type
``` 
We create the tuple and call the position, in this case 3.1416
```scala  
      /*6. Given the tuple ((2,4,5), (1,2,3), (3,116,23))) the number 3,141 returns*/
       var t = ((2,4,5),(1,2,3),(3.1416,23))
       t._3._1
``` 

