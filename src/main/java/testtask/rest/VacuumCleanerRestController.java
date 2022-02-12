package testtask.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import testtask.db.model.VacuumCleaner;
import testtask.service.VacuumCleanerService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/vc")
@Api(description = "Контроллер для работы с реестром пылесосов")
public class VacuumCleanerRestController {

    @Autowired
    private VacuumCleanerService vacuumCleanerService;

    @GetMapping("/{v_id}")
    @ApiOperation("Поиск пылесоса по id")
    public List<VacuumCleaner> getByIds(@PathVariable("v_id") Integer v_id) {
        return vacuumCleanerService.getById(v_id);
    }

    @GetMapping("/filter/price/{priceMin}/{priceMax}")
    @ApiOperation("Поиск по диапазону значений цены пылесоса")
    public List<VacuumCleaner> getAllFilterPrice(@PathVariable("priceMin") Integer priceMin, @PathVariable("priceMax") Integer priceMax) {
        return vacuumCleanerService.getAllByPrices(priceMin,priceMax);
    }

    @GetMapping("/filter/dust/{v_dust_size_min}/{v_dust_size_max}")
    @ApiOperation("Поиск по диапазону значений размера пылесборника пылесоса")
    public List<VacuumCleaner> getAllFilterDust(@PathVariable("v_dust_size_min") Integer v_dust_size_min, @PathVariable("v_dust_size_max") Integer v_dust_size_max) {
        return vacuumCleanerService.getAllByDust(v_dust_size_min, v_dust_size_max);
    }

    @GetMapping("/filter/name/{v_name}")
    @ApiOperation("Поиск по наименованию пылесоса")
    public List<VacuumCleaner> getAllSortNames(@PathVariable("v_name") String v_name) {
        return vacuumCleanerService.getAllByNames(v_name);
    }

    @RequestMapping(value = "/delete/{v_id}", method = RequestMethod.DELETE)
    @ApiOperation("Удаление")
    public void delete(@PathVariable("v_id") Integer v_id) {
        vacuumCleanerService.delete(v_id);
    }

    @PostMapping("/new")
    @ApiOperation("Создание")
    public void createTV(@RequestParam Integer v_id,
                         @RequestParam String v_name,
                         @RequestParam String v_serial_Number,
                         @RequestParam String v_color,
                         @RequestParam String v_size,
                         @RequestParam Integer v_price,
                         @RequestParam Integer v_dust_size,
                         @RequestParam Integer v_mode_quantity,
                         @RequestParam String v_availability){
        vacuumCleanerService.saveVC(v_id, v_name, v_serial_Number, v_color, v_size, v_price, v_dust_size, v_mode_quantity, v_availability);
    }

}