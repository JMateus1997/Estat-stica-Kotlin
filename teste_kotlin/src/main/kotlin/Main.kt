import java.io.*
import java.lang.Math.pow

fun main() {

    val csvFile: String = "C:\\Users\\Lenovo-IdeaPad\\Desktop\\questao1.csv"
    val listaMercado: ListaMercado = ListaMercado()
    val listaData: MutableList<String?> = mutableListOf()
    val listaDolar: MutableList<Double?> = mutableListOf()
    val listaEgie3: MutableList<Double?> = mutableListOf()
    val listaUsim5: MutableList<Double?> = mutableListOf()

    try {

        val conteudoCSV = BufferedReader(FileReader(csvFile))
        val cabecalho = conteudoCSV.readLine()
        val conteudo = conteudoCSV.readLines()
        var linhas: MutableList<String?>
        listaMercado.cabecalho = cabecalho

        for (i in conteudo) {

            linhas = i.split(",").toMutableList()

            listaData.add(linhas[0].toString())
            listaDolar.add(linhas[1]?.toDouble())
            listaEgie3.add(linhas[2]?.toDouble())
            listaUsim5.add(linhas[3]?.toDouble())

        }
    } finally {

    }
    println("--------------------------------------------------------")
    listaMercado._data = listaData
    listaMercado.dolar = listaDolar
    listaMercado.egie3 = listaEgie3
    listaMercado.usim5 = listaUsim5

    println(listaMercado.cabecalho)
    println("--------------------------------------------------------")
    println(listaMercado._data)
    println("--------------------------------------------------------")
    println(listaMercado.dolar)
    println("--------------------------------------------------------")
    println(listaMercado.egie3)
    println("--------------------------------------------------------")
    println(listaMercado.usim5)

    val listaRetornoDolar = calculaRetorno(listaMercado.dolar.size, listaMercado.dolar)
    val listaRetornoEgie3 = calculaRetorno(listaMercado.egie3.size, listaMercado.egie3)
    val listaRetornoUsim5 = calculaRetorno(listaMercado.usim5.size, listaMercado.usim5)

    println("Retorno do Dolar -------------------------------------------")
    println(listaRetornoDolar)
    println("Retorno do Egie3 -------------------------------------------")
    println(listaRetornoEgie3)
    println("Retorno do Usim5 -------------------------------------------")
    println(listaRetornoUsim5)

    val mediaRetornoDolar = listaRetornoDolar.average()
    val mediaRetornoEgie3 = listaRetornoEgie3.average()
    val mediaRetornoUsim5 = listaRetornoUsim5.average()

    println("Media do Dolar -------------------------------------------")
    println(mediaRetornoDolar)
    println("Media do Egie3 -------------------------------------------")
    println(mediaRetornoEgie3)
    println("Media do Usim5 -------------------------------------------")
    println(mediaRetornoUsim5)

    val varianciaDolar = caculaVariancia(listaMercado.dolar.size, listaMercado.dolar, mediaRetornoDolar)
    val varianciaEgie3 = caculaVariancia(listaMercado.egie3.size, listaMercado.egie3, mediaRetornoEgie3)
    val varianciaUsim5 = caculaVariancia(listaMercado.usim5.size, listaMercado.usim5, mediaRetornoUsim5)

    println("Variância do Dolar -------------------------------------------")
    println(varianciaDolar)
    println("Variância do Egie3 -------------------------------------------")
    println(varianciaEgie3)
    println("Variância do Usim5 -------------------------------------------")
    println(varianciaUsim5)

    val desvioDolar = pow(varianciaDolar, 0.5)
    val desvioEgie3 = pow(varianciaEgie3, 0.5)
    val desvioUsim5 = pow(varianciaUsim5, 0.5)

    println("Desvio do Dolar -------------------------------------------")
    println(desvioDolar)
    println("Desvio do Egie3 -------------------------------------------")
    println(desvioEgie3)
    println("Desvio do Usim5 -------------------------------------------")
    println(desvioUsim5)

    val covariancaiDolarEgie3 = calculaCovariancia(
        listaMercado.dolar.size,
        listaMercado.dolar,
        listaMercado.egie3,
        mediaRetornoDolar,
        mediaRetornoEgie3
    )
    val covariancaiDolarUsim5 = calculaCovariancia(
        listaMercado.dolar.size,
        listaMercado.dolar,
        listaMercado.usim5,
        mediaRetornoDolar,
        mediaRetornoUsim5
    )
    val covariancaiEgie3Usim5 = calculaCovariancia(
        listaMercado.dolar.size,
        listaMercado.egie3,
        listaMercado.usim5,
        mediaRetornoEgie3,
        mediaRetornoUsim5
    )

    println("Covariância Dolar com Egie3 -------------------------------------------")
    println(covariancaiDolarEgie3)
    println("Covariância Dolar com Usim5 -------------------------------------------")
    println(covariancaiDolarUsim5)
    println("Covariância Egie3 com Usim5 -------------------------------------------")
    println(covariancaiEgie3Usim5)

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

        calculoVariancia += (pow((listaMercado[i]?.minus(media)!!), 2.0))
    }
    calculoVariancia = calculoVariancia / (moedaSize - 2)

    return (calculoVariancia)
}

fun calculaCovariancia(
    tamanhoListaMoeda: Int,
    listaMercadoMoeda1: MutableList<Double?>,
    listaMercadoMoeda2: MutableList<Double?>,
    mediaMoeda1: Double,
    mediaMoeda2: Double
): Double {

    var calculoCovariancia: Double = 0.0

    for (i in 0 until (tamanhoListaMoeda - 1)) {

        calculoCovariancia += (listaMercadoMoeda1[i]?.minus(mediaMoeda1))?.times(
            (listaMercadoMoeda2[i]?.minus(
                mediaMoeda2
            )!!)
        )!!
    }

    return (calculoCovariancia / (tamanhoListaMoeda-1))
}

