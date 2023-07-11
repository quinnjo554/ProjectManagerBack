package com.example.demo.exceptions

class UserAlreadyExistsException(message: String = "Duplicate key") : RuntimeException(message)
