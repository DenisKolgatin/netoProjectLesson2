import taxes.TaxSystem;
import taxes.USNdebit;
import taxes.USNdebitcredit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int menu = 0; //Управление меню
        int taxPredSumm = 0; //Предварительный рассчет налога
        Scanner sc = new Scanner(System.in);
        Company company = new Company();
        System.out.println("Введите название компании ");
        company.title = sc.nextLine();
        company.debit = 0;
        company.credit = 0;

        while (true) {
            System.out.println("Введите 1 для добавления платежа, 2 для выбора налогообложения");
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("Введите доход или расход (со знаком минус)");
                    company.shiftMoney(sc.nextInt());
                    TaxSystem taxSystem1 = new USNdebit();
                    taxPredSumm = taxSystem1.calcTaxFor(company.debit, company.credit);
                    System.out.println("При выборе тарифа УСН доходы, вы заплатите " + taxPredSumm);
                    TaxSystem taxSystem2 = new USNdebitcredit();
                    taxPredSumm = taxSystem2.calcTaxFor(company.debit, company.credit);
                    System.out.println("При выборе тарифа УСН доходы минус расходы, вы заплатите " + taxPredSumm);
                    break;
                case 2:
                    System.out.println("Введите 1 для УСН дохода, введите 2 для УСН доходы-расходы");
                    company.SetTaxSystem(sc.nextInt());
                    company.payTaxes();
                    break;
                default:
                    System.out.println("Введите значения в рамках указанных пунктов меню");
                    break;
            }
        }

    }
}