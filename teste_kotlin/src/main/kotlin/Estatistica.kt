import kotlin.math.sqrt

var tempoInicialRetorno: Double = 0.0
var tempoFinalRetorno: Double = 0.0

var tempoInicialMedia: Double = 0.0

var tempoInicialVariancia: Double = 0.0
var tempoFinalVariancia: Double = 0.0

var tempoInicialDesvio: Double = 0.0

fun Estatistica(listaMercado: ListaMercado): DadosMercado {

    val dadosMercado: DadosMercado = DadosMercado()

    val nomeMoeda: String? = listaMercado.nome
    val listaRetornoMoeda: MutableList<Double> = calculaRetorno(listaMercado.precoMoeda.size, listaMercado.precoMoeda)
    dadosMercado.tempoRetorno = (tempoFinalRetorno - tempoInicialRetorno)/1000000

    tempoInicialMedia = System.nanoTime().toDouble()
    val mediaRetornoMoeda: Double = listaRetornoMoeda.average()
    dadosMercado.tempoMedia = (System.nanoTime().toDouble() - tempoInicialMedia)/1000000

    val varianciaMoeda: Double = caculaVariancia(
        listaMercado.precoMoeda.size,
        listaMercado.precoMoeda,
        mediaRetornoMoeda
    )
    dadosMercado.tempoVariancia = (tempoFinalVariancia - tempoInicialVariancia)/1000000

    tempoInicialDesvio = System.nanoTime().toDouble()
    val desvioMoeda = sqrt(varianciaMoeda)

    dadosMercado.tempoDesvio = (System.nanoTime().toDouble() - tempoInicialDesvio)/1000000

    dadosMercado.moedaNome = nomeMoeda
    dadosMercado.retorno = listaRetornoMoeda
    dadosMercado.media = mediaRetornoMoeda
    dadosMercado.variancia = varianciaMoeda
    dadosMercado.desvio = desvioMoeda

    return (dadosMercado)

}

fun calculaRetorno(tamanhoListaMoeda: Int, listaMercado: MutableList<Double?>): MutableList<Double> {

    tempoInicialRetorno = System.nanoTime().toDouble()

    val moedaSize = tamanhoListaMoeda
    var calculoRetornoMoeda: Double?
    val listaCalculoRetornoMoeda: MutableList<Double> = mutableListOf()

    for (i in 0 until (moedaSize - 1)) {

        calculoRetornoMoeda =
            (listaMercado[i + 1]?.minus(listaMercado[i]!!))?.div(((listaMercado[i]!!)))!!

        listaCalculoRetornoMoeda.add(calculoRetornoMoeda)
    }
    tempoFinalRetorno = System.nanoTime().toDouble()
    return (listaCalculoRetornoMoeda)
}

fun caculaVariancia(tamanhoListaMoeda: Int, listaMercado: MutableList<Double?>, media: Double): Double {

    tempoInicialVariancia = System.nanoTime().toDouble()
    val moedaSize = tamanhoListaMoeda
    var calculoVariancia: Double = 0.0

    for (i in 0 until (moedaSize - 1)) {

        calculoVariancia += (Math.pow((listaMercado[i]?.minus(media)!!), 2.0))
    }
    calculoVariancia = calculoVariancia / (moedaSize - 2)

    tempoFinalVariancia = System.nanoTime().toDouble()

    return (calculoVariancia)
}
