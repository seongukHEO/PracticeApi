package kr.co.seonguk.application.publicdatause

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.seonguk.application.publicdatause.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView(){
        binding.apply {
            materialToolbar.apply {
                title = "경기도 공공배달앱 API 사용"

                inflateMenu(R.menu.main_menu)
                setOnMenuItemClickListener {
                    when(it.itemId){
                        R.id.food_menu -> {
                            startActivity(Intent(this@MainActivity, InfoActivity::class.java))
                        }
                    }

                    true
                }
            }

            textViewMain.text = "심심해서 만들었다~!"
            textViewServe.text = "API 쓰는 건 재밌지~!!"

        }
    }
}