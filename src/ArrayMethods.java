public class ArrayMethods {

    /**
     * Finds the sum of all array values.
     * @param arr   float array
     * @return      A float sum of all array values
     */
    public static float wholeSum(float[] arr){
        return sum(arr, 0, arr.length);
    }

    // inclusive of lo, exclusive of hi
    /**
     * Finds the sum of array values between two indices.
     * @param arr   float array
     * @param lo    integer lowest index inluded in the sum
     * @param hi    integer highest index, excluded from the sum
     * @return      a float sum of all values in the array between lo (inclusive) and hi (exclusive)
     */
    public static float sum(float[] arr, int lo, int hi){
        // PSEUDOCODE
        /*
         * float sum
         * if loop that runs between lo and hi
         *  add arr[i] to the sum
         * return sum
         */
        float sum=0.0f;
        for(int i=lo; i<hi; i++) {
            sum+=arr[i];
        }
        return sum;
    }

    /**
     * Finds the mean of a float array's values between two indices.
     * @param arr   float array
     * @param lo    integer lowest index included in the mean
     * @param hi    integer highest index, excluded from the mean
     * @return      a float mean of all values in the array between lo (inclusive) and hi (exclusive)
     */
    public static float mean(float[] arr, int lo, int hi){
        //PSEUDOCODE
        /*
         * return a call to sum divided by hi-lo
         */
        return sum(arr, lo, hi) / (hi-lo);
    }


    /**
     * Finds the mean of all float array's values.
     * @param arr   float array
     * @return      a float mean of all values in the array
     */
    public static float mean(float[] arr){
        //PSEUDOCODE
        /*
         * return 0 if the array is empty
         * return a call to the other mean function with lo=0 and hi=the length of the array
         */
        if(arr.length==0) {
            return 0;
        }
        // write your code here and return your answer
        return mean(arr, 0, arr.length);
    }

    /**
     * Finds the lowest value between two indices of an array, returning a null value if the lowest & highest values are incorrect.
     * @param arr   float array
     * @param lo    integer lowest index checked
     * @param hi    integer highest index, excluded from the check
     * @return      the minimum float value of array arr between indices lo (inclusive) and hi (exclusive)
     */
    public static float min(float[] arr, int lo, int hi){

        //PSEUDOCODE
        /*
         * return null if low and/or hi are invalid
         * track lowest, starting value = arr[lo]
         * for loop between lo+1 and hi
         *  change value of lowest to arr[i] if it's lower
         * return lowest
         */

        try {
            float lowest=arr[lo];
            float highest=arr[hi-1];
        } catch (Exception e) {
            return Float.NaN;
        }
        if(lo==hi) {
            return Float.NaN;
        }

        float lowest=arr[lo];
        for(int i=lo+1; i<hi; i++) {
            if(arr[i]<lowest){
                lowest=arr[i];
            }
        }
        return lowest;
    }

    /**
     * Finds the lowest value in an array
     * @param arr   float array
     * @return      the minimum value in array arr
     */
    public static float min(float[] arr){
        //PSEUDOCODE
        /*
         * return a call to min that includes all of arr in its range
         */
        return min(arr, 0, arr.length);
    }


    /**
     * Finds the highest value in an array between two indices.
     * @param arr   float array
     * @param lo    lowest index checked
     * @param hi    highest index, excluded from checking
     * @return      a null value if lo and hi are invalid, otherwise the maximum float value in array arr between lo (inclusive) and hi (exclusive)
     */
    public static float max(float[] arr, int lo, int hi){
        //PSEUDOCODE
        /*
         * return null if highest and/or lowest are invalid
         * create a float highest with a placeholder value of arr[lo]
         * for loop between lo+1 and hi
         *  change value of highest to arr[i] if it's higher
         * return highest
         */
        try {
            float highest=arr[lo];
            float lowest = arr[hi-1];
        } catch (Exception e) {
            return Float.NaN;
        }
        if(lo==hi) {
            return Float.NaN;
        }


        float highest=arr[lo];
        for(int i=lo+1; i<hi; i++) {
            if(arr[i]>highest){
                highest=arr[i];
            }
        }
        return highest;
    }

    /**
     * Finds the highest value in an array
     * @param arr   float array
     * @return      the highest value in array arr
     */
    public static float max(float[] arr){
        // PSEUDO CODE
        /*
         * return a call to max including all of arr in its range
         */
        return max(arr, 0, arr.length);
    }

}
