package uk.ac.ox.oucs.oxgarage.oo;

import pl.psnc.dl.ege.exception.ConverterException;
import pl.psnc.dl.ege.types.ConversionActionArguments;
import pl.psnc.dl.ege.types.DataType;

import java.io.*;

import static org.junit.Assert.*;

public class OOConverterTest {
    private OOConverter converter;

    @org.junit.Before
    public void setUp() throws Exception {
        converter = new OOConverter();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        converter = null;
    }

    @org.junit.Test
    public void convert() throws IOException, ConverterException {
        //text to pdf
        InputStream is = new FileInputStream("src/test/resources/test-input.txt.zip");
        OutputStream os = new FileOutputStream("src/test/resources/test-output.pdf.zip");
        DataType inputType = new DataType("txt","text/plain");
        DataType outputType = new DataType("pdf","application/pdf");
        ConversionActionArguments conversionActionArguments = new ConversionActionArguments(inputType, outputType, null);
        String tempDir = "src/test/temp";
        converter.convert(is, os, conversionActionArguments, tempDir);
        assertNotNull(new File("src/test/resources/test-output.pdf.zip"));
        is.close();
        os.close();
        //docx to TEI
        is = new FileInputStream("src/test/resources/test-input.docx.zip");
        os = new FileOutputStream("src/test/resources/test-output.txt.zip");
        inputType = new DataType("docx","application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        outputType = new DataType("txt","text/plain");
        conversionActionArguments = new ConversionActionArguments(inputType, outputType, null);
        converter.convert(is, os, conversionActionArguments, tempDir);
        assertNotNull(new File("src/test/resources/test-output.txt.zip"));
        is.close();
        os.close();
    }

    @org.junit.Test
    public void getPossibleConversions() {
        assertNotNull(converter.getPossibleConversions());
        System.out.println(converter.getPossibleConversions());
    }
}