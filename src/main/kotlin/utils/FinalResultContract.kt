package utils

interface FinalResultContract {
    fun finalResulting(isPlayingWithBot: Boolean, player1Answer: String, player2Answer: String)
    fun finalResulting(player1Answer: String, player2Answer: String)
}