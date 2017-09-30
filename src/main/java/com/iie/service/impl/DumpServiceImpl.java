package com.iie.service.impl;

import com.iie.model.Dump;
import com.iie.repository.DumpRepository;
import com.iie.service.DumpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dev on 8/4/2014.
 */
@Service
public class DumpServiceImpl implements DumpService {

    @Autowired
    private DumpRepository dumpRepository;

    @Override
    public void create(Dump dump) {
        dumpRepository.save(dump);
    }
}
