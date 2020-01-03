package bankaccountapp;

public interface IBaseRate {

    // Write a method that returns base rate
    default double getBaseRate() {
        return 2.5;
    }

}
