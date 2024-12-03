package string.manipulation;

public class StringManuUtilsImpl implements StringManuUtils {
    @Override
    public String reverseString(String string) {
        int length = string.length();
        char[] arr = string.toCharArray();
        char[] reverse =  new char[length];

     for (int i=0; i<length ; i++){
         reverse[i] = arr[length-1-i];
     }
        return new String(reverse);
    }
}
