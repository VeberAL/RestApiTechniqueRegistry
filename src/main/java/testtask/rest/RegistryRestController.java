package testtask.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import testtask.db.model.*;
import testtask.service.RegistryService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/all")
@Api(description = "Контроллер для работы с общим списком товаров")
public class RegistryRestController {

    @Autowired
    private RegistryService registryService;

    @GetMapping("")
    @ApiOperation("Вывод всех товаров")
    public List<Object> getAll() {
        return registryService.getAll();
    }

    @GetMapping("/available")
    @ApiOperation("Вывод всех товаров в наличии")
    public List<Object> getAllAvail() {
        return registryService.getAllAvailble();
    }

    @GetMapping("/sort/tv/price")
    @ApiOperation("Сортировка телевизоров по цене (по убыванию)")
    public List<TV> sortedPriceTV() { return registryService.sortedByPriceTV(); }

    @GetMapping("/sort/tv/name")
    @ApiOperation("Сортировка телевизоров по алфавиту")
    public List<TV> sortedNameTV() { return registryService.sortedByNameTV(); }

    @GetMapping("/sort/vc/price")
    @ApiOperation("Сортировка пылесосов по цене (по убыванию)")
    public List<VacuumCleaner> sortedPriceVC() { return registryService.sortedByPriceVC(); }

    @GetMapping("/sort/vc/name")
    @ApiOperation("Сортировка пылесосов по по алфавиту")
    public List<VacuumCleaner> sortedNameVC() { return registryService.sortedByNameVC(); }

    @GetMapping("/sort/fridge/price")
    @ApiOperation("Сортировка холодильников по цене (по убыванию)")
    public List<Fridge> sortedPriceFr() { return registryService.sortedByPriceFr(); }

    @GetMapping("/sort/fridge/name")
    @ApiOperation("Сортировка холодильников по по алфавиту")
    public List<Fridge> sortedNameFr() { return registryService.sortedByNameFr(); }

    @GetMapping("/sort/smartphone/price")
    @ApiOperation("Сортировка смартфонов по цене (по убыванию)")
    public List<Smartphone> sortedPriceSm() { return registryService.sortedByPriceSm(); }

    @GetMapping("/sort/smartphone/name")
    @ApiOperation("Сортировка смартфонов по по алфавиту")
    public List<Smartphone> sortedNameSm() { return registryService.sortedByNameSm(); }

    @GetMapping("/sort/computers/price")
    @ApiOperation("Сортировка компьютеров по цене (по убыванию)")
    public List<Computers> sortedPriceCm() { return registryService.sortedByPriceCm(); }
    //сортировка компьютеров по имени
    @GetMapping("/sort/computers/name")
    @ApiOperation("Сортировка компьютеров по по алфавиту")
    public List<Computers> sortedNameCm() { return registryService.sortedByNameCm(); }
}