package result

open class Mode (
    val inputMode: String,
    val player1Answer: String,
    val player2Answer: String
) {
    open fun mode(player1: String, player2: String) {
        println("""
            
            ============== RESULT ==============
            $player1
            $player2
            Hasil :
        """.trimIndent())
    }
}