fun main() {

    // ------------------------------
    // EJEMPLO 1: break normal
    // ------------------------------
    for (i in 1..5) {
        if (i == 3) break // rompe el bucle actual cuando i == 3
        println("break normal -> i = $i")
    }
    // Salida: 1, 2


    // ------------------------------
    // EJEMPLO 2: continue normal
    // ------------------------------
    for (i in 1..5) {
        if (i == 3) continue // salta la iteración cuando i == 3
        println("continue normal -> i = $i")
    }
    // Salida: 1, 2, 4, 5


    // ------------------------------
    // EJEMPLO 3: Uso de LABELS con break
    // ------------------------------
    externo@ for (i in 1..3) {           // etiqueta "externo"
        for (j in 1..3) {
            println("i=$i, j=$j")
            if (j == 2) break@externo   // rompe el bucle con label "externo"
        }
    }
    // Salida: i=1, j=1 / i=1, j=2
    //  Cuando j==2, rompe TODO el bucle externo, no solo el interno


    // ------------------------------
    // EJEMPLO 4: Uso de LABELS con continue
    // ------------------------------
    loop@ for (i in 1..3) {              // etiqueta "loop"
        for (j in 1..3) {
            if (j == 2) continue@loop   // salta la iteración completa del bucle externo
            println("i=$i, j=$j")
        }
    }
    // Salida:
    // i=1, j=1
    // i=2, j=1
    // i=3, j=1
    //  Cuando j==2, en lugar de saltar solo el bucle interno,
    //    salta toda la iteración del bucle "loop" (externo).


    // ------------------------------
    // EJEMPLO 5: Uso de return con labels en lambdas
    // ------------------------------
    val numeros = listOf(1, 2, 3, 4, 5)

    // forEach es una función lambda -> si hacemos "return" directo,
    // se saldría de la función main, lo cual no queremos.
    // Usamos un label para salir SOLO de la lambda.
    numeros.forEach bucle@ {
        if (it == 3) return@bucle
        println("Lambda con return@bucle -> $it")
    }
    println("Fin del programa (gracias a return@bucle no se cortó el main)")
    // Salida: 1, 2, 4, 5
}
