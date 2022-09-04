import kotlin.concurrent.timer

class Process {
    companion object {
        var jawabanResult: String? = null
        var pemain1: String? = null
        var jwbPemain1: String? = null
        var pemain2: String? = null
        var jwbPemain2: String? = null

        fun process1(jawaban: String): String {
            var jawaban = jawaban
            jawaban = if (jawaban.lowercase() == "a") {
                "Gunting"
            } else if (jawaban.lowercase() == "b") {
                "Kertas"
            } else if (jawaban.lowercase() == "c") {
                "Batu"
            } else {
                "Ngawur"
            }
            jawabanResult = jawaban
            return jawaban
        }

        fun process2(i: Int) {
            if (i == 1) {
                pemain1 = "Pemain " + i + " memilih : " + jawabanResult
                jwbPemain1 = jawabanResult
            } else {
                pemain2 = "Pemain " + i + " memilih : " + jawabanResult
                jwbPemain2 = jawabanResult
            }
        }

        fun process_final() {
            println(pemain1)
            println(pemain2)
            println("")
            println("Hasil :")
            when {
                jwbPemain1 == jwbPemain2 -> println("Draw")
                jwbPemain1 == "Gunting" && jwbPemain2 == "Kertas" -> println("Pemain 1 menang")
                jwbPemain1 == "Gunting" && jwbPemain2 == "Batu" -> println("Pemain 2 menang")
                jwbPemain1 == "Kertas" && jwbPemain2 == "Gunting" -> println("Pemain 2 menang")
                jwbPemain1 == "Kertas" && jwbPemain2 == "Batu" -> println("Pemain 1 menang")
                jwbPemain1 == "Batu" && jwbPemain2 == "Gunting" -> println("Pemain 1 menang")
                jwbPemain1 == "Batu" && jwbPemain2 == "kertas" -> println("Pemain 2 menang")
                jwbPemain1 == "Ngawur" && jwbPemain2 != "Ngawur" -> println("Pemain 2 menang")
                jwbPemain2 == "Ngawur" && jwbPemain1 != "Ngawur" -> println("Pemain 1 menang")
            }
        }

        fun process_playAgain(jawabanPA: String) {
            if (jawabanPA.lowercase() == "y") {
                println("Sedang memuat ulang..")
                timer(initialDelay = 1000L, period = 1000L ) {
                    System.out.flush()
                    main()
                }
            } else {
                println("Yahhh oke deh... bye byee")
            }
        }
    }
}