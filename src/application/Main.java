package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        List<TaxPayer> list = new ArrayList<>();

        System.out.println("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for(int i=1;i<=n;i++){
            System.out.printf("Tax payer data #" +i+ " data: ");

            System.out.println("Individual or company (i/c)? ");
            char type=sc.next().charAt(0);

            System.out.println("Name: ");
            sc.nextLine();
            String name=sc.nextLine();

            System.out.println("Annual income: ");
            Double income=sc.nextDouble();

            if(type=='i') {
                System.out.println("Health expenses: ");
                double healthExpenses=sc.nextDouble();

                list.add(new Individual(name,income,healthExpenses));
            }
            else if (type=='c') {
                System.out.println("Number of employees: ");
                int numberOfEmployees=sc.nextInt();

                list.add(new Company(name,income,numberOfEmployees));
            }

            System.out.println();
            System.out.println("TAXES PAID: ");

            for (TaxPayer taxes : list){
                System.out.println(taxes.getName() + ": $" + String.format("%.2f", taxes.tax()));
            }

            System.out.println();

            double sum=0.0;

            for (TaxPayer taxes : list) {
                sum+=taxes.tax();
            }
            System.out.printf("TOTAL TAXES: $%.2f\n", sum);
        }

        sc.close();

    }
}
