package com.poroscareer.bigdataclass.connector;
import  com.poroscareer.bigdataclass.connector.adapters.DataAdapter;
import  com.poroscareer.bigdataclass.connector.adapters.impl.PostgresAdapter;
import  com.poroscareer.bigdataclass.connector.models.Message;

import  java.sql.Date;
import  java.sql.SQLException;
import  java.util.List;

public class ConnectorMain {

    public static void mian(String[] args) throws SQLException{
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "admin";
        String password = "password";
        String tableName = "CHAT_MESSAGES";


    }
}
