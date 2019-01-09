import java.util.ArrayList;

public class UserInput {

    public static ArrayList<Character> inputArray = new ArrayList<Character>();

    public static class TextInput {
        void add(char c) {
            inputArray.add(c);
        }
        String getValue(){

            String s = "";
            for (char c:  inputArray) {
                s = s + c;
            }
            return s;
        }
    }

    public static class NumericInput extends TextInput {
        @Override
        void add(char c){
            if(Character.isDigit(c))
                inputArray.add(c);
        }
    }

    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}