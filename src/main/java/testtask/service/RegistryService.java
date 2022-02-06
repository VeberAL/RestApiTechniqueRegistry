package testtask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testtask.db.model.*;
import testtask.db.repository.*;

import java.util.*;

@Service
@Transactional
public class RegistryService {

    @Autowired
    private VacuumCleanerRepository vacuumCleanerRepository1;
    @Autowired
    private TVRepository tvRepository1;
    @Autowired
    private ComputersRepository computerRepository1;
    @Autowired
    private FridgeRepository fridgeRepository1;
    @Autowired
    private SmartphoneRepository smartphoneRepository1;

    //показать все товары
    public List<Object> getAll() {
        List<Object> result = new LinkedList<>();
        result.addAll(smartphoneRepository1.All());
        result.addAll(tvRepository1.All());
        result.addAll(vacuumCleanerRepository1.All());
        result.addAll(computerRepository1.All());
        result.addAll(fridgeRepository1.All());
        return result;
    }
    //показать все доступные товары
    public List<Object> getAllAvailble() {
        List<Object> result = new LinkedList<>();
        result.addAll(smartphoneRepository1.findAvailSm());
        result.addAll(tvRepository1.findAvailTV());
        result.addAll(vacuumCleanerRepository1.findAvailVC());
        result.addAll(computerRepository1.findAvailComp());
        result.addAll(fridgeRepository1.findAvailFr());
        return result;
    }

    //сортировка по цене тв
    public List<TV> sortedByPriceTV() { return tvRepository1.sortedPrice(); }
    //сортировка по имени тв
    public List<TV> sortedByNameTV() { return tvRepository1.sortedName(); }
    //сортировка по цене пылесос
    public List<VacuumCleaner> sortedByPriceVC() { return vacuumCleanerRepository1.sortedPrice(); }
    //сортировка по имени пылесос
    public List<VacuumCleaner> sortedByNameVC() { return vacuumCleanerRepository1.sortedName(); }
    //сортировка по цене холодильник
    public List<Fridge> sortedByPriceFr() { return fridgeRepository1.sortedPrice(); }
    //сортировка по имени холодильник
    public List<Fridge> sortedByNameFr() { return fridgeRepository1.sortedName(); }
    //сортировка по цене смартфон
    public List<Smartphone> sortedByPriceSm() { return smartphoneRepository1.sortedPrice(); }
    //сортировка по имени смартфон
    public List<Smartphone> sortedByNameSm() { return smartphoneRepository1.sortedName(); }
    //сортировка по цене комп
    public List<Computers> sortedByPriceCm() { return computerRepository1.sortedPrice(); }
    //сортировка по имени комп
    public List<Computers> sortedByNameCm() { return computerRepository1.sortedName(); }
}