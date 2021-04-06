package com.codart.building_calculator.db

import io.paperdb.Paper

object NoteDB {

            fun addItem(note: Note) {
                val notes = getItems()
                notes.add(note)
                saveItems(notes)

            }
            fun removeItem(note: Note) {

                val notes = getItems()
                notes.remove(note)
                saveItems(notes)

            }
            fun saveItems(items: MutableList<Note>) {
                Paper.book().write("note", items)
            }

            fun getItems(): MutableList<Note> {
                return Paper.book().read("note", mutableListOf())
            }
            fun checkItem(note: Note): Boolean{
                val notes = getItems()
                return notes.contains(note)
            }
}