package pers.whe.code.leetcode;

public class Contest26 {

    /*
     * 521. Longest Uncommon Subsequence I
     * 这道题找两个字符串的非公共子序列，并且是其中两个中的任意一个，
     * 如果相等为-1，不想等的话最长的那个。
     * time o(1)   space o(1)
     * */
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }

    /*
     * 522. Longest Uncommon Subsequence II
     * 找数组中非公共子序列，可以用暴力解法，就是锁定一个，遍历其他，
     * 看这个是不是其他的非公共子序列。
     * time o(n2)  space o(1)
     * */
    public int findLUSlength(String[] strs) {
        int res = -1;
        for (int i = 0; i < strs.length; i++) {
            int j = 0;
            for (j = 0; j < strs.length; j++) {
                if (i == j) continue;
                if (isSub(strs[i], strs[j])) {
                    break;
                }
            }
            if (j == strs.length) {
                res = Math.max(res, strs[i].length());
            }
        }
        return res;
    }

    private boolean isSub(String s1, String s2) {
        int l1 = 0;
        for (int l2 = 0; l2 < s2.length() && l1 < s1.length(); l2++) {
            if (s1.charAt(l1) == s2.charAt(l2)) {
                l1++;
            }
        }
        return l1 == s1.length();
    }
}
