package com.epam.rd.autocode;


import com.epam.rd.autocode.domain.Employee;
import com.epam.rd.autocode.domain.FullName;
import com.epam.rd.autocode.domain.Position;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SetMapperFactory {

    List<Em> list = new ArrayList<Em>();
    Employee man_result;

    public Employee SetEmployee(Em person){
        if (person.getManager() == null) {
            man_result = new Employee(
                    person.getId(),
                    new FullName(person.getFirstName(), person.getFirstName(), person.getLastName()),
                    Position.valueOf(person.getPosition()),
                    person.getHired(),
                    person.getSalary(),
                    null
            );
            return man_result;
        }
        else
        for (Em findMan: list){
            if (findMan.getId() == person.getManager());
            man_result = new Employee(
                    person.getId(),
                    new FullName(person.getFirstName(), person.getFirstName(), person.getLastName()),
                    Position.valueOf(person.getPosition()),
                    person.getHired(),
                    person.getSalary(),
                    SetEmployee(findMan)
            );
            break;
        }
        return man_result;
    }


    public SetMapper<Set<Employee>> employeesSetMapper() {


        return new SetMapper<Set<Employee>>() {
            @Override
            public Set<Employee> mapSet(ResultSet resultSet) throws SQLException {

                Format formatter = new SimpleDateFormat("yyyy-MM-dd");

                do{
                    Em e;
                    e = new Em(
                        BigInteger.valueOf(resultSet.getInt("id")),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("middleName"),
                        resultSet.getString("position"),
                        LocalDate.parse(formatter.format(resultSet.getDate("hiredate"))),
                        BigDecimal.valueOf(resultSet.getInt("salary")),
                        BigInteger.valueOf(resultSet.getInt("manager"))
                    );
                list.add(e);
                } while (resultSet.next());

                Set<Employee> reSet = new LinkedHashSet<Employee>();

                for (Em person: list){
                    man_result = null;
                    reSet.add(SetEmployee(person));
                }
                return reSet;
            }
        };
    }
}
