fun saludar(){
    println(" Hola como esta")
}


fun saludar2(nombre: String){
    println("Hola, $nombre")
}



fun division (num1: Double, num2: Double): Double{
    return num1 / num2
}


fun cuadrado(x: Int): Int = x * x

fun main(){
    saludar2("sergio")
    division(2.0,4.0)
    
    val sumar: (Int, Int) -> Int = { a, b -> a + b }
    println(sumar(5, 3))
}