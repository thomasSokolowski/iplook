package com.iie.utils.csv.serializator;

import com.iie.dto.HostDto;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * Created by dev on 8/2/2014.
 */
public interface CsvGenerator {

    byte [] createCsvDump(Class aClass, Collection<?> objectsToBePersisted) throws IOException;
}
