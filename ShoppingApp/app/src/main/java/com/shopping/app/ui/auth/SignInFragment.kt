package com.shopping.app.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.shopping.app.R
import com.shopping.app.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {

    private lateinit var bnd: FragmentSignInBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        bnd = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_in, container, false)
        init()
        return bnd.root

    }

    private fun init(){



    }

}