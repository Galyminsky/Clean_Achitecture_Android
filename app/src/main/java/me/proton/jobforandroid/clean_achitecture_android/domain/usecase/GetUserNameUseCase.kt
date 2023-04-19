package me.proton.jobforandroid.clean_achitecture_android.domain.usecase

import me.proton.jobforandroid.clean_achitecture_android.domain.models.UserName

class GetUserNameUseCase {

    fun execute(): UserName {
        return UserName(firstName = "Lisander", lastName = "Smith")
    }

}