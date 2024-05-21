/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.21
 * Time:11:37
 */

package app.creditcard.strategy;

import app.framework.PercentageStrategy;

public class GoldMinimumPaymentPercentageStrategy implements PercentageStrategy {

    private double percent = .1;

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
