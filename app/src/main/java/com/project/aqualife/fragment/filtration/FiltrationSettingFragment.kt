package com.project.aqualife.fragment.filtration

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.project.aqualife.MainActivity
import com.project.aqualife.databinding.FiltrationSettingFragmentBinding
import com.project.aqualife.viewModel.AuthViewModel
import com.project.aqualife.viewModel.DataViewModel


class FiltrationSettingFragment : Fragment() {

    private var binding : FiltrationSettingFragmentBinding? = null
    private var filtTime = ""
    private lateinit var authViewModel : AuthViewModel
    private lateinit var dataViewModel : DataViewModel

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FiltrationSettingFragmentBinding.inflate(inflater, container, false)

        authViewModel = ViewModelProvider(requireActivity())[AuthViewModel::class.java]
        dataViewModel = ViewModelProvider(requireActivity())[DataViewModel::class.java]

        val timePicker = binding!!.timePicker
        val sdb = binding!!.sundayButton
        val mdb = binding!!.mondayButton
        val tdb = binding!!.tuesdayButton
        val wdb = binding!!.wednesdayButton
        val thdb = binding!!.thursdayButton
        val fdb = binding!!.fridayButton
        val sadb = binding!!.saturdayButton
        val cb1 = binding!!.charge1
        val cb2 = binding!!.charge2
        val cb3 = binding!!.charge3
        val cb4 = binding!!.charge4
        val save = binding!!.saveButton

        var sdbc = 0
        var mdbc = 0
        var tdbc = 0
        var wdbc = 0
        var thdbc = 0
        var fdbc = 0
        var sadbc = 0
        var chargeCount = 0

        val weekArray = listOf(sdb, mdb, tdb, wdb, thdb, fdb, sadb)
        val amountButtonArray = listOf(cb1,cb2,cb3,cb4)
        var (cb1c, cb2c, cb3c, cb4c) = arrayOf(0,0,0,0)

        timePicker.setOnTimeChangedListener { _, hour, minute ->
            filtTime = "$hour:$minute"
        }


        sdb.setOnClickListener {
            sdbc = if(sdbc == 0) {
                sdb.setBackgroundColor(Color.YELLOW)
                1
            } else{
                sdb.setBackgroundColor(Color.WHITE)
                0
            }
        }

        mdb.setOnClickListener {
            mdbc = if(mdbc == 0) {
                mdb.setBackgroundColor(Color.YELLOW)
                1
            } else{
                mdb.setBackgroundColor(Color.WHITE)
                0
            }
        }

        tdb.setOnClickListener {
            tdbc = if(tdbc == 0) {
                tdb.setBackgroundColor(Color.YELLOW)
                1
            } else{
                tdb.setBackgroundColor(Color.WHITE)
                0
            }
        }

        wdb.setOnClickListener {
            wdbc = if(wdbc == 0) {
                wdb.setBackgroundColor(Color.YELLOW)
                1
            } else{
                wdb.setBackgroundColor(Color.WHITE)
                0
            }
        }

        thdb.setOnClickListener {
            thdbc = if(thdbc == 0) {
                thdb.setBackgroundColor(Color.YELLOW)
                1
            } else{
                thdb.setBackgroundColor(Color.WHITE)
                0
            }
        }

        fdb.setOnClickListener {
            fdbc = if(fdbc == 0) {
                fdb.setBackgroundColor(Color.YELLOW)
                1
            } else{
                fdb.setBackgroundColor(Color.WHITE)
                0
            }
        }

        sadb.setOnClickListener {
            sadbc = if(sadbc == 0) {
                sadb.setBackgroundColor(Color.YELLOW)
                1
            } else{
                sadb.setBackgroundColor(Color.WHITE)
                0
            }
        }

        cb1.setOnClickListener {
            if(cb1c == 0) {
                cb1.setBackgroundColor(Color.BLUE)
                cb1c = 1
                chargeCount += 1
            }
            else{
                cb1.setBackgroundColor(Color.WHITE)
                cb1c = 0
                chargeCount -= 1
            }

        }


