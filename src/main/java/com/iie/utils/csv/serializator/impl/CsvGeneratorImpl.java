package com.iie.utils.csv.serializator.impl;

import com.iie.utils.csv.serializator.CsvGenerator;
import org.apache.log4j.Logger;
import org.jsefa.Serializer;
import org.jsefa.csv.CsvIOFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collection;

/**
 * Created by dev on 8/2/2014.
 */

@Component
public class CsvGeneratorImpl implements CsvGenerator {
    private static Logger LOG = Logger.getLogger(CsvGeneratorImpl.class);
    private final static String ENCODING = "UTF-8";

    @Override
    public byte[] createCsvDump(Class aClass, Collection<?> objectsToBePersisted) throws IOException {
        Serializer serializer = CsvIOFactory.createFactory(aClass).createSerializer();
        StringWriter writer = new StringWriter();
        serializer.open(writer);
        LOG.info("Building CSV file...");
        for (Object o : objectsToBePersisted) {
            serializer.write(o);
        }
        serializer.close(true);
        LOG.info("Building CSV finished...");
        return writer.toString().getBytes(ENCODING);
    }


}
