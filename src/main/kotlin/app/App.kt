package app

import utils.IOUtils
import java.util.*
import kotlin.concurrent.schedule
import kotlin.system.exitProcess

class App {
    private val modes = listOf("A). Bermain Dengan Bot", "B). Multiplayer")
    private val options = listOf("A). Gunting", "B). Kertas", "C). Batu")
    private val process = Process()
    private lateinit var inputUser: String
    private lateinit var inputMode: String
    private lateinit var inputPlayAgain: String

    /*=======================================================
                   DO ALL APPLICATION ACTIVITY
    ========================================================*/
    fun doApplication() {
        printAskGameMode()
        printTitle()
        printOption()
        /* 2 DIFFERENT FLOWS */
        when (inputMode) {
            "bot" -> {
                println("Pilih salah satu (Contoh menjawab 'A' tanpa tanda kutip)")
                do {
                    print("Pilih jawaban kamu: ")
                    inputUser = IOUtils.readOption()
                    if(inputUser == "") {
                        IOUtils.printInvalidAnswer()
                    }
                } while (inputUser.isBlank() || inputUser == "")
                process.getBotAnswer()
                process.processResultWithBot(inputUser)
                process.finalResulting(inputMode)
                printQuestionPlayAgain()
            }
            "player" -> {
                var i = 1
                do {
                    println("Pilih salah satu (Contoh menjawab 'A' tanpa tanda kutip)")
                    do {
                        print("Pilih untuk pemain $i : ")
                        inputUser = IOUtils.readOption()
                        if(inputUser == "") {
                            IOUtils.printInvalidAnswer()
                        }
                    } while (inputUser.isBlank() || inputUser == "")
                    process.processResult(i, inputUser)
                    printInputResult(i)
                    i++
                } while (i < 3)
                process.finalResulting(inputMode)
                printQuestionPlayAgain()
            }
        }
    }

    /*=======================================================
                        CHOOSING GAME MODE
    ========================================================*/
    private fun printAskGameMode() {
        println("Pilihan : ")
        modes.forEach { mode ->
            println(mode)
        }
        do {
            print("Pilih mode bermain : ")
            inputMode = IOUtils.readMode()
            if(inputMode == "") {
                IOUtils.printInvalidAnswer()
            }
        } while (inputMode.isBlank() || inputMode == "")
        println()
    }

    /*=======================================================
                           PRINT TITLE
    ========================================================*/
    private fun printTitle() {
        var titleMode: String ?= null
        when (inputMode) {
            "bot" -> titleMode = "MELAWAN BOT"
            "player" -> titleMode = "MULTIPLAYER"
        }
        println("""
            ~oO===============================Oo~
                 GAME SUIT TERMINAL VERSION
                         $titleMode
            ~oO===============================Oo~    
            
        """.trimIndent())
    }

    /*=======================================================
                PRINT OPTIONS ROCK PAPER SCISSORS
    ========================================================*/
    private fun printOption() {
        println("Pilihan : ")
        options.forEach { option ->
            println(option)
        }
    }

    /*=======================================================
            PRINT WHEN PLAYER 1 OR PLAYER 2 HAD ANSWER
                 IT'S ONLY IN MULTIPLAYER MODE
    ========================================================*/
    private fun printInputResult(i: Int) {
        println("Pemain $i telah menjawab")
        println()
    }

    /*=======================================================
                      ASKING TO PLAY AGAIN
    ========================================================*/
    private fun printQuestionPlayAgain() {
        print("Mau bermain kembali (Y/N)? ")
        inputPlayAgain = readln()
        printResultPlayAgain(inputPlayAgain)
    }

    /*=======================================================
                DO RESULT FROM ASKING TO PLAY AGAIN
    ========================================================*/
    private fun printResultPlayAgain(inputPlayAgain: String) {
        when(inputPlayAgain) {
            "y" -> {
                println("Mohon tunggu selagi kami mempersiapkan untuk Anda..")
                Timer("SettingUp", false).schedule(1000) {
                    process.doSpacing()
                    App().doApplication()
                }
            }
            "n" -> {
                println("~o) Terima kasih telah menggunakan aplikasi ini (o~")
                exitProcess(0)
            }
            else -> {
                print("Mohon masukkan pilihan yang benar antara (Y) atau (N) : ")
                val inputAgain = readln()
                printResultPlayAgain(inputAgain)
            }
        }
    }

    /*=======================================================
                          MAIN FUNCTION
    ========================================================*/
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            App().doApplication()
        }
    }
}