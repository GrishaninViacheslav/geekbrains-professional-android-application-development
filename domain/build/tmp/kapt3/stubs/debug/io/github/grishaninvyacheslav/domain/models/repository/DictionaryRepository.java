package io.github.grishaninvyacheslav.domain.models.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000e \u000f*\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t0\t0\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lio/github/grishaninvyacheslav/domain/models/repository/DictionaryRepository;", "Lio/github/grishaninvyacheslav/domain/models/repository/IDictionaryRepository;", "historyDao", "Lio/github/grishaninvyacheslav/domain/models/repository/room/HistoryDao;", "api", "Lio/github/grishaninvyacheslav/domain/models/repository/IDataSource;", "(Lio/github/grishaninvyacheslav/domain/models/repository/room/HistoryDao;Lio/github/grishaninvyacheslav/domain/models/repository/IDataSource;)V", "getDefinitions", "Lio/reactivex/Single;", "", "Lio/github/grishaninvyacheslav/domain/models/DictionaryWordDto;", "word", "", "getHistory", "Lio/github/grishaninvyacheslav/domain/models/repository/room/HistoryEntity;", "kotlin.jvm.PlatformType", "domain_debug"})
public final class DictionaryRepository implements io.github.grishaninvyacheslav.domain.models.repository.IDictionaryRepository {
    private final io.github.grishaninvyacheslav.domain.models.repository.room.HistoryDao historyDao = null;
    private final io.github.grishaninvyacheslav.domain.models.repository.IDataSource api = null;
    
    public DictionaryRepository(@org.jetbrains.annotations.NotNull()
    io.github.grishaninvyacheslav.domain.models.repository.room.HistoryDao historyDao, @org.jetbrains.annotations.NotNull()
    io.github.grishaninvyacheslav.domain.models.repository.IDataSource api) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<io.github.grishaninvyacheslav.domain.models.DictionaryWordDto>> getDefinitions(@org.jetbrains.annotations.NotNull()
    java.lang.String word) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<io.github.grishaninvyacheslav.domain.models.repository.room.HistoryEntity>> getHistory() {
        return null;
    }
}