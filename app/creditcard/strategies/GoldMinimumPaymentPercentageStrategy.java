/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.21
 * Time:11:37
 */

package app.creditcard.strategies;

import app.framework.domain.PercentageStrategy;

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

    public String getName() {
        return "GOLD";
    }
}
