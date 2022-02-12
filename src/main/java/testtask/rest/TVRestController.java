package testtask.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import testtask.db.model.TV;
import testtask.service.TvService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/tv")
@Api(description = "Контроллер для работы с реестром телевизоров")
public class TVRestController {

    @Autowired
    private TvService TVService;

    @GetMapping("/{tv_id}")
    @ApiOperation("Вывод телевизора с указанным id")
    public List<TV> getByIds(@PathVariable("tv_id") Integer tv_id) {
        return TVService.getById(tv_id);
    }

    @GetMapping("/filter/price/{priceMin}/{priceMax}")
    @ApiOperation("Вывод телевизора с указанным диапазоном стоимости")
    public List<TV> getAllFilterPrice(@PathVariable("priceMin") Integer priceMin, @PathVariable("priceMax") Integer priceMax) {
        return TVService.getAllByPrices(priceMin,priceMax);
    }

    @GetMapping("/filter/technology/{tv_technology}")
    @ApiOperation("Фильтрация телевизоров по технологиям")
    public List<TV> getAllFilterPrice(@PathVariable("tv_technology") String tv_technology) {
        return TVService.getAllByTechnology(tv_technology);
    }

    @GetMapping("/filter/name/{tv_name}")
    @ApiOperation("Поиск по наименованию телевизора")
    public List<TV> getAllSortNames(@PathVariable("tv_name") String tv_name) {
        return TVService.getAllByNames(tv_name);
    }

    @RequestMapping(value = "/delete/{tv_id}", method = RequestMethod.DELETE)
    @ApiOperation("Удаление")
    public void delete(@PathVariable("tv_id") Integer tv_id) {
        TVService.delete(tv_id);
    }

    @PostMapping("/new")
    @ApiOperation("Создание")
    public void createTV(@RequestParam Integer tv_id,
                         @RequestParam String tv_name,
                         @RequestParam String tv_serial_Number,
                         @RequestParam String tv_color,
                         @RequestParam String tv_size,
                         @RequestParam Integer tv_price,
                         @RequestParam String tv_category,
                         @RequestParam String tv_technology,
                         @RequestParam String tv_availability){
        TVService.saveTV(tv_id, tv_name, tv_serial_Number, tv_color, tv_size, tv_price, tv_category, tv_technology, tv_availability);
    }

}