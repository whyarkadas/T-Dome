import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    private double epsilon = 1e-6;

    @Test
    public void accountCannotHaveNegativeOverdraftLimit() {

        Account account = new Account(-20);

        Assert.assertEquals(0d, account.getOverdraftLimit(), epsilon);
    }

    @Test
    public void depositAndwithdrawWillNotAcceptNegativeNumbers() {

        Account account = new Account(0);
        Assert.assertEquals(false, account.deposit(-10.00));
        Assert.assertEquals(false, account.withdraw(-10.00));

    }


    @Test
    public void accountCannotOverstepItsOverdraftLimit(){

        Account account = new Account(-20);
        Assert.assertEquals(false, account.withdraw(50));
    }

    @Test
    public void depositCorrectAmount(){

        Account account = new Account(0);
        account.deposit(50.00);

        Assert.assertEquals(50, account.getBalance(), epsilon);
    }

    @Test
    public void withdrawCorrectAmount(){

        Account account = new Account(0);
        account.deposit(50.00);
        account.withdraw(10.00);

        Assert.assertEquals(40.00, account.getBalance(), epsilon);
    }

    @Test
    public void depositReturnCorrectValue(){
        Account account = new Account(0);
        account.deposit(50.00);
        Assert.assertEquals(true,account.deposit(10));
    }

    @Test
    public void withdrawReturnCorrectValue(){
        Account account = new Account(0);
        account.deposit(50.00);
        Assert.assertEquals(true,account.withdraw(10));
    }
}