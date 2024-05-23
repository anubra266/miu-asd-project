/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.21
 * Time:11:31
 */

package app.banking.strategies;

import app.framework.domain.PercentageStrategy;

public class SavingPercentageStrategy implements PercentageStrategy {

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
        return "SAVING";
    }
}
