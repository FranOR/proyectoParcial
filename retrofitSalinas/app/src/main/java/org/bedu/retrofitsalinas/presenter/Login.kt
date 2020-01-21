package org.bedu.retrofitsalinas.presenter

import org.bedu.retrofitsalinas.model.loginSend

interface Login {
    fun sendLogin(loginSend: loginSend)
}