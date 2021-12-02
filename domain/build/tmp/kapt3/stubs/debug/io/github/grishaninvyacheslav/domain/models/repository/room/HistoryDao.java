package io.github.grishaninvyacheslav.domain.models.repository.room;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\'J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\nH\'J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\'J\u0016\u0010\f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\'\u00a8\u0006\u000f"}, d2 = {"Lio/github/grishaninvyacheslav/domain/models/repository/room/HistoryDao;", "", "all", "", "Lio/github/grishaninvyacheslav/domain/models/repository/room/HistoryEntity;", "delete", "", "entity", "getDataByWord", "word", "", "insert", "insertAll", "entities", "update", "domain_debug"})
public abstract interface HistoryDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM HistoryEntity")
    public abstract java.util.List<io.github.grishaninvyacheslav.domain.models.repository.room.HistoryEntity> all();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM HistoryEntity WHERE word LIKE :word")
    public abstract io.github.grishaninvyacheslav.domain.models.repository.room.HistoryEntity getDataByWord(@org.jetbrains.annotations.NotNull()
    java.lang.String word);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    io.github.grishaninvyacheslav.domain.models.repository.room.HistoryEntity entity);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract void insertAll(@org.jetbrains.annotations.NotNull()
    java.util.List<io.github.grishaninvyacheslav.domain.models.repository.room.HistoryEntity> entities);
    
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    io.github.grishaninvyacheslav.domain.models.repository.room.HistoryEntity entity);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    io.github.grishaninvyacheslav.domain.models.repository.room.HistoryEntity entity);
}