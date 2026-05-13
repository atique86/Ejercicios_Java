package com.ejemplo;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.opencv.core.Core;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class OCRTableToExcel {
    // Carga la biblioteca nativa de OpenCV al iniciar la clase
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    public static void main(String[] args) {
        // Ruta del PDF escaneado
        String pdfPath = "Tabla de amortización-694640_unlocked_rotated.pdf";  // Pon tu archivo PDF en la raíz del proyecto
        // Archivo Excel resultante
        String outputExcel = "resultado.xlsx";

        try (PDDocument document = PDDocument.load(new File(pdfPath))) {
            PDFRenderer renderer = new PDFRenderer(document);

            Tesseract tesseract = new Tesseract();
            // Ajusta esta ruta según donde instalaste Tesseract
            tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
            tesseract.setLanguage("eng");

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Resultado OCR");

            int pageCount = document.getNumberOfPages();
            int rowIdx = 0;

            for (int i = 0; i < pageCount; i++) {
                // Renderizar página a imagen con 300 dpi para mejor calidad OCR
                BufferedImage image = renderer.renderImageWithDPI(i, 300);

                // Aplicar OCR sobre la imagen
                String result = tesseract.doOCR(image);

                // Escribir línea por línea en el Excel
                for (String line : result.split("\\n")) {
                    Row row = sheet.createRow(rowIdx++);
                    row.createCell(0).setCellValue(line);
                }
            }

            // Guardar el archivo Excel
            try (FileOutputStream fileOut = new FileOutputStream(outputExcel)) {
                workbook.write(fileOut);
            }
            workbook.close();

            System.out.println("OCR completo. Archivo Excel generado: " + outputExcel);
        } catch (IOException | TesseractException e) {
            e.printStackTrace();
        }
    }
}