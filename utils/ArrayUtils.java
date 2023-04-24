package utils;

public class ArrayUtils {
    public static String[] removeIndex(String[] array, int index){
        int length = array.length;
        int afterIndex = length-(index+1); //index given will be where 1=0, .length gives length starting w/ 1
        int beforeIndex = length - (afterIndex+1);
        String[] removedIndexArray = new String[length-1];
        if(beforeIndex >= 0){
            for(int i = 0; i < beforeIndex; i++){
                removedIndexArray[i] = array[i];
            }
            for(int i = 0; i<afterIndex; i++){
                removedIndexArray[(removedIndexArray.length-afterIndex)+i] = array[(beforeIndex+1)+i];
            }
        }else{
            for(int i=0; i<length-1;i++){
                removedIndexArray[i] = array[1+i];
            }
        }
        return removedIndexArray;
    }
}
