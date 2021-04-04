package edu.towson.cosc435.king.editedlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import edu.towson.cosc435.king.editedlogin.models.UserData
import edu.towson.cosc435.king.editedlogin.models.UserModel


import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var handler:UserDatabaseRepository
    private lateinit var login_buttonLog: Button
    private lateinit var saveReg: Button
    private lateinit var registrationBtn: Button
    private lateinit var loginMain: Button
    private lateinit var loginEmail: EditText
    private lateinit var loginPassword: EditText
    private lateinit var nameReg: EditText
    private lateinit var emailReg: EditText
    private lateinit var passwordReg: EditText
    private lateinit var regLayout: View
    private lateinit var loginLayout: View
    private lateinit var homeLayout: View
    private lateinit var userModel: IUserModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login_buttonLog=findViewById(R.id.login_button)
        registrationBtn = findViewById(R.id.registration)
        loginMain = findViewById(R.id.login)
        saveReg = findViewById(R.id.save)
        loginEmail = findViewById(R.id.login_email)
        loginPassword = findViewById(R.id.login_password)
        nameReg = findViewById(R.id.name)
        emailReg = findViewById(R.id.email)
        passwordReg = findViewById(R.id.password_register)
        regLayout = findViewById(R.id.registration_layout)
        loginLayout = findViewById(R.id.login_layout)
        homeLayout = findViewById(R.id.home_11)




        //handler= DatabaseHelper(this)
        //userModel = UserModel(UserDatabaseRepository(application))
        handler = UserDatabaseRepository(application)


        showHome()

        registrationBtn.setOnClickListener{
            showRegistration()
        }

        loginMain.setOnClickListener{
            showLogIN()
        }
        saveReg.setOnClickListener{
//            handler.addData(nameReg.text.toString(),emailReg.text.toString(),passwordReg.text.toString())
//            showHome()
            try{
                val data = UserData(
                    id = UUID.randomUUID(),
                    name = nameReg.editableText.toString(),
                    email = emailReg.editableText.toString(),
                    password = passwordReg.editableText.toString()
                )
                handler.addData(data)
                showHome()
            }catch (e: Exception) {
                if (e.message != null) {
                    Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                }
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
            }
        }
        login_buttonLog?.setOnClickListener {
//            if (handler.userPresent(loginEmail.text.toString(), loginPassword.text.toString())) {
//                Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show()
//                openCalendar()
//            }
//            else
//                Toast.makeText(this, "Login Failure!", Toast.LENGTH_SHORT).show()
//
        }
//        val email = handler.getEmail().toString()
//        val password = handler.getPassword().toString()
//            if (handler.compare(email, password)){
//                Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show()
//                openCalendar()
//            }
//        else{
//                Toast.makeText(this, "Login Failure!", Toast.LENGTH_SHORT).show()
//            }

    }
    private fun showRegistration(){
        regLayout.visibility=View.VISIBLE
        loginLayout.visibility=View.GONE
        homeLayout.visibility=View.GONE
    }
    private fun showLogIN(){
        regLayout.visibility=View.GONE
        loginLayout.visibility=View.VISIBLE
        homeLayout.visibility=View.GONE
    }
    private fun showHome(){
        regLayout.visibility=View.GONE
        loginLayout.visibility=View.GONE
        homeLayout.visibility=View.VISIBLE
    }
    private fun openCalendar(){
//        val intent = Intent(this, WhereToGo::class.java)
//        startActivity(intent)
    }

}