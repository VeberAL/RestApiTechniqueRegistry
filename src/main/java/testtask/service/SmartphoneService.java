package testtask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testtask.db.model.Fridge;
import testtask.db.model.Smartphone;
import testtask.db.repository.FridgeRepository;
import testtask.db.repository.SmartphoneRepository;

import java.util.List;

@Service
@Transactional
public class SmartphoneService {
    @Autowired
    private SmartphoneRepository smartphoneRepository;

        public void saveFr(Integer s_id, String s_name, String s_serial_number, String s_color, String s_size, Integer s_price, Integer s_memory, Integer s_camera_quantity, String f_availability) {
        smartphoneRepository.create(s_id,  s_name,  s_serial_number,  s_color,  s_size,  s_price,  s_memory,  s_camera_quantity,  f_availability);
    }
    //удаление
    public void delete(Integer s_id) {
        try {
            smartphoneRepository.deleteById(s_id);
        } catch (EmptyResultDataAccessException e) { }
    }
    //фильтр по цене
    public List<Smartphone> getAllByPrices(Integer priceMin, Integer priceMax) {
    return smartphoneRepository.findAllByPrices(priceMin,priceMax);
    }
    //фильтр по числу камер
    public List<Smartphone> getAllByCamera(Integer s_camera_quantity) {
        return smartphoneRepository.findAllByCamera(s_camera_quantity);
    }
    //фильтр по кол-ву памяти
    public List<Smartphone> getAllByMemory(Integer s_memory) {
        return smartphoneRepository.findAllByMemory(s_memory);
    }

    //поиск по имени
    public List<Smartphone> getAllByNames(String s_name) {
        return smartphoneRepository.findAllByNames(s_name);
    }

    //вывод по id
    public List<Smartphone> getById(Integer s_id) {
        return smartphoneRepository.findById(s_id);
    }

}