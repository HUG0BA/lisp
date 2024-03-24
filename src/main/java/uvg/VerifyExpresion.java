package uvg;

public class VerifyExpresion {

     /**
      * @param numArr
      * @return
      * @description checks if a given array of numbers satisfies the condition of being greater
      */
     public static String greaterThan(float[] numArr) {
          String resultT = "t";
          String resultF = "nil";
          if(numArr.length == 0){
               return resultF;
          }
          for(int i = 1; i < numArr.length; i++){
               if(numArr[i -1] > numArr[i] ){
                    return resultT;
               }
          }
          return resultF;
     }

     /**
      * @param numArr
      * @return
      * @description checks if the given array of numbers satisfies the condition of being less than previous number
      */
     public static String lessThan(float[] numArr) {
          String resultT = "t";
          String resultF = "nil";
          if(numArr.length == 0){
               return resultF;
          }
          for(int i = 1; i < numArr.length; i++){
               if(numArr[i - 1] < numArr[i] ){
                    return resultT;
               }
          }
          return resultF;
     }

     /**
      * @param numArr
      * @return
      * @description checks if the fiven array of numbers satisfies the condition of being equals to the previous number
      */
     public static String equalsTo(float[] numArr) {
          String resultT = "t";
          String resultF = "nil";
          if(numArr.length == 0){
               return resultF;
          }
          for(int i = 1; i < numArr.length; i++){
               if(numArr[i - 1] == numArr[i] ){
                    return resultT;
               }
          }
          return resultF;
     }

}
