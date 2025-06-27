import taxes.TaxSystem;
import taxes.USNdebit;
import taxes.USNdebitcredit;

public class Company {
    public String title;
    public int debit;
    public int credit;
    public int taxSystem;
   /*
    public Company(String title, int debit, int credit, int taxSystem) {
        this.title = title;
        this.debit = debit;
        this.credit = credit;
        this.taxSystem = taxSystem;
    } */

    public void shiftMoney(int amount) {
        if (amount > 0) {
            this.debit += amount;
        } else if (amount < 0) {
            this.credit = credit + Math.abs(amount);
        }
    }

    public void SetTaxSystem(int taxSystem) {
        this.taxSystem = taxSystem;
    }

    public void payTaxes() {
        int tax = 0;
        switch (taxSystem) {
            case 1:
                TaxSystem taxAmount1 = new USNdebit();
                tax = taxAmount1.calcTaxFor(this.debit, this.credit);
                break;
            case 2:
                TaxSystem taxAmount2 = new USNdebitcredit();
                tax = taxAmount2.calcTaxFor(this.debit, this.credit);
                break;
        }
        System.out.println("Компания "+ this.title + " уплатила налог в размере: " + tax + " руб.");
        this.debit = 0;
        this.credit = 0;

    }
}
