package com.example.tugasapi

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var tvStudentInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvStudentInfo = findViewById(R.id.tvStudentInfo)

        fetchStudentData()
    }

    private fun fetchStudentData() {
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val response = NetworkClient.apiService.getStudentProfile()

                withContext(Dispatchers.Main) {
                    tvStudentInfo.text = getString(
                        R.string.student_info_template,
                        response.message,
                        response.code,
                        response.data.studentId,
                        response.data.fullName,
                        response.data.major
                    )
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    tvStudentInfo.text = getString(R.string.error_message, e.message ?: "Unknown Error")
                }
            }
        }
    }
}