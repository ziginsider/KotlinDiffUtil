package io.github.ziginsider.kotlindiffutil.mock

import io.github.ziginsider.kotlindiffutil.model.User
import java.util.*

/**
 * Created by zigin on 16.01.2018.
 */
class MockDataProvider {
    private val NAME_LENGHT = 7
    private val MAX_AGE = 100

    val data = ArrayList<User>()
    private val TAG = this.javaClass.simpleName

    private fun getLowerCaseAlphabet()
            = CharArray(26) { (it + 97).toChar() }.joinToString("")

    private fun getLowerPartName(): String {
        val lowerAlphabet = getLowerCaseAlphabet()
        val result = StringBuilder()
        val random = Random()

        while (result.length < NAME_LENGHT) {
            val index = (random.nextFloat() * lowerAlphabet.length).toInt()
            result.append(lowerAlphabet[index])
        }
        return result.toString()
    }

    private fun getAge(): Int = Random().nextInt(MAX_AGE) + 1

    init {
        var index = 1
        for (i in 'A'..'Z') {
            for (j in 1..10) {
                data.add(User(index++,
                        i + getLowerPartName(),
                        getAge()))
            }
        }
    }
}