package com.example.augusto.firetruckassistant;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by augus on 2018-04-10.
 */

public class Fire {

    public int ID;
    public int Location;
    public int StatusID;
    public String Firefighter;
    public List<String> RouteList;
    public int NumberOfRoutes;

    public enum StatusList {
        UNKNOWN,
        URGENT,
        PROCESSING,
        FINISHED
    }

    public Fire()
    {
        this.ID = 0;
        this.Location = 0;
        this.StatusID = 0;
        this.Firefighter = "";
        this.RouteList = null;
        this.NumberOfRoutes = 0;
    }

}
