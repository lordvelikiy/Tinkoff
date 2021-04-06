package Test

class User(var firstName: String = "Peter" , var secondName:String="Patrik") {
    var login :String? = null
    set(value) {
        field=value
    }
    get() {
        println("Переменная равна $field")
        return field
    }
 //   var firstName: String =_firstName
  //  var secondName: String = _secondName


  //  init {
  //      firstName = _firstName
   //     secondName=_secondName
  //  }
  //  constructor():this("Peter","Patrik"){
  //    println("zbs")
 // }
}