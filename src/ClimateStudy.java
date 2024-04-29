import java.io.*;
import java.util.Scanner;

public class ClimateStudy extends ClimateQueries {
    /*     * The average daily temperature over the full year
    * The first day in each year with an average temperature that exceeds the annual average from the first year of data
    * The number of days with temperatures over 30 degrees
  
  Now divide the period you analyzed into a first half and a second half, and compute the average of each of these quantities for both groups.  Does the second half seem warmer than the first?  (Of course, we would need to do a much more rigorous statistical analysis to draw any real conclusions.  However, here you have shown that you would be able to get this type of analysis started by implementing arrays!) */

    public static void main(String[] args) {
    String filename = (args.length > 0) ? args[0] : "data/MILLBROOK_2010_2019.txt";
    Scanner file = null;
    try {
      file = new Scanner(new File(filename));
    } catch (FileNotFoundException e) {
      System.err.println("Cannot locate file.");
      System.exit(-1);
    }
    float[] yearTemps = new float[3652];
    String[] yearDates = new String[3652];
    int index=0;

    // PSEUDO CODE
    /*
     * create arrays for dates and temperatures throughout the year
     * Read through the file filling out yearTemps and yearDates
     * 
     * Print mean temp x 10
     * print first warm day x 10
     * print # of warm days x 10
     * print the average first 5 year temp
     * print the average last 5 year temp
     */

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
    System.out.println("\nSource file: " + filename + "\n");

    boolean[] dates_2010 = datesBetween(yearDates, "20100101", "20101231");
    boolean[] in_2010 = logicalAnd(nots, dates_2010);
    float mean_2010 = mean(yearTemps, logicalAnd(nots, dates_2010));
    int first_2010 = findFirst(logicalAnd(isGreaterThan(yearTemps, mean_2010), in_2010));
    float warm_2010 = count(logicalAnd(isGreaterThan(yearTemps, 30), in_2010));
    System.out.println("\n Year: 2010");
    System.out.println("  Annual mean temperature: " + mean_2010 + " degrees Celcius");
    System.out.println("  First above average day: " + yearDates[first_2010]);
    System.out.println("  # days above 30 degrees: " + warm_2010 + "\n");

    boolean[] dates_2011 = datesBetween(yearDates, "20110101", "20111231");
    boolean[] in_2011 = logicalAnd(nots, dates_2011);
    float mean_2011 = mean(yearTemps, logicalAnd(nots, dates_2011));
    int first_2011 = findFirst(logicalAnd(isGreaterThan(yearTemps, mean_2011), in_2011));
    float warm_2011 = count(logicalAnd(isGreaterThan(yearTemps, 30), in_2011));
    System.out.println("\n Year: 2011");
    System.out.println("  Annual mean temperature: " + mean_2011 + " degrees Celcius");
    System.out.println("  First above average day: " + yearDates[first_2011]);
    System.out.println("  # days above 30 degrees: " + warm_2011 + "\n");

    boolean[] dates_2012 = datesBetween(yearDates, "20120101", "20121231");
    boolean[] in_2012 = logicalAnd(nots, dates_2012);
    float mean_2012 = mean(yearTemps, logicalAnd(nots, dates_2012));
    int first_2012 = findFirst(logicalAnd(isGreaterThan(yearTemps, mean_2012), in_2012));
    float warm_2012 = count(logicalAnd(isGreaterThan(yearTemps, 30), in_2012));
    System.out.println("\n Year: 2012");
    System.out.println("  Annual mean temperature: " + mean_2012 + " degrees Celcius");
    System.out.println("  First above average day: " + yearDates[first_2012]);
    System.out.println("  # days above 30 degrees: " + warm_2012 + "\n");

    boolean[] dates_2013 = datesBetween(yearDates, "20130101", "20131231");
    boolean[] in_2013 = logicalAnd(nots, dates_2013);
    float mean_2013 = mean(yearTemps, logicalAnd(nots, dates_2013));
    int first_2013 = findFirst(logicalAnd(isGreaterThan(yearTemps, mean_2013), in_2013));
    float warm_2013 = count(logicalAnd(isGreaterThan(yearTemps, 30), in_2013));
    System.out.println("\n Year: 2013");
    System.out.println("  Annual mean temperature: " + mean_2013 + " degrees Celcius");
    System.out.println("  First above average day: " + yearDates[first_2013]);
    System.out.println("  # days above 30 degrees: " + warm_2013 + "\n");

    boolean[] dates_2014 = datesBetween(yearDates, "20140101", "20141231");
    boolean[] in_2014 = logicalAnd(nots, dates_2014);
    float mean_2014 = mean(yearTemps, logicalAnd(nots, dates_2014));
    int first_2014 = findFirst(logicalAnd(isGreaterThan(yearTemps, mean_2014), in_2014));
    float warm_2014 = count(logicalAnd(isGreaterThan(yearTemps, 30), in_2014));
    System.out.println("\n Year: 2014");
    System.out.println(" Annual mean temperature: " + mean_2014 + " degrees Celsius");
    System.out.println(" First above average day: " + yearDates[first_2014]);
    System.out.println(" # days above 30 degrees: " + warm_2014 + "\n");

    boolean[] dates_2015 = datesBetween(yearDates, "20150101", "20151231");
    boolean[] in_2015 = logicalAnd(nots, dates_2015);
    float mean_2015 = mean(yearTemps, logicalAnd(nots, dates_2015));
    int first_2015 = findFirst(logicalAnd(isGreaterThan(yearTemps, mean_2015), in_2015));
    float warm_2015 = count(logicalAnd(isGreaterThan(yearTemps, 30), in_2015));
    System.out.println("\n Year: 2015");
    System.out.println(" Annual mean temperature: " + mean_2015 + " degrees Celsius");
    System.out.println(" First above average day: " + yearDates[first_2015]);
    System.out.println(" # days above 30 degrees: " + warm_2015 + "\n");

    boolean[] dates_2016 = datesBetween(yearDates, "20160101", "20161231");
    boolean[] in_2016 = logicalAnd(nots, dates_2016);
    float mean_2016 = mean(yearTemps, logicalAnd(nots, dates_2016));
    int first_2016 = findFirst(logicalAnd(isGreaterThan(yearTemps, mean_2016), in_2016));
    float warm_2016 = count(logicalAnd(isGreaterThan(yearTemps, 30), in_2016));
    System.out.println("\n Year: 2016");
    System.out.println(" Annual mean temperature: " + mean_2016 + " degrees Celsius");
    System.out.println(" First above average day: " + yearDates[first_2016]);
    System.out.println(" # days above 30 degrees: " + warm_2016 + "\n");

    boolean[] dates_2017 = datesBetween(yearDates, "20170101", "20171231");
    boolean[] in_2017 = logicalAnd(nots, dates_2017);
    float mean_2017 = mean(yearTemps, logicalAnd(nots, dates_2017));
    int first_2017 = findFirst(logicalAnd(isGreaterThan(yearTemps, mean_2017), in_2017));
    float warm_2017 = count(logicalAnd(isGreaterThan(yearTemps, 30), in_2017));
    System.out.println("\n Year: 2017");
    System.out.println(" Annual mean temperature: " + mean_2017 + " degrees Celsius");
    System.out.println(" First above average day: " + yearDates[first_2017]);
    System.out.println(" # days above 30 degrees: " + warm_2017 + "\n");

    boolean[] dates_2018 = datesBetween(yearDates, "20180101", "20181231");
    boolean[] in_2018 = logicalAnd(nots, dates_2018);
    float mean_2018 = mean(yearTemps, logicalAnd(nots, dates_2018));
    int first_2018 = findFirst(logicalAnd(isGreaterThan(yearTemps, mean_2018), in_2018));
    float warm_2018 = count(logicalAnd(isGreaterThan(yearTemps, 30), in_2018));
    System.out.println("\n Year: 2018");
    System.out.println(" Annual mean temperature: " + mean_2018 + " degrees Celsius");
    System.out.println(" First above average day: " + yearDates[first_2018]);
    System.out.println(" # days above 30 degrees: " + warm_2018 + "\n");

    boolean[] dates_2019 = datesBetween(yearDates, "20190101", "20191231");
    boolean[] in_2019 = logicalAnd(nots, dates_2019);
    float mean_2019 = mean(yearTemps, logicalAnd(nots, dates_2019));
    int first_2019 = findFirst(logicalAnd(isGreaterThan(yearTemps, mean_2019), in_2019));
    float warm_2019 = count(logicalAnd(isGreaterThan(yearTemps, 30), in_2019));
    System.out.println("\n Year: 2019");
    System.out.println(" Annual mean temperature: " + mean_2019 + " degrees Celsius");
    System.out.println(" First above average day: " + yearDates[first_2019]);
    System.out.println(" # days above 30 degrees: " + warm_2019 + "\n");


    float firstHalfMean = (mean_2010 + mean_2011 + mean_2012 + mean_2013 + mean_2014)/5;
    System.out.println("\n MEAN FOR FIRST HALF: " + firstHalfMean);
    float secondHalfMean = (mean_2015 + mean_2016 + mean_2017 + mean_2018 + mean_2019)/5;
    System.out.println("\n MEAN FOR FIRST HALF: " + secondHalfMean);
    file.close();
  }
}
