import androidx.compose.runtime.*

class Model() {
    var state:  Int by mutableStateOf(-1)
    var users= (1..100).map { User(it.toString(),it.toString()) }
    //var userList =mutableListOf(User("1", "1"), User("2", "2"),User("3", "3")).toMutableStateList()
    var userList = users.toMutableStateList()
    fun getUsers():MutableList<User>{
        return userList
    }
//    fun setUsers(users: MutableList<User>){
//        this.userList=users
//    }
    fun addUser(user: User){
        userList.add(user)
    }
    fun dropUser(user: User){
        userList.remove(user)
    }


    fun handleClick(text: String, id: Int) {
        state=id

    }

}
