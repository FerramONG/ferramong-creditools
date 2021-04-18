package ferramong.creditools.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Creditools implements Serializable {

    @Id
    private int id_dweller;

    @Column(nullable = false)
    private double balance;
}
