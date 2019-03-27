package com.kq.migration.file

/**
 * SaveToFile
 *
 * @author1 kq
 * @date 2019-03-27
 */
class SaveToFile {

//    def toysFile = new File("src/TestToysFile.dat")
//
//         if(!toysFile.exists()){
//
//                  toysFile.createNewFile()
//
//                  toysFile.append('Groovy and clat' + '/n')
//
//             }


    static void saveToFile(def content) {
        def saveFile = new File("D:\\tmp\\database_capacity.txt");

        if(!saveFile.exists()) {
            saveFile.createNewFile();
        }

        def writer = new FileWriter(saveFile,true)

        writer.println(content)

        writer.flush()
        writer.close()

    }

    static void main(String[] args) {
        saveToFile("12345678")
        saveToFile("12345aaaaaaaaaaaaaa678")
        saveToFile("2222222222222222222222222")
    }

}
