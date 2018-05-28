package com.jing.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.pdfbox.io.RandomAccessBufferedFileInputStream;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.textmining.text.extraction.WordExtractor;

public class Word {
	    public static String getWord2003(File file) {
	        String word2003 = null;
	        InputStream f = null;
	        try {
	            f = new FileInputStream(file);
	            WordExtractor ex = new WordExtractor();
	            word2003 = ex.extractText(f);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                f.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        return word2003;
	    }

	    public static String getWord2007(File file) {
	        String word2007 = null;
	        try {
	            OPCPackage opcPackage = POIXMLDocument
	                    .openPackage(file.getParent());
	            System.out.println(111111111);
	            POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
	            word2007 = extractor.getText();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return word2007;
	    }
	    public static void main(String[] args) {
			File file = new File("C:/Users/my/Desktop/学习日志.docx");
			String content = getWord2007(file);
			System.out.println(content);
		}
	    
}
