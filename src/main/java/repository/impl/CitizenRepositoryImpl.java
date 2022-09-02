package repository.impl;

import config.AppConenction;
import entity.Citizen;
import repository.interfaces.CitizenRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CitizenRepositoryImpl implements CitizenRepository {
    @Override
    public void save(Citizen citizen) throws SQLException {
        String query = """
                insert into citizen (role_id, email, name, address, dob, phone, username, password, voter_id)
                values (?,?,?,?,?,?,?,?,?)
                """;
        try(PreparedStatement ps = AppConenction.getConnection().prepareStatement(query)){
            ps.setInt(1,citizen.getRoleId());
            ps.setString(2,citizen.getEmail());
            ps.setString(3, citizen.getName());
            ps.setString(4,citizen.getAddress());
            ps.setDate(5,citizen.getDob());
            ps.setString(6, citizen.getPhone());
            ps.setString(7, citizen.getUsername());
            ps.setString(8, citizen.getPassword());
            ps.setInt(9,citizen.getVoterId());
            ps.executeUpdate();
        }
    }

    @Override
    public Citizen load(Citizen citizen) throws SQLException {
        String query = """
                select * from citizen where username = ? and password = ?
                """;
        try(PreparedStatement ps = AppConenction.getConnection().prepareStatement(query)){
            ps.setString(1, citizen.getUsername());
            ps.setString(2, citizen.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                citizen.setId(rs.getInt("id"));
                citizen.setRoleId(rs.getInt("role_id"));
                citizen.setEmail(rs.getString("email"));
                citizen.setName(rs.getString("name"));
                citizen.setAddress(rs.getString("address"));
                citizen.setDob(rs.getDate("dob"));
                citizen.setUsername(rs.getString("username"));
                citizen.setPassword(rs.getString("password"));
                citizen.setPhone(rs.getString("phone"));
                citizen.setVoterId(rs.getInt("voter_id"));
                return citizen;
            }
            return null;
        }
    }

    @Override
    public void update(Citizen citizen, int id) throws SQLException {
        String query = """
                update citizen set username = ? and password = ? where id = ?
                """;
        try(PreparedStatement ps = AppConenction.getConnection().prepareStatement(query)){
            ps.setString(1, citizen.getUsername());
            ps.setString(2,citizen.getPassword());
            ps.setInt(3,id);
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = """
                delete from citizen where id = ?
                """;
        try(PreparedStatement ps = AppConenction.getConnection().prepareStatement(query)){
            ps.setInt(1,id);
            ps.executeUpdate();
        }
    }
}
