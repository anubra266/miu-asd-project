package app.creditcard.strategies;

import app.framework.domain.PercentageStrategy;

public class GoldMonthlyInterestPercentageStrategy implements PercentageStrategy {

    private double percent = .06;

    public GoldMonthlyInterestPercentageStrategy() {

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

    public String getName() {
        return "GOLD";
    }
}
