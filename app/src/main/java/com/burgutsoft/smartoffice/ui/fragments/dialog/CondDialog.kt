package com.burgutsoft.smartoffice.ui.fragments.dialog

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.burgutsoft.smartoffice.R
import com.burgutsoft.smartoffice.databinding.DialogCondViewBinding
import com.burgutsoft.smartoffice.extension.hide
import com.burgutsoft.smartoffice.extension.show
import com.burgutsoft.smartoffice.utils.KeyValues.COND_ID
import com.burgutsoft.smartoffice.utils.KeyValues.COOL_HEAT
import com.burgutsoft.smartoffice.utils.KeyValues.ON_OFF
import com.burgutsoft.smartoffice.utils.KeyValues.SPEEDFAN
import com.burgutsoft.smartoffice.utils.KeyValues.SWINGUD
import com.burgutsoft.smartoffice.utils.KeyValues.TEMP_DOWN
import com.burgutsoft.smartoffice.utils.KeyValues.TEMP_UP
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CondDialog: DialogFragment() {
    private var _binding: DialogCondViewBinding? = null
    val viewModel: CondDialogViewModel by viewModels<CondDialogViewModelImp>()
    private val binding get() = _binding!!
    private var cond_id = -1

    private val TAG = "CondDialog"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cond_id = arguments?.getInt(COND_ID)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogCondViewBinding.inflate(inflater, container, false )
        val root: View = binding.root

        initViews()
        return root
    }

    fun initViews() {

        condInfo()

        binding.ivBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

        //click cond cool orb heat
        binding.btnCondMode.setOnClickListener {
            Log.d(TAG, "initViews: click")
            viewModel.updateCond(cond_id, COOL_HEAT){
                it.onSuccess { res ->
                    scoolheat(res.status!!)
                }
                it.onFailure {
                    Log.d(TAG, "initViews: onFailure")
                }
            }
        }

        //click cond on or off
        binding.ivCondOffOn.setOnClickListener {
            viewModel.updateCond(cond_id, ON_OFF){
                it.onSuccess { res ->
                    sonoff(res.status!!)
                }
                it.onFailure {
                }
            }
        }

        // click cond direction
        binding.ivCondDirection.setOnClickListener {
            viewModel.updateCond(cond_id, SWINGUD){
                it.onSuccess { res ->
                    swingud(res.status!!)
                }
                it.onFailure {
                }
            }
        }

        binding.ivTempPlus.setOnClickListener {
           viewModel.updateCond(cond_id, TEMP_UP){
               it.onSuccess { res ->
                  binding.tvTempNum.text = res.status.toString()
               }
               it.onFailure {
               }
           }
        }

        binding.ivTempMinus.setOnClickListener {
            viewModel.updateCond(cond_id, TEMP_DOWN){
                it.onSuccess { res ->
                    binding.tvTempNum.text = res.status.toString()
                }
                it.onFailure {
                }
            }
        }

        binding.cl.setOnClickListener {
            viewModel.updateCond(cond_id, SPEEDFAN){
                it.onSuccess { res ->
                    sspeedfan(res.status!!)
                }
                it.onFailure {
                }
            }
        }
    }

    private fun condInfo() {
        viewModel.condInfo(cond_id){
            it.onSuccess { info ->
                binding.tvTempNum.text = info.temp

                // cond on or off
                sonoff(info.sonoff!!.toInt())

                //cond direction on or off
                swingud(info.sswingud!!.toInt())

                //cond cool orb heat
                scoolheat(info.scoolheat!!.toInt())

                //cond control speed
                sspeedfan(info.sspeedfan!!.toInt())
            }
            it.onFailure {
            }
        }
    }

    //cond control speed
    private fun sspeedfan(speedfan: Int){
        if (speedfan == 1){
            binding.tvCondAuto.hide()
            binding.ivSpeed.show()
            binding.ivSpeed.setImageResource(R.drawable.ic_cond_speed_1)
        }else if (speedfan == 2){
            binding.tvCondAuto.hide()
            binding.ivSpeed.show()
            binding.ivSpeed.setImageResource(R.drawable.ic_cond_speed_2)
        }else if (speedfan == 3){
            binding.tvCondAuto.hide()
            binding.ivSpeed.show()
            binding.ivSpeed.setImageResource(R.drawable.ic_cond_speed_3)
        }else{
            binding.tvCondAuto.show()
            binding.ivSpeed.hide()
        }
    }

    //cond cool or heat
    private fun scoolheat(scoolheat: Int){
        if (scoolheat == 1){
            binding.clModeColling.setBackgroundResource(R.drawable.view_mode_on)
            binding.ivModeColling.setImageResource(R.drawable.ic_cooling_on)

            binding.clModeHeating.setBackgroundResource(R.drawable.view_mode_off)
            binding.ivModeHeating.setImageResource(R.drawable.ic_heating_off)
        }else{
            binding.clModeColling.setBackgroundResource(R.drawable.view_mode_off)
            binding.ivModeColling.setImageResource(R.drawable.ic_cooling_off)

            binding.clModeHeating.setBackgroundResource(R.drawable.view_mode_on)
            binding.ivModeHeating.setImageResource(R.drawable.ic_heating_on)
        }
    }

    //cond on or off
    private fun sonoff(sonoff: Int){
        if (sonoff == 1){
            binding.ivCondOffOn.setImageResource(R.drawable.ic_cond_on)
        }else if (sonoff == 0){
            binding.ivCondOffOn.setImageResource(R.drawable.ic_cond_off)
        }
    }

    //cond direction on or off
    private fun swingud(swingud: Int){
        if (swingud == 1){
            binding.ivCondDirection.setImageResource(R.drawable.ic_direction_on)
        }else{
            binding.ivCondDirection.setImageResource(R.drawable.ic_direction_off)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}