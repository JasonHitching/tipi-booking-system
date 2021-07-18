package com.example.tipi_stock.backend.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.tipi_stock.backend.bookings.StructureBooking;

import java.time.LocalDate;
import java.time.Month;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Booking.class}, version = 1, exportSchema = true)
public abstract class BookingDatabase extends RoomDatabase {

    public abstract BookingDao bookingDao();

    private static BookingDatabase dbInstance;

    private static ExecutorService databaseExecutor =
            Executors.newFixedThreadPool(4);

    public static BookingDatabase getDbInstance(final Context context) {
        // If a database instance hasn't been created already
        if (dbInstance == null) {
            synchronized (BookingDatabase.class) {
                if (dbInstance == null) {
                    dbInstance = Room.databaseBuilder(context.getApplicationContext(),
                            BookingDatabase.class, "booking_db")
                            .fallbackToDestructiveMigration()
                            .addCallback(insertCallback)
                            .build();
                }
            }
        }
        return dbInstance;
    }

    private static RoomDatabase.Callback insertCallback = new RoomDatabase.Callback() {
        /**
         * Pre-populate database data (CHANGE THIS TO READING FROM A .DB FILE)
         * https://developer.android.com/training/data-storage/room/prepopulate
         */
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // Write to the database on a worker thread (so as not to clog up the main thread)
            databaseExecutor.execute(() -> {
                BookingDao dao = dbInstance.bookingDao();

                // Start with a fresh database
                dao.deleteAllBookings();

                Booking stretchBooking = new Booking(1, "Stetch Tent",
                        "Helen", "Copping", 800,
                        "09/08/1994",
                        5);
                dao.insertBooking(stretchBooking);

                Booking stretchBooking2 = new Booking(2, "Stetch Tent",
                        "Helen", "Copping", 800,
                        "09/08/1994",
                        5);
                dao.insertBooking(stretchBooking);

            });
        }
    };

}
