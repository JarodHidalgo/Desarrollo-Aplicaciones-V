fun main(args: Array<String>){
    val name1 = "Sesilea"
    val name2 = "Ana"

    
    getLongesName1(name1, name2)
   
    getLongesName2(name1, name2)

    getLongesname3(name1,name2)
}

fun getLongesName1(name1: String, name2: String){
    var longesName = name2

    if (name1.length > name2.length) longesName = name1 
    

    println("El nombre mas largo es: $longesName")
}

fun getLongesName2(name1: String, name2: String){
    var longesName = ""

    if(name1.length > name2.length){
        longesName = name1
    }else{
        longesName=name2
    }

    println("El nombre mas largo es: $longesName")
}


fun getLongesname3(name1: String, name2: String) {
    
    val longesName = if(name1.length > name2.length) name1 else name2

    println("El nombre mas largo es: $longesName")
}