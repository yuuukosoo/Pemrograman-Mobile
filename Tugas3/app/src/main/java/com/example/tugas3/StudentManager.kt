package com.example.tugas3

class StudentManager {
    private val _studentList: ArrayList<Pair<Long, Student>> = ArrayList()

    var appHeader: String = ""
        get() = field
        set(value) {
            field = value.uppercase()
        }

    fun addStudent(student: Student) {
        if (_studentList.any { it.first == student.nim }) {
            println("Gagal: Mahasiswa dengan NIM ${student.nim} sudah terdaftar.")
        } else {
            _studentList.add(Pair(student.nim, student))
        }
    }

    fun removeStudent(id: Long): Boolean {
        return _studentList.removeIf { it.first == id }
    }

    fun updateStudent(student: Student): Boolean {
        val index = _studentList.indexOfFirst { it.first == student.nim }
        return if (index != -1) {
            _studentList[index] = Pair(student.nim, student)
            true
        } else false
    }

    fun displayStudentList() {
        if (_studentList.isEmpty()) return println("Daftar Kosong!")
        println("--- DETAIL MAHASISWA ---")
        for ((id, student) in _studentList) {
            println("ID: $id \n" +
                    "Nama: ${student.nama} \n" +
                    "Hobi: ${student.hobi ?: "Tidak ada"}")
            println("------")
        }
    }

    fun showData(nim: Long) {
        val foundPair = _studentList.find { it.first == nim }

        if (foundPair != null) {
            val key = foundPair.first
            val student = foundPair.second

            println("Data Ditemukan")
            println("Nim: $key")
            println("Nama: ${student.nama}")
            println("Hobi: ${student.hobi ?: "Tidak ada"}")
        } else {
            println("Data Tidak Ditemukan ")
        }
    }
}