package uvg;

import java.util.List;
import java.util.Stack;

public class ArithmeticOperations {

    public float sum(float[] numArr) {
        float result = 0;
        if(numArr.length == 0){
            return result;
        }
        for(float num : numArr){
            result += num;
        }
        return result;
    }

    public float substraction(float[] numArr){
        if(numArr.length == 0){
            return 0;
        }
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
        if(numArr.length == 0){
            return result;
        }
        for(float i : numArr){
            result *= i;
        }
        return result;
    }

    public float division(float[] numArr) throws ArithmeticException{
        if(numArr.length == 0){
            return 1;
        }else if(numArr.length == 1){
            if(numArr[0] != 0){
                return 1 / numArr[0];
            }else{
                throw new ArithmeticException();
            }
            
        }  

        float result;
        if(numArr[1] != 0){
            result = numArr[0] / numArr[1];
        }else{
            throw new ArithmeticException();
        }
        
        if(numArr.length > 2){
            if(numArr.length > 2){
                for(int i = 2; i < numArr.length; i++){
                    if(numArr[i] != 0){
                        result /= numArr[i];
                    }else{
                        throw new ArithmeticException();
                    }
                    
                }
            }
        }

        return result;
    }

    public float modolusSign(float dividend, float divisor) throws ArithmeticException{
        if(divisor != 0.0f){
            return dividend % divisor;
        }else{
            throw new ArithmeticException();
        }
    }

}
