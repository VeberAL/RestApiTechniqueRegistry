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
@Table(name = "Computers")

public class Computers implements Serializable {

    private static final long serialVersionUID = 1L;

    public Computers(Integer c_id, String c_name, String c_serial_number, String c_color, String c_size, Integer c_price, String c_memory, String c_processor, String c_availability) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_serial_number = c_serial_number;
        this.c_color = c_color;
        this.c_size = c_size;
        this.c_price = c_price;
        this.c_memory = c_memory;
        this.c_processor = c_processor;
        this.c_availability = c_availability;
    }
    public Computers(String c_name, String c_serial_number, String c_color, String c_size, Integer c_price, String c_memory, String c_processor, String c_availability) {
        this.c_name = c_name;
        this.c_serial_number = c_serial_number;
        this.c_color = c_color;
        this.c_size = c_size;
        this.c_price = c_price;
        this.c_memory = c_memory;
        this.c_processor = c_processor;
        this.c_availability = c_availability;
    }

    @Id
    @Column(name = "c_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer c_id;

//    @OneToMany(targetEntity = Registry.class, mappedBy = "Computers" , fetch = FetchType.LAZY)
//    private List<Registry> registryList;

    @NonNull
    @Column(name = "c_name")
    private String c_name;

    @NonNull
    @Column(name = "c_serial_number")
    private String c_serial_number;

    @NonNull
    @Column(name = "c_color")
    private String c_color;

    @NonNull
    @Column(name = "c_size")
    private String c_size;

    @NonNull
    @Column(name = "c_price")
    private Integer c_price;

    @NonNull
    @Column(name = "c_memory")
    private String c_memory;

    @NonNull
    @Column(name = "c_processor")
    private String c_processor;

    @NonNull
    @Column(name = "c_availability")
    private String c_availability;

}
