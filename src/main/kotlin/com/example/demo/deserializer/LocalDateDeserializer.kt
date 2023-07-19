package com.example.demo.deserializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import java.io.IOException
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class LocalDateDeserializer : JsonDeserializer<LocalDate>() {
    @Throws(IOException::class)
    override fun deserialize(parser: JsonParser, context: DeserializationContext): LocalDate {
        val dateString = parser.text
        val formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy")
        return LocalDate.parse(dateString, formatter)
    }
}
