package testtask.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import testtask.db.model.TV;
import testtask.db.model.VacuumCleaner;

import java.util.List;

@Repository("vacuumCleanerRepository")
public interface VacuumCleanerRepository extends JpaRepository<VacuumCleaner, String> {

    @Query(value = "SELECT * FROM VacuumCleaner WHERE v_availability ='Yes'", nativeQuery = true)
    List<VacuumCleaner> findAvailVC();
    //  фильтрация по количеству режимов работы
    @Modifying
    @Query(value = "SELECT * FROM VacuumCleaner WHERE v_mode_quantity =:v_mode_quantity", nativeQuery = true)
    List<VacuumCleaner> findAllByMode(@Param("v_mode_quantity") Integer v_mode_quantity);

    //  фильтрация по объему пылесборника
    @Modifying
    @Query(value = "SELECT * FROM VacuumCleaner WHERE v_dust_size BETWEEN :dustSizeMin AND :dustSizeMax", nativeQuery = true)
    List<VacuumCleaner> findAllByDust(@Param("dustSizeMin") Integer dustSizeMin, @Param("dustSizeMax") Integer dustSizeMax);


    @Query(value = "SELECT * FROM VacuumCleaner WHERE v_id = :v_id ", nativeQuery = true)
    List<VacuumCleaner> findById(@Param("v_id") Integer v_id);

//  фильтрация по цене (от-до)
    @Modifying
    @Query(value = "SELECT * FROM VacuumCleaner WHERE v_price BETWEEN :priceMin AND :priceMax", nativeQuery = true)
    List<VacuumCleaner> findAllByPrices(@Param("priceMin") Integer priceMin, @Param("priceMax") Integer priceMax);

//  удаление строки
    @Modifying
    @Query(value = "delete from VacuumCleaner where v_id = :v_id", nativeQuery = true)
    void deleteById(@Param("v_id") Integer v_id);

//  добавление строки
    @Modifying
    @Query(value = "insert into VacuumCleaner (v_id, v_name,v_serial_number,v_color,v_size,v_price,v_dust_size,v_mode_quantity,v_availability) " +
            "  values (:v_id, :v_name, :v_serial_number, :v_color, :v_size, :v_price, :v_dust_size, :v_mode_quantity, :v_availability)", nativeQuery = true)
    void create(@Param("v_id") Integer v_id,@Param("v_name") String v_name, @Param("v_serial_number") String v_serial_number,
                @Param("v_size") String v_size, @Param("v_color") String v_color,
                @Param("v_price") Integer v_price, @Param("v_dust_size") Integer v_dust_size,
                @Param("v_mode_quantity") Integer v_mode_quantity, @Param("v_availability") String v_availability);

//  поиск по наименованию (без учета регистра)
    @Modifying
    @Query(value = "SELECT * FROM VacuumCleaner WHERE v_name LIKE UPPER(:v_name)", nativeQuery = true)
    List<VacuumCleaner> findAllByNames(@Param("v_name") String v_name);
    //все
    @Query(value = "SELECT * FROM VacuumCleaner", nativeQuery = true)
    List<VacuumCleaner> All();
    //сортировки по имени и цене
    @Query(value = "SELECT * FROM VacuumCleaner ORDER BY v_price DESC", nativeQuery = true)
    List<VacuumCleaner> sortedPrice();
    @Query(value = "SELECT * FROM VacuumCleaner ORDER BY v_name DESC", nativeQuery = true)
    List<VacuumCleaner> sortedName();
}
