package edu.towson.cosc435.king.editedlogin

import android.app.Application
import android.widget.Toast
import androidx.room.Room
import edu.towson.cosc435.king.editedlogin.IUserRepository
import edu.towson.cosc435.king.editedlogin.models.UserData
import edu.towson.cosc435.king.editedlogin.models.UserDatabase

//import edu.towson.cosc435.labsapp.interfaces.IUserRepository
//import edu.towson.cosc435.labsapp.models.UserData

class UserDatabaseRepository(app: Application): IUserRepository {
    private val dataList: MutableList<UserData> = mutableListOf()
    private val dataDb: UserDatabase
    init{
        dataDb = Room.databaseBuilder(
            app,
            UserDatabase::class.java,
            "user.db"
        ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
        dataList.addAll(dataDb.dataDao().getData())
    }

    override fun getCount(): Int {
        return dataList.size
    }

    override fun getData(idx: Int): UserData {
        return dataList[idx]

    }

    override fun getAllData(): List<UserData> {
        return dataList
    }

    override fun deleteData(idx: Int) {
        val song = dataList[idx]
        dataDb.dataDao().deleteSong(song)
        dataList.clear()
        dataList.addAll(dataDb.dataDao().getData())
    }

    override fun replaceData(idx: Int, data: UserData) {
        dataDb.dataDao().updateUserData(data)
        dataList.clear()
        dataList.addAll(dataDb.dataDao().getData())
    }

    override fun addData(data: UserData) {
        dataDb.dataDao().addData(data)
        dataList.clear()
        dataList.addAll(dataDb.dataDao().getData())
    }
//    fun compare(email: String, password: String): Boolean {
//        try{
//            dataDb.dataDao().validate(email, password)
//            return true
//        }catch (e: Exception) {
//            return false
//        }
//    }
//    fun getEmail() {
//        return dataDb.dataDao().getEmail()
//    }
//    fun getPassword() {
//        return dataDb.dataDao().getPassword()
//    }


}