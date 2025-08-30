package lld.wallet.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AccountNotFoundException extends Exception {

    public AccountNotFoundException(String message) {
        super(message);
    }

}
