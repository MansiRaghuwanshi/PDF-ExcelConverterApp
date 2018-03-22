package com.pdfconverter.edu;

import com.pdfconverter.edu.CustomColumn;

import com.sun.tools.classfile.ConstantPool;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class PdfConverter {



    // populate age to rate .
    public Map<String, String> populateAgeToRateMap(int startIndex, String[] lineArrayInAPdfPage, String delimeter) throws IOException {

        Map<String, String> ageToRateMap = new HashMap<>();

        for (int line = startIndex; line < lineArrayInAPdfPage.length; line++) {

            if (lineArrayInAPdfPage[line].contains(delimeter)) {

                // all age rate are conatined between the lines
                // Age Rate Age Rate Age Rate  and
                // Rates displayed are

                return ageToRateMap;
            }

            String[] ageRateArray = lineArrayInAPdfPage[line].split(" ");
            ageToRateMap.put(ageRateArray[0].trim(), ageRateArray[1].trim());
            ageToRateMap.put(ageRateArray[2].trim(), ageRateArray[3].trim());
            ageToRateMap.put(ageRateArray[4].trim(), ageRateArray[5].trim());

        }


        // ideally the code shouldnt come here, its only possible in case of
        throw new IOException("Parsing error Encountered while mapping Age to Rate, " +
                " looks like the delimeter " + delimeter + " was never found in the page");


    }



    // convert pdf to Text and populate the custrom Column Object
    public List<CustomColumn> createPdfToText(String path) throws IOException {

        PDFManager pdfManager = new PDFManager();
        pdfManager.setFilePath(path);


        String text = pdfManager.ToText();


        List<CustomColumn> rowList = new ArrayList<>();


        // this gets one pdf page in the given pdf by slpitting on valid
        String[] pdfPage = text.split(Constants.VALID);


        // skipping the first page as its "", side effect of spliiting on valid
        for (int page = 1; page < pdfPage.length; page++) {

            String[] lineArray = pdfPage[page].split(Constants.NEW_LINE);
            int index = 0;

            CustomColumn row = new CustomColumn();
            for (String lineInAPage : lineArray) {
                index++;


                if (lineInAPage.contains(Constants.EFFECTIVE_DATE)) {
                    String[] date = lineInAPage.split(Constants.EFFECTIVE_DATE)[1].split("-");

                    row.setStartDate(date[0]);
                    row.setEndDate(date[1]);


                } else if (lineInAPage.contains(Constants.RATING_AREA)) {


                    row.setRatingArea(
                            lineInAPage
                                    .split(Constants.RATING_AREA)[1]
                                    .replace("*", " ")
                                    .trim()
                    );

                } else if (lineInAPage.contains(Constants.PLAN_NAME)) {
                    String[] planArray = lineInAPage.split(Constants.PLAN_NAME);

                    row.setPlanName(planArray[1]);
                    row.setPlanId(planArray[0].split(Constants.PLAN_ID)[1]);

                } else if (lineInAPage.contains(Constants.AGE)) {
                    // populate the age and rate , index +1 has been done to skip AGE
                    row.setAgetToRateMap(populateAgeToRateMap(index, lineArray, Constants.RATES));
                }
            }

            // set the state Name
            row.setStateName(lineArray[lineArray.length - 1]);

            rowList.add(row);


        }

        return rowList;

    }


    // select all the PDF file in the given dir

    public static List<String> getListOfFilesAbsolutePathInDir(String dirPath) {

        List<String> results = new ArrayList<String>();

        File[] files = new File(dirPath).listFiles();
        for (File file : files) {
            if (file.isFile()) {

                // only add if its a pdf file
                if (file.getName().endsWith(Constants.PDF_FILE)) {
                    results.add(file.getAbsolutePath());
                }
            }

        }
        return results;
    }




    //function to store the text into the excel
    private static void wordToExcel(List<CustomColumn> columntList, String outputPath) throws Exception {

        //Create blank workbook


        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            //Create a blank sheet
            XSSFSheet spreadsheet = workbook.createSheet(" Employee Info ");


            for (int row = 0; row < Constants.EXCEL_ROW_NAMES.size(); row++) {
                XSSFRow row1 = spreadsheet.createRow(row);


                for (int columns = 0; columns <= columntList.size(); columns++) {

                    Cell cell = row1.createCell(columns);

                    if (columns == 0) {
                        cell.setCellValue(Constants.EXCEL_ROW_NAMES.get(row));
                    } else if (row < 5) {
                        cell.setCellValue(columntList
                                .get(columns - 1)
                                .getAgetToRateMap()
                                .get(Constants.EXCEL_ROW_NAMES.get(row)
                                )
                        );
                    } else {
                        cell.setCellValue(
                                columntList.get(columns - 1)
                                        .getAgetToRateMap()
                                        .get(Constants
                                                .AGE_TO_STRING_MAPPING
                                                .get(Constants.EXCEL_ROW_NAMES.get(row)
                                                )
                                        )
                        );
                    }
                }
            }

            //Write the workbook in file system
            try (FileOutputStream out = new FileOutputStream(
                    new File(outputPath))) {
                workbook.write(out);
                workbook.close();
            }
        }

    }




    public static void main(String[] args) throws Exception {


        PdfConverter converter = new PdfConverter();


        List<CustomColumn> columnListList = new ArrayList<>();


        // get all the PDF files in the DIrectory
        List<String> pdfFilesAbsolutePath = getListOfFilesAbsolutePathInDir("/Users/mansi/test/input");

        for (String filePath : pdfFilesAbsolutePath) {
            // convert PDF to Text
            columnListList.addAll(converter.createPdfToText(filePath));
        }

        // convert text to excel and save in the output as xlsx file format
        wordToExcel(columnListList, "/Users/mansi/Desktop/Writesheet.xlsx");

    }
}
