package com.gb.material_1728_3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gb.material_1728_3.BuildConfig
import com.gb.material_1728_3.repository.PDOServerResponse
import com.gb.material_1728_3.repository.PictureOfTheDayRetrofitImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PictureOfTheDayViewModel(
    private val liveData: MutableLiveData<PictureOfTheDayData> = MutableLiveData(),
    private val pictureOfTheDayRetrofitImpl: PictureOfTheDayRetrofitImpl = PictureOfTheDayRetrofitImpl()
) : ViewModel() {
    fun getData(): LiveData<PictureOfTheDayData> {
        return liveData
    }

    fun sendRequest() {
        liveData.postValue(PictureOfTheDayData.Loading(null))
        pictureOfTheDayRetrofitImpl.getRetrofitImpl().getPictureOfTheDay(BuildConfig.NASA_API_KEY)
            .enqueue(
                object : Callback<PDOServerResponse> {
                    override fun onResponse(
                        call: Call<PDOServerResponse>,
                        response: Response<PDOServerResponse>
                    ) {
                        if (response.isSuccessful && response.body() != null) {
                            response.body()?.let {
                                liveData.postValue(PictureOfTheDayData.Success(it))
                            }

                        } else {
                            // TODO HW вывести ошибку
                        }

                    }

                    override fun onFailure(call: Call<PDOServerResponse>, t: Throwable) {
                        // TODO HW
                    }
                }
            )
    }
}