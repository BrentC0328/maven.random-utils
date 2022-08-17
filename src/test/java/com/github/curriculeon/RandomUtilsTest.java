package com.github.curriculeon;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author leon on 5/22/18.
 */
public class RandomUtilsTest {

    @Test
    public void createFloatTest() {
        // Given
        Float minVal = 0F;
        Float maxVal = 100F;

        for (int i = 0; i < maxVal; i++) {
            // When
            Float randomFloat = RandomUtils.createFloat(minVal, maxVal);
            boolean outcome = RangeChecker.isInRange(randomFloat, minVal, maxVal);

            // Then
            Assert.assertTrue(outcome);
        }
    }


    @Test
    public void createDoubleTest() {
        // Given
        Double minVal = 0D;
        Double maxVal = 100D;

        for (int i = 0; i < maxVal; i++) {
            // When
            Double randomDouble = RandomUtils.createDouble(minVal, maxVal);
            boolean outcome = RangeChecker.isInRange(randomDouble, minVal, maxVal);

            // Then
            Assert.assertTrue(outcome);
        }
    }


    @Test
    public void createLongTest() {
        // Given
        Long minVal = 0L;
        Long maxVal = 100L;

        for (int i = 0; i < maxVal; i++) {
            // When
            Long randomLong = RandomUtils.createLong(minVal, maxVal);
            boolean outcome = RangeChecker.isInRange(randomLong, minVal, maxVal);

            // Then
            Assert.assertTrue(outcome);
        }
    }


    @Test
    public void createIntegerTest() {
        // Given
        Integer minVal = 0;
        Integer maxVal = 100;

        for (int i = 0; i < maxVal; i++) {
            // When
            Integer randomInteger = RandomUtils.createInteger(minVal, maxVal);
            boolean outcome = RangeChecker.isInRange(randomInteger, minVal, maxVal);

            // Then
            Assert.assertTrue(outcome);
        }
    }


    @Test
    public void createCharacterTest() {
        // Given
        char minVal = 'a';
        char maxVal = 'z';

        for (int i = 0; i < maxVal; i++) {
            // When
            Character randomCharacter = RandomUtils.createCharacter(minVal, maxVal);
            boolean outcome = RangeChecker.isInRange(randomCharacter, minVal, maxVal);

            // Then
            Assert.assertTrue(outcome);
        }
    }

    @Test
    public void createStringTest() {
        Integer stringLength = 15;
        Character min = 'a';
        Character max = 'z';
        Integer charDelta = max - min;
        Integer numberOfIterations = charDelta * stringLength;
        for (int i = 0; i < numberOfIterations; i++) {
            // create a random string
            String randomString = RandomUtils.createString(min, max, stringLength);
            Assert.assertEquals(stringLength, randomString.length());

            // check each character of string
            for (char character : randomString.toCharArray()) {
                boolean outcome = RangeChecker.isInRange(character, min, max);
                Assert.assertTrue(outcome);
            }
        }
    }

    @Test
    public void createStringsTest() {
        Integer numberOfStrings = 30;
        Integer stringLength = 15;
        Character min = 'a';
        Character max = 'z';
        Integer charDelta = max - min;
        Integer numberOfIterations = charDelta * stringLength;
        for (int i = 0; i < numberOfIterations; i++) {
            // create a random string array
            String[] randomStrings = RandomUtils.createStrings(min, max, stringLength, numberOfStrings);
            Assert.assertEquals(numberOfStrings, randomStrings.length);
            for (String randomString : randomStrings) {
                // check each character of string

                Assert.assertEquals(stringLength, randomString.length());
                for (char character : randomString.toCharArray()) {
                    boolean outcome = RangeChecker.isInRange(character, min, max);
                    Assert.assertTrue(outcome);
                }
            }
        }
    }

    @Test
    public void createDateWithDateTest() {
        // Given
        long seed = System.currentTimeMillis();

        Date minDate = new Date(seed / 2);
        Date maxDate = new Date(seed);
        Date dateDelta = new Date(maxDate.getTime() - minDate.getTime());

        for (int i = 0; i < dateDelta.getYear(); i++) {
            // When
            Date randomDate = RandomUtils.createDate(minDate, maxDate);
            boolean outcome = RangeChecker.isInRange(randomDate, minDate, maxDate);

            // Then
            Assert.assertTrue(outcome);
        }
    }


    //@Test
    public void createDateWithIntegerTest() {
        // Given
        long seed = System.currentTimeMillis();

        Date minDate = new Date(seed / 2);
        Date maxDate = new Date(seed);
        Date dateDelta = new Date(maxDate.getTime() - minDate.getTime());

        for (int i = 0; i < dateDelta.getYear(); i++) {
            // When
            Date randomDate = RandomUtils.createDate(minDate.getTime(), maxDate.getTime());
            boolean outcome = RangeChecker.isInRange(randomDate, minDate, maxDate);

            // Then
            Assert.assertTrue(outcome);
        }
    }

    @Test
    public void selectElementListTest() {
        // Given
        String[] array = {"The", "Quick", "Brown", "Fox", "Jumps", "Over"};
        List<String> list = Arrays.asList(array);
        double numberOfIterations = Math.pow(array.length, array.length);
        for (int i = 0; i < numberOfIterations; i++) {

            // When
            String value = RandomUtils.selectElement(list);
            boolean isValidValue = list.contains(value);

            // Then
            Assert.assertTrue(isValidValue);
        }
    }


    @Test
    public void selectElementArrayTest() {
        // Given
        String[] array = {"The", "Quick", "Brown", "Fox", "Jumps", "Over"};
        List<String> list = Arrays.asList(array);
        double numberOfIterations = Math.pow(array.length, array.length);
        for (int i = 0; i < numberOfIterations; i++) {

            // When
            String value = RandomUtils.selectElement(array);
            boolean isValidValue = list.contains(value);

            // Then
            Assert.assertTrue(isValidValue);
        }
    }


    @Test
    public void shuffleArrayTest() {
        // Given
        Integer[] array = {1, 2, 3, 4, 5};
        String arrayAsStr = Arrays.toString(array);

        // When
        Integer[] newArray =  RandomUtils.shuffleArray(array);
        String newArrayAsStr = Arrays.toString(newArray);

        // Then
        Assert.assertFalse(newArrayAsStr.equals(arrayAsStr));
    }
}
