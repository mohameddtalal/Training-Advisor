public class PaymentGateway {
    private String apiKey;

    public PaymentGateway(String apiKey) {
        this.apiKey = apiKey;
    }

    public boolean processPayment(String cardNumber, String expirationDate, String cvv, double amount) {

        double successRate = 0.9;

        if (Math.random() < successRate) {
            return true;
        } else {
            return false;
        }
    }
}
