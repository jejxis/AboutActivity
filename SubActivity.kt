package com.example.aboutactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aboutactivity.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    val binding by lazy { ActivitySubBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.to1.text = intent.getStringExtra("from1")//인텐트에서 담아온 값 이용
        binding.to2.text = "${intent.getIntExtra("from2", 0)}"//인텐트에서 받아온 값이 숫자라서 문자열로 만들어 준다.
        binding.btnClose.setOnClickListener {
            val returnIntent = Intent()//인텐트 생성
            returnIntent.putExtra("returnValue", binding.editMessage.text.toString())//원래 호출했던 액티비티에 값 전달
            setResult(RESULT_OK, returnIntent)//원래 호출했던 액티비티로 돌아가기
            finish()//서브 액티비티 종료, 메인 액티비티로 돌아감.
        }

    }
}