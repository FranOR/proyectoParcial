package org.bedu.retrofitsalinas.view

interface LoginView {
    fun getLoginResponse(answer: String)
    fun getLoginData(id: Int, isDoctor: Boolean)
}