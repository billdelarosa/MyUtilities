/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.wad.date;

import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;


/**
 * Utility class to manage frequently used Date and Time code using Java
 * version 1.8 API
 * 
 * @author Billy-Mac
 * @version 1.0
 */
public class DateUtilities {

    /** 
     * Parses a user String with the format "yyyy-MM-dd" into a LocalDateTime object
     * 
     * @param stringToFormatToDate - a String that will be parsed into a LocalDateTime object. 
     *                                 String must be in the format "yyyy-MM-dd"
     * 
     * @return a LocalDateTime object with the date and time parsed from the String
     *           value that is entered by user
     */
    public LocalDateTime stringToLocalDateTime(String stringToFormatToDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime dateTime = LocalDateTime.parse(stringToFormatToDate, formatter);
        return dateTime;
    }
    
    /**
     * Formats a LocalDateTime object to a String with the format "yyyy-MM-dd"
     * 
     * @param dateTime - a LocalDateTime object 
     * 
     * @return - a String that is formatted into pattern "yyyy-MM-dd" 
     *              from a LocalDateTime object
     */
    public String localDateTimeToString(LocalDateTime dateTime) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return df.format(dateTime);
    } 
    
    /**
     * Returns the difference between two LocalDateTime objects as DAYS stored as a long
     * 
     * @param start - a LocalDateTime object
     * @param end - a LocalDateTime object
     * 
     * @return - the difference in Days as a long between two LocalDateTime objects
     */
    public long findDifferenceInDays(LocalDateTime start, LocalDateTime end) {
        Duration duration = Duration.between(start, end);
        return duration.toDays();
    }
    
    /**
     * Returns the difference between two LocalDateTime objects as HOURS stored as a long
     * 
     * @param start - a LocalDateTime object
     * @param end - a LocalDateTime object
     * 
     * @return - the difference in Hours as a long between two LocalDateTime objects
     */
    public long findDifferenceInHours(LocalDateTime start, LocalDateTime end) {
        Duration duration = Duration.between(start, end);
        return duration.toHours();
    }
    
    /**
     * Returns the difference between two LocalDateTime objects as MINUTES stored as a long
     * 
     * @param start - a LocalDateTime object
     * @param end - a LocalDateTime object
     * 
     * @return - the difference in Minutes as a long between two LocalDateTime objects
     */
    public long findDifferenceInMinutes(LocalDateTime start, LocalDateTime end) {
        Duration duration = Duration.between(start, end);
        return duration.toMinutes();
    }
    
    /**
     * Formats a date to a String while giving the user the option to choose
     * the amount of DAYS in the future they want the date (in String format) returned to be
     * 
     * @param daysInFuture - a Long chosen by user to specify the amount of days ahead 
     *                      that they want the returned date (in String format) to be
     * 
     * @return - a String formatted from a LocalDateTime
     */
    public String getFormattedDateXAmountOfDaysInFuture(long daysInFuture) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime localDate = LocalDateTime.now().plusDays(daysInFuture);
        return df.format(localDate);
    }
    
    /**
     * Formats a date to a String while giving the user the option to choose
     * the amount of MONTHS in the future they want the date (in String format) returned to be
     * 
     * @param monthsInFuture - a Long chosen by user to specify amount of MONTHS ahead
     *                          that they want the returned date (in String format) to be
     * 
     * @return - a String formatted from a LocalDateTime
     */
    public String getDateXAmountOfMonthsInFuture(long monthsInFuture) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime localDate = LocalDateTime.now().plusMonths(monthsInFuture);
        return df.format(localDate);
    }
    
    /**
     * Formats a date to a String X DAYS in the past (where X is the long "daysInPast")
     * 
     * @param daysInPast - a Long chosen by user to specify amount of DAYS in the PAST
     *                     that user wants the returned date (in String format) to be
     * 
     * @return - a String formatted from a LocalDateTime 
     */
    public String getFormattedDateXAmountOfDaysInPast(long daysInPast) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime localDate = LocalDateTime.now().minusDays(daysInPast);
        return df.format(localDate);
    }
    
    /**
     * Formats a date to a String X MONTHS in the past (where X is the long "monthsInPast")
     * 
     * @param monthsInPast - a Long chosen by user to specify amount of MONTHS in PAST
     *                       that user wants the returned date (in String format) to be
     * 
     * @return - a String formatted from a LocalDateTime
     */
    public String getFormattedDateXAmountOfMonthsInPast(long monthsInPast) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime localDate = LocalDateTime.now().minusDays(monthsInPast);
        return df.format(localDate);
    }
    
}