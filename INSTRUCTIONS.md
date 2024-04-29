---
Assignment 1: Arrays and Climate
---
**Due: Tuesday, February 6, 2023, midnight**
 
*Note: Assignment 1 should be completed as a pair programming exercise.*

In this assignment, you will use arrays to analyze real data from the National Oceanic and Atmospheric Administration (NOAA). This assignment will allow you practice coding in Java, working with arrays, writing unit tests, and analyzing real data.

In the first part of the assignment, you will write and test several core methods that compute different information about an array. In the second part, you will apply your methods to the NOAA data.

Remember: Please do not use an `ArrayList` or `IndexAccess` for the time being, as the point of this assignment is to work with the actual underlying storage paradigm as closely as possible.

# Part 1: Writing the Core Methods

Please write all of these methods to work with a `float[]` array. Write each of the methods below as a static member of the class `ArrayMethods` (an stub is provided in `ArrayMethods.java`). Put your tests in the class `ArrayMethodsTest` (we have provided some code to get you started). We have provided some example tests, but you should add two more for each method.

The methods should be designed to be broadly useful given that you will also be using them to analyze data in various ways.  It's good practice to start by writing the test cases first by thinking about the edge cases. This will help you to think through the problem, as you first design a few general examples and then think about what types of errors could happen.

1. **Whole Array Sum**: The first method, `wholeSum`, will return the sum of all the elements in an array. Three tests are provided. Write at least two more test cases.

