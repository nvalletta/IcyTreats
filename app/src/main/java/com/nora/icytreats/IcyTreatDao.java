package com.nora.icytreats;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.support.annotation.NonNull;

import java.util.List;

@Dao
public interface IcyTreatDao {

    @Insert
    void createIcyTreat(@NonNull IcyTreatEntity icyTreatEntity);

    @Insert
    void createIcyTreats(@NonNull List<IcyTreatEntity> icyTreatEntities);

    @NonNull
    @Query("SELECT * FROM icy_treats")
    List<IcyTreatEntity> getIcyTreats();

    @NonNull
    @Query("SELECT * FROM icy_treats WHERE createdByUser = true")
    List<IcyTreatEntity> getIcyTreatsCreatedByUser();

}
