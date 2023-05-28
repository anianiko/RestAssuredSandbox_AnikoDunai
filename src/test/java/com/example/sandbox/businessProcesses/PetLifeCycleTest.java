package com.example.sandbox.businessProcesses;

import com.example.sandbox.Common;
import org.testng.annotations.Test;

import static com.example.sandbox.util.constans.Tags.SMOKE;

public class PetLifeCycleTest extends Common {
    @Test(enabled = true,groups = {SMOKE},description ="STORE[GET] Find purchase order by ID")
    public void T004() {
        //TODO STORE[GET] Find purchase order by - 200 successful operation



        //TODO STORE[GET] Find purchase order by - 400 Invalid ID supplied



        //TODO STORE[GET] Find purchase order by - 404 Order not found


    }


    @Test(enabled = true,groups = {SMOKE},description ="STORE[GET] Return pet inventories by status")
    public void T007() {
        //TODO STORE[GET] Return pet inventories by status - 200 successful operation



    }


    @Test(enabled = true,groups = {SMOKE},description ="STORE[DELETE] Delete purchase order by ID")
    public void T008() {
        //TODO STORE[DELETE] Delete purchase order by ID - 400 Invalid ID supplied


        //TODO STORE[DELETE] Delete purchase order by ID - 404 Order not found


    }

    @Test(enabled = true,groups = {SMOKE},description ="STORE[POST] Place an order for a pet")
    public void T009() {
        //TODO STORE[POST] Place an order for a pet - 200 Successful operation


        //TODO STORE[POST] Place an order for a pet - 400 Invalid Order


    }
}
