package edu.wctc.squirrels.service;

import edu.wctc.squirrels.entity.Ranking;
import edu.wctc.squirrels.entity.Sighting;
import edu.wctc.squirrels.entity.Squirrel;

import java.util.List;

public interface SquirrelService {
    Squirrel getSquirrel(int squirrelId);
    void updateSquirrel(Squirrel squirrel);

    List<Squirrel> getSquirrelList();
}
