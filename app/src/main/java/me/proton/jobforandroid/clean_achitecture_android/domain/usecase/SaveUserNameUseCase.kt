package me.proton.jobforandroid.clean_achitecture_android.domain.usecase

import me.proton.jobforandroid.clean_achitecture_android.domain.models.SaveUserNameParam

class SaveUserNameUseCase {

    fun execute(param: SaveUserNameParam): Boolean {
        return param.name.isNotEmpty()
    }

}