package com.example.demo.exceptions

class UserNotFoundException(message: String = "User not found") : RuntimeException(message)
