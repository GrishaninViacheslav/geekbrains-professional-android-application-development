package io.github.grishaninvyacheslav.domain.schedulers

import io.reactivex.Scheduler

interface ISchedulers {
    fun main(): Scheduler
    fun background(): Scheduler
}