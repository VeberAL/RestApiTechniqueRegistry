//package testtask.db.repository;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//import testtask.db.model.*;
//
//import java.util.List;
//
//@Repository("registryRepository")
//public interface RegistryRepository extends JpaRepository<Object, String> {
//
////  техника в наличии
//    @Query(value = "SELECT * FROM VacuumCleaner WHERE v_availability ='Yes'", nativeQuery = true)
//    List<VacuumCleaner> findAvailVC();
//    @Query(value = "SELECT * FROM Computers WHERE c_availability ='Yes'", nativeQuery = true)
//    List<Computers> findAvailComp();
//    @Query(value = "SELECT * FROM Fridge WHERE f_availability  ='Yes'", nativeQuery = true)
//    List<Fridge> findAvailFr();
//    @Query(value = "SELECT * FROM TV WHERE tv_availability  ='Yes'", nativeQuery = true)
//    List<TV> findAvailTV();
//    @Query(value = "SELECT * FROM Smartphone WHERE s_availability ='Yes'", nativeQuery = true)
//    List<Smartphone> findAvailSm();
//}
