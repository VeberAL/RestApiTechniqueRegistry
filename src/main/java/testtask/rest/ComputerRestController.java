package testtask.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import testtask.db.model.Computers;
import testtask.service.ComputersService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/computers")
@Api(description = "Контроллер для работы с реестром компьютеров")
public class ComputerRestController {

    @Autowired
    private ComputersService computerService;

    @GetMapping("/{c_id}")
    @ApiOperation("Вывод компьютера по указанному id")
    public List<Computers> getByIds(@PathVariable("c_id") Integer c_id) {
        return computerService.getById(c_id);
    }

    @GetMapping("/filter/price/{priceMin}/{priceMax}")
    @ApiOperation("Фильтрация компьютеров по цене с указанием диапазона")
    public List<Computers> getAllFilterPrice(@PathVariable("priceMin") Integer priceMin, @PathVariable("priceMax") Integer priceMax) {
        return computerService.getAllByPrices(priceMin,priceMax);
    }

    @GetMapping("/filter/processor/{c_processor}")
    @ApiOperation("Поиск компьютеров по наименованию процессора")
    public List<Computers> getAllFilterProc(@PathVariable("c_processor") String c_processor) {
        return computerService.getAllByMem(c_processor);
    }

    @GetMapping("/filter/memory/{c_memory}")
    @ApiOperation("Поиск компьютеров по объему памяти")
    public List<Computers> getAllFilterMem(@PathVariable("c_memory") String c_memory) {
        return computerService.getAllByMem(c_memory);
    }

    @GetMapping("/filter/name/{c_name}")
    @ApiOperation("Поиск компьютеров по наименованию")
    public List<Computers> getAllSortNames(@PathVariable("c_name") String c_name) {
        return computerService.getAllByNames(c_name);
    }

    @RequestMapping(value = "/delete/{c_id}", method = RequestMethod.DELETE)
    @ApiOperation("Удаление компьютера с указанным id")
    public void delete(@PathVariable("c_id") Integer c_id) {
        computerService.delete(c_id);
    }

    @PostMapping("/new")
    @ApiOperation("Добавление нового компьютера в таблицу")
    public void create(@RequestParam Integer c_id,
                         @RequestParam String c_name,
                         @RequestParam String c_serial_number,
                         @RequestParam String c_color,
                         @RequestParam String c_size,
                         @RequestParam Integer c_price,
                         @RequestParam String c_memory,
                         @RequestParam String c_processor,
                         @RequestParam String c_availability){
        computerService.saveComp(c_id, c_name, c_serial_number, c_color, c_size, c_price, c_memory, c_processor, c_availability);
    }
}