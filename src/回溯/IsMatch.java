package 回溯;

public class IsMatch {
    String s, p;

    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        return check(0, 0);
    }

    public boolean check(int sPoint, int pPoint) {
        if (sPoint == s.length() && pPoint == p.length()) {
            return true;
        }
        if (sPoint < s.length() && pPoint < p.length()) {
            if (s.charAt(sPoint) == p.charAt(pPoint)) {
                return check(sPoint + 1, pPoint + 1);
            } else if (p.charAt(pPoint) == '?') {
                return check(sPoint + 1, pPoint + 1);
            } else if (p.charAt(pPoint) == '*') {
                for (int i = sPoint; i <= s.length(); i++) {
                    if (check(i, pPoint + 1)) {
                        return true;
                    }
                }
            } else {
                return false;
            }
        } else if (sPoint == s.length() && pPoint < p.length() && p.charAt(pPoint) == '*') {
            return check(sPoint, pPoint + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        IsMatch isMatch = new IsMatch();
        System.out.println(isMatch.isMatch("", "*******"));
    }
}
