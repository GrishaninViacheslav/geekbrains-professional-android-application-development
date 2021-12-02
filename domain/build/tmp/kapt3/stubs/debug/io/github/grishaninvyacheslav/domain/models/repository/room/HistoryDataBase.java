package io.github.grishaninvyacheslav.domain.models.repository.room;

import java.lang.System;

@androidx.room.Database(entities = {io.github.grishaninvyacheslav.domain.models.repository.room.HistoryEntity.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lio/github/grishaninvyacheslav/domain/models/repository/room/HistoryDataBase;", "Landroidx/room/RoomDatabase;", "()V", "historyDao", "Lio/github/grishaninvyacheslav/domain/models/repository/room/HistoryDao;", "domain_debug"})
public abstract class HistoryDataBase extends androidx.room.RoomDatabase {
    
    public HistoryDataBase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.github.grishaninvyacheslav.domain.models.repository.room.HistoryDao historyDao();
}