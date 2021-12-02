package io.github.grishaninvyacheslav.domain.models.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00040\u0003H&\u00a8\u0006\n"}, d2 = {"Lio/github/grishaninvyacheslav/domain/models/repository/IDictionaryRepository;", "", "getDefinitions", "Lio/reactivex/Single;", "", "Lio/github/grishaninvyacheslav/domain/models/DictionaryWordDto;", "word", "", "getHistory", "Lio/github/grishaninvyacheslav/domain/models/repository/room/HistoryEntity;", "domain_debug"})
public abstract interface IDictionaryRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.List<io.github.grishaninvyacheslav.domain.models.DictionaryWordDto>> getDefinitions(@org.jetbrains.annotations.NotNull()
    java.lang.String word);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.List<io.github.grishaninvyacheslav.domain.models.repository.room.HistoryEntity>> getHistory();
}