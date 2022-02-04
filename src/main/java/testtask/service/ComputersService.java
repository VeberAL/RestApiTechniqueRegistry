package testtask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testtask.db.model.Computers;
import testtask.db.repository.ComputersRepository;

import java.util.List;

@Service
@Transactional
public class ComputersService {
    @Autowired
    private ComputersRepository computerRepository;


    public void saveComp(Integer c_id, String c_name, String c_serial_number, String c_color, String c_size, Integer c_price, String c_memory, String c_processor, String c_availability) {
        computerRepository.create(c_id, c_name, c_serial_number, c_color, c_size, c_price, c_memory, c_processor, c_availability);
    }
    //удаление
    public void delete(Integer c_id) {
        try {
            computerRepository.deleteById(c_id);
        } catch (EmptyResultDataAccessException e) { }
    }
    //фильтр по цене
    public List<Computers> getAllByPrices(Integer priceMin, Integer priceMax) {
    return computerRepository.findAllByPrices(priceMin,priceMax);
    }
    //фильтр по памяти
    public List<Computers> getAllByMem(String c_memory) {
        return computerRepository.findAllByMemory(c_memory);
    }

    //поиск по имени
    public List<Computers> getAllByNames(String c_name) {
        return computerRepository.findAllByNames(c_name);
    }
    //поиск по процессору
    public List<Computers> getAllByProc(String c_processor) {
        return computerRepository.findAllByNames(c_processor);
    }

    //вывод по id
    public List<Computers> getById(Integer c_id) {
        return computerRepository.findById(c_id);
    }

}