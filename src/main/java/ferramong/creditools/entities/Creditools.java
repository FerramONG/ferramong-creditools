package ferramong.creditools.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Creditools implements Serializable {

    @Id
    private int id_dweller;

    @Column(nullable = false)
    private double balance;

    public Creditools(int idDweller) {
        this.id_dweller = idDweller;
        balance = 0.0;
    }
}
