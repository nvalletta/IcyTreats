package com.nora.icytreats;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Database(entities = {IcyTreatEntity.class}, version = 1, exportSchema = false)
public abstract class IcyTreatsDatabase extends RoomDatabase {

    @Nullable
    private IcyTreatsDatabase INSTANCE;

    @NonNull
    public IcyTreatsDatabase getInstance(@NonNull final Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), IcyTreatsDatabase.class, "icytreats.db")
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            Thread thread = new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    prePopulateIcyTreatsDatabase(context.getApplicationContext());
                                }
                            });
                            thread.start();
                        }
                    })
                    .build();
        }
        return INSTANCE;
    }

    @NonNull
    public abstract IcyTreatDao icyTreatDao();

    private void prePopulateIcyTreatsDatabase(@NonNull Context context) {
        Gson gson = new Gson();
        try {
            InputStream inputStream = context.getAssets().open("icytreats.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new String(buffer, "UTF-8")));
            List<IcyTreatEntity> icyTreats = gson.fromJson(bufferedReader, new TypeToken<List<IcyTreatEntity>>(){}.getType());
            icyTreatDao().createIcyTreats(icyTreats);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
