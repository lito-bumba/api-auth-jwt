package com.litobumba.plugins

import com.litobumba.authenticate
import com.litobumba.data.user.UserDataSource
import com.litobumba.getSecretInfo
import com.litobumba.security.hashing.HashingService
import com.litobumba.security.token.TokenConfig
import com.litobumba.security.token.TokenService
import com.litobumba.signIn
import com.litobumba.signUp
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*

fun Application.configureRouting(
    userDataSource: UserDataSource,
    hashingService: HashingService,
    tokenService: TokenService,
    tokenConfig: TokenConfig
) {
    routing {
        signIn(userDataSource, hashingService, tokenService, tokenConfig)
        signUp(hashingService, userDataSource)
        authenticate()
        getSecretInfo()
    }
}
