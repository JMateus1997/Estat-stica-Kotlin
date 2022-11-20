class DadosMercado(
    var moedaNome: String? = null,
    var retorno: MutableList<Double> = mutableListOf(),
    var media: Double = 0.0,
    var variancia: Double = 0.0,
    var desvio: Double = 0.0,
    var tempoRetorno: Double = 0.0,
    var tempoMedia: Double = 0.0,
    var tempoVariancia: Double = 0.0,
    var tempoDesvio: Double = 0.0
) {
}