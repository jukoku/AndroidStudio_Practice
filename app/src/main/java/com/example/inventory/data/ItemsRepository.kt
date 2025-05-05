/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.inventory.data

import kotlinx.coroutines.flow.Flow

/**
 * Repository that provides insert, update, delete, and retrieve of [Item] from a given data source.
 */
interface ItemsRepository{

    // 데이터 소스 안의 모든 아이템 갱신
    fun getAllItemsStream(): Flow<List<Item>>
    // 주어지 아이디와 상응하는 데이터 호출
    fun getItemStream(id: Int): Flow<Item?>
    // 데이터에 아이템 삽입
    suspend fun insertItem(item: Item)
    // 데이터의 아이템 삭제
    suspend fun deleteItem(item: Item)
    // 데이터의 아이템 수정
    suspend fun updateItem(item: Item)
}
