import androidx.compose.runtime.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable


@Composable
fun singleCard(model: Model){
    val el = model.getUsers().random()
    Div {
        P {
            B { Text(el.login) }
            Br {  }
            B { Text(el.password) }
        }
    }
}
@Composable
fun screen(model: Model){
    P { Text("I hate compose") }
    Div{
        for (el in model.getUsers()){
            Div  {
                P {
                    Button(attrs = {
                        onClick { model.state=model.getUsers().indexOf(el) }
                    }) {  Text(el.login)}

                    Br {  }
                    Button {Text(el.password)  }

                }
            }
        }
    }
}

fun main() {
    var count: Int by mutableStateOf(-1)
    val model=Model()
    renderComposable(rootElementId = "root") {
        if (model.state==-1){
            P { Text("I hate compose") }
            P { Text("${model.getUsers().size}")}
            Button(attrs = {
                onClick {
                    val length=model.getUsers().size+1
                    val user=User(length.toString(),length.toString())
                    model.addUser(user)
                }
            }) { Text("Add element") }
            Div{
                for (el in model.getUsers()){
                    Div  {
                        P {
                            Button(attrs = {
                                onClick { model.state=model.getUsers().indexOf(el) }
                            }) {  Text(el.login)}
                            Button(attrs = {
                                onClick { model.dropUser(el) }
                            }) {  Text("Delete element")}
                            Br {  }
                            Button {Text(el.password)  }

                        }
                    }
                }
            }
        }
        else{
            val el = model.getUsers()[model.state]
            Div {
                P {
                    Button(attrs = {
                        onClick { model.state=-1 }
                    }){B { Text(el.login) }}
                    Br {  }
                    B { Text(el.password) }
                }
            }
        }
    }

}


//fun main() {
//    var count: Int by mutableStateOf(-1)
//
//    val list = mutableListOf(User("1", "1"), User("2", "2"),User("3", "3"))
//    var userList =list.toMutableStateList()
//    val model=Model(list,-1)
//        renderComposable(rootElementId = "root") {
//            if (count==-1){
//                P { Text("I hate compose") }
//                Button(attrs = {
//                    onClick {
//                        val length=userList.size+1
//                        val user=User(length.toString(),length.toString())
//                        userList.add(user)
//                    }
//                }) { Text("Add element") }
//                Div{
//                    for (el in userList){
//                        Div  {
//                            P {
//                                Button(attrs = {
//                                    onClick { count=userList.indexOf(el) }
//                                }) {  Text(el.login)}
//                                Button(attrs = {
//                                    onClick { userList.remove(el) }
//                                }) {  Text("Delete element")}
//                                Br {  }
//                                Button {Text(el.password)  }
//
//                            }
//                        }
//                    }
//                }
//            }
//            else{
//                val el = model.getUsers()[count]
//                Div {
//                    P {
//                        Button(attrs = {
//                            onClick { count=-1 }
//                        }){B { Text(el.login) }}
//                        Br {  }
//                        B { Text(el.password) }
//                    }
//                }
//            }
//        }
//
//}

