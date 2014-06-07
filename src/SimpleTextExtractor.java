import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

import java.io.IOException;

/**
 * Created by FedyuninV on 6/3/14.
 */


public class SimpleTextExtractor {
    public static void main(String[] args) throws IOException {
        // считаем, что программе передается один аргумент - имя файла
        PdfReader reader = new PdfReader(args[0]);

        // не забываем, что нумерация страниц в PDF начинается с единицы.
        for (int i = 1; i <= reader.getNumberOfPages(); ++i) {
            TextExtractionStrategy strategy = new SimpleTextExtractionStrategy();
            String text = PdfTextExtractor.getTextFromPage(reader, i, strategy);
            System.out.println(text);
        }

        // убираем за собой
        reader.close();
    }
}
