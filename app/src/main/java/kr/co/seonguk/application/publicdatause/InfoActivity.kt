package kr.co.seonguk.application.publicdatause

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.divider.MaterialDividerItemDecoration
import kr.co.seonguk.application.publicdatause.databinding.ActivityInfoBinding
import retrofit2.Call
import retrofit2.Response

class InfoActivity : AppCompatActivity() {

    lateinit var binding:ActivityInfoBinding

    val allAdapter : InfoAdapter by lazy {
        val adapter = InfoAdapter()
        adapter.setRecyclerviewClick(object : InfoAdapter.ItemOnClickListener{
            override fun recyclerviewClickListener(title:String, type:String, address:String) {
                val newIntent = Intent(this@InfoActivity, InfoOneActivity::class.java)
                newIntent.putExtra("title", title)
                newIntent.putExtra("type", type)
                newIntent.putExtra("address", address)
                startActivity(newIntent)
//                Log.d("seonguk1234", title)
//                Log.d("seonguk1234", type)
//                Log.d("seonguk1234", address)
            }

        })
        adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        infoAdapter()
        retrofitWork()
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


    //어댑터 클래스
    private fun infoAdapter(){
        binding.apply {
            recyclerview.apply {
                setHasFixedSize(true)
                adapter = allAdapter
                layoutManager = LinearLayoutManager(this@InfoActivity)
                val deco = MaterialDividerItemDecoration(this@InfoActivity, MaterialDividerItemDecoration.VERTICAL)
                addItemDecoration(deco)
            }
        }
    }

    //Retrofit 사용
    private fun retrofitWork(){
        val service = RetrofitInstance.retrofitService

        service.getStoreData(RetrofitInstance.API_KEY, "json")
            .enqueue(object : retrofit2.Callback<ApiResponse>{
                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    val result = response.body()?.GGEXPSDLV?.get(1)?.row
                    allAdapter.submitList(result)
                   // Log.d("test1235", "${call}")

                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    Log.d("test1234", "${t}")
                }

            })
    }
}


