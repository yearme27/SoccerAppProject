package com.example.soccerappproject.api

import com.example.soccerappproject.model.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface SoccerRepository {
    suspend fun getAllSoccerLeagues(leagues: String): Flow<UIState>
    suspend fun getSoccerSeason(id: String): Flow<UIState>
    suspend fun getSoccerStanding(season: Int, id: String, sort: String): Flow<UIState>
}

class SoccerRepositoryImpl(private val service: SoccerService): SoccerRepository{
    override suspend fun getAllSoccerLeagues(leagues: String): Flow<UIState> =
        flow {
            try {
                val response = service.getSoccerAllLeagues(leagues)
                if (response.isSuccessful){
                    emit(response.body()?.let {
                        UIState.Success(it)
                    } ?: throw Exception("Empty Response"))
                } else throw Exception("Failed network call")
            }catch (e: Exception){
                emit(UIState.Error(e))
            }
        }

//   override suspend fun getLeagueById(id: String): Flow<UIState> =
//        flow {
//            try {
//                val response = service.getLeagueByID(id)
//                if (response.isSuccessful) {
//                    emit(response.body()?.let { idResponse ->
//                        UIState.Success(idResponse)
//                    } ?: throw Exception("Empty response"))
//                } else throw Exception("Failed network call")
//            } catch (e: Exception) {
//                emit(UIState.Error(e))
//            }
//        }

    override suspend fun getSoccerSeason(id: String): Flow<UIState> =
        flow {
            try {
                val response = service.getSoccerSeasons(id)
                if (response.isSuccessful){
                    emit(response.body()?.let { seasonResponse ->
                        UIState.Success(seasonResponse)
                    } ?: throw Exception("Empty response"))
                } else throw Exception("Failed network call")
            } catch (e: Exception){
                emit(UIState.Error(e))
            }
        }





    override suspend fun getSoccerStanding(season: Int, id: String, sort: String): Flow<UIState> =
        flow {
            try {
                val response = service.getSoccerStanding(id, season, sort)
                if (response.isSuccessful) {
                    emit(response.body()?.let { standingResponse ->
                        UIState.Success(standingResponse)
                    } ?: throw Exception("Empty response"))
                } else throw Exception("Failed network call")
            } catch (e: Exception) {
                emit(UIState.Error(e))
            }
        }


}