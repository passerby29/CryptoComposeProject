package dev.passerby.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.passerby.data.models.db.CoinDbModel

@Dao
interface CoinDao {

    @Query("select * from coins")
    fun getCoinList(): LiveData<List<CoinDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoin(coinsList: List<CoinDbModel>)
}