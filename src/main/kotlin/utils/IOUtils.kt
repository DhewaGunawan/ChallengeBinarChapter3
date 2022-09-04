package utils

object IOUtils {
    fun readMode(default: String = ""): String {
        return when(readln().lowercase()) {
            "a" -> "bot"
            "b" -> "player"
            else ->  {
                default
            }
        }
    }

    fun readOption(default: String = ""): String {
        return when(readln().lowercase()) {
            "a" -> "Gunting"
            "b" -> "Kertas"
            "c" -> "Batu"
            else ->  {
                default
            }
        }
    }

    fun printInvalidAnswer() {
            println("""
            ----------------------------------------------------------
            Jawaban kamu tidak ada pada pilihan, silakan pilih kembali
            ----------------------------------------------------------
            """.trimIndent())
    }
}