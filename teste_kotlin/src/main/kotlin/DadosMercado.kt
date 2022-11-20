class DadosMercado(
    var moedaNome: String? = null,
    var retorno: MutableList<Double> = mutableListOf(),
    var media: Double = 0.0,
    var variancia: Double = 0.0,
    var desvio: Double = 0.0,
) {
}