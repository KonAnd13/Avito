package ru.itpark.service;

import ru.itpark.model.House;
import ru.itpark.util.JdbcTemplate;

import java.util.*;
import java.util.stream.Collectors;

public class HouseService {
    private Collection<House> houses;

    private void getData() {
        houses = JdbcTemplate.executeQuery(
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
        getData();
        List<House> result;
        result = houses.stream().filter(o -> o.getPrice() >= min && o.getPrice() <= max).collect(Collectors.toList());
        result.sort(comparator);

        return result;
    }

    public List<House> searchByMetro(Comparator<House> comparator, String... metros) {
        getData();
        List<House> result = new ArrayList<>();
        for (House house : houses) {
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
        getData();
        List<House> result = new ArrayList<>(houses);
        result.sort(comparator);
        return result;
    }
}