2. **Partial Array Sum**: What if we don't want to take the sum of the whole array, but instead just the elements at indices *i* to *j*? Here you will write a method called `sum` that takes three arguments: 
- `arr``: the array itself 
- `lo`: the first index to include (inclusive)
- `hi`: the last index (exclusive) 

    Write at least three more test cases in addition to the ones provided.

For these situations, method overloading will come in handy. Think about what `wholeSum` and `sum` have in common. Instead of writing two loops, instead you could have just overloaded `sum` to take just the array as arguments and then call sum with `lo` set to `0` and `hi` set to `arr.length`. Going forward, we will use method overloading to define a general "ranged" version of a function that takes `lo` and `hi` and a more specialized "unranged" version that takes just the array and then calls the ranged version with the `lo` and `hi` parameters filled in.

3. **Array Mean**: Computing the mean is similar to the sum, with an additional step at the end to divide the total by the number of measurements.  In fact, you can use the `sum` method you just wrote to help you implement the next method, `mean`.  Come up with three additional tests.

4. **Array Minimum** and **Array Maximum**:  The methods `min` and `max` will return the smallest or largest value found, respectively. Make sure to include both a ranged and unranged version and devise a thorough set of test cases, including at least 3-5 more examples than those shown.  In case of an empty array or range, these methods should return `Float.NaN`.

5. **[Stretch] Array Lowest** and **Array Highest**:  This item is a *stretch goal*, meaning that it may be more difficult than other parts of the assignment.  We recommend that you hold off on attempting stretch goals until you have completed the rest of the assignment fully. These methods are not included in the stub, so you will need to create the appropriate methods to run and test the functions described here.

    Instead of a single smallest (or largest) value, you now want to return the `k` smallest (or largest) values, where `k` is a parameter specified when the method is called.  The results should be returned in a new array of length `k` and do not need to appear in any particular order.  If the value of `k` is larger than the size of the range, empty values should be filled in with `Float.NaN`.  As usual, please devise a full set of test cases, including examples where values are duplicated.

    * Method name: `lowest`
    * Test #1 Input:  `[1.0, 3.0, 2.0, 4.0], 0, 4, 2` Output: `[1.0, 2.0]` or `[2.0, 1.0]`
    * Test #2 Input:  `[2.0, 3.0, 2.0, 3.0], 0, 4, 3` Output: `[2.0, 2.0, 3.0]` or some other permutation
    * Test #3 Input:  `[4.0, 3.0, 2.0, 1.0], 2` Output: `[1.0, 2.0]` or `[2.0, 1.0]`
    * Test #4 Input:  `[4.0, 3.0, 2.0, 1.0], 1` Output: `[1.0]`
    * Test #5 Input: `[4.0, 3.0], 3` Output: `[4.0, 3.0, Float.NaN]` or some other permutation
    * etc.

    * Method name: `highest`
    * Test #1 Input:  `[1.0, 3.0, 2.0, 4.0], 0, 4, 2` Output: `[3.0, 4.0]` or `[4.0, 3.0]`
    * Test #2 Input: `[4.0, 3.0], 3` Output: `[4.0, 3.0, Float.NaN]` or some other permutation
    * etc.

# Stage 3: Reading in the Data
You can [download climate data files from NOAA](https://www.ncei.noaa.gov/access/crn/qcdatasets.html).

Reading data is a core skill that you will use for many assignments this semester. We've provided an example file reader in `ReadFile.java`.  Right now, all it does is read in and print out the date and temperature fields from a datafile.  You can modify this code as needed to complete the tasks below.

For this portion of the assignment, work with the class `ClimateQueries`. Your goal is to add a main method to this class that will read data from a file and produce output in the form shown below:

    Source file: YUMA_2023.txt
    Annual mean temperature: 25.6 degrees Celsius
    Minimum average daily temperature: -2.7 degrees Celsius
    Maximum average daily temperature: 37.4 degrees Celsius
    Mean temperature in January: 8.4 degrees Celsius
    Mean temperature in July: 29.8 degrees Celsius

## Stage 4: Handling Missing Data

Oftentimes, real data files have missing values.  Here, these values are indicated with the value `-9999.0`.  Including these values when calculating something like average temperature would skew the results.  In our calculations, we therefore need to exclude missing values from our computations.

One way to do this is to write customized versions of all our methods that include some condition for when to exclude an element.  The disadvantage of this approach is that different versions would be required for every type of condition.  A more general approach is to introduce _indicator variables_ that describe which values to keep and which to drop. Here, we will use arrays of `boolean` values that are the same length as the original arrays.

For the following methods in `ClimateQueries`, you will apply a condition and then return the corresponding indicator array. 

* Method `isEqualTo` accepts an array and a value. It compares the value to each element in the array and returns an indicator array of booleans to convey whether each element in the array is (true) or is not (false) equal to the compared value.
* Method `logicalNot` accepts an array of booleans and returns a new array with the values inverted. For each element that is `true`, the corresponding value in the new array will be `false`, and vice versa.
  
# Stage 5: Writing More Complex Queries

Once we have the concept of an indicator variable, we can use them to allow more creative queries.  Add the methods below to your collection, along with a set of robust tests. For each, think about whether you can call methods you wrote for ArrayMethods or elsewhere in ClimateQueries.
* Method `logicalAnd` compares values in two boolean arrays. If the *i*th value in both arrays is `true`, then the array that is returned should have a `true` in position *i*. Otherwise, the value should be `false`. (That is, *i* is only true when *i* is true in both input arrays)
* Method `isGreaterThan` checks whether each value in an array is greater than a provided value, similar to `isEqualTo`.
* Method `datesBetween` identifies whether each date in an array (of strings) falls between two provided dates (as strings). Hint: You may want to use Integer.parseInt(arr[i]) to evaluate these strings as integers. Because they are in the ISO date format, this comparison will work!
* Method `mean` is an overloaded method building on your `mean` from ArrayMethods. Here, you will accept two arrays: first, an array of floats, second, an indicator array. Additionally, you should overload this method further so that it can work if ranged or unranged, i.e., can optionally accept integers representing the `hi` and `lo` indices to include in your calculated mean. 
* Method `count` counts the number of `true` values in a boolean array and returns the number as an `int`.
* Method `findFirst` identifies the index of the first `true` in a boolean array. If no `true` value is found, then it returns `-1`
* Method `find` is similar to findFirst, but it returns an array indicating the indices of all `true` values in the input boolean array. If there is no `true` found, it returns an empty array.

Together, these methods will allow you to ask questions like "What was the first date of the year with a temperature above 25 degrees?" or "How many days during the summer had temperatures above 30 degrees?"

# Stage 6: Putting it All Together

In the last step, you will utilize all the material developed above, and also help to collect data about the effects of climate change on a given location. 
* Choose a target location of interest to you, with at least 8-10 years of readings.  
* In the class `ClimateStudy`, process the files and create arrays to store each of the following pieces of information:
    * The average daily temperature over the full year
    * The first day in each year with an average temperature that exceeds the annual average from the first year of data
    * The number of days with temperatures over 30 degrees
  
Now divide the period you analyzed into a first half and a second half, and compute the average of each of these quantities for both groups.  Does the second half seem warmer than the first?  (Of course, we would need to do a much more rigorous statistical analysis to draw any real conclusions.  However, here you have shown that you would be able to get this type of analysis started by implementing arrays!)