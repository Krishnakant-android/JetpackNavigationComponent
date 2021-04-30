package com.josh.navitationproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.josh.navitationproject.module.Money
import kotlinx.android.synthetic.main.fragment_confirmation.*


class ConfirmationFragment : Fragment() {
    lateinit var recipient: String
    lateinit var money: Money
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = requireArguments().getString("recipient").toString()
        money = requireArguments().getParcelable("amount")!!

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        val amount = money.amount
        val confirmationMessage = "You have sent $amount to $recipient"
        confirmation_message.text = confirmationMessage

        done_transactions_btn.setOnClickListener {
            navController!!.navigate(
                R.id.action_confirmatonFragment_to_mainFragment,null)
        }
    }
}