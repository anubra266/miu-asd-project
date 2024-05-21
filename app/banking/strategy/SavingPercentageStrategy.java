package app.banking.strategy;

import app.framework.PercentageStrategy;

public class SavingPercentageStrategy implements PercentageStrategy {

    private double percent;

    public SavingPercentageStrategy(double percent) {
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
