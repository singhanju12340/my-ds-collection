package com.logics.dp;

/**
 * @author anju
 * @created on 07/02/25 and 5:16 PM
 */
public class CountNumberOfTextByPhone {

    /**
     * Alice is texting Bob using her phone. The mapping of digits to letters is shown in the figure below.
     *
     *
     * In order to add a letter, Alice has to press the key of the corresponding digit i times, where i is the position of the letter in the key.
     *
     * For example, to add the letter 's', Alice has to press '7' four times. Similarly, to add the letter 'k', Alice has to press '5' twice.
     * Note that the digits '0' and '1' do not map to any letters, so Alice does not use them.
     * However, due to an error in transmission, Bob did not receive Alice's text message but received a string of pressed keys instead.
     *
     * For example, when Alice sent the message "bob", Bob received the string "2266622".
     * Given a string pressedKeys representing the string received by Bob, return the total number of possible text messages Alice could have sent.
     *
     * Since the answer may be very large, return it modulo 109 + 7.
     * */


    public int countTexts(String pressedKeys) {
        int mod = 1000000007;
        int i=0;
        int commonPrefixCount;
        long result=1;

        while(i<pressedKeys.length()){
            int j = i;
            int digit = pressedKeys.charAt(i);
            int maxCom  = (digit == '7' || digit == '9') ? 4 : 3;

            while(j< pressedKeys.length() && pressedKeys.charAt(j) == digit){
                j++;
            }
            commonPrefixCount = j-i;
            // get all possible combination count from multiple groups
            result = (result * countWaysForGroup(maxCom, commonPrefixCount)) % mod;
            i = j;
        }
        return (int)result;
    }

    // find ways of common group ex: 22222 or 222
    public long countWaysForGroup(int maxCom, int count) {
        int mod = 1000000007;
        long[] dp = new long[count+1];
        dp[0] = 1;

        for(int i=1; i<=count; i++){
            for(int j=1; j<=maxCom && (i-j)>=0 ; j++){
                dp[i] = (dp[i] + dp[i-j]) % mod;
            }
        }
        return dp[count];
    }



    public static void main(String[] args) {
        CountNumberOfTextByPhone countNumberOfTextByPhone = new CountNumberOfTextByPhone();
//        System.out.println(countNumberOfTextByPhone.countTexts("2266622"));
//            System.out.println(countNumberOfTextByPhone.countTexts("22233"));
        System.out.println(countNumberOfTextByPhone.countTexts("77778"));


    }

}
