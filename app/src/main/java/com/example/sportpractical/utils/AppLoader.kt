package com.example.sportpractical.utils

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.ViewGroup.LayoutParams
import androidx.appcompat.app.AppCompatDialog
import androidx.fragment.app.Fragment
import com.example.sportpractical.databinding.LoaderBinding

/**
 * Universal loader
 * Use case: Create a lazy object with below method #appLoader()
 */
class AppLoader(context: Context) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = LoaderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window?.apply {
            setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }

    infix fun showIf(condition: Boolean) {
        if (condition) show() else dismiss()
    }
}

fun Fragment.appLoader(): Lazy<AppLoader> = lazy {
    AppLoader(requireContext())
}