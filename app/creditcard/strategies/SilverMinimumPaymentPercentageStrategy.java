/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.21
 * Time:11:38
 */

package app.creditcard.strategies;

import app.framework.domain.PercentageStrategy;

public class SilverMinimumPaymentPercentageStrategy implements PercentageStrategy {

    private double percent = .12;

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
