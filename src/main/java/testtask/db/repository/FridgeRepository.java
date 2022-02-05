package testtask.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import testtask.db.model.Computers;
import testtask.db.model.Fridge;
import testtask.db.model.TV;
import testtask.db.model.VacuumCleaner;

import java.util.List;

@Repository("fridgeRepository")
public interface FridgeRepository extends JpaRepository<Fridge, String> {

    @Query(value = "SELECT * FROM Fridge WHERE f_availability  ='Yes'", nativeQuery = true)
    List<Fridge> findAvailFr();

    //сортировки по имени и цене
    @Query(value = "SELECT * FROM Fridge ORDER BY f_price DESC", nativeQuery = true)
    List<Fridge> sortedPrice();
    @Query(value = "SELECT * FROM Fridge ORDER BY f_name DESC", nativeQuery = true)
    List<Fridge> sortedName();

//  фильтрация по количеству дверей
    @Modifying
    @Query(value = "SELECT * FROM Fridge WHERE f_door_quantity =:f_door_quantity", nativeQuery = true)
    List<Fridge> findAllByDoor(@Param("f_door_quantity") Integer f_door_quantity);
    //все
    @Query(value = "SELECT * FROM Fridge", nativeQuery = true)
    List<Fridge> All();
    //  фильтрация по количеству камер
    @Modifying
    @Query(value = "SELECT * FROM Fridge WHERE f_camera_quantity =:f_camera_quantity", nativeQuery = true)
    List<Fridge> findAllByCamera(@Param("f_camera_quantity") Integer f_camera_quantity);

    @Query(value = "SELECT * FROM Fridge WHERE f_id = :f_id ", nativeQuery = true)
    List<Fridge> findById(@Param("f_id") Integer f_id);

//  фильтрация по цене (от-до)
    @Modifying
    @Query(value = "SELECT * FROM Fridge WHERE f_price BETWEEN :priceMin AND :priceMax", nativeQuery = true)
    List<Fridge> findAllByPrices(@Param("priceMin") Integer priceMin, @Param("priceMax") Integer priceMax);

//  удаление строки
    @Modifying
    @Query(value = "delete from Fridge where f_id = :f_id", nativeQuery = true)
    void deleteById(@Param("f_id") Integer f_id);

//  добавление строки
    @Modifying
    @Query(value = "insert into Fridge (f_id, f_name,f_serialnumber,f_color,f_size,f_price,f_door_quantity,f_camera_quantity,f_availability) " +
            "  values (:f_id, :f_name, :f_serialNumber, :f_color, :f_size, :f_price, :f_door_quantity, :f_camera_quantity, :f_availability)", nativeQuery = true)
    void create(@Param("f_id") Integer f_id,@Param("f_name") String f_name, @Param("f_serialNumber") String f_serialNumber,
                @Param("f_size") String f_size, @Param("f_color") String f_color,
                @Param("f_price") Integer f_price, @Param("f_door_quantity") Integer f_door_quantity,
                @Param("f_camera_quantity") Integer f_camera_quantity, @Param("f_availability") String f_availability);

//  поиск по наименованию (без учета регистра)
    @Modifying
    @Query(value = "SELECT * FROM Fridge WHERE f_name LIKE UPPER(:f_name)", nativeQuery = true)
    List<Fridge> findAllByNames(@Param("f_name") String f_name);
}
