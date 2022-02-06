package testtask.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testtask.db.repository.TVRepository;
import testtask.db.model.TV;

import java.util.List;
@Service
@Transactional
public class TvService {
    @Autowired
    private TVRepository tvRepository;

    public void saveTV(Integer tv_id, String tv_name, String tv_serial_Number, String tv_color, String tv_size, Integer tv_price, String tv_category, String tv_technology, String tv_availability) {
        tvRepository.create(tv_id, tv_name, tv_serial_Number, tv_color, tv_size, tv_price, tv_category, tv_technology, tv_availability);
    }
    //удаление
    public void delete(Integer tv_id) {
        try {
            tvRepository.deleteById(tv_id);
        } catch (EmptyResultDataAccessException e) { }
    }
    //фильтр по цене
    public List<TV> getAllByPrices(Integer priceMin, Integer priceMax) {
    return tvRepository.findAllByPrices(priceMin,priceMax);
    }
    //фильтр по технологии
    public List<TV> getAllByTechnology(String tv_technology) {
        return tvRepository.findAllByTechnology(tv_technology);
    }

    //поиск по имени
    public List<TV> getAllByNames(String tv_name) {
        return tvRepository.findAllByNames(tv_name);
    }

    //вывод по id
    public List<TV> getById(Integer tv_id) {
        return tvRepository.findById(tv_id);
    }

}