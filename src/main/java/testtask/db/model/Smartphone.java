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
@Table(name = "Smartphone")

public class Smartphone implements Serializable {

    public Smartphone(Integer s_id, String s_name, String s_serial_number, String s_color, String s_size, Integer s_price, Integer s_memory, Integer s_camera_quantity, String s_availability) {
        this.s_id = s_id;
        this.s_name = s_name;
        this.s_serial_number = s_serial_number;
        this.s_color = s_color;
        this.s_size = s_size;
        this.s_price = s_price;
        this.s_memory = s_memory;
        this.s_camera_quantity = s_camera_quantity;
        this.s_availability = s_availability;
    }
    public Smartphone(String s_name, String s_serial_number, String s_color, String s_size, Integer s_price, Integer s_memory, Integer s_camera_quantity, String s_availability) {
        this.s_name = s_name;
        this.s_serial_number = s_serial_number;
        this.s_color = s_color;
        this.s_size = s_size;
        this.s_price = s_price;
        this.s_memory = s_memory;
        this.s_camera_quantity = s_camera_quantity;
        this.s_availability = s_availability;
    }

    @Id
    @Column(name = "s_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer s_id;
//    @OneToMany(targetEntity = Registry.class, mappedBy = "Smartphone" , fetch = FetchType.LAZY)
//    private List<Registry> registryList;
    @NonNull
    @Column(name = "s_name")
    private String s_name;

    @NonNull
    @Column(name = "s_serial_number")
    private String s_serial_number;

    @NonNull
    @Column(name = "s_color")
    private String s_color;

    @NonNull
    @Column(name = "s_size")
    private String s_size;

    @NonNull
    @Column(name = "s_price")
    private Integer s_price;

    @NonNull
    @Column(name = "s_memory")
    private Integer s_memory;

    @NonNull
    @Column(name = "s_camera_quantity")
    private Integer s_camera_quantity;

    @NonNull
    @Column(name = "s_availability")
    private String s_availability;
}
