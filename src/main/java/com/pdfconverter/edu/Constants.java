package com.pdfconverter.edu;

import java.util.*;

public final class Constants {

    // Constants related to pdf file reading
    public static final String VALID = "Valid";
    public static final String NEW_LINE = "\n";
    public static final String AGE = "Age Rate Age Rate Age Rate";
    public static final String RATES = "Rates displayed";
    public static final String EFFECTIVE_DATE = "for Effective Dates:";
    public static final String RATING_AREA = "Rating Area:";
    public static final String PLAN_NAME = "Plan Name:";
    public static final String PLAN_ID = "Plan ID:";

    public static final String PDF_FILE = ".pdf";


    // The fields needed in the Excel file
    public static String EXCEL_START_DATE = "start_date";
    public static String EXCEL_END_DATE = "end_date";
    public static String EXCEL_STATE_NAME = "states";
    public static String EXCEL_RATING_AREA = "group_rating_areas";
    public static String EXCEL_PRODUCT_ID = "product_id";
    public static String EXCEL_PRODUCT_NAME = "product_name";

    public static List<String> EXCEL_ROW_NAMES = new ArrayList<>();

    public static Map<String, String> AGE_TO_STRING_MAPPING = new HashMap<>();


    static {

        EXCEL_ROW_NAMES.add(EXCEL_START_DATE);
        EXCEL_ROW_NAMES.add(EXCEL_END_DATE);
        EXCEL_ROW_NAMES.add(EXCEL_PRODUCT_NAME);
        EXCEL_ROW_NAMES.add(EXCEL_PRODUCT_ID);
        EXCEL_ROW_NAMES.add(EXCEL_RATING_AREA);
        EXCEL_ROW_NAMES.add("zero_eighteen");
        EXCEL_ROW_NAMES.add("nineteen_twenty");
        EXCEL_ROW_NAMES.add("twenty_one");
        EXCEL_ROW_NAMES.add("twenty_two");
        EXCEL_ROW_NAMES.add("twenty_three");
        EXCEL_ROW_NAMES.add("twenty_four");
        EXCEL_ROW_NAMES.add("twenty_five");
        EXCEL_ROW_NAMES.add("twenty_six");
        EXCEL_ROW_NAMES.add("twenty_seven");
        EXCEL_ROW_NAMES.add("twenty_eight");
        EXCEL_ROW_NAMES.add("twenty_nine");
        EXCEL_ROW_NAMES.add("thirty");
        EXCEL_ROW_NAMES.add("thirty_one");
        EXCEL_ROW_NAMES.add("thirty_two");
        EXCEL_ROW_NAMES.add("thirty_three");
        EXCEL_ROW_NAMES.add("thirty_four");
        EXCEL_ROW_NAMES.add("thirty_five");
        EXCEL_ROW_NAMES.add("thirty_six");
        EXCEL_ROW_NAMES.add("thirty_seven");
        EXCEL_ROW_NAMES.add("thirty_eight");
        EXCEL_ROW_NAMES.add("thirty_nine");
        EXCEL_ROW_NAMES.add("forty");
        EXCEL_ROW_NAMES.add("forty_one");
        EXCEL_ROW_NAMES.add("forty_two");
        EXCEL_ROW_NAMES.add("forty_three");
        EXCEL_ROW_NAMES.add("forty_four");
        EXCEL_ROW_NAMES.add("forty_five");
        EXCEL_ROW_NAMES.add("forty_six");
        EXCEL_ROW_NAMES.add("forty_seven");
        EXCEL_ROW_NAMES.add("forty_eight");
        EXCEL_ROW_NAMES.add("forty_nine");
        EXCEL_ROW_NAMES.add("fifty");
        EXCEL_ROW_NAMES.add("fifty_one");
        EXCEL_ROW_NAMES.add("fifty_two");
        EXCEL_ROW_NAMES.add("fifty_three");
        EXCEL_ROW_NAMES.add("fifty_four");
        EXCEL_ROW_NAMES.add("fifty_five");
        EXCEL_ROW_NAMES.add("fifty_six");
        EXCEL_ROW_NAMES.add("fifty_seven");
        EXCEL_ROW_NAMES.add("fifty_eight");
        EXCEL_ROW_NAMES.add("fifty_nine");
        EXCEL_ROW_NAMES.add("sixty");
        EXCEL_ROW_NAMES.add("sixty_one");
        EXCEL_ROW_NAMES.add("sixty_two");
        EXCEL_ROW_NAMES.add("sixty_three");
        EXCEL_ROW_NAMES.add("sixty_four");
        EXCEL_ROW_NAMES.add("sixty_five_plus");


        // string to age in pdf mapping
        AGE_TO_STRING_MAPPING.put("zero_eighteen", "0-20");
        AGE_TO_STRING_MAPPING.put("nineteen_twenty", "0-20");
        AGE_TO_STRING_MAPPING.put("twenty_one", "21");
        AGE_TO_STRING_MAPPING.put("twenty_two", "22");
        AGE_TO_STRING_MAPPING.put("twenty_three", "23");
        AGE_TO_STRING_MAPPING.put("twenty_four", "24");
        AGE_TO_STRING_MAPPING.put("twenty_five", "25");
        AGE_TO_STRING_MAPPING.put("twenty_six", "26");
        AGE_TO_STRING_MAPPING.put("twenty_seven", "27");
        AGE_TO_STRING_MAPPING.put("twenty_eight", "28");
        AGE_TO_STRING_MAPPING.put("twenty_nine", "29");
        AGE_TO_STRING_MAPPING.put("thirty", "30");
        AGE_TO_STRING_MAPPING.put("thirty_one", "31");
        AGE_TO_STRING_MAPPING.put("thirty_two", "32");
        AGE_TO_STRING_MAPPING.put("thirty_three", "33");
        AGE_TO_STRING_MAPPING.put("thirty_four", "34");
        AGE_TO_STRING_MAPPING.put("thirty_five", "35");
        AGE_TO_STRING_MAPPING.put("thirty_six", "36");
        AGE_TO_STRING_MAPPING.put("thirty_seven", "37");
        AGE_TO_STRING_MAPPING.put("thirty_eight", "38");
        AGE_TO_STRING_MAPPING.put("thirty_nine", "39");
        AGE_TO_STRING_MAPPING.put("forty", "40");
        AGE_TO_STRING_MAPPING.put("forty_one", "41");
        AGE_TO_STRING_MAPPING.put("forty_two", "42");
        AGE_TO_STRING_MAPPING.put("forty_three", "43");
        AGE_TO_STRING_MAPPING.put("forty_four", "44");
        AGE_TO_STRING_MAPPING.put("forty_five", "45");
        AGE_TO_STRING_MAPPING.put("forty_six", "46");
        AGE_TO_STRING_MAPPING.put("forty_seven", "47");
        AGE_TO_STRING_MAPPING.put("forty_eight", "48");
        AGE_TO_STRING_MAPPING.put("forty_nine", "49");
        AGE_TO_STRING_MAPPING.put("fifty", "50");
        AGE_TO_STRING_MAPPING.put("fifty_one", "51");
        AGE_TO_STRING_MAPPING.put("fifty_two", "52");
        AGE_TO_STRING_MAPPING.put("fifty_three", "53");
        AGE_TO_STRING_MAPPING.put("fifty_four", "54");
        AGE_TO_STRING_MAPPING.put("fifty_five", "55");
        AGE_TO_STRING_MAPPING.put("fifty_six", "56");
        AGE_TO_STRING_MAPPING.put("fifty_seven", "57");
        AGE_TO_STRING_MAPPING.put("fifty_eight", "58");
        AGE_TO_STRING_MAPPING.put("fifty_nine", "59");
        AGE_TO_STRING_MAPPING.put("sixty", "60");
        AGE_TO_STRING_MAPPING.put("sixty_one", "61");
        AGE_TO_STRING_MAPPING.put("sixty_two", "62");
        AGE_TO_STRING_MAPPING.put("sixty_three", "63");
        AGE_TO_STRING_MAPPING.put("sixty_four", "64+");
        AGE_TO_STRING_MAPPING.put("sixty_five_plus", "64+");

    }

}
