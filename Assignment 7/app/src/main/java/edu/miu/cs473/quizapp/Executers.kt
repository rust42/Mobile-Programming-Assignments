package edu.miu.cs473.quizapp

import java.util.concurrent.Executors

private val IO_EXECUTORS = Executors.newSingleThreadExecutor()
fun ioThread(f: () -> Unit) {
    IO_EXECUTORS.execute(f)
}