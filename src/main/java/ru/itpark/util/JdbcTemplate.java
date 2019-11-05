package ru.itpark.util;

import ru.itpark.exception.DataAccesException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate {
    public static <T> List<T> executeQuery(String url, String sql, RowMapper<T> mapper) {
        try (
                Connection connection = DriverManager.getConnection(url);
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
        ) {
            List<T> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(mapper.map(resultSet));
            }
            return result;
        } catch (SQLException e) {
            throw new DataAccesException();
        }
    }
}
