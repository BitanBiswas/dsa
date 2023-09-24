/** 

Balanced Or Not?
Consider a string consisting of the characters < and > only. The string is balanced if each < always appears before (i.e., to the left of) a corresponding > character (they do not need to be adjacent). Moreover, each < and > act as a unique pair of symbols and neither symbol can be considered as part of any other pair of symbols.
To balance a string, any > character can be replaced with <.
Given an expression and a maximum number of replacements, determine whether the string can be balanced.

Example
expressions = ['<<>>', '<> <>', '>><<>>>><', '>><> <>', '><> <> <>']
maxReplacements = [0, 1, 2, 2, 2, 2]
N
Process a series of expressions and their corresponding maxReplacements. Each of the first three expressions is balanced already. The string expressions[3] = '>>' can be balanced in two moves by replacing each > with a < to make <><>.
Neither of the last two strings can ever be balanced.

Function Description
Complete the function balanced or not in the editor below.

balancedOrNot has the following parameter(s):

string expressions[n]: an array of strings to check
int maxReplacements[n]: an array of integers representing the maximum number of replacements available for each expressions[i]
Returns:

int[n]: an array of integers where element[i] contains a 1 if expressions[i] is balanced or a 0 if it is not
Constraints

1≤n≤102
1≤ length of expressions[i] ≤ 105
0≤ maxReplacements[i] < 105

*/

// Java code for balancedOrNot1 function

// Function to check if the given string is balanced or not
public static int[] balancedOrNot1(String[] expressions, int[] maxReplacements) {
    // Create an empty array to store the results
    int[] ans = new int[expressions.length];

    // Iterate over the expressions and their corresponding maxReplacements
    for (int i = 0; i < expressions.length; i++) {
        // Create a copy of the current expression
        String e = expressions[i];

        // Remove all occurrences of the string "<>" from the expression
        String tmp = e.replace("<>", "");

        // Iterate over the expression until it no longer changes
        while (!e.equals(tmp)) {
            // Update the expression and its copy
            e = tmp;
            tmp = tmp.replace("<>", "");
        }

        // If the expression still contains the character "<", then it is not balanced
        if (e.contains("<")) {
            ans[i] = 0;
        } else {
            // Check if the length of the expression is less than or equal to the maxReplacements
            ans[i] = (e.length() <= maxReplacements[i]) ? 1 : 0;
        }
    }

    // Return the results array
    return ans;
}


// Python code for balancedOrNot1 function
/**
def balancedOrNot1(expressions, maxReplacements):
    ans = []
    for e, m in zip(expressions, maxReplacements):
        tmp = e.replace('<>', '')
        while e != tmp:
            e, tmp = tmp, tmp.replace('<>', '')
        if '<' in e:
            ans.append(0)
        else:
            ans.append(int(len(e) <= m))
    return ans
*/
/**
# Test cases
expressions = ['<<>>', '<> <>', '>><<>>>><', '>><> <>', '><> <> <>']
maxReplacements = [0, 1, 2, 2, 2, 2]

ans = balancedOrNot1(expressions, maxReplacements)

print(ans) 
  */
