import java.util.ArrayList;

public class LinearRegression {

    static double[] xValues = {1,2,3,4,5,6};
    static double[] yValues = {3,4,8,10,11,15};
    static int m = xValues.length;

    public static ArrayList<Double> LinearRegression(int start, int end) {

        ArrayList<Double> everything = new ArrayList<Double>();
        if(end <= 1){

            double slope = 0;
            double intercept = yValues[0];
            double error = 0;

            everything.add(slope);
            everything.add(intercept);
            everything.add(error);
        }else{

            //Slope
            double sum1 = 0;
            for (int i = start; i <end ; i++) {
                sum1 += xValues[i] * yValues[i];
            }

            double sum2 = 0;
            for (int i = start; i <end ; i++) {
                sum2 += xValues[i];
            }

            double sum3 = 0;
            for (int i = start; i <end ; i++) {
                sum3 += yValues[i];
            }

            double sum4 = 0;
            for (int i = start; i <end ; i++) {
                sum4 += xValues[i] * xValues[i];
            }

            double product1 = (sum1 * end) - (sum2 * sum3);
            double product2 = (sum4 * end) - (sum2 * sum2);
            double beta1 =  product1 / product2;
            everything.add(beta1);

            //Y - Intercept
            double beta2 = (sum3 / end) - (beta1 * (sum2 / end));
            everything.add(beta2);

            //Error
            double Errorf = 0;
            for (int j = 0; j < m; j++) {
                Errorf = (yValues[j] - ((beta1 * xValues[j]) - beta2)) * (yValues[j] -((beta1 * xValues[j]) - beta2));
            }
            everything.add(Errorf);
        }
        return everything;
    }


    public static void main(String[] args) {
        
        ArrayList<Double> result = LinearRegression(0,m);

        System.out.println("Slope: "+ result.get(0));
        System.out.println("Y - Intercepts: "+ result.get(1));
        System.out.println("Errors: "+ result.get(2));

        }

    }


