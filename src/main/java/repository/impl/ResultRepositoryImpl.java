package repository.impl;

import config.AppConenction;
import entity.Result;
import repository.interfaces.ResultRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultRepositoryImpl implements ResultRepository {
    @Override
    public void save(Result result) throws SQLException {
        String query = """
                insert into result (candidate_id, type, description, date) 
                values (?,?,?,?)
                """;
        try(PreparedStatement ps = AppConenction.getConnection().prepareStatement(query)){
            ps.setInt(1,result.getCandidateId());
            ps.setString(2,result.getType());
            ps.setString(3,result.getDescription());
            ps.setDate(4,result.getDate());
            ps.executeUpdate();
        }
    }

    @Override
    public Result load(Result result) throws SQLException {
        String query = """
                select * from result where id = ?
                """;
        try(PreparedStatement ps = AppConenction.getConnection().prepareStatement(query)){
            ps.setInt(1,result.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                result.setId(rs.getInt("id"));
                result.setDate(rs.getDate("date"));
                result.setType(rs.getString("type"));
                result.setDescription(rs.getString("description"));
                result.setCandidateId(rs.getInt("candidate_id"));
                return result;
            }
            return null;
        }
    }

    @Override
    public void update(Result result, int id) throws SQLException {
        String query = """
                update result set description = ? where id = ?
                """;
        try(PreparedStatement ps = AppConenction.getConnection().prepareStatement(query)){
            ps.setString(1,result.getDescription());
            ps.setInt(2,id);
            ps.executeUpdate();
        }

    }

    @Override
    public void delete(int id) throws SQLException {
        String query = """
                delete from result where id = ?
                """;
        try(PreparedStatement ps = AppConenction.getConnection().prepareStatement(query)){
            ps.setInt(1,id);
            ps.executeUpdate();
        }
    }
}
