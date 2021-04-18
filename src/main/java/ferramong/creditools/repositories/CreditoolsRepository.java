package ferramong.creditools.repositories;

import ferramong.creditools.entities.Creditools;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CreditoolsRepository extends JpaRepository<Creditools, Integer> {

    @Modifying
    @Transactional
    @Query(
            "UPDATE Creditools c " +
            "SET c.balance = c.balance + :value " +
            "WHERE c.id_dweller = :id_dweller"
    )
    public void creditDweller(
            @Param("id_dweller") int idDweller,
            @Param("value") double value
    );

    @Modifying
    @Transactional
    @Query(
            "UPDATE Creditools c " +
            "SET c.balance = c.balance - :value " +
            "WHERE c.id_dweller = :id_dweller"
    )
    public void debitDweller(
            @Param("id_dweller") int idDweller,
            @Param("value") double value
    );

    @Query(
            "SELECT balance " +
            "FROM Creditools " +
            "WHERE id_dweller = :id_dweller"
    )
    public double getBalance(
            @Param("id_dweller") int idDweller
    );
}
