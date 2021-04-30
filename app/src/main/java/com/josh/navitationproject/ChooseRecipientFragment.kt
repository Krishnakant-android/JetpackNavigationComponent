package com.josh.navitationproject

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.josh.navitationproject.module.Money
import kotlinx.android.synthetic.main.fragment_choose_recipient.*


class ChooseRecipientFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.next_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.next_btn -> {
                if (!TextUtils.isEmpty(input_recipient.text.toString())) {
                    val money = Money("5667788", input_recipient.text.toString())
                    val action =
                        ChooseRecipientFragmentDirections.actionChooseRecepientFragmentToSpecifiedAmountFragment()
                    action.money = money
                    navController.navigate(action)
//                    val bundle = bundleOf("recipient" to input_recipient.text.toString())
//                    navController!!.navigate(
//                        R.id.action_chooseRecepientFragment_to_specifiedAmountFragment,
//                        bundle
//                    )
                } else {
                    Toast.makeText(activity, "Enter a name", Toast.LENGTH_SHORT).show()
                }
            }

            R.id.cancel_btn -> requireActivity().onBackPressed()
        }
    }
}