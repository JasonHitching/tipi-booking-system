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

    private static volatile BookingDatabase dbInstance;

    private static ExecutorService databaseExecutor =
            Executors.newFixedThreadPool(4);

    public static BookingDatabase getDbInstance(final Context context) {
        // If a database instance hasn't been created already
        if (dbInstance == null) {
            synchronized (BookingDatabase.class) {
                if (dbInstance == null) {
                    dbInstance = Room.databaseBuilder(context.getApplicationContext(),
                            BookingDatabase.class, "booking_db")
                            .addCallback(insertCallback)
                            .build();
                }
            }
        }
        return dbInstance;
    }

    private static RoomDatabase.Callback insertCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            prepopulateBookingData();
        }
    };

    /**
     * Pre-populate the Room database with data
     * POTENTIALLY SEPERATE DATA INTO A .DB FILE?
     */
    public static void prepopulateBookingData() {
        // Write to the database on a worker thread (so as not to clog up the main thread)
        databaseExecutor.execute(() -> {
            BookingDao dao = dbInstance.bookingDao();

            // Start with a fresh database each load
            dao.deleteAllBookings();

            Booking stretchBooking = new Booking(1, "Stetch Tent",
                    "Joe", "Copping", 800,
                    "09/08/1994",
                    5);
            dao.insertBooking(stretchBooking);

            Booking tipiBooking = new Booking(2, "Tipi",
                    "Jason", "Hitching", 233,
                    "09/2/1994",
                    10);
            dao.insertBooking(tipiBooking);

            Booking marqueeBooking = new Booking(3, "Marquee",
                    "Daniel", "Rose", 500,
                    "09/2/1994",
                    2);
            dao.insertBooking(marqueeBooking);

            databaseExecutor.shutdown();
        });
    }
}
