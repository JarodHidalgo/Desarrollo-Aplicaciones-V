fun usoVariable(){
   
    val nombre = "Cabalo"
    
    println(nombre)

    
    var persona = "guille"
    persona = "guille"

    println(persona)

    
    var texto:String
    var entero: Int
    var decimal1:Double
    var decimal2: Float
    var boleano : Boolean
    var caracter : Char


    println("ingrese su edad: ")
    var edad = readLine()?.toIntOrNull() ?: 0 // Convierte a Int, si es null usa 0
}


fun main(){
    usoVariable()
}