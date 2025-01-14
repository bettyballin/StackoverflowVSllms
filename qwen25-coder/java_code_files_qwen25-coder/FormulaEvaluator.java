import java.lang.String;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class FormulaEvaluator {
    public static void main(String[] args) {
        String formulaText = "BenchmarkA + 1"; // This would come from your database PricingFormulas table

        double benchmarkAValue = 10.0; // retrieved from MarketBenchmarks table

        Expression e = new ExpressionBuilder(formulaText)
                .variables("BenchmarkA")
                .build()
                .setVariable("BenchmarkA", benchmarkAValue); // retrieved from MarketBenchmarks table

        double result = e.evaluate();
        System.out.println("Calculated Price: " + result);
    }
}