package uvg;

public class VerifyExpresion {

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
