/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.21
 * Time:11:31
 */

package app.banking.strategy;

import app.framework.PercentageStrategy;

public class CheckingPercentageStrategy implements PercentageStrategy {

    private double percent;

    public CheckingPercentageStrategy(double percent) {
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
