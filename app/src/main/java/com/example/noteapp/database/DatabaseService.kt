package com.example.noteapp.database

import com.example.noteapp.model.Note

interface DatabaseService {
    // CRUD -> C = Create, R = Read
    fun saveNote(note: Note) // create
    fun updateNote(note: Note) // update
    fun deleteNote(id: Int) // delete
    fun getAllNotes(): MutableList<Note> // read
    fun deleteAllNotes()
}