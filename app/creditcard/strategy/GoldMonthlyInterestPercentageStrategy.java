package app.creditcard.strategy;

import app.framework.PercentageStrategy;

public class GoldMonthlyInterestPercentageStrategy implements PercentageStrategy {

    private double percent = .06;

    public GoldMonthlyInterestPercentageStrategy(double percent) {
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    @Override
    public double getPercentAmount(double amount) {
        return amount * percent;
    }
}
