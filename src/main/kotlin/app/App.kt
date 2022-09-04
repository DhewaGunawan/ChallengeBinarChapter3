package App

class UserInterface {
    private val options = mutableListOf("A). Gunting", "B). Kertas", "C). Batu")
    val process = Process()
    lateinit var inputUser: String

    fun doApplication() {
        printTitle()
        printOption()
        var i = 1
        do {
            printQuestion(i)
            inputUser = readln()
            process.process1(inputUser)
            process.process2(i)
            printInputResult(i)

        } while (i < 3)
        printTitleFinalResults()
    }

    private fun printTitle() {
        println("~oO===============================Oo~")
        println("     GAME SUIT TERMINAL VERSION")
        println("~oO===============================Oo~")
        println()
    }

    private fun printOption() {
        println("Pilihan : ")
        options.forEach { product ->
            println(product)
        }
    }

    private fun printQuestion(i: Int) {
        print("Pilih salah satu (Contoh menjawab 'A' tanpa tanda kutip) untuk pemain $i : ")
    }

    private fun printInputResult(i: Int) {
        println("Pemain $i telah menjawab")
        println()
    }

    fun printTitleFinalResults() {
        println("===================RESULT===================")
    }

    fun userInterface_playAgain() {
        println("Mau bermain kembali (Y/N)?")
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            UserInterface().doApplication()
        }
    }
}