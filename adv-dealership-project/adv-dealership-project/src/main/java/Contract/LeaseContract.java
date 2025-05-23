package Contract;

import com.pluralsight.dealership.Vehicle;

public class LeaseContract extends Contract {
    private double expectedEndingValue;
    private double leaseFee;
    private double monthlyPayment;


    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);

        this.expectedEndingValue = getVehicleSold().getPrice() * 0.05;
        this.leaseFee = 0.07;
        this.monthlyPayment = monthlyPayment;//
        // this.vehicleSold = vehicleSold();    }
    }

        public double getExpectedEndingValue () {
            return expectedEndingValue;
        }


        public void setExpectedEndingValue ( double expectedEndingValue){
            this.expectedEndingValue = expectedEndingValue;
        }


        public double getLeaseFee () {
            return leaseFee;
        }


        public void setLeaseFee ( double leaseFee){
            this.leaseFee = leaseFee;
        }

        @Override
        public double getTotalPrice () {
            return (getVehicleSold().getPrice() - expectedEndingValue) + leaseFee;
        }

        @Override
        public double getMonthlyPayment () {
            int numberOfPayments = 36;
            double interestRate = 4.0 / 1200;
            double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
            monthlyPayment = Math.round(monthlyPayment * 100);
            monthlyPayment /= 100;
            return monthlyPayment;
        }
    }
