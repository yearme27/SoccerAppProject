package com.example.soccerappproject.api


import com.example.soccerappproject.model.LeagueResponse
import com.example.soccerappproject.model.SeasonResponse
import com.example.soccerappproject.model.StandingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SoccerService {
    ///leagues
    //https://api-football-standings.azharimm.site/leagues
    @GET("{leagues}")
    suspend fun getSoccerAllLeagues(
        @Path("leagues") leagues: String = "leagues"
    ): Response<LeagueResponse>
    ///leagues/{id}
//    //https://api-football-standings.azharimm.site/leagues/eng.1
//    @GET("leagues/{id}")
//    suspend fun getLeagueByID(
//        @Path("id") id: String
//    ): Response<LeagueIdResponse>
    ///leagues/{id}/seasons
    //https://api-football-standings.azharimm.site/leagues/eng.1/seasons
    @GET("leagues/{id}/seasons")
    suspend fun getSoccerSeasons(
        @Path("id") id: String
    ): Response<SeasonResponse>
    ///leagues/{id}/standings
    //https://api-football-standings.azharimm.site/leagues/eng.1/standings?season=2020&sort=asc
    @GET("leagues/{id}/standings")
    suspend fun getSoccerStanding(
        @Path("id") id: String,
        @Query("season") season: Int,
        @Query("sort") sort: String = "asc"
    ): Response<StandingResponse>




}