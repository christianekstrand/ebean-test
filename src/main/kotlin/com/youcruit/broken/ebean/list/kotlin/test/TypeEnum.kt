package com.youcruit.broken.ebean.list.kotlin.test

enum class TypeEnum(val number: Int) {
    ONE(1),
    TWO(2);

    fun dbValue() = number

}

fun getEnum(number: Int) = TypeEnum.values().firstOrNull { it.number == number } ?: throw IllegalArgumentException()


