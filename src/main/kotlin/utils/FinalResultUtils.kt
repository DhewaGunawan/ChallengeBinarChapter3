package utils

class FinalResultUtils : FinalResultContract {
    private var player: String ?= ""
    private var opponent: String ?= ""
    override fun finalResulting(isPlayingWithBot: Boolean, player1Answer: String, player2Answer: String) {
        player = "Kamu"
        opponent = "Bot"
        printFinalResult(player1Answer, player2Answer)
    }

    override fun finalResulting(player1Answer: String, player2Answer: String) {
        player = "Pemain 1"
        opponent = "Pemain 2"
        printFinalResult(player1Answer, player2Answer)
    }

    private fun printFinalResult(player1Answer: String, player2Answer: String) {
        when {
            player1Answer == player2Answer -> println("!! Draw !!")
            player1Answer == "Gunting" && player2Answer == "Kertas" -> println("!! $player Menang !!")
            player1Answer == "Gunting" && player2Answer == "Batu" -> println("!! $opponent Menang !!")
            player1Answer == "Kertas" && player2Answer == "Gunting" -> println("!! $opponent Menang !!")
            player1Answer == "Kertas" && player2Answer == "Batu" -> println("!! $player Menang !!")
            player1Answer == "Batu" && player2Answer == "Gunting" -> println("!! $player Menang !!")
            player1Answer == "Batu" && player2Answer == "Kertas" -> println("!! $opponent Menang !!")
        }
        println()
    }
}