package app

import result.Result

class Process {
    private var player1: String? = null
    private var player1Answer: String? = null
    private var player2: String? = null
    private var player2Answer: String? = null

    /*=======================================================
                       FLOW FROM BOT MODE
    ========================================================*/
    /* PROCESS TO GET BOT ANSWER WITH RANDOM PICK CHARACTER*/
    fun getBotAnswer() {
        val options = ('a'..'c').random()
        when (options.toString()) {
            "a" -> player2Answer = "Gunting"
            "b" -> player2Answer = "Kertas"
            "c" -> player2Answer = "Batu"
        }
    }

    /* PROCESS TO COMPLETING FINAL RESULT PRINT */
    fun processResultWithBot(inputUser: String) {
        player1 = "Kamu memilih : $inputUser"
        player1Answer = inputUser
        player2 = "Bot memilih : $player2Answer"
    }

    /*=======================================================
                   FLOW FROM MULTIPLAYER MODE
    ========================================================*/
    /* PROCESS TO COMPLETING FINAL RESULT PRINT */
    fun processResult(i: Int, inputUser: String) = when (i) {
        1 -> {
            player1 = "Pemain $i memilih : $inputUser"
            player1Answer = inputUser
        }
        else -> {
            player2 = "Pemain $i memilih : $inputUser"
            player2Answer = inputUser
        }
    }

    /*=======================================================
                FINAL RESULTING TO MAKE A CHOICE
               WHAT WILL APP PRINT FOR THE RESULT
    ========================================================*/
    fun finalResulting(inputMode: String) {
        val result = Result(
            inputMode,
            player1Answer.toString(),
            player2Answer.toString()
        )
        result.mode(player1.toString(), player2.toString())
    }

    /*=======================================================
                   DO SPACING FOR CLEARING AREA
               BUT USER STILL CAN SEE GAME HISTORY
    ========================================================*/
    fun doSpacing() {
        println()
        println()
        println()
        println()
        println()
        println()
        println()
        println()
        println()
        println()
        println()
        println()
        println()
        println()
        println()
        println()
        println()
        println()
        println()
        println()
        println()
    }
}