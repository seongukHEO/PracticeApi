package kr.co.seonguk.application.publicdatause

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.seonguk.application.publicdatause.databinding.ActivityInfoBinding
import kr.co.seonguk.application.publicdatause.databinding.ActivityInfoOneBinding

class InfoOneActivity : AppCompatActivity() {

    lateinit var binding: ActivityInfoOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoOneBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView(){
        with(binding){
            materialToolbar2.apply {
                title = "음식점 정보 보기"
                setNavigationIcon(R.drawable.arrow_back_24px)
                setNavigationOnClickListener {
                    finish()
                }
            }
            textViewOneTitle.text = "우돈가"
            textViewOneType.text = "일반 음식점"
            textViewOneAddress.text = "경기도 의정부"
        }
    }
}