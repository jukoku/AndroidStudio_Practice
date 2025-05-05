package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    // 아이템 입력
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)
    // 아이템 업데이트 (수정)
    @Update
    suspend fun update(item: Item)
    // 아이템 삭제
    @Delete
    suspend fun delete(item: Item)
    // 단일 아이템 정보 열람
    @Query("SELECT * from items WHERE id = :id")
    fun getItem(id: Int): Flow<Item>
    // 전체 아이템 확인 및 이름 오름차순 정렬
    @Query("SELECT * from items ORDER BY name ASC")
    fun getAllItems(): Flow<List<Item>>
}