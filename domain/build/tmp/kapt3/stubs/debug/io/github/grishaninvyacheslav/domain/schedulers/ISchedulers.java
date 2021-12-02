package io.github.grishaninvyacheslav.domain.schedulers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&\u00a8\u0006\u0005"}, d2 = {"Lio/github/grishaninvyacheslav/domain/schedulers/ISchedulers;", "", "background", "Lio/reactivex/Scheduler;", "main", "domain_debug"})
public abstract interface ISchedulers {
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Scheduler main();
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Scheduler background();
}