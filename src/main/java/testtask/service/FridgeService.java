package testtask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testtask.db.model.Fridge;
import testtask.db.model.TV;
import testtask.db.repository.FridgeRepository;
import testtask.db.repository.TVRepository;

import java.util.List;

@Service
@Transactional
public class FridgeService {
    @Autowired
    private FridgeRepository fridgeRepository;

    public void saveFr(Integer f_id, String f_name, String f_serial_number, String f_color, String f_size, Integer f_price, Integer f_door_quantity, Integer f_camera_quantity, String f_availability) {
        fridgeRepository.create(f_id,  f_name,  f_serial_number,  f_color,  f_size,  f_price,  f_door_quantity,  f_camera_quantity,  f_availability);
    }
    //удаление
    public void delete(Integer tv_id) {
        try {
            fridgeRepository.deleteById(tv_id);
        } catch (EmptyResultDataAccessException e) { }
    }
    //фильтр по цене
    public List<Fridge> getAllByPrices(Integer priceMin, Integer priceMax) {
    return fridgeRepository.findAllByPrices(priceMin,priceMax);
    }
    //фильтр по числу камер
    public List<Fridge> getAllByCamera(Integer f_camera_quantity) {
        return fridgeRepository.findAllByCamera(f_camera_quantity);
    }
    //фильтр по кол-ву дверей
    public List<Fridge> getAllByDoor(Integer f_door_quantity) {
        return fridgeRepository.findAllByDoor(f_door_quantity);
    }

    //поиск по имени
    public List<Fridge> getAllByNames(String f_name) {
        return fridgeRepository.findAllByNames(f_name);
    }

    //вывод по id
    public List<Fridge> getById(Integer f_id) {
        return fridgeRepository.findById(f_id);
    }

}