package testtask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testtask.db.model.VacuumCleaner;
import testtask.db.repository.VacuumCleanerRepository;

import java.util.List;

@Service
@Transactional
public class VacuumCleanerService {

    @Autowired
    private VacuumCleanerRepository vacuumCleanerRepository;

    public void saveVC(Integer v_id, String v_name, String v_serial_Number, String v_color, String v_size, Integer v_price, Integer v_dust_size, Integer v_mode_quantity, String v_availability) {
        vacuumCleanerRepository.create(v_id, v_name, v_serial_Number, v_color, v_size, v_price,v_dust_size, v_mode_quantity, v_availability);
    }
    //удаление
    public void delete(Integer v_id) {
        try {
            vacuumCleanerRepository.deleteById(v_id);
        } catch (EmptyResultDataAccessException e) { }
    }

    //фильтр по объему пылесборника
    public List<VacuumCleaner> getAllByDust(Integer dustMin, Integer dustMax) {
        return vacuumCleanerRepository.findAllByPrices(dustMin,dustMax);
    }
    //фильтр по цене
    public List<VacuumCleaner> getAllByPrices(Integer priceMin, Integer priceMax) {
    return vacuumCleanerRepository.findAllByPrices(priceMin,priceMax);
    }

    //фильтр по количеству режимов
    public List<VacuumCleaner> getAllByMode(Integer v_mode_quantity) {
        return vacuumCleanerRepository.findAllByMode(v_mode_quantity);
    }

    //поиск по имени
    public List<VacuumCleaner> getAllByNames(String v_name) {
        return vacuumCleanerRepository.findAllByNames(v_name);
    }

    //вывод по id
    public List<VacuumCleaner> getById(Integer v_id) {
        return vacuumCleanerRepository.findById(v_id);
    }

}