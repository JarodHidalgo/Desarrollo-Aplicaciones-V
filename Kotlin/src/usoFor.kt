fun main(){
    val num = intArrayOf(1,2,3,4,5,6,7)

    for (nume: Int in num) println(nume) 

    
    println("**** Números pares ****")
    val numeroPares = intArrayOf(0,2,4,6,8,10)
    for((indice, valor)in numeroPares.withIndex()){
        println("Elemento $indice: $valor")
    }

    println()

   
    for(i in 1..10) println(i)
}