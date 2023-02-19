package com.badoo.mvicore

import io.reactivex.rxjava3.observers.TestObserver

//TODO
fun <T : Any> TestObserver<T>.onNextEvents() = this.values()

