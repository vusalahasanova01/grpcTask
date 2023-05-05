package com.example.grpctask.repository;


import com.example.grcptask.tables.records.LogRecord;

public interface BaseRepository {

    LogRecord addLog(LogRecord baseRecord);
}
