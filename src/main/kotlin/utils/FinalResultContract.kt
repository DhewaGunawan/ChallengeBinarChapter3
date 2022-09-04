package utils

interface ProcessResultContract {
    fun processResult(i: Int, inputUser: String)
    fun processResultWithBot(inputUser: String)
}