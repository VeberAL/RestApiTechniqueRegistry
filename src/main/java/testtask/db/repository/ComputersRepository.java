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

@Repository("computersRepository")
public interface ComputersRepository extends JpaRepository<Computers, String> {
    //все
    @Query(value = "SELECT * FROM Computers", nativeQuery = true)
    List<Computers> All();

    @Query(value = "SELECT * FROM Computers WHERE c_availability  ='Yes'", nativeQuery = true)
    List<Computers> findAvailComp();

//  поиск по процессору
    @Modifying
    @Query(value = "SELECT * FROM Computers WHERE c_processor LIKE UPPER(:c_processor)", nativeQuery = true)
    List<Computers> findAllByProc(@Param("c_processor") String c_processor);

//  фильтрация по памяти
    @Modifying
    @Query(value = "SELECT * FROM Computers WHERE c_memory = :c_memory", nativeQuery = true)
    List<Computers> findAllByMemory(@Param("c_memory") String c_memory);

    @Query(value = "SELECT * FROM Computers WHERE c_id = :c_id ", nativeQuery = true)
    List<Computers> findById(@Param("c_id") Integer c_id);

//  фильтрация по цене (от-до)
    @Modifying
    @Query(value = "SELECT * FROM Computers WHERE c_price BETWEEN :priceMin AND :priceMax", nativeQuery = true)
    List<Computers> findAllByPrices(@Param("priceMin") Integer priceMin, @Param("priceMax") Integer priceMax);

//  удаление строки
    @Modifying
    @Query(value = "delete from Computers where c_id = :c_id", nativeQuery = true)
    void deleteById(@Param("c_id") Integer c_id);
    //сортировки по имени и цене
    @Query(value = "SELECT * FROM Computers ORDER BY c_price DESC", nativeQuery = true)
    List<Computers> sortedPrice();
    @Query(value = "SELECT * FROM Computers ORDER BY c_name DESC", nativeQuery = true)
    List<Computers> sortedName();
//  добавление строки
    @Modifying
    @Query(value = "insert into Computers (c_id, c_name,c_serial_number,c_color,c_size,c_price,c_memory,c_processor,c_availability) " +
            "  values (:c_id, :c_name, :c_serial_number, :c_color, :c_size, :c_price, :c_memory, :c_processor, :c_availability)", nativeQuery = true)
    void create(@Param("c_id") Integer c_id,@Param("c_name") String c_name, @Param("c_serial_number") String c_serial_number,
                @Param("c_size") String c_size, @Param("c_color") String c_color,
                @Param("c_price") Integer c_price, @Param("c_memory") String c_memory,
                @Param("c_processor") String c_processor, @Param("c_availability") String c_availability);

//  поиск по наименованию (без учета регистра)
    @Modifying
    @Query(value = "SELECT * FROM Computers WHERE c_name LIKE UPPER(:c_name)", nativeQuery = true)
    List<Computers> findAllByNames(@Param("c_name") String c_name);
}
