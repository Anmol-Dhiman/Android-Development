package com.example.retrofitmvvm


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

import com.example.example.Questions


class QuizAdapter() : RecyclerView.Adapter<QuizAdapter.QuizViewHolder>() {


    private lateinit var question: ArrayList<Questions>

    fun setQuizData(_question : ArrayList<Questions>) {
        this.question = _question
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.question_layout, parent, false)
        return QuizViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {

        var currentQuestion = question[position]
        holder.question.text = (position + 1).toString() + ". " + currentQuestion.lable
        holder.optionA.text = "A. " + currentQuestion.options[0].lable
        holder.optionB.text = "B. " + currentQuestion.options[1].lable
        holder.optionC.text = "C. " + currentQuestion.options[2].lable
        holder.optionD.text = "D. " + currentQuestion.options[3].lable
        var count = 0
        holder.question.setOnClickListener {
            if (count == 0) {
                holder.optionMenu.visibility = View.GONE
                count++
            } else if (count == 1) {
                holder.optionMenu.visibility = View.VISIBLE
                count--
            }

        }

    }

    override fun getItemCount(): Int {
        return question.size
    }


    class QuizViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        var question: TextView = itemView.findViewById(R.id.question)
        var optionA: TextView = itemView.findViewById(R.id.optionA)
        var optionB: TextView = itemView.findViewById(R.id.optionB)
        var optionC: TextView = itemView.findViewById(R.id.optionC)
        var optionD: TextView = itemView.findViewById(R.id.optionD)
        var optionMenu: LinearLayout = itemView.findViewById(R.id.optionMenu)
    }
}