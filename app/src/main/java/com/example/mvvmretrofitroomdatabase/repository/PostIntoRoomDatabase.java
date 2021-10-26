package com.example.mvvmretrofitroomdatabase.repository;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.mvvmretrofitroomdatabase.models.ResultModel;

@Database(entities = {ResultModel.class},exportSchema = false,version = 1)
public abstract class PostIntoRoomDatabase extends RoomDatabase {

    public abstract PostInfoDao postInfoDao();

    private static PostIntoRoomDatabase INSTANCE;

    static PostIntoRoomDatabase getDatabase(final Context context){

        if (INSTANCE == null){
            synchronized (PostIntoRoomDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext()
                            ,PostIntoRoomDatabase.class,"postonfo_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static Callback sRoomDatabaseCallback = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulatedBAsync(INSTANCE).execute();
        }
    };
}
