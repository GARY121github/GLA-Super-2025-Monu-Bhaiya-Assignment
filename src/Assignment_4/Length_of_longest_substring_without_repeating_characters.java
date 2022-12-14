package Assignment_4;

/*

Given a string s, find the length of the longest substring without repeating characters.

Input Format
Input string

Constraints
0<=|s|<=10000

Output Format
Length of longest substring with non repeating characters

Sample Input
ABDEFGABEF
Sample Output
6
Explanation
For “ABDEFGABEF”, the longest substring are “BDEFGA” and “DEFGAB”, with length 6.

*/

import java.util.HashMap;
import java.util.Scanner;

public class Length_of_longest_substring_without_repeating_characters {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        System.out.println(findLongestSubstring(st));
    }

    public static int findLongestSubstring(String str)
    {
        int i;
        int n = str.length();

        // Starting point
        // of current substring.
        int st = 0;

        // length of
        // current substring.
        int currlen = 0;

        // maximum length
        // substring without
        // repeating characters.
        int maxlen = 0;

        // starting index of
        // maximum length substring.
        int start = 0;

        // Hash Map to store last
        // occurrence of each

        // already visited character.
        HashMap<Character,
                        Integer> pos = new HashMap<Character,
                Integer>();

        // Last occurrence of first
        // character is index 0;
        pos.put(str.charAt(0), 0);

        for (i = 1; i < n; i++)
        {
            // If this character is not present in hash,
            // then this is first occurrence of this
            // character, store this in hash.
            if (!pos.containsKey(str.charAt(i)))
            {
                pos.put(str.charAt(i), i);
            }
            else
            {
                // If this character is present
                // in hash then this character
                // has previous occurrence,
                // check if that occurrence
                // is before or after starting
                // point of current substring.
                if (pos.get(str.charAt(i)) >= st)
                {
                    // find length of current
                    // substring and update maxlen
                    // and start accordingly.
                    currlen = i - st;
                    if (maxlen < currlen)
                    {
                        maxlen = currlen;
                        start = st;
                    }

                    // Next substring will start
                    // after the last occurrence
                    // of current character to avoid
                    // its repetition.
                    st = pos.get(str.charAt(i)) + 1;
                }

                // Update last occurrence of
                // current character.
                pos.replace(str.charAt(i), i);
            }
        }

        // Compare length of last
        // substring with maxlen and
        // update maxlen and start
        // accordingly.
        if (maxlen < i - st)
        {
            maxlen = i - st;
            start = st;
        }

        // The required longest
        // substring without
        // repeating characters
        // is from str[start]
        // to str[start+maxlen-1].
        return str.substring(start,
                start +
                        maxlen).length();
    }
}
