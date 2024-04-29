import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
public class ClimateQueriesTest {
    float[] arr1 = {1.0f, 2.0f, 3.0f, 2.0f};
    float[] arr2 = {1.0f, -9999.0f, 3.0f, 2.0f};
    float[] arr3 = {1.0f, 2.0f, 3.0f, 2.5f};

    
    @Test public void testMin(){
        boolean[] nots = ClimateQueries.logicalNot(ClimateQueries.isEqualTo(arr2, -9999));
        assertEquals(1.0f, ClimateQueries.min(arr2, nots), 0.000001);
        //assertEquals(1.0f, ArrayMethods.min(arr1), 0.000001);
        //assertEquals(Float.NaN, ArrayMethods.min(arr3), 0.000001);
        // Write TWO OR THREE additional tests
    }


    @Test public void testIsEqualTo(){
        boolean[] eq1 = ClimateQueries.isEqualTo(arr1, 2f);
        assertTrue("isEqualTo: [1,2,3,2], 2 --> [false, true, false, true]", eq1.length==4&&!eq1[0]&&eq1[1]&&!eq1[2]&&eq1[3]);

        boolean[] eq3 = ClimateQueries.isEqualTo(arr2, -9999.0f);
        assertTrue("isEqualTo: [1, -9999, 3, 2], -9999 -> [false, true, false, false]",(eq3.length==4)&&!eq3[0]&&eq3[1]&&!eq3[2]&&!eq3[3]);
    }

        @Test public void testLogicalNot() {
        boolean[] ind1 = {false, true, false, false};
        boolean[] not1 = ClimateQueries.logicalNot(ind1);
        assertTrue("[false, true, false, false] -> [true, false, true, true]",(not1.length==4)&&not1[0]&&!not1[1]&&not1[2]&&not1[3]);
    }

    @Test public void testLogicalAnd(){
        boolean[] ind1 = {false, true, false, true};
        boolean[] ind2 = {false, true, true, false};
        boolean[] and1 = ClimateQueries.logicalAnd(ind1, ind2);
        assertTrue("[false, true, true, false], [false, true, false, true] -> [false, true, false, false]",and1.length==4&&!and1[0]&&and1[1]&&!and1[2]&&!and1[3]);

    }

    @Test public void testIsGreaterThan(){
        boolean[] eq1 = ClimateQueries.isGreaterThan(arr3, 2.5f);
        assertTrue("isGreaterThan: [1,2,3,2.5], 2.5 --> [false, false, true, true]", eq1.length==4&&!eq1[0]&&!eq1[1]&&eq1[2]&&eq1[3]);
    }

    @Test public void testDatesBetween(){
        String[] arr4 = {"20230101", "20230214", "20230704"};
        boolean[] eq1 = ClimateQueries.datesBetween(arr4, "20230201", "20230601");
        assertTrue("datesBetween: [20230101,20230214,20230704], 20230201, 20230601 --> [false, true, false]", eq1.length==3&&!eq1[0]&&eq1[1]&&!eq1[2]);
    }

    @Test public void testLogicalMean(){
        boolean[] ind1 = {true, false, true, true};
        assertEquals(2.5f, ClimateQueries.mean(arr2, ind1, 1, 4), 0.000001);
        assertEquals(2f, ClimateQueries.mean(arr2, ind1), 0.000001);
    }

    @Test public void testCount(){
        boolean[] ind1 = {false, true, true, false, true};
        assertEquals(3, ClimateQueries.count(ind1), 0.000001);
    }

    @Test public void testFindFirst(){
        boolean[] ind1 = {false, false, true, false, true};
        assertEquals(2, ClimateQueries.findFirst(ind1), 0.000001);

        boolean[] ind2 = {false, false, false};
        assertEquals(-1, ClimateQueries.findFirst(ind2), 0.000001);
    }

    @Test
    public void testFind(){

        boolean[] ind1 = {false, true, true, false, true};
        int[] f1 = ClimateQueries.find(ind1);
        System.out.println(Arrays.toString(f1));
        assertTrue("[false, true, true, false, true] --> [1,2,4]",(f1.length==3)&&(f1[0]==1)&&(f1[1]==2)&&(f1[2]==4));

        boolean[] ind2 = {false, false, false};
        int[] f2 = ClimateQueries.find(ind2);
        assertTrue("[false, false, false] -> []",f2.length==0);
    }
}