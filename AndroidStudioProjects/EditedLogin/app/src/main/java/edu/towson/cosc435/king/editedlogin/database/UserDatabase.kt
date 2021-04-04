package edu.towson.cosc435.king.editedlogin.models

import androidx.room.*
import edu.towson.cosc435.king.editedlogin.models.UserData
import java.util.*

@Dao
interface IUserDao{
    @Query("select id, name, email, password from UserData")
    fun getData(): List<UserData>

    @Query("select * from UserData where email = :email and password = :password")
    fun validate(email: String, password: String): UserData

    @Update
    fun updateUserData(data: UserData)

    @Delete
    fun deleteSong(data:UserData)

    @Insert
    fun addData(data:UserData)

}


class UUIDTypeConverter{
    @TypeConverter
    fun toString(uuid: UUID): String{
        return uuid.toString()
    }
    @TypeConverter
    fun fromString(uuid: String): UUID{
        return UUID.fromString(uuid)
    }
}

@Database(entities = [UserData::class],version = 1, exportSchema = false)
@TypeConverters(UUIDTypeConverter::class)
abstract class UserDatabase : RoomDatabase(){
    abstract fun dataDao(): IUserDao
}