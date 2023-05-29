package com.example.sandbox.businessProcesses;

import com.example.sandbox.Common;
import org.testng.annotations.Test;

import static com.example.sandbox.util.constans.Tags.SMOKE;

public class UserLifeCycleTest extends Common {

    @Test(enabled = true,groups = {SMOKE},description ="USER[GET] Get user by user name")
    public void T010() {
        //TODO USER[GET] Get user by user name - 200 successful operation



        //TODO USER[GET] Get user by user name - 400 Invalid username supplied



        //TODO USER[GET] Get user by user name - 404 User not found


    }

    @Test(enabled = true,groups = {SMOKE},description ="USER[DELETE] Delete user")
    public void T011() {
        //This can only be done by the logged in user.

        //TODO USER[DELETE] Delete user - 200 successful operation



        //TODO USER[DELETE] Delete user - 400 Invalid username supplied



        //TODO USER[DELETE] Delete user - 404 User not found


    }

    @Test(enabled = true,groups = {SMOKE},description ="USER[PUT] Update user")
    public void T012() {
        //This can only be done by the logged in user.

        //TODO USER[PUT] Update user - 200 successful operation



        //TODO USER[PUT] Update user - 400 Invalid username supplied



        //TODO USER[PUT] Update user - 404 User not found


    }

    @Test(enabled = true,groups = {SMOKE},description ="USER[GET] Log user info the system")
    public void T013() {

        //TODO USER[GET] Log user info the system - 200 successful operation



        //TODO USER[GET] Log user info the system - 400 Invalid username/password supplied


    }

    @Test(enabled = true,groups = {SMOKE},description ="USER[GET] Log out current logged in user session")
    public void T014() {

        //TODO USER[GET] Log out current logged in user session - default Successful operation


    }

    @Test(enabled = true,groups = {SMOKE},description ="USER[POST] Create user")
    public void T015() {

        //TODO USER[GET] USER[POST] Create user - default Successful operation


    }

    @Test(enabled = true,groups = {SMOKE},description ="USER[POST] Create list of users with given input array")
    public void T016() {

        //TODO USER[POST] Create list of users with given input array - default Successful operation


    }

    @Test(enabled = true,groups = {SMOKE},description ="USER[POST] Create list of users with given input list")
    public void T017() {

        //TODO USER[POST] Create list of users with given input list - default Successful operation


    }
}
