package com.example.soccerappproject.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soccerappproject.api.SoccerRepository
import com.example.soccerappproject.model.LeagueItem
import com.example.soccerappproject.model.SeasonItem
import com.example.soccerappproject.model.UIState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import okhttp3.Dispatcher

const val TAG = "SoccerViewModel"
class SoccerViewModel(
    private val repository: SoccerRepository,
    private val dispatcher: CoroutineDispatcher
    ): ViewModel(){

    private val _allLeagueListData = MutableLiveData<UIState>()
    val allLeagueListData: LiveData<UIState> get() = _allLeagueListData


    private val _allSeasonListData = MutableLiveData<UIState>()
    val allSeasonListData: LiveData<UIState> get() = _allSeasonListData

    private val _allStandingListData = MutableLiveData<UIState>()
    val allStandingListData: LiveData<UIState> get() = _allStandingListData

    private val coroutineExceptionHandler by lazy {
        CoroutineExceptionHandler{ coroutineContext, throwable ->
            Log.e(TAG, "Context: $coroutineContext\nMessage: ${throwable.localizedMessage}", throwable)
        }
    }

    private val viewModelSafeScope by lazy {
        viewModelScope + coroutineExceptionHandler
    }

    var shouldLoadId = false
    var startPage = "leagues"
    var currentId = ""

    fun getDemLeagues(league: String){
        viewModelSafeScope.launch(dispatcher) {
            repository.getAllSoccerLeagues(league).collect{
                _allLeagueListData.postValue(it)
            }
        }
    }


    fun getDemSeason(id: String){
        viewModelSafeScope.launch(dispatcher) {
            repository.getSoccerSeason(id).collect{
                _allSeasonListData.postValue(it)

            }
        }
    }

    fun getDemStanding(season: Int, id: String){
        viewModelSafeScope.launch(dispatcher) {
            repository.getSoccerStanding(season, id, "asc").collect{
                _allStandingListData.postValue(it)
            }
        }
    }



    fun setLoading(){
        if ( shouldLoadId) _allSeasonListData.value = UIState.Loading
        else _allLeagueListData.value =UIState.Loading
    }

    fun setLoadingSeason(){ _allSeasonListData.value = UIState.Loading}

    fun setLoadingStanding(){ _allStandingListData.value = UIState.Loading}

    fun setSuccessForId(id: String) { _allSeasonListData.value = UIState.Success(id)}

}