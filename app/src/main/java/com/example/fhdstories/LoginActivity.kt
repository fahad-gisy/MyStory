package com.example.fhdstories

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private  var editTextUser:EditText? = null
    private  var editTextPass:EditText? = null
    private  var buttonLogin:Button? = null
    private  var checkBoxView:CheckBox? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        connectVs()
        login()
//        checkFields()

    }

    private fun connectVs() {
        editTextUser = findViewById(R.id.etUser)
        editTextPass = findViewById(R.id.pass)
        buttonLogin = findViewById(R.id.login)
        checkBoxView = findViewById(R.id.check)
    }
private fun login(){
    val array:ArrayList<User> = ArrayList()
    array.add(User("test@test.com","1234"))
    array.add(User("t@test.com","12345"))
    array.add(User("b@test.com","123456"))
    array.add(User("fhd@gmail.com","123456"))

   buttonLogin?.setOnClickListener {
val username = editTextUser?.text.toString()
val password = editTextPass?.text.toString()
val user = User(username,password)

       for (userArray in array){
           if (userArray.email == user.email
               && userArray.password == user.password){
//               Toast.makeText(this,"Welcome ${user.email}",Toast.LENGTH_SHORT).show()
             val i = Intent(this,MainActivity::class.java)
               i.putExtra("username",userArray.email)
               startActivity(i)
               finish()
               break
           }else{

               Toast.makeText(this,"Welcome",Toast.LENGTH_SHORT).show()
           }

       }

   }


}
private  fun checkFields(){


buttonLogin?.setOnClickListener {
    if (editTextUser?.text?.isEmpty() == true ){
        editTextUser?.setError("Enter your email")
      }else if (editTextPass?.text?.isEmpty() == true){
        editTextPass?.error = "Please Enter Password"
      }
    }
}


}


