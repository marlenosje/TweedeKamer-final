package personen;

import data.Motie;

public interface Politicus {

    public String getpartij();

    public void setPartij(String value);

    public String reageer();

    public Motie schrijfMotie();

    public String definieerBudget(String doel);

}
