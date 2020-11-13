import org.junit.Assert;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class AutocompleteTest {


   @Test (expected = NullPointerException.class)
   public void topMatchNullTest() {
      String[] string = new String [0];
      double[] weight = new double [0];
      
      Autocomplete.TrieAutocomplete TAC = new Autocomplete.TrieAutocomplete(string, weight);
      TAC.topMatch(null);
   }
 
   @Test public void topMatch1Test() {
      String[] string = new String [7];
      double[] weight = new double [7];
      string[0] = "ape";
      weight[0] = 6;
      string[1] = "app";
      weight[1] = 4;
      string[2] = "ban";
      weight[2] = 2;
      string[3] = "bat";
      weight[3] = 3;
      string[4] = "bee";
      weight[4] = 5;
      string[5] = "car";
      weight[5] = 7;
      string[6] = "cat";
      weight[6] = 1;
      Autocomplete.TrieAutocomplete TAC = new Autocomplete.TrieAutocomplete(string, weight);
      Assert.assertEquals("car", TAC.topMatch(""));
   }
   
   @Test public void topMatch2Test() {
      String[] string = new String [1];
      double[] weight = new double [1];
      string[0] = "car";
      weight[0] = 7;
      
      Autocomplete.TrieAutocomplete TAC = new Autocomplete.TrieAutocomplete(string, weight);
      Assert.assertEquals("car", TAC.topMatch(""));
   }
   
   @Test public void topMatch3Test() {
      String[] string = new String [7];
      double[] weight = new double [7];
      string[0] = "ape";
      weight[0] = 6;
      string[1] = "app";
      weight[1] = 4;
      string[2] = "ban";
      weight[2] = 2;
      string[3] = "bat";
      weight[3] = 3;
      string[4] = "bee";
      weight[4] = 5;
      string[5] = "car";
      weight[5] = 7;
      string[6] = "cat";
      weight[6] = 1;
      Autocomplete.TrieAutocomplete TAC = new Autocomplete.TrieAutocomplete(string, weight);
      Assert.assertEquals("bee", TAC.topMatch("b"));
   }
   
   @Test public void topMatchMultTest() {
      String[] string = new String [7];
      double[] weight = new double [7];
      string[0] = "ape";
      weight[0] = 6;
      string[1] = "app";
      weight[1] = 4;
      string[2] = "ban";
      weight[2] = 2;
      string[3] = "bat";
      weight[3] = 5;
      string[4] = "bee";
      weight[4] = 5;
      string[5] = "car";
      weight[5] = 7;
      string[6] = "cat";
      weight[6] = 1;
      Autocomplete.TrieAutocomplete TAC = new Autocomplete.TrieAutocomplete(string, weight);
      Assert.assertEquals("bat", TAC.topMatch("b"));
   }
   
   @Test(expected = NullPointerException.class)
   public void topMatchesNullTest() {
      String[] string = new String [0];
      double[] weight = new double [0];
      Autocomplete.TrieAutocomplete TAC = new Autocomplete.TrieAutocomplete(string, weight);
      TAC.topMatches(null,1);
   
   }
   
   @Test public void topMatches1Test() {
      String[] string = new String [7];
      double[] weight = new double [7];
      string[0] = "ape";
      weight[0] = 6;
      string[1] = "app";
      weight[1] = 4;
      string[2] = "ban";
      weight[2] = 2;
      string[3] = "bat";
      weight[3] = 3;
      string[4] = "bee";
      weight[4] = 5;
      string[5] = "car";
      weight[5] = 7;
      string[6] = "cat";
      weight[6] = 1;
      Autocomplete.TrieAutocomplete TAC = new Autocomplete.TrieAutocomplete(string, weight);
      Iterable<String> expected = Arrays.asList("car", "ape", "bee", "app", "bat", "ban", "cat");
      Assert.assertEquals(expected,TAC.topMatches("", 8));
   }
   
   @Test public void topMatches2Test() {
      String[] string = new String [7];
      double[] weight = new double [7];
      string[0] = "ape";
      weight[0] = 6;
      string[1] = "app";
      weight[1] = 4;
      string[2] = "ban";
      weight[2] = 2;
      string[3] = "bat";
      weight[3] = 3;
      string[4] = "bee";
      weight[4] = 5;
      string[5] = "car";
      weight[5] = 7;
      string[6] = "cat";
      weight[6] = 1;
      Autocomplete.TrieAutocomplete TAC = new Autocomplete.TrieAutocomplete(string, weight);
      Iterable<String> expected = Arrays.asList("car");
      Assert.assertEquals(expected,TAC.topMatches("", 1));
   }
   
   @Test public void topMatches3Test() {
      String[] string = new String [7];
      double[] weight = new double [7];
      string[0] = "ape";
      weight[0] = 6;
      string[1] = "app";
      weight[1] = 4;
      string[2] = "ban";
      weight[2] = 2;
      string[3] = "bat";
      weight[3] = 3;
      string[4] = "bee";
      weight[4] = 5;
      string[5] = "car";
      weight[5] = 7;
      string[6] = "cat";
      weight[6] = 1;
      Autocomplete.TrieAutocomplete TAC = new Autocomplete.TrieAutocomplete(string, weight);
      Iterable<String> expected = Arrays.asList("car", "ape");
      Assert.assertEquals(expected,TAC.topMatches("", 2));
   }
   
   
   
   @Test public void topMatches4Test() {
      String[] string = new String [7];
      double[] weight = new double [7];
      string[0] = "ape";
      weight[0] = 6;
      string[1] = "app";
      weight[1] = 4;
      string[2] = "ban";
      weight[2] = 2;
      string[3] = "bat";
      weight[3] = 3;
      string[4] = "bee";
      weight[4] = 5;
      string[5] = "car";
      weight[5] = 7;
      string[6] = "cat";
      weight[6] = 1;
      Autocomplete.TrieAutocomplete TAC = new Autocomplete.TrieAutocomplete(string, weight);
      Iterable<String> expected = Arrays.asList("car", "ape","bee");
      Assert.assertEquals(expected,TAC.topMatches("", 3));
   }
   
   @Test public void topMatches5Test() {
      String[] string = new String [7];
      double[] weight = new double [7];
      string[0] = "ape";
      weight[0] = 6;
      string[1] = "app";
      weight[1] = 4;
      string[2] = "ban";
      weight[2] = 2;
      string[3] = "bat";
      weight[3] = 3;
      string[4] = "bee";
      weight[4] = 5;
      string[5] = "car";
      weight[5] = 7;
      string[6] = "cat";
      weight[6] = 1;
      Autocomplete.TrieAutocomplete TAC = new Autocomplete.TrieAutocomplete(string, weight);
      Iterable<String> expected = Arrays.asList("ape");
      Assert.assertEquals(expected,TAC.topMatches("a", 1));
   }
   
   @Test public void topMatches6Test() {
      String[] string = new String [7];
      double[] weight = new double [7];
      string[0] = "ape";
      weight[0] = 6;
      string[1] = "app";
      weight[1] = 4;
      string[2] = "ban";
      weight[2] = 2;
      string[3] = "bat";
      weight[3] = 3;
      string[4] = "bee";
      weight[4] = 5;
      string[5] = "car";
      weight[5] = 7;
      string[6] = "cat";
      weight[6] = 1;
      Autocomplete.TrieAutocomplete TAC = new Autocomplete.TrieAutocomplete(string, weight);
      Iterable<String> expected = Arrays.asList("ape");
      Assert.assertEquals(expected,TAC.topMatches("ap", 1));
   }
   
   @Test public void topMatches7Test() {
      String[] string = new String [7];
      double[] weight = new double [7];
      string[0] = "ape";
      weight[0] = 6;
      string[1] = "app";
      weight[1] = 4;
      string[2] = "ban";
      weight[2] = 2;
      string[3] = "bat";
      weight[3] = 3;
      string[4] = "bee";
      weight[4] = 5;
      string[5] = "car";
      weight[5] = 7;
      string[6] = "cat";
      weight[6] = 1;
      Autocomplete.TrieAutocomplete TAC = new Autocomplete.TrieAutocomplete(string, weight);
      Iterable<String> expected = Arrays.asList("bee", "bat");
      Assert.assertEquals(expected,TAC.topMatches("b", 2));
   }
   
   @Test public void topMatches8Test() {
      String[] string = new String [7];
      double[] weight = new double [7];
      string[0] = "ape";
      weight[0] = 6;
      string[1] = "app";
      weight[1] = 4;
      string[2] = "ban";
      weight[2] = 2;
      string[3] = "bat";
      weight[3] = 3;
      string[4] = "bee";
      weight[4] = 5;
      string[5] = "car";
      weight[5] = 7;
      string[6] = "cat";
      weight[6] = 1;
      Autocomplete.TrieAutocomplete TAC = new Autocomplete.TrieAutocomplete(string, weight);
      Iterable<String> expected = Arrays.asList("bat", "ban");
      Assert.assertEquals(expected,TAC.topMatches("ba", 2));
   }
   
   @Test public void topMatches9Test() {
      String[] string = new String [7];
      double[] weight = new double [7];
      string[0] = "ape";
      weight[0] = 6;
      string[1] = "app";
      weight[1] = 4;
      string[2] = "ban";
      weight[2] = 2;
      string[3] = "bat";
      weight[3] = 3;
      string[4] = "bee";
      weight[4] = 5;
      string[5] = "car";
      weight[5] = 7;
      string[6] = "cat";
      weight[6] = 1;
      Autocomplete.TrieAutocomplete TAC = new Autocomplete.TrieAutocomplete(string, weight);
      Iterable<String> expected = Arrays.asList();
      Assert.assertEquals(expected,TAC.topMatches("d", 100));
   }
   
}
