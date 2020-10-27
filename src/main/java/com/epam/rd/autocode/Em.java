package com.epam.rd.autocode;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

public class Em {
    private BigInteger id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String Position;
    private LocalDate hired;
    private BigDecimal salary;
    private BigInteger manager;

    public Em(BigInteger id, String firstName, String lastName, String middleName, String position, LocalDate hired, BigDecimal salary, BigInteger manager) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        Position = position;
        this.hired = hired;
        this.salary = salary;
        this.manager = manager;
    }

    public BigInteger getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getPosition() {
        return Position;
    }

    public LocalDate getHired() {
        return hired;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public BigInteger getManager() {
        return manager;
    }
}
