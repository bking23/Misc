package edu.towson.cosc435.king.editedlogin.interfaces

import edu.towson.cosc435.king.editedlogin.models.UserData


interface IUserDataController {
    fun deleteData(idx: Int)
    fun launchAddUserDataScreen()
    fun getData(idx: Int): UserData
    fun getDatas(): List<UserData>
    fun addNewUserData(data: UserData)
    fun editUserData(idx: Int)
}