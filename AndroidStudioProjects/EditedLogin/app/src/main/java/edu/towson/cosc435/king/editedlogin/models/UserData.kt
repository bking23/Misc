package edu.towson.cosc435.king.editedlogin.models


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class UserData(
        @PrimaryKey
        val id: UUID,
        val name: String,
        val email: String,
        val password: String
)
