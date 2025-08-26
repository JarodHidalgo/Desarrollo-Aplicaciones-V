// el operado when es tambien como en otro lenguaje switch

fun main(){
    val password = "ahdsfkljahdoihejadsnfp"

    when(password.length){
        0 -> println("Contraseña vacia") // podemos especificar un caso
        in 1..4 -> println("Contraseña muy débil") // podemos con in especificar un largo de caso
        5,6 -> println("Contraseña debil") // aqui igual especificamos el rango de caso de manera manual
        else -> println("Contraseña segura")
    } // aqui estamos comprobando la longitud para asi ver que caso cumple
    /*
    when es una forma mas sencilla que usar un switch ejemplo de como seria hacer lo de
    whe con switch

    String password = "ahdsfkljahdoihejadsnfp";
    switch (password.length()) {
            case 0:
                System.out.println("Contraseña vacía");
                break;
            case 1: case 2: case 3: case 4:
                System.out.println("Contraseña muy débil");
                break;
            case 5: case 6:
                System.out.println("Contraseña débil");
                break;
            default:
                System.out.println("Contraseña segura");
        }
     */

    //uso de función de when
    esPar(43435)
}

// podemos usar when en forma de una función que sea especial para el when
fun esPar(num: Int) = when(num%2) {
    0-> println("El numero es par")
    else -> ("El numero es impar")
}
