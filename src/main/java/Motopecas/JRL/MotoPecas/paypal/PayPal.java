/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.paypal;

import java.util.ArrayList;
import java.util.List;
 
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Authorization;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;


/**
 *
 * @author Luana
 */
public class PayPal {

    private static String crunchifyID = "AeSKEC0oP_SoHXjaJlNFH4tOIOa-BJ4MOfQbKE4gBMyhVmsZbYcF3bufwr0szV48j53cKHj2bBAMSGvq";
    private static String crunchifySecret = "EHNIA-XZKQURhPU7sfNqiPKrSjnvEOKb20JkgrGTPjrE1yaZWnbxY3zZ2LjS36mBeNFoqbSN3XjOtPtl";

    private static String executionMode = "sandbox"; // sandbox or production

    public static void main(String args[]) {
        PayPal crunchifyObj = new PayPal();

        // How to capture PayPal Payment using Java SDK? doCapture() PayPal SDK call.
        crunchifyObj.crunchifyCapturePayPalAPI();
    }

    // This is simple API call which will capture a specified amount for any given
    // Payer or User
    public void crunchifyCapturePayPalAPI() {

        
/// *
//* O fluxo ficaria assim:
//* 1. Crie o objeto Pagador e defina o PaymentMethod
//* 2. Defina RedirectUrls e defina cancelURL e returnURL
//* 3. Definir detalhes e adicionar detalhes de pagamento
//* 4. Montante Montante
//* 5. Definir transação
//* 6. Adicionar detalhes de pagamento e definir intenção para "autorizar"
//* 7. Crie o APIContext passando o clientID, o secret e o mode
//* 8. Crie o objeto Payment e receba paymentID
//* 9. Definir payerID para objeto PaymentExecution
//* 10. Execute o pagamento e obtenha a autorização
//*
//         * /
        
        Payer crunchifyPayer = new Payer();
        crunchifyPayer.setPaymentMethod("paypal");

        // Redirect URLs
        RedirectUrls crunchifyRedirectUrls = new RedirectUrls();
        crunchifyRedirectUrls.setCancelUrl("http://localhost:3000/crunchifyCancel");
        crunchifyRedirectUrls.setReturnUrl("http://localhost:3000/crunchifyReturn");

        // Set Payment Details Object
        Details crunchifyDetails = new Details();
        crunchifyDetails.setShipping("2.22");
        crunchifyDetails.setSubtotal("3.33");
        crunchifyDetails.setTax("1.11");

        // Set Payment amount
        Amount crunchifyAmount = new Amount();
        crunchifyAmount.setCurrency("USD");
        crunchifyAmount.setTotal("6.66");
        crunchifyAmount.setDetails(crunchifyDetails);

        // Set Transaction information
        Transaction crunchifyTransaction = new Transaction() {};
        crunchifyTransaction.setAmount(crunchifyAmount);
        crunchifyTransaction.setDescription("Crunchify Tutorial: How to Invoke PayPal REST API using Java Client?");
        List<Transaction> crunchifyTransactions = new ArrayList<Transaction>();
        crunchifyTransactions.add(crunchifyTransaction);

        // Add Payment details
        Payment crunchifyPayment = new Payment();

        // Set Payment intent to authorize
        crunchifyPayment.setIntent("authorize");
        crunchifyPayment.setPayer(crunchifyPayer);
        crunchifyPayment.setTransactions(crunchifyTransactions);
        crunchifyPayment.setRedirectUrls(crunchifyRedirectUrls);

        // Pass the clientID, secret and mode. The easiest, and most widely used option.
        APIContext crunchifyapiContext = new APIContext(crunchifyID, crunchifySecret, executionMode);

        try {

            Payment myPayment = crunchifyPayment.create(crunchifyapiContext);

            System.out.println("createdPayment Obejct Details ==> " + myPayment.toString());

            // Identifier of the payment resource created 
            crunchifyPayment.setId(myPayment.getId());

            PaymentExecution crunchifyPaymentExecution = new PaymentExecution();

            // Set your PayerID. The ID of the Payer, passed in the `return_url` by PayPal.
            crunchifyPaymentExecution.setPayerId("<!---- Add your PayerID here ---->");

            // This call will fail as user has to access Payment on UI. Programmatically
            // there is no way you can get Payer's consent.
            Payment createdAuthPayment = crunchifyPayment.execute(crunchifyapiContext, crunchifyPaymentExecution);

            // Transactional details including the amount and item details.
            Authorization crunchifyAuthorization = createdAuthPayment.getTransactions().get(0).getRelatedResources().get(0).getAuthorization();

            log("Here is your Authorization ID" + crunchifyAuthorization.getId());

        } catch (PayPalRESTException e) {

            // The "standard" error output stream. This stream is already open and ready to
            // accept output data.
            System.err.println(e.getDetails());
        }
    }

    private void log(String string) {
        System.out.println(string);

    }
}
