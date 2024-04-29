import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ClimateQueries extends ArrayMethods{

    // Below are stubs for each of the methods for the 
    // climate analysis. You should include both ranged
    // and unranged methods for each, but only the unranged
    // are listed below

   /**
    * Creates a boolean array whose values correspond to the array value's equality to a specified value.
    * @param arr    float array
    * @param val    float value against which array values are checked
    * @return       a boolean array. for any index i in the inputted array that equals the inputted value, the returned boolean will return
    */
    public static boolean[] isEqualTo(float[] arr, float val){
        // PSEUDO CODE
        /*
         * boolean array indicator of the same length as arr
         * for loop running from 0 to the length of arr
         *  sets indicator[i] to true if arr[i] is the same as val, otherwise sets it to false
         * return indicator
         */
        boolean[] indicator = new boolean[arr.length];
        for(int i=0; i<arr.length; i++) {
            if(arr[i]==val) {
                indicator[i]=true;
            }
            else {
                indicator[i]=false;
            }
            //System.out.println(arr[i] + " is " + indicator[i]);

        }
        return indicator;
    }

    /**
     * Creates a boolean array whos values are the opposite of the inputted array's values.
     * @param arr   boolean array
     * @return      a boolean array whos values are the opposite of arr's values (ie: if arr[i] is true, returned[i] is false)
     */
    public static boolean[] logicalNot(boolean[] arr){
        // PSEUDO CODE
        /*
         * 
         */
        boolean[] indicator = new boolean[arr.length];
        for(int i=0; i<arr.length; i++) {
            indicator[i]=!arr[i];
        }
        return indicator;
    }

    /**
     * Creates a boolean array whos values are only true if the inputted arrays' values are both true.
     * @param arr1  first boolean array
     * @param arr2  second boolean array
     * @return      returns a boolean array for which all values are false unless arr1[i] and arr2[i] are true.
     */
    public static boolean[] logicalAnd(boolean[] arr1, boolean[] arr2){
        // PSEUDO CODE
        /*
         * 
         */
        if(arr1.length!=arr2.length) {
            throw new RuntimeException();
        }

        boolean[] indicator = new boolean[arr1.length];
        for(int i=0; i<arr1.length; i++) {
            if(arr1[i]==false || arr2[i]==false) {
                indicator[i]=false;
            }
            else {
                indicator[i]=true;
            }

        }
        return indicator;
    }

    /**
     * Creates a boolean array with values that show whether an inputted array's values are greater or equal to an inputted float value.
     * @param arr   float array
     * @param val   float value against which all array values are checked
     * @return      a boolean array that has a value at every index i that is true if arr[i] equals or is greater than val
     */
    public static boolean[] isGreaterThan(float[] arr, float val){
        // PSEUDO CODE
        /*
         * 
         */
        boolean[] indicator = new boolean[arr.length];
        for(int i=0; i<arr.length; i++) {
            if(arr[i]>=val) {
                indicator[i]=true;
            }
            else {
                indicator[i]=false;
            }
            //System.out.println(arr[i] + " is " + indicator[i]);

        }
        return indicator;
    }

    /**
     * Creates a boolean array that indicates which dates in a String array are between two inputted times.
     * @param arr       String array of dates
     * @param date1     earlier date
     * @param date2     later date
     * @return          a boolean array that has a value at every index i that is true if arr[i] is later or equal to date1 and earlier or equal to date 2
     */
    public static boolean[] datesBetween(String[] arr, String date1, String date2){
        // PSEUDO CODE
        /*
         * 
         */
        boolean[] indicator = new boolean[arr.length];
        for(int i=0; i<arr.length; i++) {
            try {
                Integer.parseInt(arr[i]);
                Integer.parseInt(date1);
                Integer.parseInt(date2);
            } catch (Exception e) {
                return indicator;
            }
            int check= Integer.parseInt(arr[i]);
            int early= Integer.parseInt(date1);
            int late= Integer.parseInt(date2);

            if(check >= early && check<=late) {
                indicator[i]=true;
            }
            else {
                indicator[i]=false;
            }
        }
        return indicator;
    }

    /**
     * Finds the mean of an array between two indices, excluding certain values.
     * @param arr       float array
     * @param indicator boolean array in which each value at index i is false if arr[i] should be excluded from the mean
     * @param lo        the lower index used for the mean, inclusive
     * @param hi        the upper index used for the mean, exclusive
     * @return          a float value that is the mean of all floats in arr stored in indices between lo (inclusive) and hi (exclusive) for which indicator is true
     */
    public static float mean(float[] arr, boolean[] indicator, int lo, int hi){
        // PSEUDO CODE
        /*
         * 
         */
        // returns the mean of floats in arr that correspond to true vals in indicator
        if(count(indicator)==0) {
            return -1;
        }
        float sum = 0;
        float tot = 0;
        for(int i=lo; i<hi; i++) {
            if(indicator[i]) {
                sum+=arr[i];
                tot++;
            }
        }
        return sum / tot;
    }

    /**
     * Finds the mean of an array, excluding certain values.
     * @param arr       float array
     * @param indicator boolean array in which each value at index i is false if arr[i] should be excluded from the mean
     * @return
     */
    public static float mean(float[] arr, boolean[] indicator){
        // PSEUDO CODE
        /*
         * 
         */
        return mean(arr, indicator, 0, arr.length);
    }

    /**
     * counts the number of 'true' values in an array
     * @param arr   boolean array
     * @return      an int value that equals the amount of true values in arr
     */
    public static int count(boolean[] arr){
        // PSEUDO CODE
        /*
         * 
         */
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i]==true) {
                count++;
            }
        }
        return count;
    }

    /**
     * Finds the first index of a true value in an array.
     * @param arr   boolean array
     * @return      an int value of the first index of 'true' appearing in arr, otherwise returning -1
     */
    public static int findFirst(boolean[] arr){
        // PSEUDO CODE
        /*
         * 
         */
        if(count(arr)==0) {
            //System.out.println("Count is " + count(arr));
            return -1;
        }
        
        // returns first index of true val, otherwise -1
        for(int i=0; i<arr.length; i++) {
            if(arr[i]==true) {
                //System.out.println(i + " is true");
                return i;
            }
        }

        return -1;
    }


    /**
     * Creates an array with the indices of all the true values in an array
     * @param arr   boolean array
     * @return      an int array where every value i corresponds to every arr[i] that equals true
     */
    public static int[] find(boolean[] arr){
        // PSEUDO CODE
        /*
         * 
         */
        if(findFirst(arr)==-1) {
            return new int[] {};
        }
        int[] ret = new int[count(arr)];
        int retCount = 0;

        for(int i=0; i<arr.length; i++) {
            if(arr[i]==true) {
                ret[retCount]=i;
                retCount++;
            }
        }
        return ret;
        
    }

    /**
     * Finds the lowest value in an array, excluding certain vaues
     * @param arr       float array
     * @param indicator boolean array, for which every false value at index i means arr[i] will be excluded
     * @return          the lowest float value in arr at index i where indicator[i] is true
     */
    public static float min(float[] arr, boolean[] indicator){
        // PSEUDO CODE
        /*
         * create a float lowest, temporary value ff the first included arr value
         * for loop going from the index above lowest to the length of indicator
         *  if statement changing lowest to arr[i] whenever it's below lowest and an included index
         */

        float lowest=arr[findFirst(indicator)];
        //System.out.println("    First true is " + lowest + " degrees Celcius at " + findFirst(indicator));
        for(int i=findFirst(indicator)+1; i<indicator.length; i++) {
            if(arr[i]<lowest && indicator[i]){
                lowest=arr[i];
                //System.out.println("    New lowest is " + lowest + " degrees Celcius at i=" + i);
            }
        }
        return lowest;
    }

    public static void main(String[] args) {
    String filename = (args.length > 0) ? args[0] : "data/YUMA_2023.txt";
    Scanner file = null;
    try {
      file = new Scanner(new File(filename));
    } catch (FileNotFoundException e) {
      System.err.println("Cannot locate file.");
      System.exit(-1);
    }

    // PSEUDO CODE
    /*
     * arrays for temperature and dates throughout the year
     * fill out yearTemps and yearDates based on read data
     * print out annual mean
     * print minimum daily temperature
     * print maximum temperature
     * print mean temp in January
     * print mean temp in Jult 
     */

    float[] yearTemps = new float[226];
    String[] yearDates = new String[226];
    int index=0;

    while (file.hasNextLine()) {
      String line = file.nextLine();
      String[] fields = line.split("\\s+");
      String date = fields[1];
      float temperature = Float.valueOf(fields[8]);
      //System.out.println("On " + date + " the temperature was " + temperature + " degrees Celsius.");
      yearTemps[index]=temperature;
      yearDates[index]=date;
      index++;
    }

    boolean[] nots = logicalNot(isEqualTo(yearTemps, -9999.0f));
    System.out.println("Source file: " + filename + "\n");
    System.out.println("Annual mean temperature: " + mean(yearTemps, nots) + " degrees Celcius");
    System.out.println("Minimum average daily temperature: " + min(yearTemps, nots) + " degrees Celcius");
    System.out.println("Maximum average daily temperature: " + max(yearTemps) + " degrees Celcius");
    // is both datesbetween and nots
    System.out.println("Mean temperature in January: " + mean(yearTemps, logicalAnd(nots, datesBetween(yearDates, "20230101", "20230131"))) + " degrees Celcius");
    System.out.println("Mean temperature in July: " + mean(yearTemps, logicalAnd(nots, datesBetween(yearDates, "20230701", "20230731"))) + " degrees Celcius");
    file.close();
  }
}