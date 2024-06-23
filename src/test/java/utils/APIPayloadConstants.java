package utils;

public class APIPayloadConstants {

    public static String createEmployeePayload(){
        String createEmployeePayload = "{\n" +
                "    \"emp_firstname\":\"mish34\",\n" +
                "    \"emp_lastname\":\"Dzhen1234\",\n" +
                "    \"emp_middle_name\":\"Vale1234\",\n" +
                "    \"emp_gender\":\"M\",\n" +
                "    \"emp_birthday\":\"1989-01-03\",\n" +
                "    \"emp_status\":\"Employee\",\n" +
                "    \"emp_job_title\":\"Api Tester\"\n" +
                "}";
        return createEmployeePayload;
    }
}
