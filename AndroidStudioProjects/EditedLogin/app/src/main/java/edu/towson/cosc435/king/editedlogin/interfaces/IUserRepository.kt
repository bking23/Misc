package edu.towson.cosc435.king.editedlogin

import edu.towson.cosc435.king.editedlogin.models.UserData

// The song repository is an abstract collection of Songs
// We will need methods for:
// getting the number of songs, getting a song by index,
// getting all the songs in the repository, deleting a song,
// and, finally, replacing a song at a given index (this one will be explained later)

interface IUserRepository {
    fun getCount(): Int
    fun getData(idx: Int): UserData
    fun getAllData(): List<UserData>
    fun deleteData(idx: Int)
    fun replaceData(idx: Int, data: UserData)
    fun addData(data: UserData)
}