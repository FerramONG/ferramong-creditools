package ferramong.creditools.controllers;

import ferramong.creditools.models.TransactionInfo;
import ferramong.creditools.services.CreditoolsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.cors.CorsConfiguration;

@RestController
@AllArgsConstructor
@CrossOrigin(
        origins = CorsConfiguration.ALL,
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
public class CreditoolsController {

    private final CreditoolsService creditoolsService;

    /**
     * Creates a wallet for a dweller.
     *
     * <h2>CURL example</h2>
     * <code>
     *     curl "https://ferramong-creditools.herokuapp.com/wallet" \
     *     -X POST \
     *     -d "{\n  \"idDweller\": \"1\"\n}" \
     *     -H "Content-type: application/json"
     * </code>
     *
     * @param       request idDweller: Dweller id
     *
     * @return      200 if ok; 400 if another error occurs
     */
    @PostMapping("/wallet")
    public void newWallet(@RequestBody Map<String, Integer> request) {
        creditoolsService.newWallet(request.get("idDweller"));
    }

    /**
     * Credits some cash value to a dweller's account.
     * (1 money unit <=> 10 creditools)
     *
     * <h2>CURL example</h2>
     * <code>
     *     curl "https://ferramong-creditools.herokuapp.com/wallet/credit/money" \
     *     -X PUT \
     *     -d "{\n  \"idDweller\": \"1\", \n  \"value\": \"99\"\n}" \
     *     -H "Content-type: application/json"
     * </code>
     *
     * @param       transaction Dweller id and value to be credited to the
     * dweller's account
     *
     * @return      200 if ok; 404 if there is no dweller with the provided id;
     * 400 if another error occurs
     */
    @PutMapping("/wallet/credit/money")
    public void creditUsingMoney(@RequestBody TransactionInfo transaction) {
        creditoolsService.creditUsingMoney(
                transaction.getIdDweller(),
                transaction.getValue()
        );
    }

    /**
     * Credits some creditool value to a dweller's account.
     *
     * <h2>CURL example</h2>
     * <code>
     *     curl "https://ferramong-creditools.herokuapp.com/wallet/credit/creditools" \
     *     -X PUT \
     *     -d "{\n  \"idDweller\": \"1\", \n  \"value\": \"99\"\n}" \
     *     -H "Content-type: application/json"
     * </code>
     *
     * @param       transaction Dweller id and value to be credited to the
     * dweller's account
     *
     * @return      200 if ok; 404 if there is no dweller with the provided id;
     * 400 if another error occurs
     */
    @PutMapping("/wallet/credit/creditools")
    public void creditUsingCreditools(@RequestBody TransactionInfo transaction) {
        creditoolsService.creditUsingCreditools(
                transaction.getIdDweller(),
                transaction.getValue()
        );
    }

    /**
     * Debits some creditool value to a dweller's account.
     *
     * <h2>CURL example</h2>
     * <code>
     *     curl "https://ferramong-creditools.herokuapp.com/wallet/debit" \
     *     -X PUT \
     *     -d "{\n  \"idDweller\": \"1\", \n  \"value\": \"9\"\n}" \
     *     -H "Content-type: application/json"
     * </code>
     *
     * @param       transaction Dweller id and value to be credited to the
     * dweller's account
     *
     * @return      200 if ok; 404 if there is no dweller with the provided id;
     * 400 if another error occurs
     */
    @PutMapping("/wallet/debit")
    public void debit(@RequestBody TransactionInfo transaction) {
         creditoolsService.debit(
                 transaction.getIdDweller(),
                 transaction.getValue()
         );
    }

    /**
     * Gets the balance from a dweller.
     *
     * <h2>CURL example</h2>
     * <code>
     *      curl "https://ferramong-creditools.herokuapp.com/wallet/dweller/1"
     * </code>
     *
     * @param       idDweller Dweller id
     *
     * @return      Dweller balance and 200 if ok; 404 if there is no dweller
     * with the provided id; 400 if another error occurs
     */
    @GetMapping("/wallet/dweller/{id_dweller}")
    public ResponseEntity<Double> getBalance(@PathVariable("id_dweller") int idDweller) {
        return ResponseEntity.ok().body(creditoolsService.getBalance(idDweller));
    }
}
