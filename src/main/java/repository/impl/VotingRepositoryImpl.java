package repository.impl;

import config.AppConenction;
import entity.Voting;
import repository.interfaces.VotingRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VotingRepositoryImpl implements VotingRepository {
    @Override
    public void save(Voting voting) throws SQLException {
        String query = """
                insert into voting (type, description, timing, date, candidate_id, citizen_id)
                values (?,?,?,?,?,?)
                """;
        try(PreparedStatement ps = AppConenction.getConnection().prepareStatement(query)){
            ps.setString(1,voting.getType());
            ps.setString(2, voting.getDescription());
            ps.setString(3, voting.getTiming());
            ps.setDate(4,voting.getDate());
            ps.setInt(5,voting.getCandidateId());
            ps.setInt(6,voting.getCitizenId());
            ps.executeUpdate();
        }
    }

    @Override
    public Voting load(Voting voting) throws SQLException {
        String query = """
                select * from voting where id = ?
                """;
        try(PreparedStatement ps = AppConenction.getConnection().prepareStatement(query)){
            ps.setInt(1,voting.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                voting.setId(rs.getInt("id"));
                voting.setType(rs.getString("type"));
                voting.setDescription(rs.getString("description"));
                voting.setTiming(rs.getString("timing"));
                voting.setDate(rs.getDate("date"));
                voting.setCandidateId(rs.getInt("candidate_id"));
                voting.setCitizenId(rs.getInt("citizen_id"));
                return voting;
            }
            return null;
        }
    }
    public List<Voting> loadAll() throws SQLException {
        String query = """
                select * from voting
                """;
        try(PreparedStatement ps = AppConenction.getConnection().prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<Voting> votingList = new ArrayList<>();
            while (rs.next()) {
                Voting voting = new Voting();
                voting.setId(rs.getInt("id"));
                voting.setType(rs.getString("type"));
                voting.setDescription(rs.getString("description"));
                voting.setTiming(rs.getString("timing"));
                voting.setDate(rs.getDate("date"));
                voting.setCandidateId(rs.getInt("candidate_id"));
                voting.setCitizenId(rs.getInt("citizen_id"));
                votingList.add(voting);
            }
            return votingList;
        }
    }
    @Override
    public void update(Voting voting, int id) throws SQLException {
        String query = """
                update voting set candidate_id = ? and citizen_id = ? where id = ?
                """;
        try(PreparedStatement ps = AppConenction.getConnection().prepareStatement(query)){
            ps.setInt(1,id);
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = """
                delete from voting where id = ?
                """;
        try(PreparedStatement ps = AppConenction.getConnection().prepareStatement(query)){
            ps.setInt(1,id);
            ps.executeUpdate();
        }
    }
}
