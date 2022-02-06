package testtask.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import testtask.db.model.Fridge;
import testtask.db.model.Smartphone;
import testtask.db.model.VacuumCleaner;

import java.util.List;

@Repository("smartphoneRepository")
public interface SmartphoneRepository extends JpaRepository<Smartphone, String> {

    @Modifying
    @Query(value = "SELECT * FROM Smartphone WHERE s_availability = 'Yes'", nativeQuery = true)
    List<Smartphone> findAvailSm();

//  фильтрация по количеству памяти
    @Modifying
    @Query(value = "SELECT * FROM Smartphone WHERE s_memory =:s_memory", nativeQuery = true)
    List<Smartphone> findAllByMemory(@Param("s_memory") Integer s_memory);

    //  фильтрация по количеству камер
    @Modifying
    @Query(value = "SELECT * FROM Smartphone WHERE s_cameraQuantity =:s_cameraQuantity", nativeQuery = true)
    List<Smartphone> findAllByCamera(@Param("s_cameraQuantity") Integer s_cameraQuantity);

    @Query(value = "SELECT * FROM Smartphone WHERE s_id = :s_id ", nativeQuery = true)
    List<Smartphone> findById(@Param("s_id") Integer s_id);

//  фильтрация по цене (от-до)
    @Modifying
    @Query(value = "SELECT * FROM Smartphone WHERE s_price BETWEEN :priceMin AND :priceMax", nativeQuery = true)
    List<Smartphone> findAllByPrices(@Param("priceMin") Integer priceMin, @Param("priceMax") Integer priceMax);

//  удаление строки
    @Modifying
    @Query(value = "delete from Smartphone where s_id = :s_id", nativeQuery = true)
    void deleteById(@Param("s_id") Integer s_id);

//  добавление строки
    @Modifying
    @Query(value = "insert into Smartphone (s_id, s_name,s_serialnumber,s_color,s_size,s_price,s_memory,s_cameraQuantity,s_availability) " +
            "  values (:s_id, :s_name, :s_serialNumber, :s_color, :s_size, :s_price, :s_memory, :s_cameraQuantity, :s_availability)", nativeQuery = true)
    void create(@Param("s_id") Integer s_id,@Param("s_name") String s_name, @Param("s_serialNumber") String s_serialNumber,
                @Param("s_size") String s_size, @Param("s_color") String s_color,
                @Param("s_price") Integer s_price, @Param("s_memory") Integer s_memory,
                @Param("s_cameraQuantity") Integer s_cameraQuantity, @Param("s_availability") String s_availability);
    //все
    @Query(value = "SELECT * FROM Smartphone", nativeQuery = true)
    List<Smartphone> All();
//  поиск по наименованию (без учета регистра)
    @Modifying
    @Query(value = "SELECT * FROM Smartphone WHERE s_name LIKE UPPER(:s_name)", nativeQuery = true)
    List<Smartphone> findAllByNames(@Param("s_name") String s_name);

    //сортировки по имени и цене
    @Query(value = "SELECT * FROM Smartphone ORDER BY s_price DESC", nativeQuery = true)
    List<Smartphone> sortedPrice();
    @Query(value = "SELECT * FROM Smartphone ORDER BY s_name DESC", nativeQuery = true)
    List<Smartphone> sortedName();
}
