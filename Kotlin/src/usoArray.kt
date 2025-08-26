fun main() {

    //Puedes crear un array indicando tamaño y regla de inicialización:
    val cuadrados = Array(5) { i -> i * i }
    println(cuadrados.joinToString()) // 0, 1, 4, 9, 16

    // Array de enteros
    val numeros = arrayOf(1, 2, 3, 4, 5)

    // Array de strings
    val nombres = arrayOf("Ana", "Luis", "Carlos")

    // Array mixto (tipado como Any)
    val mixto = arrayOf(1, "Hola", true)

    println(numeros[0])  // Acceder al primer elemento -> 1
    println(nombres[2])  // Acceder al tercero -> Carlos

    // Forma 1: for-in
    for (n in numeros) {
        println(n)
    }

    // Forma 2: con índice
    for (i in numeros.indices) {
        println("Índice $i -> ${numeros[i]}")
    }

    // Forma 3: forEach
    numeros.forEach { println(it) }

    println(numeros.size)         // Tamaño -> 4
    println(numeros.first())      // Primer elemento -> 5
    println(numeros.last())       // Último elemento -> 20
    println(numeros.contains(10)) // ¿Existe 10? -> true

    val duplicados = numeros.map { it * 2 }
    println(duplicados) // [10, 20, 30, 40]
}
