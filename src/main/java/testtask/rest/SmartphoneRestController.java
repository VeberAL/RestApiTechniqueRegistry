package testtask.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import testtask.db.model.Smartphone;
import testtask.service.SmartphoneService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/smartphone")
@Api(description = "Контроллер для работы с реестром смартфонов")
public class SmartphoneRestController {

    @Autowired
    private SmartphoneService smartphoneService;

    @GetMapping("/{s_id}")
    @ApiOperation("Вывод смартфона по указанному id")
    public List<Smartphone> getByIds(@PathVariable("s_id") Integer s_id) {
        return smartphoneService.getById(s_id);
    }

    @GetMapping("/filter/price/{priceMin}/{priceMax}")
    @ApiOperation("Фильрация смартфонов по ценовому диапазону")
    public List<Smartphone> getAllFilterPrice(@PathVariable("priceMin") Integer priceMin, @PathVariable("priceMax") Integer priceMax) {
        return smartphoneService.getAllByPrices(priceMin,priceMax);
    }

    @GetMapping("/filter/memory/{s_memory}")
    @ApiOperation("Фильрация смартфонов по объему памяти")
    public List<Smartphone> getAllFilterMem(@PathVariable("s_memory") Integer s_memory) {
        return smartphoneService.getAllByMemory(s_memory);
    }

    @GetMapping("/filter/camera/{s_camera_quantity}")
    @ApiOperation("Фильрация смартфонов по количеству камер")
    public List<Smartphone> getAllFilterCam(@PathVariable("s_camera_quantity") Integer s_camera_quantity) {
        return smartphoneService.getAllByCamera(s_camera_quantity);
    }

    @GetMapping("/filter/name/{s_name}")
    @ApiOperation("Поиск смартфонов по наименованию (нечувствительно к регистру)")
    public List<Smartphone> getAllSortNames(@PathVariable("s_name") String s_name) {
        return smartphoneService.getAllByNames(s_name);
    }

    @RequestMapping(value = "/delete/{s_id}", method = RequestMethod.DELETE)
    @ApiOperation("Удаление строки")
    public void delete(@PathVariable("s_id") Integer s_id) {
        smartphoneService.delete(s_id);
    }

    @ApiOperation("Создание строки")
    @PostMapping("/new")
    public void create(@RequestParam Integer s_id,
                         @RequestParam String s_name,
                         @RequestParam String s_serial_number,
                         @RequestParam String s_color,
                         @RequestParam String s_size,
                         @RequestParam Integer s_price,
                         @RequestParam Integer s_memory,
                         @RequestParam Integer s_camera_quantity,
                         @RequestParam String s_availability){
        smartphoneService.saveFr(s_id, s_name, s_serial_number, s_color, s_size, s_price, s_memory, s_camera_quantity, s_availability);
    }
}