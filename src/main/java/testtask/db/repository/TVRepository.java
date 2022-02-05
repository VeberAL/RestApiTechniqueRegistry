package testtask.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import testtask.db.model.Smartphone;
import testtask.db.model.TV;


import java.util.List;
@Repository("tvRepository")
public interface TVRepository extends JpaRepository<TV, String> {
    //сортировки по имени и цене
    @Query(value = "SELECT * FROM TV ORDER BY tv_price DESC", nativeQuery = true)
    List<TV> sortedPrice();
    @Query(value = "SELECT * FROM TV ORDER BY tv_name DESC", nativeQuery = true)
    List<TV> sortedName();
    //все
    @Query(value = "SELECT * FROM TV", nativeQuery = true)
    List<TV> All();
    @Query(value = "SELECT * FROM TV WHERE tv_availability ='Yes'", nativeQuery = true)
    List<TV> findAvailTV();

    @Query(value = "SELECT * FROM TV WHERE tv_id = :tv_id ", nativeQuery = true)
    List<TV> findById(@Param("tv_id") Integer tv_id);

//  фильтрация по цене (от-до)
    @Modifying
    @Query(value = "SELECT * FROM TV WHERE tv_price BETWEEN :priceMin AND :priceMax", nativeQuery = true)
    List<TV> findAllByPrices(@Param("priceMin") Integer priceMin, @Param("priceMax") Integer priceMax);

//  фильтрация по технологии
    @Modifying
    @Query(value = "SELECT * FROM TV WHERE tv_technology LIKE UPPER(:tv_technology)", nativeQuery = true)
    List<TV> findAllByTechnology(@Param("tv_technology") String tv_technology);

//  удаление строки
    @Modifying
    @Query(value = "delete from TV where tv_id = :tv_id", nativeQuery = true)
    void deleteById(@Param("tv_id") Integer tv_id);

//  добавление строки
    @Modifying
    @Query(value = "insert into TV (tv_id, tv_name,tv_serial_number,tv_color,tv_size,tv_price,tv_category,tv_technology,tv_availability) " +
            "  values (:tv_id, :tv_name, :tv_serial_Number, :tv_color, :tv_size, :tv_price, :tv_category, :tv_technology, :tv_availability)", nativeQuery = true)
    void create(@Param("tv_id") Integer tv_id,@Param("tv_name") String tv_name, @Param("tv_serial_Number") String tv_serial_Number,
                @Param("tv_size") String tv_size, @Param("tv_color") String tv_color,
                @Param("tv_price") Integer tv_price, @Param("tv_category") String tv_category,
                @Param("tv_technology") String tv_technology, @Param("tv_availability") String tv_availability);

//  поиск по наименованию (без учета регистра)
    @Modifying
    @Query(value = "SELECT * FROM TV WHERE tv_name LIKE UPPER(:tv_name)", nativeQuery = true)
    List<TV> findAllByNames(@Param("tv_name") String tv_name);
}
