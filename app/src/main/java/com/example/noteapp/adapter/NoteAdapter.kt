package com.example.noteapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.R
import com.example.noteapp.databinding.NoteLayoutBinding
import com.example.noteapp.model.Note

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    lateinit var onItemClicked: (Note) -> Unit
    lateinit var onItemLongClicked: (Note, pos: Int) -> Unit
    var noteList: MutableList<Note> = mutableListOf()
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        context = parent.context
        return NoteViewHolder(
            NoteLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(noteList[position])
    }

    override fun getItemCount(): Int = noteList.size

    inner class NoteViewHolder(private val binding: NoteLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            binding.apply {
                title.text = note.title
                desc.text = note.description
                time.text = note.time

                cardView.setCardBackgroundColor(ContextCompat.getColor(context,randomColor()))

                itemView.setOnClickListener {
                    onItemClicked(note)
                }
                itemView.setOnLongClickListener {
                    onItemLongClicked(note, adapterPosition)
                    true
                }
            }
        }
    }
    @ColorRes
    private fun randomColor(): Int {
        val colorList = listOf(
            R.color.green,
            R.color.yellow,
            R.color.blue,
            R.color.gray,
            R.color.red,
            R.color.light_black,
        )
        val randomNumber = (colorList.indices).random()
        return colorList[randomNumber]
    }
    fun filterNotes(notes: MutableList<Note>) {
        noteList = notes
        notifyDataSetChanged()
    }
}

