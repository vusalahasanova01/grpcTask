package com.example.grpctask.repository.impl;

import com.example.grcptask.tables.records.LogRecord;
import com.example.grpctask.repository.BaseRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import static com.example.grcptask.Tables.LOG;


@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Repository
public class BaseRepositoryImpl implements BaseRepository {

    private final DSLContext dslContext;

    @Override
    public LogRecord addLog(LogRecord baseRecord) {
        return dslContext.insertInto(LOG)
                .set(baseRecord)
                .returning()
                .fetchOne();
    }
}
