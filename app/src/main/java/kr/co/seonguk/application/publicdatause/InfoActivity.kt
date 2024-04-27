package kr.co.seonguk.application.publicdatause

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.divider.MaterialDividerItemDecoration
import kr.co.seonguk.application.publicdatause.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {

    lateinit var binding:ActivityInfoBinding

    val allAdapter : InfoAdapter by lazy {
        val adapter = InfoAdapter()
        adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        infoAdapter()
        initAdapter()
    }

    private fun initView(){
        binding.apply {
            materialToolbar3.apply {
                title = "음식점 전체보기"
                setNavigationIcon(R.drawable.arrow_back_24px)
                setNavigationOnClickListener {
                    finish()
                }
            }
        }
    }

    private fun initAdapter(){
        allAdapter.submitList()
    }


    //어댑터 클래스
    private fun infoAdapter(){
        binding.apply {
            recyclerview.apply {
                adapter = allAdapter
                layoutManager = LinearLayoutManager(this@InfoActivity)
                val deco = MaterialDividerItemDecoration(this@InfoActivity, MaterialDividerItemDecoration.VERTICAL)
                addItemDecoration(deco)
            }
        }
    }
}


