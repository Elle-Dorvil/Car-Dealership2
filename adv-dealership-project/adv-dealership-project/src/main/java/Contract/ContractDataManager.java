package Contract;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class ContractDataManager {
        public  void saveContracts(List<Contract> contracts) {
            for (Contract contract : contracts) {
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("contracts.csv", true));
                    writer.write(String.valueOf(contract.getDate()));
                    writer.newLine();
                    writer.write(contract.getCustomerName());
                    writer.newLine();
                    writer.write(String.valueOf(contract.getCustomerEmail()));
                    writer.newLine();
                    writer.write(String.valueOf(contract.getVehicleSold().toString()));
                    writer.newLine();
                    writer.write(String.valueOf(contract.getTotalPrice()));
                    writer.newLine();
                    writer.write(String.valueOf(contract.getMonthlyPayment()));
                    writer.newLine();

                    if (contract instanceof SalesContract) {
                        SalesContract sc = (SalesContract) contract;
                        writer.write(String.valueOf(sc.getSalesTaxAmount()));
                        writer.newLine();
                        writer.write(String.valueOf(sc.getRecordingFee()));
                        writer.newLine();
                        writer.write(String.valueOf(sc.getProcessingFee()));
                        writer.newLine();
                        writer.write(String.valueOf(sc.isFinanced()));
                        writer.newLine();
                    } else if (contract instanceof LeaseContract) {
                        LeaseContract lc = (LeaseContract) contract;
                        writer.write(String.valueOf(lc.getExpectedEndingValue()));
                        writer.newLine();
                        writer.write(String.valueOf(lc.getLeaseFee()));
                        writer.newLine();
                    }
                    writer.close();
                } catch (Exception e) {
                    System.out.println("Oops! Could not write to file.");;
                }
            }
        }}

