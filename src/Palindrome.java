public class Palindrome {

    public static boolean isPalindrome(String word) {

        char[] wordCharAray= word.toCharArray();
        //Character[] wordCharacterAray = new Character[](wordCharAray);
        int i = 0;
        while (i<wordCharAray.length/2){
            if (Character.toLowerCase(wordCharAray[i]) != Character.toLowerCase(wordCharAray[wordCharAray.length-1-i]))
                return false;
            i++;
        }

        return true;
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Deleveled"));
    }
}