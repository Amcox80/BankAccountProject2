import model.BankAccount;
import model.AccountExtractor;
import model.ImportXMLFile;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        ImportXMLFile xmlFile1 = new ImportXMLFile();

        AccountExtractor accountExtractor = new AccountExtractor();

        String filePath =  "src/main/java/payload/requests.xml";

        String contents = xmlFile1.xmlFileContents("src/main/java/payload/requests.xml");

        List<Map<String, String>> accountRequests = accountExtractor.accountsExtracted(contents);

        List<BankAccount> bankAccounts = new ArrayList<>();

        // Account number must start at 1
        for (int i = 0; i < accountRequests.size(); i++) {
            int accountNumber = i;
            accountNumber = accountNumber + 1;
            BankAccount defaultAccount = new BankAccount(String.valueOf(accountNumber), 0.0, accountRequests.get(i).get("firstname"), accountRequests.get(i).get("email"), accountRequests.get(i).get("phone"));
            bankAccounts.add(defaultAccount);
        }

        System.out.println(bankAccounts.size());
    }
}


