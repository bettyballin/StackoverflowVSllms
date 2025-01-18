interface Formula {
    public double calculate(double x, double y);
}

// Abstract implementation of Formula
abstract class AbstractFormula implements Formula {
    protected Formula formula; // Decorator pattern applied here

    public AbstractFormula() {
        this.formula = null;
    }

    public AbstractFormula(Formula formula) {
        this.formula = formula;
    }

    @Override
    public double calculate(double x, double y) {
        if (formula != null) {
            return formula.calculate(x, y);
        } else {
            return doStuff(x, y);  // Default behavior
        }
    }

    protected abstract double doStuff(double x, double y);
}

class SumFormula extends AbstractFormula {

    public SumFormula() {
        super();
    }

    public SumFormula(Formula formula) {
        super(formula);
    }

    @Override
    protected double doStuff(double x, double y) {
        return x + y;
    }
}

class MultiplyFormula extends AbstractFormula {

    public MultiplyFormula() {
        super();
    }

    public MultiplyFormula(Formula formula) {
        super(formula);
    }

    @Override
    protected double doStuff(double x, double y) {
        return x * y;
    }
}