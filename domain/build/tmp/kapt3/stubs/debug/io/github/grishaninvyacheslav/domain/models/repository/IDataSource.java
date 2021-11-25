package io.github.grishaninvyacheslav.domain.models.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\'\u00a8\u0006\b"}, d2 = {"Lio/github/grishaninvyacheslav/domain/models/repository/IDataSource;", "", "getDefinitions", "Lretrofit2/Call;", "", "Lio/github/grishaninvyacheslav/domain/models/DictionaryWordDto;", "word", "", "domain_debug"})
public abstract interface IDataSource {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/api/v2/entries/en/{word}")
    public abstract retrofit2.Call<java.util.List<io.github.grishaninvyacheslav.domain.models.DictionaryWordDto>> getDefinitions(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "word")
    java.lang.String word);
}