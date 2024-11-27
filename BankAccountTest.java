import model.BankAccount;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class BankAccountTest {

    private static BankAccount test1;

    @Before
    public void initialiseBankAccount() throws Exception {
        test1 = new BankAccount("45262553", 750.00, "Aidan Cox", "aidancox@gmail.com", "04534534");
    }

    @Test
    public void should_DepositFunds_When_ValidAmountDeposited() {

        //When
        double expected = 850;
        test1.depositFunds(100.00);
        double actual = test1.getAccountBalance();

        //Then
        assertEquals(expected, actual, 0.1);
    }

    @Test
    public void shouldNot_DepositFunds_When_InValidAmountDeposited() {

        //When
        double expected = 750.00;
        test1.depositFunds(-300.00);
        double actual = test1.getAccountBalance();

        //Then
        assertEquals(expected, actual, 0.1);

    }

    @Test
    public void shouldNot_Deposit_When_NullPresent() {

        //When
        double expected = test1.getAccountBalance();
        test1.depositFunds(null);
        double actual = test1.getAccountBalance();

        //Then
        assertEquals(expected, actual, 0.1);
    }

    @Test
    public void should_WithdrawFunds_When_ValidAmountWithdrawn() {

        //When
        test1.withdrawFunds(300.00);
        double actual = test1.getAccountBalance();
        double expected = 450.00;

        //Then
        assertEquals(expected, actual, 0.1);

    }

    @Test
    public void shouldNot_WithdrawFunds_When_InValidAmountWithdrawn() {

        //When
        test1.withdrawFunds(-300.00);
        double actual = test1.getAccountBalance();
        double expected = 750.00;

        //Then
        assertEquals(expected, actual, 0.1);
    }

    @Test
    public void shouldNot_Withdraw_When_NullPresent() {

        //When
        double expected = test1.getAccountBalance();
        test1.withdrawFunds(null);
        double actual = test1.getAccountBalance();

        //Then
        assertEquals(expected, actual, 0.1);


    }
}



