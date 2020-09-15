package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {
    @Test
    public void test() throws IOException {
            String dosyaYolu = "src/test/resources/ULKELER.xlsx";
            //Java'da bir dosyayı açmak için bu kullanılır.
            // Parametre bölümüne açmak istediğimiz dosyanın adresi (dosya yolu,path) yazılır
            FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

            //workbook ile excel dosyasini okumaya basladik
            Workbook workbook = WorkbookFactory.create(fileInputStream);

            //gitmek istedigimiz sheet'in indexini yazarak oraya gideriz
            Sheet sheet = workbook.getSheetAt(0);//1. sayfaya gider.index "0" dan baslar

            //1.satira gidelim.index degeri yine "0" dan baslar
            Row row = sheet.getRow(0);
            //istedigimiz hucreyi almak istersek.1. hucreyi alalim
            Cell ulkeler  = row.getCell(0);
            Cell baskentler = row.getCell(1);
            Cell meshurlar = row.getCell(2);

        System.out.println(ulkeler);
        System.out.println(baskentler);
        System.out.println(meshurlar);

        //kisa yolu
        //excel'e git--> sheet "0" a git-->2. indexteki satira git-->1. indexteki hucre
        System.out.println(workbook.getSheetAt(0).getRow(3).getCell(1));

        System.out.println(workbook.getSheetAt(0).getRow(7).getCell(2));
        System.out.println(workbook.getSheetAt(0).getRow(10).getCell(0));

        //son satir(row) numarasini(index) almak icin
        int satirSayisi = workbook.getSheetAt(0).getLastRowNum()+1;
        System.out.println("satir sayisi= "+satirSayisi);

        //icerisinde veri olan satir sayisi
        //index'i "1" den baslatiyor
        int doluSatirSayisi = workbook.getSheetAt(0).getPhysicalNumberOfRows();
        System.out.println("dolu satir sayisi= " + doluSatirSayisi);

        int sonSatirinIndexi = workbook.getSheetAt(0).getLastRowNum();
        //tum ulkeleri ekrana yazdiralim
        for(int i= 0 ; i<=sonSatirinIndexi; i++ ){
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(0));
        }
        //tum baskentleri ekrana yazdiralim
        for(int i= 0 ; i<=sonSatirinIndexi; i++ ){
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(1));
        }

        //bir satirin son sutunun indexini almak
        //indexi "1" den basliyor
        int sonSutunIndex = workbook.getSheetAt(0).getRow(3).getLastCellNum();
        System.out.println("son sutun index= " +sonSutunIndex);

        //
        for(int i=0 ; i<sonSutunIndex; i++){
            System.out.println("4. Satir "+i+". Sutun= "+workbook.getSheetAt(0).getRow(3).getCell(i) + "  ");
        }
        fileInputStream.close();
        workbook.close();

    }
}
