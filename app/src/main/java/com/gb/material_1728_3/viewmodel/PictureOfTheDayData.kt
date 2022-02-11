package com.gb.material_1728_3.viewmodel

import com.gb.material_1728_3.repository.PDOServerResponse

sealed class PictureOfTheDayData {
    data class Success(val serverResponse: PDOServerResponse):PictureOfTheDayData()
    data class Error(val error:Throwable):PictureOfTheDayData()
    data class Loading(val process: Int?):PictureOfTheDayData()
}