package com.example.sportpractical.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.sportpractical.databinding.FragmentMatchInfoBinding
import com.example.sportpractical.models.SportsData
import com.example.sportpractical.utils.appLoader
import com.example.sportpractical.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MatchInfoFragment : Fragment() {

    private var _binding: FragmentMatchInfoBinding? = null
    private val binding get() = _binding!!

    private val mainViewModel: MainViewModel by activityViewModels()
    private val loader by appLoader()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMatchInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupObserver()
    }

    /**
     * Handle the observer of the view model
     */
    private fun setupObserver() {
        lifecycleScope.launch {
            mainViewModel.sportsDataFlow.collect {
                loader showIf (it == null)
                it?.let { updateUi(it) }
            }
        }
    }

    /**
     * View initialization
     */
    private fun setupView() {
        with(binding) {
            btnNext.setOnClickListener {
                findNavController().navigate(MatchInfoFragmentDirections.actionMatchInfoFragmentToTeamInfoFragment())
            }
        }
    }

    /**
     * Update the UI after the get data from the API
     */
    private fun updateUi(data: SportsData) {
        with(binding) {
            val team1 = data.teams[data.matchdetail.teamHome]?.nameFull
            val team2 = data.teams[data.matchdetail.teamAway]?.nameFull
            tvTeamName.text = "$team1 vs $team2"
            tvMatchDetails.text = """
                Date: ${data.matchdetail.match.date} ${data.matchdetail.match.time}
                Venue: ${data.matchdetail.venue.name}
            """.trimIndent()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}