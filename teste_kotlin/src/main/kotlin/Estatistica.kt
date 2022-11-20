import kotlin.math.sqrt

fun Estatistica(listaMercado: ListaMercado): DadosMercado {

    val dadosMercado: DadosMercado = DadosMercado()

    val nomeMoeda: String? = listaMercado.nome
    val listaRetornoMoeda: MutableList<Double> = calculaRetorno(listaMercado.precoMoeda.size, listaMercado.precoMoeda)
    val mediaRetornoMoeda: Double = listaRetornoMoeda.average()

    val varianciaMoeda: Double = caculaVariancia(
        listaMercado.precoMoeda.size,
        listaMercado.precoMoeda,
        mediaRetornoMoeda
    )

    val desvioMoeda = sqrt(varianciaMoeda)

    dadosMercado.moedaNome = nomeMoeda
    dadosMercado.retorno = listaRetornoMoeda
    dadosMercado.media = mediaRetornoMoeda
    dadosMercado.variancia = varianciaMoeda
    dadosMercado.desvio = desvioMoeda

    return (dadosMercado)

}

fun calculaRetorno(tamanhoListaMoeda: Int, listaMercado: MutableList<Double?>): MutableList<Double> {

    val moedaSize = tamanhoListaMoeda
    var calculoRetornoMoeda: Double?
    val listaCalculoRetornoMoeda: MutableList<Double> = mutableListOf()

    for (i in 0 until (moedaSize - 1)) {

        calculoRetornoMoeda =
            (listaMercado[i + 1]?.minus(listaMercado[i]!!))?.div(((listaMercado[i]!!)))!!

        listaCalculoRetornoMoeda.add(calculoRetornoMoeda)
    }

    return (listaCalculoRetornoMoeda)
}

fun caculaVariancia(tamanhoListaMoeda: Int, listaMercado: MutableList<Double?>, media: Double): Double {

    val moedaSize = tamanhoListaMoeda
    var calculoVariancia: Double = 0.0

    for (i in 0 until (moedaSize - 1)) {

        calculoVariancia += (Math.pow((listaMercado[i]?.minus(media)!!), 2.0))
    }
    calculoVariancia = calculoVariancia / (moedaSize - 2)

    return (calculoVariancia)
}
