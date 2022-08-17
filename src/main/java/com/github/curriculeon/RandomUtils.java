package com.github.curriculeon;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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
//        String alphabet = "abcdefghijklmnopqrstuvwxyz";
//        int abcLength = alphabet.length(); //not used.
        //maxValue = alphabet.indexOf(max);
        //int minValue = alphabet.indexOf(min);
        //                result = alphabet.charAt(random.nextInt(maxValue - minValue) + minValue);


        result = (char) createInteger(min, max).intValue();


        return result;

    }


    /**
     * @return a random float between the specified min and max numeric range
     */
    public static Float createFloat(float min, float max) {


        return createDouble(min, max).floatValue();
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
//        Integer result;
//        result = random.nextInt(max - min) + min;
        return createDouble(min, max).intValue();
    }

    /**
     * @return a random long between the specified min and max numeric range
     */
    public static Long createLong(long min, long max) {

        return createDouble(min, max).longValue();
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

        int rangedYear = createInteger((int) minYear, (int) maxYear);

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
        long theMinimum = minDate.getTime();
        long theMaximum = maxDate.getTime();

        long randomDate = createLong(theMinimum, theMaximum);
        Date date = new Date(randomDate);
        return date;
    }

    /**
     * @param array     an array to select a random element from
     * @param <AnyType> any type
     * @return a randomly selected element from the specified array
     */
    public static <AnyType> AnyType selectElement(AnyType[] array) {
        int arrayLength = Array.getLength(array);
        int randomNumber = random.nextInt(arrayLength);

        AnyType result = array[randomNumber];

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
        List<AnyType> arrayList = Arrays.asList(array);
        Collections.shuffle(arrayList);
        //want to move sorted array list back into the array.
        for (int i = 0; i < array.length; i++) {
            AnyType randomGet = arrayList.get(i);
            array[i] = randomGet;
        }

        return array;

    }

    /**
     * @return a random color with the specified maximum rgb values
     */
    public static Color createColor(int maxRed, int maxGreen, int maxBlue) {
        int randomRed = random.nextInt(maxRed);
        int randomGreen = random.nextInt(maxGreen);
        int randomBlue = random.nextInt(maxBlue);


        return new Color(randomRed, randomGreen, randomBlue);
    }
}