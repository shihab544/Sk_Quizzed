package com.example.shihab.activities

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shihab.R
import com.example.shihab.adapters.QuizAdapter
import com.example.shihab.models.Quiz
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var adapter: QuizAdapter
    private var quizList = mutableListOf<Quiz>()
    lateinit var firestore: FirebaseFirestore
   // var db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        populateDummyData()
        setUpViews()

    }

    private fun populateDummyData() {
        quizList.add(Quiz("12-10-2021", "12-10-2021"))
        quizList.add(Quiz("13-10-2021", "13-10-2021"))
        quizList.add(Quiz("14-10-2021", "14-10-2021"))
        quizList.add(Quiz("15-10-2021", "15-10-2021"))
        quizList.add(Quiz("16-10-2021", "16-10-2021"))
        quizList.add(Quiz("17-10-2021", "17-10-2021"))
        quizList.add(Quiz("18-10-2021", "18-10-2021"))
        quizList.add(Quiz("1626", "Shihab"))
        quizList.add(Quiz("19-10-2021", "19-10-2021"))
        quizList.add(Quiz("20-10-2021", "20-10-2021"))
        quizList.add(Quiz("21-10-2021", "21-10-2021"))
        quizList.add(Quiz("22-10-2021", "22-10-2021"))
        quizList.add(Quiz("23-10-2021", "23-10-2021"))
        quizList.add(Quiz("24-10-2021", "24-10-2021"))
        quizList.add(Quiz("25-10-2021", "25-10-2021"))
    }

    fun setUpViews() {
        setUpFireStore()
        setUpDrawerLayout()
        setUpRecyclerView()
    }

    private fun setUpFireStore() {
        firestore = FirebaseFirestore.getInstance()
        val collectionReference = firestore.collection("quizzes")
        collectionReference.addSnapshotListener { value, error ->
            if(value == null || error != null){
                Toast.makeText(this, "Error fetching data", Toast.LENGTH_SHORT).show()
                return@addSnapshotListener
            }
            Log.d("DATA", value.toObjects(Quiz::class.java).toString())
            quizList.clear()
            quizList.addAll(value.toObjects(Quiz::class.java))
            adapter.notifyDataSetChanged()

        }
    }

    private fun setUpRecyclerView() {

        adapter = QuizAdapter(this, quizList)
        quizReclerView.layoutManager = GridLayoutManager(this, 2)
        quizReclerView.adapter = adapter


    }

    fun setUpDrawerLayout() {
        setSupportActionBar(AppBar)
        actionBarDrawerToggle = ActionBarDrawerToggle(
            this, mainDrawer,
            R.string.app_name,
            R.string.app_name
        )
        actionBarDrawerToggle.syncState();
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}