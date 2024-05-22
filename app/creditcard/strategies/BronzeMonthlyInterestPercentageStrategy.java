/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.21
 * Time:11:36
 */

package app.creditcard.strategies;

import app.framework.PercentageStrategy;

public class BronzeMonthlyInterestPercentageStrategy implements PercentageStrategy {


    private double percent = .1;

    public BronzeMonthlyInterestPercentageStrategy(double percent) {
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