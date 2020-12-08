package com.example.shihab.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shihab.R
import com.example.shihab.adapters.OptionAdapter
import com.example.shihab.models.Question
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        bindViews()
    }

    private fun bindViews() {
        val question = Question(
            "খলজী সাম্রাজ্যের প্রতিষ্ঠাতা কে ?",
            "(ক) জালালউদ্দিন",
            "(খ) আলাউদ্দিন",
            "(গ) কুতুবউদ্দিন",
            "(ঘ) নাসিরউদ্দিন",
            "জালালউদ্দিন"
        )

        description.text = question.description
        val optionAdapter = OptionAdapter(this,question)
        optionList.layoutManager = LinearLayoutManager(this)
        optionList.adapter = optionAdapter
        optionList.setHasFixedSize(true)
    }
}