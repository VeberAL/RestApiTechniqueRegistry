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
@Table(name = "Fridge")

public class Fridge implements Serializable {

    public Fridge(Integer f_id, String f_name, String f_serial_number, String f_color, String f_size, Integer f_price, Integer f_door_quantity, Integer f_camera_quantity, String f_availability) {
        this.f_id = f_id;
        this.f_name = f_name;
        this.f_serial_number = f_serial_number;
        this.f_color = f_color;
        this.f_size = f_size;
        this.f_price = f_price;
        this.f_camera_quantity = f_camera_quantity;
        this.f_door_quantity = f_door_quantity;
        this.f_availability = f_availability;
    }
    public Fridge(String f_name, String f_serial_number, String f_color, String f_size, Integer f_price, Integer f_door_quantity, Integer f_camera_quantity, String f_availability)  {
        this.f_name = f_name;
        this.f_serial_number = f_serial_number;
        this.f_color = f_color;
        this.f_size = f_size;
        this.f_price = f_price;
        this.f_camera_quantity = f_camera_quantity;
        this.f_door_quantity = f_door_quantity;
        this.f_availability = f_availability;
    }

    @Id
    @Column(name = "f_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer f_id;

    @Column(nullable = false, name = "f_name")
    private String f_name;

    @Column(nullable = false, name = "f_serial_number")
    private String f_serial_number;

    @Column(nullable = false, name = "f_color")
    private String f_color;

    @Column(nullable = false, name = "f_size")
    private String f_size;

    @Column(nullable = false, name = "f_price")
    private Integer f_price;

    @Column(nullable = false, name = "f_door_quantity")
    private Integer f_door_quantity;

    @Column(nullable = false, name = "f_camera_quantity")
    private Integer f_camera_quantity;

    @Column(nullable = false, name = "f_availability")
    private String f_availability;
}
