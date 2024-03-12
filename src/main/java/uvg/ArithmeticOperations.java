package uvg;

import java.util.List;
import java.util.Stack;

public class ArithmeticOperations {

    public float sum(float[] numArr) {
        float result = 0;
        for(float num : numArr){
            result += num;
        }
        return result;
    }

    public float substraction(float[] numArr){
        float result = numArr[0] - numArr[1];
        if(numArr.length > 2){
            for(int i = 2; i < numArr.length; i++){
                result -= numArr[i];
            }
        }
        return result;
    }

    public float multiplication(float[] numArr){
        float result = 1;
        for(float i : numArr){
            result *= i;
        }
        return result;
    }

    public float division(float[] numArr){
        float result = numArr[0] / numArr[1];
        if(numArr.length > 2){
            if(numArr.length > 2){
                for(int i = 2; i < numArr.length; i++){
                    result /= numArr[i];
                }
            }
        }

        return result;
    }


}
