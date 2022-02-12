package testtask.db.model;

import lombok.*;
//import testtask.db.model.Registry;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {})
@ToString(exclude = {})
@Entity
@Table(name = "VacuumCleaner")

public class VacuumCleaner implements Serializable {

    public VacuumCleaner(Integer v_id, String v_name, String v_serial_number, String v_color, String v_size, Integer v_price, Integer v_dust_size, Integer v_mode_quantity, String v_availability) {
        this.v_id = v_id;
        this.v_name = v_name;
        this.v_serial_number = v_serial_number;
        this.v_color = v_color;
        this.v_size = v_size;
        this.v_price = v_price;
        this.v_dust_size = v_dust_size;
        this.v_mode_quantity = v_mode_quantity;
        this.v_availability = v_availability;
    }
    public VacuumCleaner(String v_name, String v_serial_number, String v_color, String v_size, Integer v_price, Integer v_dust_size, Integer v_mode_quantity, String v_availability) {
        this.v_name = v_name;
        this.v_serial_number = v_serial_number;
        this.v_color = v_color;
        this.v_size = v_size;
        this.v_price = v_price;
        this.v_dust_size = v_dust_size;
        this.v_mode_quantity = v_mode_quantity;
        this.v_availability = v_availability;
    }

    @Id
    @Column(name = "v_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer v_id;

    @Column(nullable = false, name = "v_name")
    private String v_name;

    @Column(nullable = false, name = "v_serial_number")
    private String v_serial_number;

    @Column(nullable = false, name = "v_color")
    private String v_color;

    @Column(nullable = false, name = "v_size")
    private String v_size;

    @Column(nullable = false, name = "v_price")
    private Integer v_price;

    @Column(nullable = false, name = "v_dust_size")
    private Integer v_dust_size;

    @Column(nullable = false, name = "v_mode_quantity")
    private Integer v_mode_quantity;

    @Column(nullable = false, name = "v_availability")
    private String v_availability;

}
