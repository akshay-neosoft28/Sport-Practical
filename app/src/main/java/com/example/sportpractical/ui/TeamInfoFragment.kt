package com.example.sportpractical.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportpractical.R
import com.example.sportpractical.databinding.FragmentTeamInfoBinding
import com.example.sportpractical.viewmodels.MainViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TeamInfoFragment : Fragment() {

    private var _binding: FragmentTeamInfoBinding? = null
    private val binding get() = _binding!!

    private val mainViewModel: MainViewModel by activityViewModels()
    private val args: TeamInfoFragmentArgs by navArgs()
    private val playerAdapter = PlayerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTeamInfoBinding.inflate(inflater, container, false)
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
            mainViewModel.playersFlow.collect {
                playerAdapter.submitList(it)
            }
        }
        lifecycleScope.launch {
            args.data.let {
                val team1 = it.teams[it.matchdetail.teamHome]?.nameFull
                val team2 = it.teams[it.matchdetail.teamAway]?.nameFull
                binding.chipTeamA.text = team1
                binding.chipTeamB.text = team2
            }
        }
    }

    /**
     * View initialization
     */
    private fun setupView() {
        with(binding) {
            rvPlayer.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(requireContext())
                adapter = playerAdapter
            }
            playerAdapter.onClick = {
                val style = """
                    Batting Style: ${it.batting.style}
                    Bowling Style: ${it.bowling.style}
                """.trimIndent()

                MaterialAlertDialogBuilder(requireContext()).apply {
                    setMessage(style)
                    show()
                }
            }
            cgFilter.setOnCheckedChangeListener { group, checkedIds ->
                when (checkedIds) {
                    (R.id.chip_all) -> {
                        mainViewModel.arrangePlayer(args.data,0)
                    }
                    (R.id.chip_team_a) -> {
                        mainViewModel.arrangePlayer(args.data,1)
                    }
                    (R.id.chip_team_b) -> {
                        mainViewModel.arrangePlayer(args.data,2)
                    }
                }
            }
            mainViewModel.arrangePlayer(args.data,0)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}