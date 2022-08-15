package com.github.curriculeon;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import javax.swing.text.html.parser.Element;
import java.awt.*;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Leon on 2/4/2017.
 */
public final class RandomUtils {
    private static volatile Random random = new Random();

    private RandomUtils() {
        /** This class is uninstantiable */
    }

    /**
     * @return true with the likelihood of specified percentage
     */
    public static Boolean createBoolean(float percentage) {
        Boolean result;
        float randomNumber = random.nextFloat(); //returns value between 0.0 and 1.0.
        if (randomNumber > percentage) {
            return true;
        }
        return false;
    }

    /**
     * @return a random character between the specified min and max character range
     */
    public static Character createCharacter(char min, char max) {
        Character result;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int abcLength = alphabet.length(); //not used.

        int maxValue = alphabet.indexOf(max);
        int minValue = alphabet.indexOf(min);

        result = alphabet.charAt(random.nextInt(maxValue - minValue) + minValue);


        return result;

    }


    /**
     * @return a random float between the specified min and max numeric range
     */
    public static Float createFloat(float min, float max) {


        return random.nextFloat() * (max - min) + min;
    }

    /**
     * @return a random double between the specified min and max numeric range
     */
    public static Double createDouble(double min, double max) {
        return random.nextDouble() * (max - min) + min;
    }

    /**
     * @return a random integer between the specified min and max numeric range
     */
    public static Integer createInteger(int min, int max) {
        Integer result;
        result = random.nextInt(max - min) + min;
        return result;
    }

    /**
     * @return a random long between the specified min and max numeric range
     */
    public static Long createLong(long min, long max) {
        long result;
        int longToMaxInt = (int) max;
        int longToMinInt = (int) min;

        result = random.nextInt(longToMaxInt - longToMinInt) + longToMinInt;
        return result;
    }

    /**
     * @return a random string of the specified length containing characters in the specified range
     */
    public static String createString(char min, char max, int stringLength) {
        String result = "";
        for (int i = 0; i < stringLength; i++) {
            result = result + createCharacter(min, max);
        }

        return result;
    }

    /**
     * @return an array of random string objects of the specified length containing characters in the specified range
     */
    public static String[] createStrings(char min, char max, int stringLength, int stringCount) {
        String[] result = new String[stringCount];
        for (int i = 0; i < stringCount; i++) {
            result[i] = createString(min, max, stringLength);
        }
        return result;
    }

    /**
     * @param minYear minimum year-value to be generated
     * @param maxYear maximum year-value to be generated
     * @return a random Date value within the specified min and max year
     */
    public static Date createDate(Number minYear, Number maxYear) {
        Date result;
        int minimumYear = (int) minYear;
        int maximumYear = (int) maxYear;
        int rangedYear = createInteger(minimumYear, maximumYear);

        int randomDay = random.nextInt(31);
        int randomMonth = random.nextInt(12) - 1;

        result = new java.sql.Date(rangedYear, randomMonth, randomDay);
        return result;
    }

    /**
     * @param minDate minimum Date to be returned
     * @param maxDate minimum Date to be returned
     * @return random date between the specified `minDate` and `maxDate`
     */
    public static Date createDate(Date minDate, Date maxDate) {

        return null;
    }

    /**
     * @param array     an array to select a random element from
     * @param <AnyType> any type
     * @return a randomly selected element from the specified array
     */
    public static <AnyType> AnyType selectElement(AnyType[] array) {
        int arrayLength = Array.getLength(array);
        Object theElement = Array.get(array, random.nextInt(arrayLength));

        AnyType result = (AnyType) theElement;
        return result;
    }

    /**
     * @param list      an array to select a random element from
     * @param <AnyType> any type
     * @return a randomly selected element from the specified array
     */
    public static <AnyType> AnyType selectElement(List<AnyType> list) {
        return list.get(random.nextInt(list.size()));
    }

    /**
     * @return specified string value with random upper and lower casing assigned to each character
     */
    public static String shuffleCasing(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (createBoolean(50)) {
                result = result + str.toLowerCase().charAt(i);
            } else {
                result = result + str.toUpperCase().charAt(i);
            }
        }

        return result;
    }

    /**
     * @return shuffles the specified string array
     */
    public static <AnyType> AnyType[] shuffleArray(AnyType[] array) {
        return null;
    }

    /**
     * @return a random color with the specified maximum rgb values
     */
    public static Color createColor(int maxRed, int maxGreen, int maxBlue) {
        int randomRed = random.nextInt(maxRed);
        int randomGreen = random.nextInt(maxGreen);
        int randomBlue = random.nextInt(maxBlue);


        Color result = new Color(randomRed, randomGreen, randomBlue);
        return result;
    }
}