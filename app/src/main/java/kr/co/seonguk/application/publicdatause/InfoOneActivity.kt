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
        val titleInfo = intent?.getStringExtra("title")
        val type = intent?.getStringExtra("type")
        val address = intent?.getStringExtra("address")
        with(binding){
            materialToolbar2.apply {
                title = "음식점 정보 보기"
                setNavigationIcon(R.drawable.arrow_back_24px)
                setNavigationOnClickListener {
                    finish()
                }
            }
            textViewOneTitle.text = "${titleInfo}"
            textViewOneType.text = "${type}"
            textViewOneAddress.text = "${address}"
        }
    }
}