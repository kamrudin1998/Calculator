import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MainApp 
{
    public static void main(String arg[])
    {
        final String inputExp = ReadInput.read();

        Queue<String> operations;
        Queue<String> numbers;

        String numberArr[] = inputExp.split("[-+*/]");
        String operArr[] = inputExp.split("[0-9]+");

        numbers = new LinkedList<String>(Arrays.asList(numberArr));
        operations = new LinkedList<String>(Arrays.asList(operArr));

        Double res = Double.parseDouble(numbers.poll());

        while(!numbers.isEmpty())
        {
            String opr = operations.poll();

            Operate operate;

            switch (opr) {
                case "+":
                    operate = new Add();
                    break;
            
                case "-":
                    operate = new Subtract();
                    break;
                
                case "*":
                    operate = new Multiply();
                    break;
                
                case "/":
                    operate = new Divide();
                    break;
                default:
                    continue;
            }

            Double num = Double.parseDouble(numbers.poll());

            res = operate.getResult(res, num);
        }

        System.out.println(res);
        

    }    
}
