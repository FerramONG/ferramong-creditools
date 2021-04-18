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

    @PutMapping("/wallet/credit/money")
    public void creditUsingMoney(@RequestBody TransactionInfo transaction) {
        creditoolsService.creditUsingMoney(
                transaction.getIdDweller(),
                transaction.getValue()
        );
    }

    @PutMapping("/wallet/credit/creditools")
    public void creditUsingCreditools(@RequestBody TransactionInfo transaction) {
        creditoolsService.creditUsingCreditools(
                transaction.getIdDweller(),
                transaction.getValue()
        );
    }

    @PutMapping("/wallet/debit")
    public void debit(@RequestBody TransactionInfo transaction) {
         creditoolsService.debit(
                 transaction.getIdDweller(),
                 transaction.getValue()
         );
    }

    @GetMapping("/wallet/dweller/{id_dweller}")
    public ResponseEntity<Double> getBalance(@PathVariable("id_dweller") int idDweller) {
        return ResponseEntity.ok().body(creditoolsService.getBalance(idDweller));
    }
}
