package com.codart.building_calculator.db

import io.paperdb.Paper

object NotebookDB {

    fun addItem(item: Notebook) {
        val items = getItems()
        items.add(item)
        saveItems(items)

    }
    fun removeItem(item: Notebook) {

        val items = getItems()
        items.remove(item)
        saveItems(items)

    }
    fun saveItems(items: MutableList<Notebook>) {
        Paper.book().write("notebook", items)
    }

    fun getItems(): MutableList<Notebook> {
        return Paper.book().read("notebook", mutableListOf())
    }
    fun checkItem(item: Note): Boolean{
        val items = getItems()
        return items.contains(item)
    }
}