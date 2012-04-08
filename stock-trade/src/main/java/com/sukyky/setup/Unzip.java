package com.sukyky.setup;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Unzip {

    /**
     * Unzips all files in the zipFile into the targetDir and returns the unzipped files.
     */
    public static List<File> unzip(File zipFile, File targetDir) throws IOException {
        List<File> files = new ArrayList<File>();
        ZipFile zip = new ZipFile(zipFile);
        try {
            zip = new ZipFile(zipFile);
            for (ZipEntry entry : Collections.list(zip.entries())) {
                InputStream input = zip.getInputStream(entry);
                try {
                    if (!targetDir.exists()) targetDir.mkdirs();
                    File target = new File(targetDir, entry.getName());
                    FileUtils.copyInputStreamToFile(input, target);
                    files.add(target);
                } finally {
                    IOUtils.closeQuietly(input);
                }
            }
            return files;
        } finally {
            zip.close();
        }
    }
}
