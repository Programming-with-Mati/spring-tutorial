package com.programmingwith.mati;

import java.sql.*;

public class JdbcBankAccountRepository implements BankAccountRepository {
  @Override
  public BankAccount findById(int id) {
    try (Connection con = createConnection()) {
      var statement = con.createStatement();
      var resultSet = statement.executeQuery("SELECT id, balance FROM bank_account WHERE id = %d".formatted(id));
      if (!resultSet.next()) throw new RuntimeException("Entity not found");

      return new BankAccount(resultSet.getInt("id"),
              resultSet.getBigDecimal("balance"));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public BankAccount save(BankAccount bankAccount) {
    try (Connection con = createConnection()) {
      var statement = con.createStatement();
      statement.execute("INSERT INTO bank_account(balance) VALUES (%s);".formatted(bankAccount.balance()));

      return new BankAccount(statement.getGeneratedKeys().getInt("id"), bankAccount.balance());
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private static Connection createConnection() throws SQLException {
    return DriverManager
            .getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
  }

  @Override
  public BankAccount update(BankAccount bankAccount) {
    try (Connection con = createConnection()) {
      var statement = con.createStatement();
      statement.executeUpdate("UPDATE bank_account SET balance = %s WHERE id = %d;".formatted(bankAccount.balance(), bankAccount.id()));

      return bankAccount;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
