package ferramong.creditools.services;

import ferramong.creditools.repositories.CreditoolsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;

@Service
@AllArgsConstructor
public class CreditoolsService {

    private final CreditoolsRepository repository;

    public void creditUsingMoney(int idDweller, double value) {
        creditUsingCreditools(idDweller, value * 10);
    }

    public void creditUsingCreditools(int idDweller, double value) {
        if (!repository.existsById(idDweller))
            throw new NotFoundException();

        repository.creditDweller(idDweller, value);
    }

    public void debit(int idDweller, double value) {
        if (!repository.existsById(idDweller))
            throw new NotFoundException();

        repository.debitDweller(idDweller, value);
    }

    public double getBalance(int idDweller) {
        if (!repository.existsById(idDweller))
            throw new NotFoundException();

        return repository.getBalance(idDweller);
    }
}
