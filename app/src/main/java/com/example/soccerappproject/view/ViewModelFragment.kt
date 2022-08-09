package com.example.soccerappproject.view

import androidx.fragment.app.Fragment
import com.example.soccerappproject.di.DI

open class ViewModelFragment: Fragment() {

    protected val viewModel by lazy {
        DI.provideViewModel(requireActivity())
    }
}