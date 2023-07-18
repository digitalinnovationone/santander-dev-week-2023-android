package dio.me.data.network.repository

import dio.me.data.network.service.AccountService
import javax.inject.Inject

class AccountRepository @Inject constructor(
    private val accountService: AccountService,
) {
    suspend fun getAccount() = accountService.getAccount()
}
