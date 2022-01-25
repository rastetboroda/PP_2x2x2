package web.service;

import org.springframework.stereotype.Component;

import web.model.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImpl implements CarService {
    private List<Car> cars = new ArrayList<>();

    public CarServiceImpl() {
        cars.add(new Car("Chevrolet Lacetti", "Blue", 94));
        cars.add(new Car("BMW 318i", "Black", 150));
        cars.add(new Car("Ford F150", "Grey", 470));
        cars.add(new Car("Mercedes GLK 220", "White", 180));
        cars.add(new Car("Mitsubishi", "Lancer", 105));
    }

    @Override
    public List<Car> getCars(Integer count) {
        if (count == null || count >= 5) {
            return cars;
        }
        return  cars.stream()
                .limit(count)
                .collect(Collectors.toList());
    }
}
