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

    @Query("select * from coins where isFavorite = 1")
    fun getFavorites(): LiveData<List<CoinDbModel>>

    @Query("select * from coins where name like :filter order by rank")
    fun searchCoins(filter: String): LiveData<List<CoinDbModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCoin(coinsList: List<CoinDbModel>)
}