package io.github.grishaninvyacheslav.domain.schedulers

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object DefaultSchedulers : ISchedulers {
    override fun main(): Scheduler = AndroidSchedulers.mainThread()
    override fun background(): Scheduler = Schedulers.io()
}