// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel {
    BASICO,
    INTERMEDIARIO,
    DIFICIL
}

enum class TipoAtividade {
    CURSO,
    MENTORIA,
    DESAFIO_PROJETO
}

data class Usuario(val nome: String, val documento: String)

data class Atividade(val descricao: String, val duracaoHoras: Int, val nivel: Nivel, val tipo: TipoAtividade)

data class ConteudoEducacional(val descricao: String, val atividades: List<Atividade>)

data class Formacao(
    val nome: String,
    val nivel: Nivel,
    val duracaoHoras: Int,
    var conteudos: List<ConteudoEducacional>
) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuario: Usuario) {
        inscritos.addAll(usuario)
    }

    val countMatriculas: Int
        get() = inscritos.size
}

fun main() {
    val userJoaquim = Usuario(nome = "Joaquim Farias", documento = "602.239.211-06")
    val userClara = Usuario(nome = "Clara Monteiro", documento = "101.761.750-32")
    val userVicente = Usuario(nome = "Vicente Moreira", documento = "381.357.479-26")
    val userJaqueline = Usuario(nome = "Jaqueline Gonçalves", documento = "193.240.546-19")
    val userNathan = Usuario(nome = "Nathan Assis", documento = "461.759.377-24")

    val conteudoIntroducaoAndroid = ConteudoEducacional(
        descricao = "Introdução a Desenvolvimento Nativo Android",
        atividades = listOf(
            Atividade(
                descricao = "Introdução a Experiência e Sistemas Nativos Android",
                nivel = Nivel.BASICO,
                duracaoHoras = 1,
                tipo = TipoAtividade.CURSO
            ),
            Atividade(
                descricao = "Live de Lançamento - Cognizant Mobile Developer",
                nivel = Nivel.BASICO,
                duracaoHoras = 1,
                tipo = TipoAtividade.MENTORIA
            )
        )
    )

    val essencialParaDesenvolvimentoAndroid = ConteudoEducacional(
        descricao = "Essencial para Desenvolvimento De Aplicativos Android",
        atividades = listOf(
            Atividade(
                descricao = "Estruturas de Controle de Fluxo e Coleções em Kotlin",
                duracaoHoras = 2,
                nivel = Nivel.BASICO,
                tipo = TipoAtividade.CURSO
            ),
            Atividade(
                descricao = "Abstraindo Formações da DIO Usando Orientação a Objetos com Kotlin",
                duracaoHoras = 2,
                nivel = Nivel.BASICO,
                tipo = TipoAtividade.DESAFIO_PROJETO
            )
        )
    )

    val cognizantMobileDeveloper = Formacao(
        nome = "Cognizant - Mobile Developer",
        nivel = Nivel.INTERMEDIARIO,
        duracaoHoras = 58,
        conteudos = listOf(
            conteudoIntroducaoAndroid,
            essencialParaDesenvolvimentoAndroid
        )
    )

    cognizantMobileDeveloper.matricular(
        userJoaquim,
        userClara,
        userNathan,
        userVicente,
        userJaqueline
    )

    cognizantMobileDeveloper.run {
        println("A formação ${nome} de nível ${nivel} e com ${duracaoHoras} hrs de duração possui ${countMatriculas} pessoas matriculadas.")
    }
}




