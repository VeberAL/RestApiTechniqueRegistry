package testtask.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import testtask.db.model.Fridge;
import testtask.service.FridgeService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/fridge")
@Api(description = "Контроллер для работы с реестром холодильников")
public class FridgeRestController {

    @Autowired
    private FridgeService fridgeService;

    @GetMapping("/{f_id}")
    @ApiOperation("Вывод холодильника по указанному id")
    public List<Fridge> getByIds(@PathVariable("f_id") Integer f_id) {
        return fridgeService.getById(f_id);
    }

    @GetMapping("/filter/price/{priceMin}/{priceMax}")
    @ApiOperation("Фильтрация холодильников по диапазону цен")
    public List<Fridge> getAllFilterPrice(@PathVariable("priceMin") Integer priceMin, @PathVariable("priceMax") Integer priceMax) {
        return fridgeService.getAllByPrices(priceMin,priceMax);
    }

    @GetMapping("/filter/door/{f_door_quantity}")
    @ApiOperation("Вывод холодильника по указанному количеству дверей")
    public List<Fridge> getAllFilterDoor(@PathVariable("f_door_quantity") Integer f_door_quantity) {
        return fridgeService.getAllByDoor(f_door_quantity);
    }

    @GetMapping("/filter/camera/{f_camera_quantity}")
    @ApiOperation("Вывод холодильника по указанному числу морозильных камер")
    public List<Fridge> getAllFilterMem(@PathVariable("f_camera_quantity") Integer f_camera_quantity) {
        return fridgeService.getAllByCamera(f_camera_quantity);
    }

    @GetMapping("/filter/name/{f_name}")
    @ApiOperation("Вывод холодильника по указанному наименованию")
    public List<Fridge> getAllSortNames(@PathVariable("f_name") String f_name) {
        return fridgeService.getAllByNames(f_name);
    }

    @ApiOperation("Удаление из таблицы")
    @RequestMapping(value = "/delete/{f_id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("f_id") Integer f_id) {
        fridgeService.delete(f_id);
    }

    @PostMapping("/new")
    @ApiOperation("Создание нового")
    public void create(@RequestParam Integer f_id,
                         @RequestParam String f_name,
                         @RequestParam String f_serial_number,
                         @RequestParam String f_color,
                         @RequestParam String f_size,
                         @RequestParam Integer f_price,
                         @RequestParam Integer f_door_quantity,
                         @RequestParam Integer f_camera_quantity,
                         @RequestParam String f_availability){
        fridgeService.saveFr(f_id, f_name, f_serial_number, f_color, f_size, f_price, f_door_quantity, f_camera_quantity, f_availability);
    }
}