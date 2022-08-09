package com.example.soccerappproject.model

import com.google.gson.annotations.SerializedName

/*
    https://api-football-standings.azharimm.site/leagues
     "status": true,
    "data": [
        {
            "id": "arg.1",
            "name": "Argentine Liga Profesional de Fútbol",
            "slug": "argentine-liga-profesional-de-futbol",
            "abbr": "Prim A",
            "logos": {
                "light": "https://a.espncdn.com/i/leaguelogos/soccer/500/1.png",
                "dark": "https://a.espncdn.com/i/leaguelogos/soccer/500-dark/1.png"
            }
        },
        "next": https://api-football-standings.azharimm.site/leagues/arg.1/seasons
        "status": true,
    "data": {
        "name": "Argentine Liga Profesional de Fútbol",
        "desc": "Available seasons standings data",
        "abbreviation": "Prim A",
        "seasons": [
            {
                "year": 2022,
                "startDate": "2022-06-01T04:00Z",
                "endDate": "2022-10-31T04:00Z",
                "displayName": "2022 Argentine Liga Profesional de Fútbol",
                "types": [
                    {
                        "id": "1",
                        "name": "2022 Argentine Liga Profesional",
                        "abbreviation": "2022 Argentine Liga Profesional",
                        "startDate": "2022-06-01T04:00Z",
                        "endDate": "2022-11-01T03:59Z",
                        "hasStandings": true
                    }
                ]
            },

            "next": https://api-football-standings.azharimm.site/leagues/arg.1/standings?season=2020&sort=asc
            "status": true,
    "data": {
        "name": "Argentine Liga Profesional de Fútbol",
        "abbreviation": "Prim A",
        "seasonDisplay": "Group A2",
        "season": 2020,
        "standings": [
            {
                "team": {
                    "id": "17",
                    "uid": "s:600~t:17",
                    "location": "Rosario Central",
                    "name": "Rosario Central",
                    "abbreviation": "ROS",
                    "displayName": "Rosario Central",
                    "shortDisplayName": "Rosario Central",
                    "isActive": true,
                    "logos": [
                        {
                            "href": "https://a.espncdn.com/i/teamlogos/soccer/500/17.png",
                            "width": 500,
                            "height": 500,
                            "alt": "",
                            "rel": [
                                "full",
                                "default"
                            ],
                            "lastUpdated": "2019-05-08T16:07Z"
                        }
                    ]
                },
                "stats": [
                    {
                        "name": "wins",
                        "displayName": "Wins",
                        "shortDisplayName": "W",
                        "description": "Team's current Win-Loss record",
                        "abbreviation": "W",
                        "type": "wins",
                        "value": 3,
                        "displayValue": "3"
                    },
                    {
                        "name": "losses",
                        "displayName": "Losses",
                        "shortDisplayName": "L",
                        "description": "Losses",
                        "abbreviation": "L",
                        "type": "losses",
                        "value": 1,
                        "displayValue": "1"
                    },
                    {
                        "name": "ties",
                        "displayName": "Draws",
                        "shortDisplayName": "D",
                        "description": "Draws",
                        "abbreviation": "D",
                        "type": "ties",
                        "value": 1,
                        "displayValue": "1"
                    },
                    {
                        "name": "gamesPlayed",
                        "displayName": "Games Played",
                        "shortDisplayName": "GP",
                        "description": "Games Played",
                        "abbreviation": "GP",
                        "type": "gamesplayed",
                        "value": 5,
                        "displayValue": "5"
                    },
                    {
                        "name": "pointsFor",
                        "displayName": "Goals For",
                        "shortDisplayName": "F",
                        "description": "Goals For",
                        "abbreviation": "F",
                        "type": "pointsfor",
                        "value": 10,
                        "displayValue": "10"
                    },
                    {
                        "name": "pointsAgainst",
                        "displayName": "Goals Against",
                        "shortDisplayName": "A",
                        "description": "Goals Against",
                        "abbreviation": "A",
                        "type": "pointsagainst",
                        "value": 4,
                        "displayValue": "4"
                    },
                    {
                        "name": "points",
                        "displayName": "Points",
                        "shortDisplayName": "P",
                        "description": "Points",
                        "abbreviation": "P",
                        "type": "points",
                        "value": 10,
                        "displayValue": "10"
                    },
                    {
                        "name": "rankChange",
                        "displayName": "Rank Change",
                        "shortDisplayName": "Rank Change",
                        "description": "Rank Change",
                        "abbreviation": "RC",
                        "type": "rankchange",
                        "value": 0,
                        "displayValue": "0"
                    },
                    {
                        "name": "rank",
                        "displayName": "Rank",
                        "shortDisplayName": "Rank",
                        "description": "Rank",
                        "abbreviation": "R",
                        "type": "rank",
                        "value": 1,
                        "displayValue": "1"
                    },
                    {
                        "name": "pointDifferential",
                        "displayName": "Goal Difference",
                        "shortDisplayName": "GD",
                        "description": "Goal Difference",
                        "abbreviation": "GD",
                        "type": "pointdifferential",
                        "value": 6,
                        "displayValue": "+6"
                    },
                    {
                        "name": "deductions",
                        "displayName": "Point Deductions",
                        "shortDisplayName": "Deductions",
                        "description": "Point Deductions",
                        "abbreviation": "PD",
                        "type": "deductions",
                        "value": 0,
                        "displayValue": ""
                    },
                    {
                        "name": "ppg",
                        "displayName": "Points Per Game",
                        "shortDisplayName": "PPG",
                        "description": "Points Per Game",
                        "abbreviation": "PPG",
                        "type": "ppg",
                        "value": 0,
                        "displayValue": "0"
                    },
                    {
                        "id": "0",
                        "name": "All Splits",
                        "abbreviation": "Total",
                        "displayName": "Overall",
                        "shortDisplayName": "OVER",
                        "description": "Overall Record",
                        "type": "total",
                        "summary": "3-1-1",
                        "displayValue": "3-1-1"
                    }
                ]
            },

 */

data class LeagueResponse(
    val data: List<LeagueItem>
)

data class LeagueItem(
    val id: String,
    val name: String,
    val logos: LogosItem,

)
data class LogosItem(
    val light: String,
    val dark: String
)

data class SeasonResponse(
    val data: LeagueDetails
)
//data class LeagueIdResponse(
//    val data: LeagueItem
//)

data class LeagueDetails(
    val name: String,
    val desc: String,
    val abbreviations: String,
    val seasons: List<SeasonItem>
)

data class SeasonItem(
    val year: Int,
    val startDate: String,
    val endDate: String,
    val displayName: String
)

data class StandingResponse(
    val data: LeagueResult
)
data class LeagueResult(
    val name: String,
    val standings: List<StandingItem>
)

data class StandingItem(
    val team: TeamItem,
    val note: NoteItem,
    val stats: List<StatsData>
)

data class TeamItem(
    val name: String,
    val shortDisplayName: String,
    val logos: List<LogoData>
)

data class LogoData(
    val href: String
)

data class NoteItem(
    val rank: Int,
    val color: String
)

data class StatsData(
    val value: Int
)
