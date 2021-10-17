/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal.sql;

import hr.algebra.dal.Repository;
import hr.algebra.model.Person;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

/**
 *
 * @author lukak
 */
public class PersonRepo implements Repository<Person> {
    
    private static final String ID_PERSON = "IDPerson";
    private static final String NAME = "Name";
    private static final String SURNAME = "Surname";
    
    private static final String CREATE_PERSON = "{ CALL createPerson (?,?,?) }";
    private static final String UPDATE_PERSON = "{ CALL updatePerson (?,?,?) }";
    private static final String DELETE_PERSON = "{ CALL deletePerson (?) }";
    private static final String SELECT_PERSON = "{ CALL selectPerson (?) }";
    private static final String SELECT_PERSONS = "{ CALL selectPersons }";

    @Override
    public int create(Person obj) throws Exception {
         DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_PERSON)) {
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getSurname());
            
            stmt.registerOutParameter(3, Types.INTEGER);
            stmt.executeUpdate();
            return stmt.getInt(3);
        }
    }

    @Override
    public void create(List<Person> persons) throws Exception {
         DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_PERSON)) {
            
            for (Person obj : persons) {
                stmt.setString(1, obj.getName());
                stmt.setString(2, obj.getSurname());

                stmt.registerOutParameter(3, Types.INTEGER);
                stmt.executeUpdate();
            } 
        }
    }

    @Override
    public void update(int id, Person data) throws Exception {
         DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_PERSON)) {
            
            stmt.setString(1, data.getName());
            stmt.setString(2, data.getSurname());
            
            stmt.setInt(3, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_PERSON)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Person> select(int id) throws Exception {
         DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_PERSON)) {

            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) {
                    return Optional.of(new Person(
                            rs.getInt(ID_PERSON),
                            rs.getString(NAME),
                            rs.getString(SURNAME)));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Person> select() throws Exception {
        List<Person> persons = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_PERSONS);
                ResultSet rs = stmt.executeQuery()) {
            while(rs.next()) {
                persons.add(new Person(
                        rs.getInt(ID_PERSON), 
                        rs.getString(NAME),
                        rs.getString(SURNAME)));
            }
        }
        return persons;
    }
    
}
