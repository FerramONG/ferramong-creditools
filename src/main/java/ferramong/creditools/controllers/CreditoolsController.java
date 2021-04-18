package ferramong.creditools.controllers;

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
    public void creditUsingMoney(@RequestAttribute("id_dweller") int idDweller,
                                 @RequestAttribute("value") double value) {
        creditoolsService.creditUsingMoney(idDweller, value);
    }

    @PutMapping("/wallet/credit/creditools")
    public void creditUsingCreditools(@RequestAttribute("id_dweller") int idDweller,
                                      @RequestAttribute("value") double value) {
        creditoolsService.creditUsingCreditools(idDweller, value);
    }

    @PutMapping("/wallet/debit")
    public void debit(@RequestAttribute("id_dweller") int idDweller,
                      @RequestAttribute("value") double value) {
         creditoolsService.debit(idDweller, value);
    }

    @GetMapping("/wallet/dweller/{id_dweller}")
    public ResponseEntity<Double> getBalance(@PathVariable("id_dweller") int idDweller) {
        return ResponseEntity.ok().body(creditoolsService.getBalance(idDweller));
    }
}
