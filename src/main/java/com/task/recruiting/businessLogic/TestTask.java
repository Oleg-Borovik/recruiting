package com.task.recruiting.businessLogic;

import com.task.recruiting.entity.ResponseCategory;
import com.task.recruiting.entity.Resume;

public class TestTask implements FilterResume{
    @Override
    public long filterResume(Resume resume) {
        return 2L;
    }
}
