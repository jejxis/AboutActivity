package com.example.aboutactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.aboutactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //서브 액티비티에서 인텐트 돌려받기
        val activityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                val message = it.data?.getStringExtra("returnValue")
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            }
        }

        val intent = Intent(this, SubActivity::class.java)//인텐트 생성
        intent.putExtra("from1", "Hello Bundle")//인텐트에 값 넣기(키, 값)
        intent.putExtra("from2", 2021)

        binding.btnStart.setOnClickListener {activityResult.launch(intent)}//서브 액티비티로부터 값을 돌려 받기 위함. 새로운 액티비티 실행
        // { startActivity(intent) }//새로만든 액티비티 실행

        /*super.onActivityResult(requestCode, resultCode, data)//-->이 코드 왜 있는지 모르겠음. 없어도 실행 잘됨.
        if(resultCode == RESULT_OK){
            when(requestCode){
                99->{
                    val message = data?.getStringExtra("returnValue")
                    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
                }
            }
        }*/
    }

}
