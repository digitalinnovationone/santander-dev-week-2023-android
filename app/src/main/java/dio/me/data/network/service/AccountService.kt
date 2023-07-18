package dio.me.data.network.service

import dio.me.data.model.Response
import retrofit2.http.GET

interface AccountService {
    @GET("/santander-dev-week-2023-api/mocks/find_one.json")
    suspend fun getAccount(): Response
}
