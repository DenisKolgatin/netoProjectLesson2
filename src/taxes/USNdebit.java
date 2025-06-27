package taxes;

public class USNdebit extends TaxSystem{
    public int tax = 0;
    @Override
    public int calcTaxFor(int debit, int credit) {
        return tax = debit * 6 / 100;
    }
}
