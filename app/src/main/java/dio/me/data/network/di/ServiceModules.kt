package dio.me.data.network.di

import dio.me.data.network.service.AccountService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
class ServiceModules {
    @Provides
    fun provideAuthService(retrofit: Retrofit) = retrofit.create<AccountService>()
}
