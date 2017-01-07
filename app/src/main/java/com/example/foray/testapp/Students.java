package com.example.foray.testapp;

/**
 * Created by Foray on 03-01-2017.
 */

public class Students {

    private int _id;
    private String _sname;
    private String _sdegree;
    private String _saddress;

    public Students(){

    }


    public Students(String sname, String sdegree, String saddress) {
        this._sname = sname;
        this._sdegree = sdegree;
        this._saddress = saddress;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_sname(String _sname) {
        this._sname = _sname;
    }

    public void set_sdegree(String _sdegree) {
        this._sdegree = _sdegree;
    }

    public void set_saddress(String _saddress) {
        this._saddress = _saddress;
    }


    public int get_id() {
        return _id;
    }

    public String get_sname() {
        return _sname;
    }

    public String get_sdegree() {
        return _sdegree;
    }

    public String get_saddress() {
        return _saddress;
    }



}





