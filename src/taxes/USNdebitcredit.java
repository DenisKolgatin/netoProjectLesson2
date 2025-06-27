package taxes;

public class USNdebitcredit extends TaxSystem{
    public int tax = 0;
    @Override
    public int calcTaxFor(int debit, int credit) {
        tax = (debit-credit) * 15 / 100;
        if (tax > 0) {
            return tax;
        } else return 0;
    }
}
