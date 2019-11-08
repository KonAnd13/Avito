package ru.itpark.service;

import ru.itpark.model.House;
import ru.itpark.util.JdbcTemplate;

import java.util.*;
import java.util.stream.Collectors;

public class HouseService {

    private List<House> getData() {
        return JdbcTemplate.executeQuery(
                "jdbc:sqlite:db.sqlite",
                "SELECT id, price, rooms, district, metro FROM houses;",
                resultSet ->
                        new House(
                                resultSet.getInt("id"),
                                resultSet.getInt("price"),
                                resultSet.getInt("rooms"),
                                resultSet.getString("district"),
                                resultSet.getString("metro")
                        )
        );
    }

    public List<House> searchByPrice(int min, int max, Comparator<House> comparator) {
        List<House> result;
        result = getData().stream().filter(o -> o.getPrice() >= min && o.getPrice() <= max).collect(Collectors.toList());
        result.sort(comparator);

        return result;
    }

    public List<House> searchByMetro(Comparator<House> comparator, String... metros) {
        List<House> result = new ArrayList<>();
        for (House house : getData()) {
            for (String metro : metros) {
                if (metro.equals(house.getMetro())) {
                    result.add(house);
                    break;
                }
            }
        }
        result.sort(comparator);
        return result;
    }

    public List<House> sortBy(Comparator<House> comparator) {
        List<House> result = getData();
        result.sort(comparator);
        return result;
    }
}
