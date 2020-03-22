package com.poroscareer.bigdataclass.connector.adapters.impl;

import com.poroscareer.bigdataclass.connector.adapters.DataAdapter;
import com.poroscareer.bigdataclass.connector.models.Message;
import javafx.scene.chart.XYChart;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class PostgresAdapterTest {
    private DataAdapter dataAdapter;

    @Before
    public void setUp() throws Exception {

            String url = "jdbc:postgresql://localhost:5432/postgres";
            String username = "admin";
            String password = "password";
            String tableName = "CHAT_MESSAGES";

            this.dataAdapter = new PostgresAdapter(tableName);


    }
    private boolean chekDateExistence(String user) throws SQLException{

       List<Message> messages = dataAdapter.findAllByUser(user);

       return  messages.size() != 0;
    }

    @Test
    public void testAddOneHappyPath(){
        String user ="HXL";
        String content ="test messge";
        Data data = new java.sql.Date(now.getTime());
        //prepare date
        //Mock
        //Call method
        dataAdapter.addOne(user,content,data);
        //Verify
        //Ex True
        Assert.assertTrue(chekDateExistence(user));
    }
    @Test
    public  void  testAddOneContentNull(){
        public void testAddOneHappyPath() {
            String user = "HXL";
            String content = null;
            java.util.Date now = new java.util.Date();
            Date data = new java.sql.Date(now.getTime());
            //prepare date
            //Mock
            //Call method/Verify
            dataAdapter.addOne(user, content, data);
        } catch(SQLException e){
        }
        Assert.assertEquals();
            //Verify

    }
    @Test
    public  void  testAddOneDateInvalid(){
        //prepare date

        //Mock
        //Call method/Verify
    };


    @After
    public void tearDown() throws Exception {
    }
}