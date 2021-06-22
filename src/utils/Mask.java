/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Lucas
 */
public class Mask {
    
    public static String maskField(String valueField, int length){
        if(valueField.length() > length){
            return valueField.substring(0, length);
        }
        return valueField;
    }
    
    public static String maskPhone(String phone){
        if(!phone.equals("")){
            String regex = "\\d+";
            Matcher formated = Pattern.compile(regex).matcher(phone);
            phone = formated.matches() ? formated.group() : phone;
            if(phone.length() != 10){
                return phone.length() > 14 ? phone.substring(0,15) : phone;
            }
            phone = "(" + phone.substring(0, 2) + ") " + phone.substring(2, 7) + "-" + phone.substring(7, 10);
            return phone;
        }
        return "";
    }
}
