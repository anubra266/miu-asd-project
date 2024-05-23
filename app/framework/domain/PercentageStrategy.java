package app.framework.domain;

import java.io.Serializable;

public interface PercentageStrategy  extends Serializable {

    public static final long serialVersionUID = -891292834814574888L;

    public double getPercentAmount(double amount);

    public String getName();
}
