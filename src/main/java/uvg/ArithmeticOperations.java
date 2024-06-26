package uvg;

import java.util.List;
import java.util.Stack;

public class ArithmeticOperations {

    /**
     * @param numArr
     * @return
     * @description: this method evaluate an array of floats and calculates the sum
     *               of all elements but it ckecks if the element is not empty.
     */
    public static String sum(float[] numArr) {
        float result = 0;
        if (numArr.length == 0) {
            return Float.toString(result);
        }
        for (float num : numArr) {
            result += num;
        }
        return Float.toString(result);
    }

    /**
     * @param numArr
     * @return
     * @description: this method evaluate an array of floats and calculates the
     *               substraction of all elements but it checks if the element is
     *               not empty.
     */
    public static String subtraction(float[] numArr) {
        if (numArr.length == 0) {
            return "0";
        }
        float result = numArr[0] - numArr[1];
        if (numArr.length > 2) {
            for (int i = 2; i < numArr.length; i++) {
                result -= numArr[i];
            }
        }
        return Float.toString(result);
    }

    /**
     * @param numArr
     * @return
     * @description: this method evaluate an array of floats and calculates the
     *               multiplication of all elements but it checks of the the array
     *               is not empty.
     */
    public static String multiplication(float[] numArr) {
        float result = 1;
        if (numArr.length == 0) {
            return Float.toString(result);
        }
        for (float i : numArr) {
            result *= i;
        }
        return Float.toString(result);
    }

    /**
     * @param numArr
     * @return
     * @throws ArithmeticException
     * @description: this method evaluate an array of floats and calculates the
     *               multiplication of all elements but it checks of the array is
     *               not empty or with just one element.
     */
    public static String division(float[] numArr) throws ArithmeticException {
        if (numArr.length == 0) {
            return "1";
        } else if (numArr.length == 1) {
            if (numArr[0] != 0) {
                return Float.toString(1 / numArr[0]);
            } else {
                throw new ArithmeticException();
            }

        }

        float result;
        if (numArr[1] != 0) {
            result = numArr[0] / numArr[1];
        } else {
            throw new ArithmeticException();
        }

        if (numArr.length > 2) {
            if (numArr.length > 2) {
                for (int i = 2; i < numArr.length; i++) {
                    if (numArr[i] != 0) {
                        result /= numArr[i];
                    } else {
                        throw new ArithmeticException();
                    }

                }
            }
        }

        return Float.toString(result);
    }

    /**
     * @param numArr
     * @return
     * @throws ArithmeticException
     * @description: this method evaluate an array of floats and calculates the
     *               module of all elements by checking of the second one is not
     *               0.00f.
     */
    public static String modolusSign(float[] numArr) throws ArithmeticException {
        if (numArr[1] != 0.0f) {
            return Float.toString(numArr[0] % numArr[0]);
        } else {
            throw new ArithmeticException();
        }
    }

}
