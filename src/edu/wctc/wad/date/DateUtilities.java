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
import java.time.temporal.TemporalAdjusters;


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
    public LocalDateTime stringToLocalDateTime(String stringToFormatToDate) 
            throws IllegalArgumentException {
        if (stringToFormatToDate == null || stringToFormatToDate.isEmpty()) {
            throw new IllegalArgumentException("String to format to date cannot be null");
        }
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
    public String localDateTimeToString(LocalDateTime dateTime) 
            throws IllegalArgumentException {
        if (dateTime == null) {
            throw new IllegalArgumentException("date time cannot be null");
        }
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
    public long findDifferenceInDays(LocalDateTime start, LocalDateTime end) 
            throws IllegalArgumentException {
        if (start == null || end == null) {
            throw new IllegalArgumentException("start and end dates cannot be null");
        }
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
    public long findDifferenceInHours(LocalDateTime start, LocalDateTime end) 
            throws IllegalArgumentException {
        if (start == null || end == null) {
            throw new IllegalArgumentException("start and end dates cannot be null");
        }
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
    public long findDifferenceInMinutes(LocalDateTime start, LocalDateTime end) 
            throws IllegalArgumentException {
        if (start == null || end == null) {
            throw new IllegalArgumentException("start and end dates cannot be null");
        }
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
    public String getFormattedDateXAmountOfDaysInFuture(long daysInFuture) 
            throws IllegalArgumentException {
        if (daysInFuture < 0) {
            throw new IllegalArgumentException("Days in future cannot be less than zero");
        }
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
    public String getDateXAmountOfMonthsInFuture(long monthsInFuture) 
            throws IllegalArgumentException {
        if (monthsInFuture < 0) {
            throw new IllegalArgumentException("Months in future cannot be less than zero");
        }
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
    public String getFormattedDateXAmountOfDaysInPast(long daysInPast) 
            throws IllegalArgumentException {
        if (daysInPast < 0) {
            throw new IllegalArgumentException("Days in past cannot be less than zero");
        }
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
     * 
     */
    
    public String getFormattedDateXAmountOfMonthsInPast(long monthsInPast) 
            throws IllegalArgumentException {
        if (monthsInPast < 0){
            throw new IllegalArgumentException("Months in past cannot be less than zero");
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime localDate = LocalDateTime.now().minusDays(monthsInPast);
        return df.format(localDate);
    }
    
    /**
     * Finds the last day of the month for the LocalDate passed to the method
     * i.e.: LocalDate 2000-12-1 passed in would return 2000-12-31 
     * 
     * @param date - a LocalDate object
     * 
     * @return a LocalDate object of last day of the month of the LocalDate passed
     * 
     * @throws IllegalArgumentException 
     */
    public LocalDate getLastDayOfMonth(LocalDate date) throws IllegalArgumentException {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        return date.with(TemporalAdjusters.lastDayOfMonth());
    }  
    
    
}