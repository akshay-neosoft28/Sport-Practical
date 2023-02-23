package com.example.sportpractical.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportpractical.models.Player
import com.example.sportpractical.models.SportsData
import com.example.sportpractical.repositories.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepo: MainRepo
) : ViewModel() {


    val sportsDataFlow = MutableStateFlow<SportsData?>(null)
    val playersFlow = MutableStateFlow(listOf<Player>())

    init {
        fetchSportsData()
    }

    private fun fetchSportsData() {
        viewModelScope.launch(Dispatchers.IO) {
            mainRepo.getSportsData().onSuccess {
                sportsDataFlow.value = it

                arrangePlayer(0)
            }.onFailure {
                it.printStackTrace()
            }
        }
    }

    fun arrangePlayer(type: Int) {
        when (type) {
            0 -> {
                val allPlayers = mutableListOf<Player>()
                sportsDataFlow.value?.teams?.values?.forEach { team ->
                    allPlayers.addAll(team.players.values)
                }
                playersFlow.value = allPlayers
            }
            1 -> {
                sportsDataFlow.value?.let { data ->
                    val team1 = data.teams[data.matchdetail.teamHome]
                    playersFlow.value = team1?.players?.values?.toList() ?: listOf()
                }
            }
            2 -> {
                sportsDataFlow.value?.let { data ->
                    val team2 = data.teams[data.matchdetail.teamAway]
                    playersFlow.value = team2?.players?.values?.toList() ?: listOf()
                }
            }
        }
    }
}