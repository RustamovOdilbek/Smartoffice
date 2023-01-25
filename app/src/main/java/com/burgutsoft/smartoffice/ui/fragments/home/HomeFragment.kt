package com.burgutsoft.smartoffice.ui.fragments.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.burgutsoft.smartoffice.R
import com.burgutsoft.smartoffice.databinding.FragmentHomeBinding
import com.burgutsoft.smartoffice.utils.KeyValues.COND_ID
import com.burgutsoft.smartoffice.utils.changeDateFormat
import com.burgutsoft.smartoffice.utils.changeTimeFormat
import com.burgutsoft.smartoffice.utils.temp
import com.burgutsoft.smartoffice.utils.tempBool
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    val viewModel: HomeViewModel by viewModels<HomeVieweModelImp>()

    private val TAG = "HomeFragment"

    private lateinit var mapRooms: HashMap<Int, TextView>
    private lateinit var mapRoomTemps: HashMap<Int, TextView>
    private lateinit var mapRoomConds: HashMap<Int, ImageView>
    private lateinit var mapRoomLamps: HashMap<Int, ImageView>
    private lateinit var mapRoomViews: HashMap<Int, ConstraintLayout>

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        saveConst()
        initViews()
        controllerLamp()
        controllerCond()

        val handler = Handler()
        val runnable = object : Runnable {
            override fun run() {
                initViews()
                handler.postDelayed(this, 10000) //Update every minute
            }
        }
        handler.postDelayed(runnable, 10000)

        return root
    }

    private fun controllerCond() {
        binding.ivAircond1.setOnClickListener {
            updateCond(12)
        }
        binding.ivAircond2.setOnClickListener {
           updateCond(1)
        }
        binding.ivAircond3.setOnClickListener {
           updateCond(13)
        }
        binding.ivAircond4.setOnClickListener {
           updateCond(15)
        }
        binding.ivAircond5.setOnClickListener {
           updateCond(16)
        }
        binding.ivAircond6.setOnClickListener {
           updateCond(22)
        }
        binding.ivAircond7.setOnClickListener {
           updateCond(21)
        }
        binding.ivAircond8.setOnClickListener {
           updateCond(20)
        }
        binding.ivAircond9.setOnClickListener {
            updateCond(14)
        }
        binding.ivAircond10.setOnClickListener {
            updateCond(6)
        }
        binding.ivAircond11.setOnClickListener {
            updateCond(7)
        }
        binding.ivAircond12.setOnClickListener {
            updateCond(8)
        }
        binding.ivAircond13.setOnClickListener {
            updateCond(5)
        }
        binding.ivAircond14.setOnClickListener {
            updateCond(3)
        }
        binding.ivAircond15.setOnClickListener {
            updateCond(9)
        }
        binding.ivAircond16.setOnClickListener {
            updateCond(10)
        }
        binding.ivAircond17.setOnClickListener {
            updateCond(11)
        }
        binding.ivAircond18.setOnClickListener {
            updateCond(19)
        }
        binding.ivAircond19.setOnClickListener {
            updateCond(17)
        }
        binding.ivAircond20.setOnClickListener {
            updateCond(18)
        }
        binding.ivAircond22.setOnClickListener {
            updateCond(4)
        }
        binding.ivAircond23.setOnClickListener {
            updateCond(23)
        }
    }

    private fun controllerLamp() {
        binding.ivLight1.setOnClickListener {
            updateLamp(1)
        }
        binding.ivLight2.setOnClickListener {
            updateLamp(2)
        }
        binding.ivLight3.setOnClickListener {
            updateLamp(3)
        }
        binding.ivLight4.setOnClickListener {
            updateLamp(4)
        }
        binding.ivLight5.setOnClickListener {
            updateLamp(5)
        }
        binding.ivLight6.setOnClickListener {
            updateLamp(6)
        }
        binding.ivLight7.setOnClickListener {
            updateLamp(7)
        }
        binding.ivLight8.setOnClickListener {
            updateLamp(8)
        }
        binding.ivLight9.setOnClickListener {
            updateLamp(9)
        }
        binding.ivLight10.setOnClickListener {
            updateLamp(10)
        }
        binding.ivLight11.setOnClickListener {
            updateLamp(11)
        }
        binding.ivLight12.setOnClickListener {
            updateLamp(12)
        }
        binding.ivLight13.setOnClickListener {
            updateLamp(13)
        }
        binding.ivLight14.setOnClickListener {
            updateLamp(14)
        }
        binding.ivLight15.setOnClickListener {
            updateLamp(15)
        }
        binding.ivLight16.setOnClickListener {
            updateLamp(16)
        }
        binding.ivLight17.setOnClickListener {
            updateLamp(17)
        }
        binding.ivLight18.setOnClickListener {
            updateLamp(18)
        }
        binding.ivLight19.setOnClickListener {
            updateLamp(19)
        }
        binding.ivLight20.setOnClickListener {
            updateLamp(20)
        }
        binding.ivLight21.setOnClickListener {
            updateLamp(21)
        }
    }

    private fun saveConst() {
        mapRooms = HashMap()
        mapRooms.put(1, binding.tvRoomName1)
        mapRooms.put(2, binding.tvRoomName2)
        mapRooms.put(3, binding.tvRoomName3)
        mapRooms.put(4, binding.tvRoomName4)
        mapRooms.put(5, binding.tvRoomName5)
        mapRooms.put(6, binding.tvRoomName6)
        mapRooms.put(7, binding.tvRoomName7)
        mapRooms.put(8, binding.tvRoomName8)
        mapRooms.put(9, binding.tvRoomName9)
        mapRooms.put(10, binding.tvRoomName10)
        mapRooms.put(11, binding.tvRoomName11)
        mapRooms.put(12, binding.tvRoomName12)
        mapRooms.put(13, binding.tvRoomName13)
        mapRooms.put(14, binding.tvRoomName14)
        mapRooms.put(15, binding.tvRoomName15)
        mapRooms.put(16, binding.tvRoomName16)
        mapRooms.put(17, binding.tvRoomName17)
        mapRooms.put(18, binding.tvRoomName18)
        mapRooms.put(19, binding.tvRoomName19)
        mapRooms.put(20, binding.tvRoomName20)
        mapRooms.put(21, binding.tvRoomName21)
        mapRooms.put(22, binding.tvRoomName22)
        mapRooms.put(23, binding.tvRoomName23)

        mapRoomViews = HashMap()
        mapRoomViews.put(1, binding.view1)
        mapRoomViews.put(2, binding.view2)
        mapRoomViews.put(3, binding.view3)
        mapRoomViews.put(4, binding.view4)
        mapRoomViews.put(5, binding.view5)
        mapRoomViews.put(6, binding.view6)
        mapRoomViews.put(7, binding.view7)
        mapRoomViews.put(8, binding.view8)
        mapRoomViews.put(9, binding.view9)
        mapRoomViews.put(10, binding.view10)
        mapRoomViews.put(11, binding.view11)
        mapRoomViews.put(12, binding.view12)
        mapRoomViews.put(13, binding.view13)
        mapRoomViews.put(14, binding.view14)
        mapRoomViews.put(15, binding.view15)
        mapRoomViews.put(16, binding.view16)
        mapRoomViews.put(17, binding.view17)
        mapRoomViews.put(18, binding.view18)
        mapRoomViews.put(19, binding.view19)
        mapRoomViews.put(20, binding.view20)
        mapRoomViews.put(21, binding.view21)
        mapRoomViews.put(22, binding.view22)
        mapRoomViews.put(23, binding.view23)

        mapRoomTemps = HashMap()
        mapRoomTemps.put(1, binding.tvRoomTemp2)
        mapRoomTemps.put(3, binding.tvRoomTemp14)
        mapRoomTemps.put(4, binding.tvRoomTemp22)
        mapRoomTemps.put(5, binding.tvRoomTemp13)
        mapRoomTemps.put(6, binding.tvRoomTemp10)
        mapRoomTemps.put(7, binding.tvRoomTemp11)
        mapRoomTemps.put(8, binding.tvRoomTemp12)
        mapRoomTemps.put(9, binding.tvRoomTemp15)
        mapRoomTemps.put(10, binding.tvRoomTemp16)
        mapRoomTemps.put(11, binding.tvRoomTemp17)
        mapRoomTemps.put(12, binding.tvRoomTemp1)
        mapRoomTemps.put(13, binding.tvRoomTemp3)
        mapRoomTemps.put(14, binding.tvRoomTemp9)
        mapRoomTemps.put(15, binding.tvRoomTemp4)
        mapRoomTemps.put(16, binding.tvRoomTemp5)
        mapRoomTemps.put(17, binding.tvRoomTemp19)
        mapRoomTemps.put(18, binding.tvRoomTemp20)
        mapRoomTemps.put(19, binding.tvRoomTemp18)
        mapRoomTemps.put(20, binding.tvRoomTemp8)
        mapRoomTemps.put(21, binding.tvRoomTemp7)
        mapRoomTemps.put(22, binding.tvRoomTemp6)
        mapRoomTemps.put(23, binding.tvRoomTemp23)

        mapRoomConds = HashMap()
        mapRoomConds.put(1, binding.ivAircond2)
        mapRoomConds.put(3, binding.ivAircond14)
        mapRoomConds.put(4, binding.ivAircond22)
        mapRoomConds.put(5, binding.ivAircond13)
        mapRoomConds.put(6, binding.ivAircond10)
        mapRoomConds.put(7, binding.ivAircond11)
        mapRoomConds.put(8, binding.ivAircond12)
        mapRoomConds.put(9, binding.ivAircond15)
        mapRoomConds.put(10, binding.ivAircond16)
        mapRoomConds.put(11, binding.ivAircond17)
        mapRoomConds.put(12, binding.ivAircond1)
        mapRoomConds.put(13, binding.ivAircond3)
        mapRoomConds.put(14, binding.ivAircond9)
        mapRoomConds.put(15, binding.ivAircond4)
        mapRoomConds.put(16, binding.ivAircond5)
        mapRoomConds.put(17, binding.ivAircond19)
        mapRoomConds.put(18, binding.ivAircond20)
        mapRoomConds.put(19, binding.ivAircond18)
        mapRoomConds.put(20, binding.ivAircond8)
        mapRoomConds.put(21, binding.ivAircond7)
        mapRoomConds.put(22, binding.ivAircond6)
        mapRoomConds.put(23, binding.ivAircond23)

        mapRoomLamps = HashMap()
        mapRoomLamps.put(1, binding.ivLight1)
        mapRoomLamps.put(2, binding.ivLight2)
        mapRoomLamps.put(3, binding.ivLight3)
        mapRoomLamps.put(4, binding.ivLight4)
        mapRoomLamps.put(5, binding.ivLight5)
        mapRoomLamps.put(6, binding.ivLight6)
        mapRoomLamps.put(7, binding.ivLight7)
        mapRoomLamps.put(8, binding.ivLight8)
        mapRoomLamps.put(9, binding.ivLight9)
        mapRoomLamps.put(10, binding.ivLight10)
        mapRoomLamps.put(11, binding.ivLight11)
        mapRoomLamps.put(12, binding.ivLight12)
        mapRoomLamps.put(13, binding.ivLight13)
        mapRoomLamps.put(14, binding.ivLight14)
        mapRoomLamps.put(15, binding.ivLight15)
        mapRoomLamps.put(16, binding.ivLight16)
        mapRoomLamps.put(17, binding.ivLight17)
        mapRoomLamps.put(18, binding.ivLight18)
        mapRoomLamps.put(19, binding.ivLight19)
        mapRoomLamps.put(20, binding.ivLight20)
        mapRoomLamps.put(21, binding.ivLight21)


    }

    @SuppressLint("NewApi")
    private fun initViews() {

        //get room name
        viewModel.getRooms {
            it.onSuccess { allRooms ->
                allRooms.forEach { roomsResponse ->
                    mapRooms[roomsResponse.roomid]!!.text = roomsResponse.name

                   // Log.d(TAG, "initViews: ${mapRoomViews[roomsResponse.roomid]}" )



                        val marginParams = mapRoomViews[roomsResponse.roomid]!!.getLayoutParams() as ViewGroup.MarginLayoutParams

                        marginParams.setMargins(roomsResponse.pleft!!.toInt() -5,
                            roomsResponse.ptop!!.toInt() + 35,
                            0, //notice only changing right margin
                            marginParams.bottomMargin);

//                        Log.d(TAG, "initViews: ${roomsResponse.pleft!!.toInt()}")
//                        Log.d(TAG, "initViews: ${roomsResponse.ptop!!.toInt()}")
//                        val lp = ConstraintLayout.LayoutParams(mapRoomViews[roomsResponse.roomid]!!.getLayoutParams())
//                        lp.setMargins(724, 120, 0, 0)
//                        mapRoomViews[roomsResponse.roomid]!!.setLayoutParams(lp)
                    }

            }
            it.onFailure {
            }
        }

        //get cont on or off
        viewModel.getAllCond {
            it.onSuccess { allCond ->
                allCond.forEach { condResponse ->
                    mapRoomTemps[condResponse.condid]!!.text = temp(condResponse.temp!!)

                    if (condResponse.status!!.toInt() == 0) {
                        Glide.with(requireActivity()).load(R.drawable.ic_aircond_off).into(
                            mapRoomConds[condResponse.condid]!!
                        )
                    } else {
                        Glide.with(requireActivity()).load("http://10.69.69.188/img/air-cond2.gif")
                            .into(
                                mapRoomConds[condResponse.condid]!!
                            )
                    }
                }
            }
            it.onFailure {
            }
        }

        //get lamp on or off
        viewModel.getAllLamps {
            it.onSuccess { allLamps ->
                allLamps.forEach { roomLamp ->
                    if (roomLamp.status!!.toInt() == 0) {
                        Glide.with(requireActivity()).load(R.drawable.ic_light_off).into(
                            mapRoomLamps[roomLamp.lampid]!!
                        )
                    } else {
                        Glide.with(requireActivity()).load(R.drawable.ic_light_on).into(
                            mapRoomLamps[roomLamp.lampid]!!
                        )
                    }
                }
            }
            it.onFailure {

            }
        }

        //get outside and in office temp
        viewModel.getTemp {
            it.onSuccess { temp ->
                binding.tvOfficeTemp.text = temp(temp.intemp!!)
                binding.tvOutsideTemp.text = temp(temp.outtemp!!)

                if (tempBool(temp.intemp!!)){
                    binding.ivOfficeTewmp.setImageResource(R.drawable.ic_hot_temp)
                }else{
                    binding.ivOfficeTewmp.setImageResource(R.drawable.ic_cold_temp)
                }

                if (tempBool(temp.outtemp!!)){
                    binding.ivOutsideTewmp.setImageResource(R.drawable.ic_hot_temp)
                }else{
                    binding.ivOutsideTewmp.setImageResource(R.drawable.ic_cold_temp)
                }
            }
            it.onFailure {

            }
        }

        //get the current time and date
        viewModel.getDate {
            it.onSuccess { date ->
                binding.tvDate.text = changeDateFormat(date.date!!)

                binding.tvTime.text = changeTimeFormat(date.date!!)
            }
            it.onFailure {
            }
        }
    }

    fun updateLamp(lampid: Int){
        viewModel.updateLamp(lampid){
            it.onSuccess { update ->
                if (update.status == 1){
                    mapRoomLamps[lampid]!!.setImageResource(R.drawable.ic_light_on)
                }else{
                    mapRoomLamps[lampid]!!.setImageResource(R.drawable.ic_light_off)
                }
            }
            it.onFailure {
            }
        }
    }

    fun updateCond(condid: Int){
        findNavController().navigate(R.id.action_homeFragment_to_condDialog, bundleOf(COND_ID to condid))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}