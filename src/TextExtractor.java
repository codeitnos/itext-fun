import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import javafx.util.Pair;

import java.io.IOException;

/**
 * Created by FedyuninV on 6/7/14.
 */
public class TextExtractor {
    public static void main(String[] args) throws IOException {
        PdfReader reader = new PdfReader(args[0]);

        for (int i = 1; i <= reader.getNumberOfPages(); ++i) {
            TextExtractionStrategyImpl strategy = new TextExtractionStrategyImpl();

            // вызываем, чтобы наша реализация стратегия получила информацию о тексте на странице
            PdfTextExtractor.getTextFromPage(reader, i, strategy);

            System.out.println("Page : " + i);
            for (Pair<Float, String> pair: strategy.getStringsWithCoordinates()) {
                System.out.println(pair.getKey().toString() + " " + pair.getValue());
            }
        }

        reader.close();
    }
}
