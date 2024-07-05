import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class PayPal {
    private String apiKey;

    public PayPal(String apiKey) {
        this.apiKey = apiKey;
    }

    public boolean chargeCreditCard(String cardNumber, String expirationDate, String cvv, double amount) {

        PaymentGateway gateway = new PaymentGateway(apiKey);


        if (!isValidCreditCardNumber(cardNumber)) {
            System.out.println("Invalid credit card number.");
            return false;
        }
        if (!isValidExpirationDate(expirationDate)) {
            System.out.println("Invalid expiration date.");
            return false;
        }
        if (!isValidCvv(cvv)) {
            System.out.println("Invalid CVV.");
            return false;
        }


        boolean success = gateway.processPayment(cardNumber, expirationDate, cvv, amount);

        if (success) {
            System.out.println("Payment successful.");
        } else {
            System.out.println("Payment failed.");
        }

        return success;
    }

    private boolean isValidCreditCardNumber(String cardNumber) {

        return cardNumber.matches("\\d{16}");
    }

    private boolean isValidExpirationDate(String expirationDate) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
        dateFormat.setLenient(false);

        try {
            Date currentDate = new Date();
            Date date = dateFormat.parse(expirationDate);
            return date.after(currentDate);
        } catch (ParseException e) {
            return false;
        }
    }

    private boolean isValidCvv(String cvv) {

        return cvv.matches("\\d{3}");
    }
}

