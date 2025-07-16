import taxes.TaxSystem;
import taxes.USNdebit;
import taxes.USNdebitcredit;

public class Company {
    public String title;
    public int debit;
    public int credit;
    public TaxSystem taxSystem;

    public Company(String title, TaxSystem taxSystem) {
        this.title = title;
        this.taxSystem = taxSystem;
    }

    public void shiftMoney(int amount) {
        if (amount > 0) {
            this.debit += amount;
        } else if (amount < 0) {
            this.credit = credit + Math.abs(amount);
        }
    }

    public void SetTaxSystem(TaxSystem taxSystem) {
        this.taxSystem = taxSystem;
    }

    public void payTaxes() {
        int tax = taxSystem.calcTaxFor(debit, credit);
        System.out.println("Компания "+ this.title + " уплатила налог в размере: " + tax + " руб.");
        this.debit = 0;
        this.credit = 0;

    }

}
