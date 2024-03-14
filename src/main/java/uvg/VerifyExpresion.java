package uvg;

public class VerifyExpresion {

     public static boolean higherThan(float[] numArr) {
          boolean result = false;
          if(numArr.length == 0){
               return result;
          }
          for(int i = 1; i < numArr.length; i++){
               if(numArr[i -1] > numArr[i] ){
                    result = true;
                    return result;
               }
          }
          return result;
     }

     public static boolean lowerThan(float[] numArr) {
          boolean result = false;
          if(numArr.length == 0){
               return result;
          }
          for(int i = 1; i < numArr.length; i++){
               if(numArr[i - 1] < numArr[i] ){
                    result = true;
                    return result;
               }
          }
          return result;
     }

     public static boolean equalsTo(float[] numArr) {
          boolean result = false;
          if(numArr.length == 0){
               return result;
          }
          for(int i = 1; i < numArr.length; i++){
               if(numArr[i - 1] == numArr[i] ){
                    result = true;
                    return result;
               }
          }
          return result;
     }

}
