package testtask.db.model;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {})
@ToString(exclude = {})
@Entity
@Table(name = "TV")

public class TV implements Serializable {

   // private static final long serialVersionUID = 1L;

    public TV(Integer tv_id, String tv_name, String tv_serial_Number, String tv_color, String tv_size, Integer tv_price, String tv_category, String tv_technology, String tv_availability) {
        this.tv_id = tv_id;
        this.tv_name = tv_name;
        this.tv_serial_Number = tv_serial_Number;
        this.tv_color = tv_color;
        this.tv_size = tv_size;
        this.tv_price = tv_price;
        this.tv_category = tv_category;
        this.tv_technology = tv_technology;
        this.tv_availability = tv_availability;
    }
    public TV(String tv_name, String tv_serial_Number, String tv_color, String tv_size, Integer tv_price, String tv_category, String tv_technology, String tv_availability) {
        this.tv_name = tv_name;
        this.tv_serial_Number = tv_serial_Number;
        this.tv_color = tv_color;
        this.tv_size = tv_size;
        this.tv_price = tv_price;
        this.tv_category = tv_category;
        this.tv_technology = tv_technology;
        this.tv_availability = tv_availability;
    }

    @Id
    @Column(name = "tv_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tv_id;

    @Column(nullable = false, name = "tv_name")
    private String tv_name;

    @Column(nullable = false, name = "tv_serial_Number")
    private String tv_serial_Number;

    @Column(nullable = false, name = "tv_color")
    private String tv_color;

    @Column(nullable = false, name = "tv_size")
    private String tv_size;

    @Column(nullable = false, name = "tv_price")
    private Integer tv_price;

    @Column(nullable = false, name = "tv_category")
    private String tv_category;

    @Column(nullable = false, name = "tv_technology")
    private String tv_technology;

    @Column(nullable = false, name = "tv_availability")
    private String tv_availability;

}