        cb2.setOnClickListener {
            if(cb2c == 0) {
                cb2.setBackgroundColor(Color.BLUE)
                cb2c = 1
                chargeCount += 1
            }
            else{
                cb2.setBackgroundColor(Color.WHITE)
                cb2c = 0
                chargeCount -= 1
            }

        }

        cb3.setOnClickListener {
            if(cb3c == 0) {
                cb3.setBackgroundColor(Color.BLUE)
                cb3c = 1
                chargeCount += 1
            }
            else{
                cb3.setBackgroundColor(Color.WHITE)
                cb3c = 0
                chargeCount -= 1
            }

        }

        cb4.setOnClickListener {
            if(cb4c == 0) {
                cb4.setBackgroundColor(Color.BLUE)
                cb4c = 1
                chargeCount += 1
            }
            else{
                cb4.setBackgroundColor(Color.WHITE)
                cb4c = 0
                chargeCount -= 1
            }


        }

        dataViewModel.recentIndex.observe(requireActivity()){
            val dayCode = (activity as MainActivity).aquariumList[it].filtDayCode
            val amount = (activity as MainActivity).aquariumList[it].filtAmount
            val startTime = (activity as MainActivity).aquariumList[it].filtStartTime

            val dayCodeToken = dayCode.chunked(1)
            chargeCount = amount.toInt()
            filtTime = startTime

            sdbc = dayCodeToken[0].toInt()
            mdbc = dayCodeToken[1].toInt()
            tdbc = dayCodeToken[2].toInt()
            wdbc = dayCodeToken[3].toInt()
            thdbc = dayCodeToken[4].toInt()
            fdbc =dayCodeToken[5].toInt()
            sadbc = dayCodeToken[6].toInt()

            when (chargeCount) {
                1 -> {
                    cb1c = 1
                }
                2 -> {
                    cb1c = 1
                    cb2c = 1
                }
                3 -> {
                    cb1c = 1
                    cb2c = 1
                    cb3c = 1
                    cb4c = 1
                }
                4 -> {
                    cb1c = 1
                    cb2c = 1
                    cb3c = 1
                    cb4c = 1
                }
            }

            timePicker.hour

            Log.d("일요일","${sdbc},${dayCodeToken}")

            setColor(weekArray, dayCodeToken)
            setFiltAmount(amountButtonArray, amount)
        }

        save.setOnClickListener {
            val dayCode = "${sdbc}${mdbc}${tdbc}${wdbc}${thdbc}${fdbc}${sadbc}"
            authViewModel.changeFiltSetting((activity as MainActivity).getSpinnerData().first, dayCode, filtTime, chargeCount)
            Toast.makeText(context, "환수 설정 완료!!", Toast.LENGTH_LONG).show()
            (activity as MainActivity).onBackPressed()
        }

        return binding!!.root
    }

    private fun setColor(weekArray: List<Button>, dayCodeToken: List<String>) {
        for(i : Int in 0..6 ) {
            if(dayCodeToken[i] == "1") {
                weekArray[i].setBackgroundColor(Color.YELLOW)

            }
        }
    }

    private fun setFiltAmount(amountButtonArray: List<Button>, amount: String) {
        when (amount) {
            "1" -> {
                amountButtonArray[0].setBackgroundColor(Color.BLUE)

            }
            "2" -> {
                amountButtonArray[0].setBackgroundColor(Color.BLUE)
                amountButtonArray[1].setBackgroundColor(Color.BLUE)
            }
            "3" -> {
                amountButtonArray[0].setBackgroundColor(Color.BLUE)
                amountButtonArray[1].setBackgroundColor(Color.BLUE)
                amountButtonArray[2].setBackgroundColor(Color.BLUE)
            }
            "4" -> {
                amountButtonArray[0].setBackgroundColor(Color.BLUE)
                amountButtonArray[1].setBackgroundColor(Color.BLUE)
                amountButtonArray[2].setBackgroundColor(Color.BLUE)
                amountButtonArray[3].setBackgroundColor(Color.BLUE)
            }
            else -> {
                Toast.makeText(context, "환수 양을 조절하세요!", Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}


