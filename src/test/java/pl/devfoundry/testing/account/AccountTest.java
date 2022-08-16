package pl.devfoundry.testing.account;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pl.devfoundry.testing.account.Account;
import pl.devfoundry.testing.account.Address;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.hamcrest.MatcherAssert.assertThat;

@Tag("fries")
class AccountTest {

    @Test
    public void newAccountShouldNotBeActiveAfterCreation() {
        //given
        Account newAccount = new Account();

        //then
        assertFalse(newAccount.isActive(), "Check if new account is not active");
        assertThat(newAccount.isActive()).isFalse();
    }

    @Test
    void newAccountShouldBeActiveAfterActivation() {
        //given
        Account newAccount = new Account();

        //when
        newAccount.activate();

        //then
        assertTrue(newAccount.isActive());
        assertThat(newAccount.isActive()).isTrue();
    }

    @Test
    void newlyCreatedAccountShouldNotHaveDefaultDeliveryAddress() {

        //given
        Account account = new Account();

        //when
        Address address = account.getDefaultDeliveryAddress();

        //then
        assertNull(address);
        assertThat(address).isNull();
    }

    @Test
    void defaultDeliveryAddressShouldNotBeNullAfterBeingSet() {

        //given
        Address address = new Address("Krakowska", "44");
        Account account = new Account();
        account.setDefaultDeliveryAddress(address);

        //when
        Address defaultAddress = account.getDefaultDeliveryAddress();

        //then
        assertNotNull(defaultAddress);
        assertThat(address).isNotNull();
    }

    @RepeatedTest(5)
     void newAccountWithNotNullAddressShouldBeActive() {

        //given
        Address address = new Address("Puławska", "46/6");

        //when
        Account account = new Account(address);

        assumingThat(address != null, () -> {
           assertTrue(account.isActive());
        });
    }

    @Test
    void invalidEmailShouldThrowException() {

        //given
        Account account = new Account();

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> account.setEmail("wrong Email"));
    }

    @Test
    void validEmailShouldBeSet() {

        //given
        Account account = new Account();

        //when
        account.setEmail("kontakt@devfoundry.pl");

        //then
        assertThat(account.getEmail(), is("kontakt@devfoundry.pl"));
    }
}
