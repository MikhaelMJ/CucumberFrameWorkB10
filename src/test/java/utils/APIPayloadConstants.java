package utils;

import org.json.JSONObject;

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

    public static String createEmployeeBody(){

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", "mish34");
        obj.put("emp_lastname", "Dzhen1234");
        obj.put("emp_middle_name", "Vale1234");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday", "1989-01-03");
        obj.put("emp_status", "Employee");
        obj.put("emp_job_title", "Api Tester");
        return obj.toString();
    }

    public static String payLoadMoreDynamic (String emp_firstname, String emp_lastname, String emp_middle_name, String emp_gender,
                                             String emp_birthday, String emp_status, String emp_job_title){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", emp_firstname);
        obj.put("emp_lastname", emp_lastname);
        obj.put("emp_middle_name", emp_middle_name);
        obj.put("emp_gender", emp_gender);
        obj.put("emp_birthday", emp_birthday);
        obj.put("emp_status", emp_status);
        obj.put("emp_job_title", emp_job_title);
        return obj.toString();
    }
}
