/*
    Copyright 2023 SafeHarbor

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/
package com.app.appellas.data.network.services.admin

import com.app.appellas.data.models.dtos.response.GenericResponse
import com.app.appellas.data.models.dtos.response.UserResponse
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface AdminUserService {

    @GET("user")
    suspend fun getUsers(@Header("Authorization") token: String): Response<GenericResponse<List<UserResponse>>>

    @DELETE("user/delete_user/{id}")
    suspend fun deleteUser(@Header("Authorization") token: String, @Path("id") id: Int): Response<GenericResponse<String>>

}