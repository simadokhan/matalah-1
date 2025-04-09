import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class exercise1 {
    public static String[] sentenceToArray(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return new String[0]; // Return an empty array for null or empty input
        }
        return sentence.trim().split("\\s+"); // Split by one or more whitespace characters
    }
    public static void main(String[] args) {
        double result = 0,x;
        int j=0 ;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter an operation the numbers should be between 0-10");
        String sentence = myObj.nextLine();
        String[] anArray = sentenceToArray(sentence);
        OperationsValues op = new OperationsValues();
        double[] array_numbers = new double[anArray.length+1];
        char[] array_op = new char[anArray.length];
        double[] temp_numbers = new double[anArray.length+1];
        char[] temp_op = new char[anArray.length];
        for (int i = 0; i < anArray.length; i ++) {
            if(i*2<anArray.length)
            {
            op.setnumber(anArray[2*i]);
            }
            else {
                break;
            }
            int number = op.makeIt_areal_number();
            array_numbers[i]= number;
        }
        op.setOperation(anArray[1]);
        char ch1 = op.makeIt_areal_operation();
        array_op[0] =ch1;
        for (int i = 1; i < anArray.length; i ++) {
            if (i + 2 < anArray.length) {
                op.setOperation(anArray[i + 2]);
            } else {
                break;
            }
            char ch = op.makeIt_areal_operation();
            array_op[i] = ch;
        }
        for (int i = 0; i < array_op.length; i ++)
        {
            if (array_op[i] == '/'&&array_numbers[i+1] == 0)
            {
                System.out.println("you can not divide by zero");
            }

        }
           for (int i = 0; i < array_op.length; i ++)
           {
            if (array_op[i] == '/' && i+1<array_numbers.length)
            {
                x=array_numbers[i]/array_numbers[i+1];
                array_numbers[i+1] = x;
                temp_numbers[i]=array_numbers[i];

            } else if (array_op[i] == '*' && i+1<array_numbers.length)
            {
                x=array_numbers[i]*array_numbers[i+1];
                array_numbers[i+1] = x;
                temp_numbers[i]=array_numbers[i];
            }
            else
            {
                temp_numbers[j]=array_numbers[i];
                temp_op[j]=array_op[i];
                j++;
            }


           }

           for (int i = 0; i < j-1; i ++)
           {
                if (temp_op[i] == '+' && i+2<temp_numbers.length) {
               x=temp_numbers[i]+temp_numbers[i+1];
               temp_numbers[i+1] = x;
           }else
           {
               x=temp_numbers[i]-temp_numbers[i+1];
               temp_numbers[i+1] = x;
           }
           }
           result=temp_numbers[j-1];
           System.out.println("The value of expression "+sentence+"="+result);

    }
}

