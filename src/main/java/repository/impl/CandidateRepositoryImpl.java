package repository.impl;

import config.AppConenction;
import entity.Candidate;
import repository.interfaces.CandidateRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CandidateRepositoryImpl implements CandidateRepository {

    @Override
    public void save(Candidate candidate) throws SQLException {
        String query = "insert into candidate ( role_id, email, address, name, dob, phone, username, password, voter_id) values(?,?,?,?,?,?,?,?,?) ";
        try (PreparedStatement ps = AppConenction.getConnection().prepareStatement(query)) {
            ps.setInt(1, candidate.getRoleId());
            ps.setString(2, candidate.getEmail());
            ps.setString(3, candidate.getAddress());
            ps.setString(4, candidate.getName());
            ps.setDate(5, candidate.getDob());
            ps.setString(6, candidate.getPhone());
            ps.setString(7, candidate.getUsername());
            ps.setString(8, candidate.getPassword());
            ps.setInt(9, candidate.getVoterId());
            ps.executeUpdate();

        }
    }

    @Override
    public Candidate load(Candidate candidate) throws SQLException {
        String query = "select * from candidate where username = ? and password = ?";
        try (PreparedStatement ps = AppConenction.getConnection().prepareStatement(query)) {
            ps.setString(1, candidate.getUsername());
            ps.setString(2, candidate.getPassword());
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                return null;
            }
            candidate.setId(rs.getInt("id"));
            candidate.setRoleId(rs.getInt("role_id"));
            candidate.setEmail(rs.getString("email"));
            candidate.setAddress(rs.getString("address"));
            candidate.setName(rs.getString("name"));
            candidate.setDob(rs.getDate("dob"));
            candidate.setPhone(rs.getString("phone"));
            candidate.setUsername(rs.getString("username"));
            candidate.setPassword(rs.getString("password"));
            candidate.setVoterId(rs.getInt("voter_id"));
            return candidate;
        }

    }

    @Override
    public void update(Candidate candidate, int id) throws SQLException {
        String query = """
                update candidate set username = ? and  password = ? where id = ?
                """;
        try(PreparedStatement ps = AppConenction.getConnection().prepareStatement(query)){
            ps.setString(1,candidate.getUsername());
            ps.setString(2,candidate.getPassword());
            ps.setInt(3,id);
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = """
                delete from candidate where id = ?
                """;
        try(PreparedStatement ps = AppConenction.getConnection().prepareStatement(query)){
            ps.setInt(1,id);
            ps.executeUpdate();
        }

    }
}
