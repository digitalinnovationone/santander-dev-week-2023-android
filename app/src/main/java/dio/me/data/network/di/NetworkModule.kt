package dio.me.data.network.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    private val url = "https://digitalinnovationone.github.io/"

    @Provides
    @Singleton
    fun provideRetrofitBuilder(): Retrofit.Builder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .baseUrl(url)

    @Provides
    @Singleton
    fun provideRetrofit(
        builder: Retrofit.Builder,
    ): Retrofit = builder
        .client(OkHttpClient.Builder().build())
        .build()
}
