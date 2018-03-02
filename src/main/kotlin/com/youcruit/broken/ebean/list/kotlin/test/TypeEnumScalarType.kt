package com.youcruit.broken.ebean.list.kotlin.test

import io.ebean.config.ScalarTypeConverter

class TypeEnumScalarType : ScalarTypeConverter<TypeEnum, String> {
    override fun wrapValue(scalarType: String) = getEnum(scalarType.toInt())

    override fun unwrapValue(beanType: TypeEnum?) = beanType?.dbValue().toString()

    override fun getNullValue() = null
}