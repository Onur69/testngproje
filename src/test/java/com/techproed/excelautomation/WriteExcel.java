package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    @Test
    public void test() throws IOException {
        String dosyaYolu = "src/test/resources/ULKELER.xlsx";
        //Java'da bir dosyayı açmak için bu kullanılır.
        // Parametre bölümüne açmak istediğimiz dosyanın adresi (dosya yolu,path) yazılır
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        //workbook ile excel dosyasini okumaya basladik
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //dosya uzerinde yazma islemi gerceklestirecegimiz icin buraya
        //FileOutputStream class'indan bir tane obje olusturmak gerekir
        FileOutputStream fileOutputStream = new FileOutputStream(dosyaYolu);

        //ULKELER      BASKENTLER      NEYI MESHUR
        //0. index'teki satirin 3. index'teki hucresine NUFUS hucresi ekleyelim
        workbook.getSheetAt(0).getRow(0).createCell(3).setCellValue("NUFUS");
        workbook.getSheetAt(0).getRow(1).createCell(3).setCellValue("80 milyon");
        workbook.getSheetAt(0).getRow(2).createCell(3).setCellValue("11 milyon");
        //bir daha calistirirsak alttaki iki  komutta (33 & 37)hata aliriz
        //0. indexteki satirin 1. indexindeki hucreyi silelim(BASKENTLER)
        Cell silmekIstedigimizHucre = workbook.getSheetAt(0).getRow(0).getCell(1);
        workbook.getSheetAt(0).getRow(0).removeCell(silmekIstedigimizHucre);

        //1. indexteki satiri silelim(Almanya)
        Row silmekIstedigimizSatir = workbook.getSheetAt(0).getRow(1);
        workbook.getSheetAt(0).removeRow(silmekIstedigimizSatir);

        //yaptigimiz degisiklikleri excele aktarir veriyi yazar ve kaydeder.
        workbook.write(fileOutputStream);

        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();


    }}
