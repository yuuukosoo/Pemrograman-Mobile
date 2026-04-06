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

    fun displayStudentPair() {
        if (_studentList.isEmpty()) return println("Daftar Kosong!")
        println("--- SHOW DATA (KEY, VALUE) ---")
        for ((id, student) in _studentList) {
            println("Key: $id => Value: ${student.nama}")
        }
    }
}