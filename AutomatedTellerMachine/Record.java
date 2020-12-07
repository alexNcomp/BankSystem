package AutomatedTellerMachine;

import java.util.Date;

/**
 * A class for an ATM operation record.
 * @author Alex Nguyen
 */
public class Record {
    private String operation;
    private String atmID;
    private double amount;
    private Date date;

    public Record() {
        this.operation = null;
        this.atmID = null;
        this.amount = 0;
        this.date = null;
    }
    
    public Record(String operation, String atmID, double amount) {
        this.operation = operation;
        this.atmID = atmID;
        this.amount = amount;
        this.date = new Date();     // will give object of current time.
    }
    
    public Record(Record record) {
        this.operation = record.operation;
        this.atmID = record.atmID;
        this.amount = record.amount;
        this.date = record.date;
    }
    
    @Override
    public String toString() {
        String str = "";
        
        str += String.format("%-10s: %s\n", "Operation", operation);
        str += String.format("%-10s: %.2f\n", "Amount", amount);
        str += String.format("%-10s: %s\n", "Datet", date);
        str += String.format("%-10s: %s\n", "ATM ID", atmID);
        
        return str;
    }
    
    public boolean equals(Record record) {
        return this.operation.equals(record.operation) && 
                this.atmID.equals(record.atmID) &&
                this.amount == record.amount &&
                this.date.equals(record.date);
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getAtmID() {
        return atmID;
    }

    public void setAtmID(String atmID) {
        this.atmID = atmID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
