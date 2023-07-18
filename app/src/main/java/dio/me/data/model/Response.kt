package dio.me.data.model

data class Response(
    val name: String,
    val account: Account,
    val card: Card,
    val features: List<Feature>,
    val news: List<News>,
)
