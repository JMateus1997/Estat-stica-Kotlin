import java.io.*

fun main() {

    val csvFile: String = "C:\\Users\\Lenovo-IdeaPad\\Desktop\\questao1.csv"
    val listaMercado1: ListaMercado = ListaMercado()
    val listaMercado2: ListaMercado = ListaMercado()
    val listaMercado3: ListaMercado = ListaMercado()
    val listaData: MutableList<String?> = mutableListOf()

    try {

        val conteudoCSV = BufferedReader(FileReader(csvFile))
        val cabecalho = conteudoCSV.readLine()
        val conteudo = conteudoCSV.readLines()
        var linhas: MutableList<String?>
        val nomes: MutableList<String> = cabecalho.split(",").toMutableList()
        listaMercado1.nome = nomes[1]
        listaMercado2.nome = nomes[2]
        listaMercado3.nome = nomes[3]

        for (i in conteudo) {

            linhas = i.split(",").toMutableList()

            listaData.add(linhas[0].toString())
            listaMercado1.precoMoeda.add(linhas[1]?.toDouble())
            listaMercado2.precoMoeda.add(linhas[2]?.toDouble())
            listaMercado3.precoMoeda.add(linhas[3]?.toDouble())

        }
        println(listaMercado1.nome)
        println(listaMercado2.nome)
        println(listaMercado3.nome)

        println(listaMercado1.precoMoeda)
        println(listaMercado2.precoMoeda)
        println(listaMercado3.precoMoeda)

    } finally {

    }

    val dadosMercado1: DadosMercado = Estatistica(listaMercado1)
    mostraResultados(dadosMercado1)

    val dadosMercado2: DadosMercado = Estatistica(listaMercado2)
    mostraResultados(dadosMercado2)

    val dadosMercado3: DadosMercado = Estatistica(listaMercado3)
    mostraResultados(dadosMercado3)
}

fun mostraResultados(dadosMercado: DadosMercado){

    println("Moeda: \n${dadosMercado.moedaNome}")
    println("Retornos: \n${dadosMercado.retorno}")
    println("Media: \n${dadosMercado.media}")
    println("Variancia: \n${dadosMercado.variancia}")
    println("Desvio: \n${dadosMercado.desvio}")

}




