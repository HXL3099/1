package com.poroscareer.bigdataclass.connector.adapters.impl;

import com.poroscareer.bigdataclass.connector.adapters.DataAdapter;
import com.poroscareer.bigdataclass.connector.models.Message;
import jdk.nashorn.internal.parser.TokenStream;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostgresAdapter implements DataAdapter {
    
    private Connection connection;
    private String tableName;
    public PostgresAdapter(String Password,String usl,String root,String tableNamen)throws SQLException{
        this.connect(Password,usl,root);
        this.tableName = tableNamen;
    }
    public void disconnect() throws SQLException{
        connection.close();
        connection.setAutoCommit(false);
    }

    private void connect(String password, String usl, String root) throws SQLException{
        connection = DriverManager.getConnection(usl,"root","password");
    }

    public void addOne(String user, String content, Date date) throws SQLException {
                String query="INSERT INTO"+tableName+"(User,Content,Date) VALUES(?,?,?)";
                PreparedStatement pt = connection.prepareStatement(query);
                pt.setString(1,user);
                pt.setString(2,content);
                pt.setDate(3,java.sql.Date.valueOf(date.toString()));
                pt.execute();
    }

    public List<Message> findAll() throws SQLException {
                ArrayList<Message> messagesList = new ArrayList<Message>();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Message");
                while (resultSet.next()){
                    long id=resultSet.getLong();
        }
        return messagesList;
    }

    public List<Message> findAllByUser(String user) throws SQLException {
        ArrayList<Message> messagesList = new ArrayList<Message>();
        String sql= "SELECT * FROM Message WHERE =?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,user);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            long id = resultSet.getLong("id");
            String aUesr= resultSet.getString("user");
            String aCantent = resultSet.getString("content");
            Date date =resultSet.getDate("date");
            Message message = new Message(aUesr,aCantent,id,date);
            messagesList.add(message);
        }
        resultSet.close();
        preparedStatement.close();
        return messagesList;
    }

    public void deleteAllByUser(String user) throws SQLException {

        ArrayList<Message> messagesList = new ArrayList<Message>();

    }

    @Override
    public void connect(String url,String username,String password)throws  SQLException{

    }
}
