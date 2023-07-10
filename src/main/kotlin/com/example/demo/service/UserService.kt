package com.example.demo.service

import com.example.demo.exceptions.UserNotFoundException
import com.example.demo.models.User
import com.example.demo.repository.UserRepo
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepo: UserRepo) {

    fun getUserByEmail(email: String): User {
        return userRepo.findByEmail(email) ?: throw UserNotFoundException() // think about security and what the exception should return
    }

    

    /**
     * @PostMapping("/post/pokemon-to-trainer")
     *     fun addPokemonToTrainer(@RequestBody pokeTrainerRequest: PokeTrainerRequest) {
     *         return pokeTrainerService.addPokemonToTrainer(pokeTrainerRequest)
     *
     */
}
