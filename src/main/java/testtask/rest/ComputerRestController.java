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

    @PostMapping("/new/{c_id}_{c_name}_{c_serial_number}_{c_color}_{c_size}_{c_price}_{c_memory}_{c_processor}_{c_availability}")
    @ApiOperation("Добавление нового компьютера в таблицу")
    public void create(@PathVariable("c_id") Integer c_id,
                         @PathVariable("c_name") String c_name,
                         @PathVariable("c_serial_number") String c_serial_number,
                         @PathVariable("c_color") String c_color,
                         @PathVariable("c_size") String c_size,
                         @PathVariable("c_price") Integer c_price,
                         @PathVariable("c_memory") String c_memory,
                         @PathVariable("c_processor") String c_processor,
                         @PathVariable("c_availability") String c_availability){
        computerService.saveComp(c_id, c_name, c_serial_number, c_color, c_size, c_price, c_memory, c_processor, c_availability);
    }
}