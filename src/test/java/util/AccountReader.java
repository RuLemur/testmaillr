package util;

import org.junit.Assert;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccountReader {

    public static List<Account> readAccounts() {
        List<Account> accounts = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/test/resources/accounts.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                accounts.add(new Account(line.split(";")));
                line = br.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (accounts.isEmpty()) {
            Assert.fail( "Список аккаунтов пуст");
            // По хорошему стоит делать кастомные экзепшены, но это не критично
        }
        return accounts;
    }
}
