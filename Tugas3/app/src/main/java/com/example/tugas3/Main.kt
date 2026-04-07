package com.example.tugas3


fun     main() {
    val manager = StudentManager()
    manager.appHeader = "Managemen Mahasiswa ULM"

    var isRunning = true
    while (isRunning) {
        println(manager.appHeader)
        println("1. Tambah Data\n2. List Data \n3. Show Data\n4. Edit Data\n5. Hapus Data\n6. Keluar")
        print("Pilih Menu: ")

        when (readln()) {
            "1" -> {
                print("NIM: ")
                val id = readln().toLongOrNull() ?: 0L

                print("Nama: ")
                val name = readln()
                if(name.isBlank())
                {
                    println("Nama tidak boleh kosong!")
                }

                else{
                    print("Hobi: ")
                    val hobby = readln().ifBlank { null }
                    manager.addStudent(Student(id, name, hobby))
                    println("Data Berhasil Ditambahkan")
                }

            }

            "2" -> manager.displayStudentList()
            "3" -> {

                print("Masukkan NIM yang dicari: ")
                val searchNim = readln().toLongOrNull() ?: 0L
                manager.showData(searchNim)
            }
            "4" -> {
                print("NIM Edit: ")
                val id = readln().toLongOrNull() ?: 0L
                print("Nama Baru: ")
                val name = readln()

                if(name.isBlank()){
                    println("Nama Tidak Boleh Kosong!")
                }

                else{
                    print("Hobi Baru: ")
                    val hobby = readln().ifBlank { null }

                    if (manager.updateStudent(Student(id, name, hobby)))
                        println("Berhasil Diedit")

                    else println("Gagal")
                }

            }
            "5" -> {
                print("NIM Hapus: ")
                val id = readln().toLongOrNull() ?: 0L
                if (manager.removeStudent(id)) println("Data Berhasil Terhapus")
                else println("Gagal")
            }
            "6" -> isRunning = false
            else -> println("Salah Input")
        }

        println()
    }


}