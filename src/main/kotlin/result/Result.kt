package result

import utils.FinalResultUtils

class Result (
    inputMode: String,
    player1Answer: String,
    player2Answer: String
) : Mode (inputMode, player1Answer, player2Answer) {
    private lateinit var finalResultUtils: FinalResultUtils

    /*=======================================================
             APP PROCESS CHOOSING FOR PRINT RESULT
    ========================================================*/
    override fun mode(player1: String, player2: String) {
        finalResultUtils = FinalResultUtils()
        super.mode(player1, player2)
        when (inputMode) {
            "bot" -> finalResultUtils.finalResulting(true, player1Answer, player2Answer)
            "player" -> finalResultUtils.finalResulting(player1Answer, player2Answer)
        }
    }
}